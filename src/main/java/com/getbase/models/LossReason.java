// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;



public class LossReason {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) Long creatorId;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
  protected @JsonView(Views.ReadWrite.class) String name;

  public LossReason() {
  }

  public Long getId() {
    return this.id;
  }

  public Long getCreatorId() {
    return this.creatorId;
  }

  public DateTime getCreatedAt() {
    return this.createdAt;
  }

  public DateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "LossReason{" +
          "id=" + id + 
          "creatorId=" + creatorId + 
          "createdAt=" + createdAt + 
          "updatedAt=" + updatedAt + 
          "name='" + name + '\'' + 
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    LossReason lossReason = (LossReason) o;

    if (id != null ? !id.equals(lossReason.id) : lossReason.id != null) return false;
    if (creatorId != null ? !creatorId.equals(lossReason.creatorId) : lossReason.creatorId != null) return false;
    if (createdAt != null ? !createdAt.equals(lossReason.createdAt) : lossReason.createdAt != null) return false;
    if (updatedAt != null ? !updatedAt.equals(lossReason.updatedAt) : lossReason.updatedAt != null) return false;
    if (name != null ? !name.equals(lossReason.name) : lossReason.name != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
