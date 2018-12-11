// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;

public class Visit {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) Long creatorId;
  protected @JsonView(Views.ReadOnly.class) Long outcomeId;
  protected @JsonView(Views.ReadOnly.class) Long resourceId;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) DateTime visitedAt;
  protected @JsonView(Views.ReadOnly.class) String repLocationVerificationStatus;
  protected @JsonView(Views.ReadOnly.class) String resourceAddress;
  protected @JsonView(Views.ReadOnly.class) String resourceType;
  protected @JsonView(Views.ReadOnly.class) String summary;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;

  public Visit() {
  }

  public Long getId() {
    return this.id;
  }

  public Long getCreatorId() {
    return this.creatorId;
  }

  public Long getOutcomeId() {
    return this.outcomeId;
  }

  public Long getResourceId() {
    return this.resourceId;
  }

  public DateTime getCreatedAt() {
    return this.createdAt;
  }

  public DateTime getVisitedAt() {
    return this.visitedAt;
  }

  public String getRepLocationVerificationStatus() {
    return this.repLocationVerificationStatus;
  }

  public String getResourceAddress() {
    return this.resourceAddress;
  }

  public String getResourceType() {
    return this.resourceType;
  }

  public String getSummary() {
    return this.summary;
  }

  public DateTime getUpdatedAt() {
    return this.updatedAt;
  }

  @Override
  public String toString() {
    return "Visit{" +
            "id=" + id +
            ", creatorId=" + creatorId +
            ", outcomeId=" + outcomeId +
            ", resourceId=" + resourceId +
            ", createdAt=" + createdAt +
            ", visitedAt=" + visitedAt +
            ", repLocationVerificationStatus='" + repLocationVerificationStatus + '\'' +
            ", resourceAddress='" + resourceAddress + '\'' +
            ", resourceType='" + resourceType + '\'' +
            ", summary='" + summary + '\'' +
            ", updatedAt=" + updatedAt +
            "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Visit visit = (Visit) o;

    if (id != null ? !id.equals(visit.id) : visit.id != null) return false;
    if (creatorId != null ? !creatorId.equals(visit.creatorId) : visit.creatorId != null) return false;
    if (outcomeId != null ? !outcomeId.equals(visit.outcomeId) : visit.outcomeId != null) return false;
    if (resourceId != null ? !resourceId.equals(visit.resourceId) : visit.resourceId != null) return false;
    if (createdAt != null ? !createdAt.equals(visit.createdAt) : visit.createdAt != null) return false;
    if (visitedAt != null ? !visitedAt.equals(visit.visitedAt) : visit.visitedAt != null) return false;
    if (repLocationVerificationStatus != null ? !repLocationVerificationStatus.equals(visit.repLocationVerificationStatus) : visit.repLocationVerificationStatus != null) return false;
    if (resourceAddress != null ? !resourceAddress.equals(visit.resourceAddress) : visit.resourceAddress != null) return false;
    if (resourceType != null ? !resourceType.equals(visit.resourceType) : visit.resourceType != null) return false;
    if (summary != null ? !summary.equals(visit.summary) : visit.summary != null) return false;
    if (updatedAt != null ? !updatedAt.equals(visit.updatedAt) : visit.updatedAt != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
    result = 31 * result + (outcomeId != null ? outcomeId.hashCode() : 0);
    result = 31 * result + (resourceId != null ? resourceId.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (visitedAt != null ? visitedAt.hashCode() : 0);
    result = 31 * result + (repLocationVerificationStatus != null ? repLocationVerificationStatus.hashCode() : 0);
    result = 31 * result + (resourceAddress != null ? resourceAddress.hashCode() : 0);
    result = 31 * result + (resourceType != null ? resourceType.hashCode() : 0);
    result = 31 * result + (summary != null ? summary.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    return result;
  }
}
