// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;



public class Account {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
  protected @JsonView(Views.ReadWrite.class) String currency;
  protected @JsonView(Views.ReadWrite.class) String name;
  protected @JsonView(Views.ReadWrite.class) String phone;
  protected @JsonView(Views.ReadWrite.class) String timeFormat;
  protected @JsonView(Views.ReadWrite.class) String timezone;

  public Account() {
  }

  public Long getId() {
    return this.id;
  }

  public DateTime getCreatedAt() {
    return this.createdAt;
  }

  public DateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public String getCurrency() {
    return this.currency;
  }

  public String getName() {
    return this.name;
  }

  public String getPhone() {
    return this.phone;
  }

  public String getTimeFormat() {
    return this.timeFormat;
  }

  public String getTimezone() {
    return this.timezone;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setTimeFormat(String timeFormat) {
    this.timeFormat = timeFormat;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  @Override
  public String toString() {
    return "Account{" +
          "id=" + id +
          ", createdAt=" + createdAt +
          ", updatedAt=" + updatedAt +
          ", currency='" + currency + '\'' +
          ", name='" + name + '\'' +
          ", phone='" + phone + '\'' +
          ", timeFormat='" + timeFormat + '\'' +
          ", timezone='" + timezone + '\'' +
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Account account = (Account) o;

    if (id != null ? !id.equals(account.id) : account.id != null) return false;
    if (createdAt != null ? !createdAt.equals(account.createdAt) : account.createdAt != null) return false;
    if (updatedAt != null ? !updatedAt.equals(account.updatedAt) : account.updatedAt != null) return false;
    if (currency != null ? !currency.equals(account.currency) : account.currency != null) return false;
    if (name != null ? !name.equals(account.name) : account.name != null) return false;
    if (phone != null ? !phone.equals(account.phone) : account.phone != null) return false;
    if (timeFormat != null ? !timeFormat.equals(account.timeFormat) : account.timeFormat != null) return false;
    if (timezone != null ? !timezone.equals(account.timezone) : account.timezone != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (currency != null ? currency.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (phone != null ? phone.hashCode() : 0);
    result = 31 * result + (timeFormat != null ? timeFormat.hashCode() : 0);
    result = 31 * result + (timezone != null ? timezone.hashCode() : 0);
    return result;
  }
}
