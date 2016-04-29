// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;



public class AssociatedContact {
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
  protected @JsonView(Views.ReadWrite.class) Long contactId;
  protected @JsonView(Views.ReadWrite.class) String role;

  public AssociatedContact() {
  }

  public DateTime getCreatedAt() {
    return this.createdAt;
  }

  public DateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public Long getContactId() {
    return this.contactId;
  }

  public String getRole() {
    return this.role;
  }

  public void setContactId(long contactId) {
    this.contactId = contactId;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "AssociatedContact{" +
          "createdAt=" + createdAt +
          ", updatedAt=" + updatedAt +
          ", contactId=" + contactId +
          ", role='" + role + '\'' +
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AssociatedContact associatedContact = (AssociatedContact) o;

    if (createdAt != null ? !createdAt.equals(associatedContact.createdAt) : associatedContact.createdAt != null) return false;
    if (updatedAt != null ? !updatedAt.equals(associatedContact.updatedAt) : associatedContact.updatedAt != null) return false;
    if (contactId != null ? !contactId.equals(associatedContact.contactId) : associatedContact.contactId != null) return false;
    if (role != null ? !role.equals(associatedContact.role) : associatedContact.role != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = 0;
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (contactId != null ? contactId.hashCode() : 0);
    result = 31 * result + (role != null ? role.hashCode() : 0);
    return result;
  }
}
