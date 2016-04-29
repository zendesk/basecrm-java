// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;



public class Address {
  protected @JsonView(Views.ReadWrite.class) String city;
  protected @JsonView(Views.ReadWrite.class) String country;
  protected @JsonView(Views.ReadWrite.class) String line1;
  protected @JsonView(Views.ReadWrite.class) String postalCode;
  protected @JsonView(Views.ReadWrite.class) String state;

  public Address() {
  }

  public String getCity() {
    return this.city;
  }

  public String getCountry() {
    return this.country;
  }

  public String getLine1() {
    return this.line1;
  }

  public String getPostalCode() {
    return this.postalCode;
  }

  public String getState() {
    return this.state;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "Address{" +
          "city='" + city + '\'' +
          ", country='" + country + '\'' +
          ", line1='" + line1 + '\'' +
          ", postalCode='" + postalCode + '\'' +
          ", state='" + state + '\'' +
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Address address = (Address) o;

    if (city != null ? !city.equals(address.city) : address.city != null) return false;
    if (country != null ? !country.equals(address.country) : address.country != null) return false;
    if (line1 != null ? !line1.equals(address.line1) : address.line1 != null) return false;
    if (postalCode != null ? !postalCode.equals(address.postalCode) : address.postalCode != null) return false;
    if (state != null ? !state.equals(address.state) : address.state != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = 0;
    result = 31 * result + (city != null ? city.hashCode() : 0);
    result = 31 * result + (country != null ? country.hashCode() : 0);
    result = 31 * result + (line1 != null ? line1.hashCode() : 0);
    result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
    result = 31 * result + (state != null ? state.hashCode() : 0);
    return result;
  }
}
