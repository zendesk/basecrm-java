// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;



public class Task {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) Long creatorId;
  protected @JsonView(Views.ReadOnly.class) DateTime completedAt;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) Boolean overdue;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
  protected @JsonView(Views.ReadWrite.class) Long ownerId;
  protected @JsonView(Views.ReadWrite.class) Long resourceId;
  protected @JsonView(Views.ReadWrite.class) Boolean completed;
  protected @JsonView(Views.ReadWrite.class) String content;
  protected @JsonView(Views.ReadWrite.class) DateTime dueDate;
  protected @JsonView(Views.ReadWrite.class) DateTime remindAt;
  protected @JsonView(Views.ReadWrite.class) String resourceType;

  public Task() {
  }

  public Long getId() {
    return this.id;
  }

  public Long getCreatorId() {
    return this.creatorId;
  }

  public DateTime getCompletedAt() {
    return this.completedAt;
  }

  public DateTime getCreatedAt() {
    return this.createdAt;
  }

  public Boolean getOverdue() {
    return this.overdue;
  }

  public DateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public Long getOwnerId() {
    return this.ownerId;
  }

  public Long getResourceId() {
    return this.resourceId;
  }

  public Boolean getCompleted() {
    return this.completed;
  }

  public String getContent() {
    return this.content;
  }

  public DateTime getDueDate() {
    return this.dueDate;
  }

  public DateTime getRemindAt() {
    return this.remindAt;
  }

  public String getResourceType() {
    return this.resourceType;
  }

  public void setOwnerId(long ownerId) {
    this.ownerId = ownerId;
  }

  public void setResourceId(long resourceId) {
    this.resourceId = resourceId;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setDueDate(DateTime dueDate) {
    this.dueDate = dueDate;
  }

  public void setRemindAt(DateTime remindAt) {
    this.remindAt = remindAt;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  @Override
  public String toString() {
    return "Task{" +
          "id=" + id + 
          "creatorId=" + creatorId + 
          "completedAt=" + completedAt + 
          "createdAt=" + createdAt + 
          "overdue=" + overdue + 
          "updatedAt=" + updatedAt + 
          "ownerId=" + ownerId + 
          "resourceId=" + resourceId + 
          "completed=" + completed + 
          "content='" + content + '\'' + 
          "dueDate=" + dueDate + 
          "remindAt=" + remindAt + 
          "resourceType='" + resourceType + '\'' + 
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Task task = (Task) o;

    if (id != null ? !id.equals(task.id) : task.id != null) return false;
    if (creatorId != null ? !creatorId.equals(task.creatorId) : task.creatorId != null) return false;
    if (completedAt != null ? !completedAt.equals(task.completedAt) : task.completedAt != null) return false;
    if (createdAt != null ? !createdAt.equals(task.createdAt) : task.createdAt != null) return false;
    if (overdue != null ? !overdue.equals(task.overdue) : task.overdue != null) return false;
    if (updatedAt != null ? !updatedAt.equals(task.updatedAt) : task.updatedAt != null) return false;
    if (ownerId != null ? !ownerId.equals(task.ownerId) : task.ownerId != null) return false;
    if (resourceId != null ? !resourceId.equals(task.resourceId) : task.resourceId != null) return false;
    if (completed != null ? !completed.equals(task.completed) : task.completed != null) return false;
    if (content != null ? !content.equals(task.content) : task.content != null) return false;
    if (dueDate != null ? !dueDate.equals(task.dueDate) : task.dueDate != null) return false;
    if (remindAt != null ? !remindAt.equals(task.remindAt) : task.remindAt != null) return false;
    if (resourceType != null ? !resourceType.equals(task.resourceType) : task.resourceType != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
    result = 31 * result + (completedAt != null ? completedAt.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (overdue != null ? overdue.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
    result = 31 * result + (resourceId != null ? resourceId.hashCode() : 0);
    result = 31 * result + (completed != null ? completed.hashCode() : 0);
    result = 31 * result + (content != null ? content.hashCode() : 0);
    result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
    result = 31 * result + (remindAt != null ? remindAt.hashCode() : 0);
    result = 31 * result + (resourceType != null ? resourceType.hashCode() : 0);
    return result;
  }
}
