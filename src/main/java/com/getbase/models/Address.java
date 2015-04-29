package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;

public class Address {
    public Address() {
    }

    public Address(String line1, String city, String postalCode, String state, String country) {
        this.line1 = line1;
        this.city = city;
        this.postalCode = postalCode;
        this.state = state;
        this.country = country;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (line1 != null ? !line1.equals(address.line1) : address.line1 != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (postalCode != null ? !postalCode.equals(address.postalCode) : address.postalCode != null) return false;
        if (state != null ? !state.equals(address.state) : address.state != null) return false;
        return !(country != null ? !country.equals(address.country) : address.country != null);

    }

    @Override
    public int hashCode() {
        int result = line1 != null ? line1.hashCode() : 0;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    protected @JsonView(Views.ReadWrite.class) String line1;
    protected @JsonView(Views.ReadWrite.class) String city;
    protected @JsonView(Views.ReadWrite.class) String postalCode;
    protected @JsonView(Views.ReadWrite.class) String state;
    protected @JsonView(Views.ReadWrite.class) String country;
}
