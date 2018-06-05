package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

public class Call {
    protected @JsonView(Views.ReadOnly.class) Long id;
    protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
    protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
    protected @JsonView(Views.ReadWrite.class) Long userId;
    protected @JsonView(Views.ReadWrite.class) String summary;
    protected @JsonView(Views.ReadWrite.class) String recordingUrl;
    protected @JsonView(Views.ReadWrite.class) Long outcomeId;
    protected @JsonView(Views.ReadWrite.class) Long duration;
    protected @JsonView(Views.ReadWrite.class) String phoneNumber;
    protected @JsonView(Views.ReadWrite.class) Boolean incoming;
    protected @JsonView(Views.ReadWrite.class) Boolean missed;
    protected @JsonView(Views.ReadWrite.class) String resourceType;
    protected @JsonView(Views.ReadWrite.class) Long resourceId;
    protected @JsonView(Views.ReadWrite.class) List<Long> associatedDealIds = new ArrayList<Long>();
    protected @JsonView(Views.ReadWrite.class) DateTime madeAt;
    protected @JsonView(Views.ReadWrite.class) String externalId;

    public Call() {
    }

    public Long getId() {
        return id;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(DateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRecordingUrl() {
        return recordingUrl;
    }

    public void setRecordingUrl(String recordingUrl) {
        this.recordingUrl = recordingUrl;
    }

    public Long getOutcomeId() {
        return outcomeId;
    }

    public void setOutcomeId(Long outcomeId) {
        this.outcomeId = outcomeId;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getIncoming() {
        return incoming;
    }

    public void setIncoming(Boolean incoming) {
        this.incoming = incoming;
    }

    public Boolean getMissed() {
        return missed;
    }

    public void setMissed(Boolean missed) {
        this.missed = missed;
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

    public List<Long> getAssociatedDealIds() {
        return associatedDealIds;
    }

    public void setAssociatedDealIds(List<Long> associatedDealIds) {
        this.associatedDealIds = associatedDealIds;
    }

    public DateTime getMadeAt() {
        return madeAt;
    }

    public void setMadeAt(DateTime madeAt) {
        this.madeAt = madeAt;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Call call = (Call) o;

        if (id != null ? !id.equals(call.id) : call.id != null) return false;
        if (createdAt != null ? !createdAt.equals(call.createdAt) : call.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(call.updatedAt) : call.updatedAt != null) return false;
        if (userId != null ? !userId.equals(call.userId) : call.userId != null) return false;
        if (summary != null ? !summary.equals(call.summary) : call.summary != null) return false;
        if (recordingUrl != null ? !recordingUrl.equals(call.recordingUrl) : call.recordingUrl != null) return false;
        if (outcomeId != null ? !outcomeId.equals(call.outcomeId) : call.outcomeId != null) return false;
        if (duration != null ? !duration.equals(call.duration) : call.duration != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(call.phoneNumber) : call.phoneNumber != null) return false;
        if (incoming != null ? !incoming.equals(call.incoming) : call.incoming != null) return false;
        if (missed != null ? !missed.equals(call.missed) : call.missed != null) return false;
        if (resourceType != null ? !resourceType.equals(call.resourceType) : call.resourceType != null) return false;
        if (resourceId != null ? !resourceId.equals(call.resourceId) : call.resourceId != null) return false;
        if (associatedDealIds != null ? !associatedDealIds.equals(call.associatedDealIds) : call.associatedDealIds != null)
            return false;
        if (madeAt != null ? !madeAt.equals(call.madeAt) : call.madeAt != null) return false;
        return externalId != null ? externalId.equals(call.externalId) : call.externalId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (recordingUrl != null ? recordingUrl.hashCode() : 0);
        result = 31 * result + (outcomeId != null ? outcomeId.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (incoming != null ? incoming.hashCode() : 0);
        result = 31 * result + (missed != null ? missed.hashCode() : 0);
        result = 31 * result + (resourceType != null ? resourceType.hashCode() : 0);
        result = 31 * result + (resourceId != null ? resourceId.hashCode() : 0);
        result = 31 * result + (associatedDealIds != null ? associatedDealIds.hashCode() : 0);
        result = 31 * result + (madeAt != null ? madeAt.hashCode() : 0);
        result = 31 * result + (externalId != null ? externalId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", userId=" + userId +
                ", summary='" + summary + '\'' +
                ", recordingUrl='" + recordingUrl + '\'' +
                ", outcomeId=" + outcomeId +
                ", duration=" + duration +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", incoming=" + incoming +
                ", missed=" + missed +
                ", resourceType='" + resourceType + '\'' +
                ", resourceId=" + resourceId +
                ", associatedDealIds=" + associatedDealIds +
                ", madeAt=" + madeAt +
                ", externalId='" + externalId + '\'' +
                '}';
    }

}

