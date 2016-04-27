// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;

import java.math.BigDecimal;


public class Price {
  protected @JsonView(Views.ReadWrite.class) BigDecimal amount;
  protected @JsonView(Views.ReadWrite.class) String currency;

  public Price() {
  }

  public BigDecimal getAmount() {
    return this.amount;
  }

  public String getCurrency() {
    return this.currency;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public String toString() {
    return "Price{" +
          "amount=" + amount +
          ", currency='" + currency + '\'' +
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Price price = (Price) o;

    if (amount != null ? !amount.equals(price.amount) : price.amount != null) return false;
    if (currency != null ? !currency.equals(price.currency) : price.currency != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = 0;
    result = 31 * result + (amount != null ? amount.hashCode() : 0);
    result = 31 * result + (currency != null ? currency.hashCode() : 0);
    return result;
  }
}
