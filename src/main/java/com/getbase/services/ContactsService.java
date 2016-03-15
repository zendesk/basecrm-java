// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.services;

import com.getbase.http.HttpClient;
import com.getbase.models.Contact;
import com.getbase.serializer.JsonDeserializer;
import com.getbase.serializer.JsonSerializer;
import com.getbase.serializer.Views;

import java.util.*;

import static com.getbase.utils.Lists.asList;
import static com.getbase.utils.Precondition.*;


public class ContactsService extends BaseService {
  public ContactsService(HttpClient httpClient) {
    super(httpClient);
  }

  public List<Contact> list(Map<String, Object> params) {
    String url = "/contacts";
    return JsonDeserializer.deserializeList(this.httpClient.get(url, params).getBody(), Contact.class);
  }

  public List<Contact> list(SearchCriteria criteria) {
    return list(criteria.asMap());
  }


  public Contact create(Contact contact) {
    checkNotNull(contact, "contact parameter must not be null");

    String url = "/contacts";
    String serialized = JsonSerializer.serialize(contact, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), Contact.class);
  }

  public Contact create(Map<String, Object> attributes) {
    checkNotNull(attributes, "attributes parameter must not be null");
    
    String url = "/contacts";
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.post(url, serialized).getBody(), Contact.class);
  }


  public Contact get(long id) {
    checkArgument(id > 0, "id must be a valid id");

    String url = String.format(Locale.US, "/contacts/%d", id); 
    return JsonDeserializer.deserialize(this.httpClient.get(url, null).getBody(), Contact.class);
  }


  public Contact update(Contact contact) {
    checkNotNull(contact, "contact parameter must not be null");
    checkNotNull(contact.getId(), "contact must have id attribute set");
    checkArgument(contact.getId() > 0, "contact id must be a valid id");

    String url = String.format(Locale.US, "/contacts/%d", contact.getId());
    String serialized = JsonSerializer.serialize(contact, Views.ReadWrite.class);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Contact.class);
  }

  public Contact update(long id, Map<String, Object> attributes) {
    checkArgument(id > 0, "id must be a valid id");
    checkNotNull(attributes, "attributes parameter must not be null");

    String url = String.format(Locale.US, "/contacts/%d", id);
    String serialized = JsonSerializer.serialize(attributes);
    return JsonDeserializer.deserialize(this.httpClient.put(url, serialized).getBody(), Contact.class);
  }


  public boolean delete(long id) {
    checkArgument(id > 0, "id must be a valid id");
    
    String url = String.format(Locale.US, "/contacts/%d", id); 
    return this.httpClient.delete(url, null).getHttpStatus() == 204;
  }



  public static class SearchCriteria {
    private Map<String, Object> queryParams;

    public SearchCriteria() {
      this.queryParams = new HashMap<String, Object>();
    }

    public SearchCriteria page(long page) {
      queryParams.put("page", page);
      return this;
    }

    public SearchCriteria perPage(long perPage) {
      queryParams.put("per_page", perPage);
      return this;
    }

    public SearchCriteria sortBy(String criteria, String order) {
      queryParams.put("sort_by", criteria + ":" + order);
      return this;
    }

    public SearchCriteria sortBy(String criteria) {
      return sortBy(criteria, "asc");
    }

    public SearchCriteria ids(List<Long> ids) {
      queryParams.put("ids", ids);
      return this;
    }

    public SearchCriteria ids(Long... ids) {
      return ids(asList(ids));
    }

    public SearchCriteria contactId(long contactId) {
      queryParams.put("contact_id", contactId);
      return this;
    }

    public SearchCriteria addressCity(String addressCity) {
      queryParams.put("address[city]", addressCity);
      return this;
    }

    public SearchCriteria addressCountry(String addressCountry) {
      queryParams.put("address[country]", addressCountry);
      return this;
    }

    public SearchCriteria addressPostalCode(String addressPostalCode) {
      queryParams.put("address[postal_code]", addressPostalCode);
      return this;
    }

    public SearchCriteria email(String email) {
      queryParams.put("email", email);
      return this;
    }

    public SearchCriteria firstName(String firstName) {
      queryParams.put("first_name", firstName);
      return this;
    }

    public SearchCriteria isOrganization(boolean isOrganization) {
      queryParams.put("is_organization", isOrganization);
      return this;
    }

    public SearchCriteria lastName(String lastName) {
      queryParams.put("last_name", lastName);
      return this;
    }

    public SearchCriteria name(String name) {
      queryParams.put("name", name);
      return this;
    }

    public Map<String, Object> asMap() {
      return Collections.unmodifiableMap(queryParams);
    }
  }

}

