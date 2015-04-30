package com.getbase;


import com.getbase.models.Lead;
import com.getbase.services.LeadsService;

import java.util.List;

public class BaseCrm {
    public static void main(String[] args) {
        Client client = new Client(new Configuration.Builder().
                accessToken(System.getenv("BASECRM_ACCESS_TOKEN")).
                verbose().
                userAgent(Configuration.DEFAULT_USER_AGENT + "+tests").
                build());

        client.leads().list(new LeadsService.QueryParamBuilder().
                page(1).
                perPage(10)).
                stream().
                forEach(System.out::println);

        Lead mark = new Lead();
        mark.setFirstName("Mark");
        mark.setLastName("Johnson");

        long markId = client.leads().create(mark).getId();

        client.leads().delete(markId);
    }
}
