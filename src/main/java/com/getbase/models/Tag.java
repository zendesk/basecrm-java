// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;



public class Tag {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) Long creatorId;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
  protected @JsonView(Views.ReadWrite.class) String name;
  protected @JsonView(Views.ReadWrite.class) String resourceType;

  public Tag() {
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

  public String getResourceType() {
    return this.resourceType;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  @Override
  public String toString() {
    return "Tag{" +
          "id=" + id + 
          "creatorId=" + creatorId + 
          "createdAt=" + createdAt + 
          "updatedAt=" + updatedAt + 
          "name='" + name + '\'' + 
          "resourceType='" + resourceType + '\'' + 
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Tag tag = (Tag) o;

    if (id != null ? !id.equals(tag.id) : tag.id != null) return false;
    if (creatorId != null ? !creatorId.equals(tag.creatorId) : tag.creatorId != null) return false;
    if (createdAt != null ? !createdAt.equals(tag.createdAt) : tag.createdAt != null) return false;
    if (updatedAt != null ? !updatedAt.equals(tag.updatedAt) : tag.updatedAt != null) return false;
    if (name != null ? !name.equals(tag.name) : tag.name != null) return false;
    if (resourceType != null ? !resourceType.equals(tag.resourceType) : tag.resourceType != null) return false;

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
    result = 31 * result + (resourceType != null ? resourceType.hashCode() : 0);
    return result;
  }
}
