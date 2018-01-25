package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;

public class CallOutcome {
    protected @JsonView(Views.ReadOnly.class) Long id;
    protected @JsonView(Views.ReadOnly.class) Long creatorId;
    protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
    protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;

    public CallOutcome() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CallOutcome that = (CallOutcome) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (creatorId != null ? !creatorId.equals(that.creatorId) : that.creatorId != null) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        return updatedAt != null ? updatedAt.equals(that.updatedAt) : that.updatedAt == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CallOutcome{" +
                "id=" + id +
                ", creatorId=" + creatorId +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}

