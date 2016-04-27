// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import static com.getbase.utils.Precondition.*;

public class Deal {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) Long creatorId;
  protected @JsonView(Views.ReadOnly.class) Long organizationId;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) String dropboxEmail;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
  protected @JsonView(Views.ReadWrite.class) Long contactId;
  protected @JsonView(Views.ReadWrite.class) Long lossReasonId;
  protected @JsonView(Views.ReadWrite.class) Long ownerId;
  protected @JsonView(Views.ReadWrite.class) Long sourceId;
  protected @JsonView(Views.ReadWrite.class) Long stageId;
  protected @JsonView(Views.ReadWrite.class) String currency;
  protected @JsonView(Views.ReadWrite.class) Boolean hot;
  protected @JsonView(Views.ReadWrite.class) String name;
  protected @JsonView(Views.ReadWrite.class) Long value;
  protected @JsonView(Views.ReadWrite.class) List<String> tags = new ArrayList<String>();
  protected @JsonView(Views.ReadWrite.class) Map<String, Object> customFields = new HashMap<String, Object>();

  public Deal() {
  }

  public Long getId() {
    return this.id;
  }

  public Long getCreatorId() {
    return this.creatorId;
  }

  public Long getOrganizationId() {
    return this.organizationId;
  }

  public DateTime getCreatedAt() {
    return this.createdAt;
  }

  public String getDropboxEmail() {
    return this.dropboxEmail;
  }

  public DateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public Long getContactId() {
    return this.contactId;
  }

  public Long getLossReasonId() {
    return this.lossReasonId;
  }

  public Long getOwnerId() {
    return this.ownerId;
  }

  public Long getSourceId() {
    return this.sourceId;
  }

  public Long getStageId() {
    return this.stageId;
  }

  public String getCurrency() {
    return this.currency;
  }

  public Boolean getHot() {
    return this.hot;
  }

  public String getName() {
    return this.name;
  }

  public Long getValue() {
    return this.value;
  }

  public List<String> getTags() {
    return this.tags;
  }

  public Map<String, Object> getCustomFields() {
    return this.customFields;
  }

  public void setContactId(long contactId) {
    this.contactId = contactId;
  }

  public void setLossReasonId(long lossReasonId) {
    this.lossReasonId = lossReasonId;
  }

  public void setOwnerId(long ownerId) {
    this.ownerId = ownerId;
  }

  public void setSourceId(long sourceId) {
    this.sourceId = sourceId;
  }

  public void setStageId(long stageId) {
    this.stageId = stageId;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public void setHot(boolean hot) {
    this.hot = hot;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setValue(long value) {
    this.value = value;
  }

  public void setTags(List<String> tags) {
    checkNotNull(tags, "tags must not be null.");
    this.tags = tags;
  }

  public void setCustomFields(Map<String, Object> customFields) {
    checkNotNull(customFields, "customFields must not be null.");
    this.customFields = customFields;
  }

  @Override
  public String toString() {
    return "Deal{" +
          "id=" + id +
          ", creatorId=" + creatorId +
          ", organizationId=" + organizationId +
          ", createdAt=" + createdAt +
          ", dropboxEmail='" + dropboxEmail + '\'' +
          ", updatedAt=" + updatedAt +
          ", contactId=" + contactId +
          ", lossReasonId=" + lossReasonId +
          ", ownerId=" + ownerId +
          ", sourceId=" + sourceId +
          ", stageId=" + stageId +
          ", currency='" + currency + '\'' +
          ", hot=" + hot +
          ", name='" + name + '\'' +
          ", value=" + value +
          ", tags=" + tags +
          ", customFields=" + customFields +
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Deal deal = (Deal) o;

    if (id != null ? !id.equals(deal.id) : deal.id != null) return false;
    if (creatorId != null ? !creatorId.equals(deal.creatorId) : deal.creatorId != null) return false;
    if (organizationId != null ? !organizationId.equals(deal.organizationId) : deal.organizationId != null) return false;
    if (createdAt != null ? !createdAt.equals(deal.createdAt) : deal.createdAt != null) return false;
    if (dropboxEmail != null ? !dropboxEmail.equals(deal.dropboxEmail) : deal.dropboxEmail != null) return false;
    if (updatedAt != null ? !updatedAt.equals(deal.updatedAt) : deal.updatedAt != null) return false;
    if (contactId != null ? !contactId.equals(deal.contactId) : deal.contactId != null) return false;
    if (lossReasonId != null ? !lossReasonId.equals(deal.lossReasonId) : deal.lossReasonId != null) return false;
    if (ownerId != null ? !ownerId.equals(deal.ownerId) : deal.ownerId != null) return false;
    if (sourceId != null ? !sourceId.equals(deal.sourceId) : deal.sourceId != null) return false;
    if (stageId != null ? !stageId.equals(deal.stageId) : deal.stageId != null) return false;
    if (currency != null ? !currency.equals(deal.currency) : deal.currency != null) return false;
    if (hot != null ? !hot.equals(deal.hot) : deal.hot != null) return false;
    if (name != null ? !name.equals(deal.name) : deal.name != null) return false;
    if (value != null ? !value.equals(deal.value) : deal.value != null) return false;
    if (!tags.equals(deal.tags)) return false;
    if (!customFields.equals(deal.customFields)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
    result = 31 * result + (organizationId != null ? organizationId.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (dropboxEmail != null ? dropboxEmail.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (contactId != null ? contactId.hashCode() : 0);
    result = 31 * result + (lossReasonId != null ? lossReasonId.hashCode() : 0);
    result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
    result = 31 * result + (sourceId != null ? sourceId.hashCode() : 0);
    result = 31 * result + (stageId != null ? stageId.hashCode() : 0);
    result = 31 * result + (currency != null ? currency.hashCode() : 0);
    result = 31 * result + (hot != null ? hot.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (value != null ? value.hashCode() : 0);
    result = 31 * result + tags.hashCode();
    result = 31 * result + customFields.hashCode();
    return result;
  }
}
