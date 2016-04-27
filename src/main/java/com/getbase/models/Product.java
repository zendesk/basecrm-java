// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import static com.getbase.utils.Precondition.*;

public class Product {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
  protected @JsonView(Views.ReadWrite.class) Boolean active;
  protected @JsonView(Views.ReadWrite.class) BigDecimal cost;
  protected @JsonView(Views.ReadWrite.class) String costCurrency;
  protected @JsonView(Views.ReadWrite.class) String description;
  protected @JsonView(Views.ReadWrite.class) Long maxDiscount;
  protected @JsonView(Views.ReadWrite.class) Long maxMarkup;
  protected @JsonView(Views.ReadWrite.class) String name;
  protected @JsonView(Views.ReadWrite.class) List<Price> prices = new ArrayList<Price>();
  protected @JsonView(Views.ReadWrite.class) String sku;

  public Product() {
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

  public Boolean getActive() {
    return this.active;
  }

  public BigDecimal getCost() {
    return this.cost;
  }

  public String getCostCurrency() {
    return this.costCurrency;
  }

  public String getDescription() {
    return this.description;
  }

  public Long getMaxDiscount() {
    return this.maxDiscount;
  }

  public Long getMaxMarkup() {
    return this.maxMarkup;
  }

  public String getName() {
    return this.name;
  }

  public List<Price> getPrices() {
    return this.prices;
  }

  public String getSku() {
    return this.sku;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void setCost(BigDecimal cost) {
    this.cost = cost;
  }

  public void setCostCurrency(String costCurrency) {
    this.costCurrency = costCurrency;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setMaxDiscount(long maxDiscount) {
    this.maxDiscount = maxDiscount;
  }

  public void setMaxMarkup(long maxMarkup) {
    this.maxMarkup = maxMarkup;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPrices(List<Price> prices) {
    checkNotNull(prices, "prices must not be null.");
    this.prices = prices;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  @Override
  public String toString() {
    return "Product{" +
          "id=" + id +
          ", createdAt=" + createdAt +
          ", updatedAt=" + updatedAt +
          ", active=" + active +
          ", cost=" + cost +
          ", costCurrency='" + costCurrency + '\'' +
          ", description='" + description + '\'' +
          ", maxDiscount=" + maxDiscount +
          ", maxMarkup=" + maxMarkup +
          ", name='" + name + '\'' +
          ", prices=" + prices +
          ", sku='" + sku + '\'' +
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Product product = (Product) o;

    if (id != null ? !id.equals(product.id) : product.id != null) return false;
    if (createdAt != null ? !createdAt.equals(product.createdAt) : product.createdAt != null) return false;
    if (updatedAt != null ? !updatedAt.equals(product.updatedAt) : product.updatedAt != null) return false;
    if (active != null ? !active.equals(product.active) : product.active != null) return false;
    if (cost != null ? !cost.equals(product.cost) : product.cost != null) return false;
    if (costCurrency != null ? !costCurrency.equals(product.costCurrency) : product.costCurrency != null) return false;
    if (description != null ? !description.equals(product.description) : product.description != null) return false;
    if (maxDiscount != null ? !maxDiscount.equals(product.maxDiscount) : product.maxDiscount != null) return false;
    if (maxMarkup != null ? !maxMarkup.equals(product.maxMarkup) : product.maxMarkup != null) return false;
    if (name != null ? !name.equals(product.name) : product.name != null) return false;
    if (!prices.equals(product.prices)) return false;
    if (sku != null ? !sku.equals(product.sku) : product.sku != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (active != null ? active.hashCode() : 0);
    result = 31 * result + (cost != null ? cost.hashCode() : 0);
    result = 31 * result + (costCurrency != null ? costCurrency.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (maxDiscount != null ? maxDiscount.hashCode() : 0);
    result = 31 * result + (maxMarkup != null ? maxMarkup.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + prices.hashCode();
    result = 31 * result + (sku != null ? sku.hashCode() : 0);
    return result;
  }
}
