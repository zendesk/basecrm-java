// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;



public class Source {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) Long creatorId;
  protected @JsonView(Views.ReadOnly.class) String createdAt;
  protected @JsonView(Views.ReadOnly.class) String updatedAt;
  protected @JsonView(Views.ReadWrite.class) String name;

  public Source() {
  }

  public Long getId() {
    return this.id;
  }

  public Long getCreatorId() {
    return this.creatorId;
  }

  public String getCreatedAt() {
    return this.createdAt;
  }

  public String getUpdatedAt() {
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
    return "Source{" +
          "id=" + id +
          ", creatorId=" + creatorId +
          ", createdAt='" + createdAt + '\'' +
          ", updatedAt='" + updatedAt + '\'' +
          ", name='" + name + '\'' +
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Source source = (Source) o;

    if (id != null ? !id.equals(source.id) : source.id != null) return false;
    if (creatorId != null ? !creatorId.equals(source.creatorId) : source.creatorId != null) return false;
    if (createdAt != null ? !createdAt.equals(source.createdAt) : source.createdAt != null) return false;
    if (updatedAt != null ? !updatedAt.equals(source.updatedAt) : source.updatedAt != null) return false;
    if (name != null ? !name.equals(source.name) : source.name != null) return false;

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
