package com.getbase;

import com.getbase.http.HttpClient;

public class BaseCrm {
    public static void main(String[] args) {
        Client client = new Client(new Configuration.Builder().
                accessToken("0536d6526cbf676fdddac05df66ec87094db83cf4fb0493404480289fad7b016").
                build());

        HttpClient httpClient = client.getHttpClient();

        System.out.println("Hello");
    }
}
