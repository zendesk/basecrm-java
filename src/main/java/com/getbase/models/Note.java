// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;



public class Note {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) Long creatorId;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
  protected @JsonView(Views.ReadWrite.class) Long resourceId;
  protected @JsonView(Views.ReadWrite.class) String content;
  protected @JsonView(Views.ReadWrite.class) String resourceType;
  protected @JsonView(Views.ReadWrite.class) String type;

  public Note() {
  }

  public Long getId() {
    return this.id;
  }

  public Long getCreatorId() {
    return this.creatorId;
  }

  public DateTime getCreatedAt() {
    return this.createdAt;
  }

  public DateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public Long getResourceId() {
    return this.resourceId;
  }

  public String getContent() {
    return this.content;
  }

  public String getResourceType() {
    return this.resourceType;
  }

  public void setResourceId(long resourceId) {
    this.resourceId = resourceId;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void setResourceType(String resourceType) {
    this.resourceType = resourceType;
  }

  @Override
  public String toString() {
    return "Note{" +
          "id=" + id +
          ", creatorId=" + creatorId +
          ", createdAt=" + createdAt +
          ", updatedAt=" + updatedAt +
          ", resourceId=" + resourceId +
          ", content='" + content + '\'' +
          ", resourceType='" + resourceType + '\'' +
          ", type='" + type + '\'' +
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Note note = (Note) o;

    if (id != null ? !id.equals(note.id) : note.id != null) return false;
    if (creatorId != null ? !creatorId.equals(note.creatorId) : note.creatorId != null) return false;
    if (createdAt != null ? !createdAt.equals(note.createdAt) : note.createdAt != null) return false;
    if (updatedAt != null ? !updatedAt.equals(note.updatedAt) : note.updatedAt != null) return false;
    if (resourceId != null ? !resourceId.equals(note.resourceId) : note.resourceId != null) return false;
    if (content != null ? !content.equals(note.content) : note.content != null) return false;
    if (type != null ? !type.equals(note.type) : note.type != null) return false;
    if (resourceType != null ? !resourceType.equals(note.resourceType) : note.resourceType != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (resourceId != null ? resourceId.hashCode() : 0);
    result = 31 * result + (content != null ? content.hashCode() : 0);
    result = 31 * result + (resourceType != null ? resourceType.hashCode() : 0);
    result = 31 * result + (type != null ? type.hashCode() : 0);
    return result;
  }
}
