// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;



public class User {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) Boolean confirmed;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) String role;
  protected @JsonView(Views.ReadOnly.class) String status;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
  protected @JsonView(Views.ReadWrite.class) String email;
  protected @JsonView(Views.ReadWrite.class) String name;
  protected @JsonView(Views.ReadOnly.class) DateTime deletedAt;

  public User() {
  }

  public Long getId() {
    return this.id;
  }

  public Boolean getConfirmed() {
    return this.confirmed;
  }

  public DateTime getCreatedAt() {
    return this.createdAt;
  }

  public String getRole() {
    return this.role;
  }

  public String getStatus() {
    return this.status;
  }

  public DateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public String getEmail() {
    return this.email;
  }

  public String getName() {
    return this.name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public DateTime getDeletedAt() {
    return this.deletedAt;
  }

  @Override
  public String toString() {
    return "User{" +
          "id=" + id +
          ", confirmed=" + confirmed +
          ", createdAt=" + createdAt +
          ", role='" + role + '\'' +
          ", status='" + status + '\'' +
          ", updatedAt=" + updatedAt +
          ", email='" + email + '\'' +
          ", name='" + name + '\'' +
          ", deletedAt='" + deletedAt + '\'' +
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (id != null ? !id.equals(user.id) : user.id != null) return false;
    if (confirmed != null ? !confirmed.equals(user.confirmed) : user.confirmed != null) return false;
    if (createdAt != null ? !createdAt.equals(user.createdAt) : user.createdAt != null) return false;
    if (role != null ? !role.equals(user.role) : user.role != null) return false;
    if (status != null ? !status.equals(user.status) : user.status != null) return false;
    if (updatedAt != null ? !updatedAt.equals(user.updatedAt) : user.updatedAt != null) return false;
    if (email != null ? !email.equals(user.email) : user.email != null) return false;
    if (name != null ? !name.equals(user.name) : user.name != null) return false;
    if (deletedAt != null ? !deletedAt.equals(user.deletedAt) : user.deletedAt != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (confirmed != null ? confirmed.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (role != null ? role.hashCode() : 0);
    result = 31 * result + (status != null ? status.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (deletedAt != null ? deletedAt.hashCode() : 0);
    return result;
  }
}
