// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;



public class VisitOutcome {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) String name;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;

  public VisitOutcome() {
  }

  public Long getId() {
    return this.id;
  }

  public DateTime getCreatedAt() {
    return this.createdAt;
  }

  public String getName() {
    return this.name;
  }

  public DateTime getUpdatedAt() {
    return this.updatedAt;
  }

  @Override
  public String toString() {
    return "VisitOutcome{" +
          "id=" + id +
          ", createdAt=" + createdAt +
          ", name='" + name + '\'' +
          ", updatedAt=" + updatedAt +
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    VisitOutcome visitOutcome = (VisitOutcome) o;

    if (id != null ? !id.equals(visitOutcome.id) : visitOutcome.id != null) return false;
    if (createdAt != null ? !createdAt.equals(visitOutcome.createdAt) : visitOutcome.createdAt != null) return false;
    if (name != null ? !name.equals(visitOutcome.name) : visitOutcome.name != null) return false;
    if (updatedAt != null ? !updatedAt.equals(visitOutcome.updatedAt) : visitOutcome.updatedAt != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    return result;
  }
}
