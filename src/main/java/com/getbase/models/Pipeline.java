// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;



public class Pipeline {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
  protected @JsonView(Views.ReadWrite.class) String name;
  protected @JsonView(Views.ReadWrite.class) Boolean disabled;

  public Pipeline() {
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

  public String getName() {
    return this.name;
  }

  public Boolean getDisabled() {
    return this.disabled;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Pipeline{" +
          "id=" + id +
          ", createdAt=" + createdAt +
          ", updatedAt=" + updatedAt +
          ", name='" + name + '\'' +
          ", disabled='" + disabled + '\'' +
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pipeline pipeline = (Pipeline) o;

    if (id != null ? !id.equals(pipeline.id) : pipeline.id != null) return false;
    if (createdAt != null ? !createdAt.equals(pipeline.createdAt) : pipeline.createdAt != null) return false;
    if (updatedAt != null ? !updatedAt.equals(pipeline.updatedAt) : pipeline.updatedAt != null) return false;
    if (name != null ? !name.equals(pipeline.name) : pipeline.name != null) return false;
    if (disabled != null ? !disabled.equals(pipeline.disabled) : pipeline.disabled != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (disabled != null ? disabled.hashCode() : 0);
    return result;
  }
}
