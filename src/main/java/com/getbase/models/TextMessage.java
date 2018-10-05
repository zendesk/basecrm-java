// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

import static com.getbase.utils.Precondition.*;

public class TextMessage {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) List<Long> associatedDealIds;
  protected @JsonView(Views.ReadOnly.class) Long resourceId;
  protected @JsonView(Views.ReadOnly.class) Long userId;
  protected @JsonView(Views.ReadOnly.class) String content;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) Boolean incoming;
  protected @JsonView(Views.ReadOnly.class) String resourcePhoneNumber;
  protected @JsonView(Views.ReadOnly.class) String resourceType;
  protected @JsonView(Views.ReadOnly.class) DateTime sentAt;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
  protected @JsonView(Views.ReadOnly.class) String userPhoneNumber;

  public TextMessage() {
  }

  public Long getId() {
    return this.id;
  }

  public List<Long> getAssociatedDealIds() {
    return this.associatedDealIds;
  }

  public Long getResourceId() {
    return this.resourceId;
  }

  public Long getUserId() {
    return this.userId;
  }

  public String getContent() {
    return this.content;
  }

  public DateTime getCreatedAt() {
    return this.createdAt;
  }

  public Boolean getIncoming() {
    return this.incoming;
  }

  public String getResourcePhoneNumber() {
    return this.resourcePhoneNumber;
  }

  public String getResourceType() {
    return this.resourceType;
  }

  public DateTime getSentAt() {
    return this.sentAt;
  }

  public DateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public String getUserPhoneNumber() {
    return this.userPhoneNumber;
  }

  @Override
  public String toString() {
    return "TextMessage{" +
          "id=" + id +
          ", associatedDealIds=" + associatedDealIds +
          ", resourceId=" + resourceId +
          ", userId=" + userId +
          ", content='" + content + '\'' +
          ", createdAt=" + createdAt +
          ", incoming=" + incoming +
          ", resourcePhoneNumber='" + resourcePhoneNumber + '\'' +
          ", resourceType='" + resourceType + '\'' +
          ", sentAt=" + sentAt +
          ", updatedAt=" + updatedAt +
          ", userPhoneNumber='" + userPhoneNumber + '\'' +
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TextMessage textMessage = (TextMessage) o;

    if (id != null ? !id.equals(textMessage.id) : textMessage.id != null) return false;
    if (!associatedDealIds.equals(textMessage.associatedDealIds)) return false;
    if (resourceId != null ? !resourceId.equals(textMessage.resourceId) : textMessage.resourceId != null) return false;
    if (userId != null ? !userId.equals(textMessage.userId) : textMessage.userId != null) return false;
    if (content != null ? !content.equals(textMessage.content) : textMessage.content != null) return false;
    if (createdAt != null ? !createdAt.equals(textMessage.createdAt) : textMessage.createdAt != null) return false;
    if (incoming != null ? !incoming.equals(textMessage.incoming) : textMessage.incoming != null) return false;
    if (resourcePhoneNumber != null ? !resourcePhoneNumber.equals(textMessage.resourcePhoneNumber) : textMessage.resourcePhoneNumber != null) return false;
    if (resourceType != null ? !resourceType.equals(textMessage.resourceType) : textMessage.resourceType != null) return false;
    if (sentAt != null ? !sentAt.equals(textMessage.sentAt) : textMessage.sentAt != null) return false;
    if (updatedAt != null ? !updatedAt.equals(textMessage.updatedAt) : textMessage.updatedAt != null) return false;
    if (userPhoneNumber != null ? !userPhoneNumber.equals(textMessage.userPhoneNumber) : textMessage.userPhoneNumber != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + associatedDealIds.hashCode();
    result = 31 * result + (resourceId != null ? resourceId.hashCode() : 0);
    result = 31 * result + (userId != null ? userId.hashCode() : 0);
    result = 31 * result + (content != null ? content.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (incoming != null ? incoming.hashCode() : 0);
    result = 31 * result + (resourcePhoneNumber != null ? resourcePhoneNumber.hashCode() : 0);
    result = 31 * result + (resourceType != null ? resourceType.hashCode() : 0);
    result = 31 * result + (sentAt != null ? sentAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (userPhoneNumber != null ? userPhoneNumber.hashCode() : 0);
    return result;
  }
}
