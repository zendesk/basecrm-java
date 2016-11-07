package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;

import java.math.BigDecimal;

public class LineItem {

    protected @JsonView(Views.ReadOnly.class) Long id;
    protected @JsonView(Views.ReadWrite.class) Long productId;
    protected @JsonView(Views.ReadWrite.class) BigDecimal value;
    protected @JsonView(Views.ReadWrite.class) BigDecimal variation;
    protected @JsonView(Views.ReadWrite.class) String currency;
    protected @JsonView(Views.ReadWrite.class) Long quantity;
    protected @JsonView(Views.ReadOnly.class) BigDecimal price;
    protected @JsonView(Views.ReadOnly.class) String name;
    protected @JsonView(Views.ReadOnly.class) String sku;
    protected @JsonView(Views.ReadOnly.class) String description;
    protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
    protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getVariation() {
        return variation;
    }

    public String getCurrency() {
        return currency;
    }

    public Long getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public String getDescription() {
        return description;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setVariation(BigDecimal variation) {
        this.variation = variation;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineItem lineItem = (LineItem) o;

        if (id != null ? !id.equals(lineItem.id) : lineItem.id != null) return false;
        if (productId != null ? !productId.equals(lineItem.productId) : lineItem.productId != null) return false;
        if (value != null ? !value.equals(lineItem.value) : lineItem.value != null) return false;
        if (variation != null ? !variation.equals(lineItem.variation) : lineItem.variation != null) return false;
        if (currency != null ? !currency.equals(lineItem.currency) : lineItem.currency != null) return false;
        if (quantity != null ? !quantity.equals(lineItem.quantity) : lineItem.quantity != null) return false;
        if (price != null ? !price.equals(lineItem.price) : lineItem.price != null) return false;
        if (name != null ? !name.equals(lineItem.name) : lineItem.name != null) return false;
        if (sku != null ? !sku.equals(lineItem.sku) : lineItem.sku != null) return false;
        if (description != null ? !description.equals(lineItem.description) : lineItem.description != null)
            return false;
        if (createdAt != null ? !createdAt.equals(lineItem.createdAt) : lineItem.createdAt != null) return false;
        return updatedAt != null ? updatedAt.equals(lineItem.updatedAt) : lineItem.updatedAt == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (variation != null ? variation.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (sku != null ? sku.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

}
