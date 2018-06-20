package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;

public class Collaboration {

    protected @JsonView(Views.ReadOnly.class) Long id;
    protected @JsonView(Views.ReadOnly.class) Long creatorId;
    protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
    protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
    protected @JsonView(Views.ReadWrite.class) String resourceType;
    protected @JsonView(Views.ReadWrite.class) Long resourceId;
    protected @JsonView(Views.ReadWrite.class) Long collaboratorId;

    public Long getId() {
        return id;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getCollaboratorId() {
        return collaboratorId;
    }

    public void setCollaboratorId(Long collaboratorId) {
        this.collaboratorId = collaboratorId;
    }

    @Override
    public String toString() {
        return "Collaboration{" +
                "id=" + id +
                ", creatorId=" + creatorId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", resourceType='" + resourceType + '\'' +
                ", resourceId=" + resourceId +
                ", collaboratorId=" + collaboratorId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Collaboration that = (Collaboration) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (creatorId != null ? !creatorId.equals(that.creatorId) : that.creatorId != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (resourceType != null ? !resourceType.equals(that.resourceType) : that.resourceType != null) return false;
        if (resourceId != null ? !resourceId.equals(that.resourceId) : that.resourceId != null) return false;
        return collaboratorId != null ? collaboratorId.equals(that.collaboratorId) : that.collaboratorId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (resourceType != null ? resourceType.hashCode() : 0);
        result = 31 * result + (resourceId != null ? resourceId.hashCode() : 0);
        result = 31 * result + (collaboratorId != null ? collaboratorId.hashCode() : 0);
        return result;
    }

}
