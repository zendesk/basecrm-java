// WARNING: This code is auto-generated from the BaseCRM API Discovery JSON Schema

package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;



public class Stage {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
  protected @JsonView(Views.ReadWrite.class) Long pipelineId;
  protected @JsonView(Views.ReadWrite.class) Boolean active;
  protected @JsonView(Views.ReadWrite.class) String category;
  protected @JsonView(Views.ReadWrite.class) Long likelihood;
  protected @JsonView(Views.ReadWrite.class) String name;
  protected @JsonView(Views.ReadWrite.class) Long position;

  public Stage() {
  }

  public Long getId() {
    return this.id;
  }

  public DateTime getCreatedAt() {
    return this.createdAt;
  }

  public DateTime getUpdatedAt() {
    return this.updatedAt;
  }

  public Long getPipelineId() {
    return this.pipelineId;
  }

  public Boolean getActive() {
    return this.active;
  }

  public String getCategory() {
    return this.category;
  }

  public Long getLikelihood() {
    return this.likelihood;
  }

  public String getName() {
    return this.name;
  }

  public Long getPosition() {
    return this.position;
  }

  public void setPipelineId(long pipelineId) {
    this.pipelineId = pipelineId;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setLikelihood(long likelihood) {
    this.likelihood = likelihood;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPosition(long position) {
    this.position = position;
  }

  @Override
  public String toString() {
    return "Stage{" +
          "id=" + id +
          ", createdAt=" + createdAt +
          ", updatedAt=" + updatedAt +
          ", pipelineId=" + pipelineId +
          ", active=" + active +
          ", category='" + category + '\'' +
          ", likelihood=" + likelihood +
          ", name='" + name + '\'' +
          ", position=" + position +
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Stage stage = (Stage) o;

    if (id != null ? !id.equals(stage.id) : stage.id != null) return false;
    if (createdAt != null ? !createdAt.equals(stage.createdAt) : stage.createdAt != null) return false;
    if (updatedAt != null ? !updatedAt.equals(stage.updatedAt) : stage.updatedAt != null) return false;
    if (pipelineId != null ? !pipelineId.equals(stage.pipelineId) : stage.pipelineId != null) return false;
    if (active != null ? !active.equals(stage.active) : stage.active != null) return false;
    if (category != null ? !category.equals(stage.category) : stage.category != null) return false;
    if (likelihood != null ? !likelihood.equals(stage.likelihood) : stage.likelihood != null) return false;
    if (name != null ? !name.equals(stage.name) : stage.name != null) return false;
    if (position != null ? !position.equals(stage.position) : stage.position != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (pipelineId != null ? pipelineId.hashCode() : 0);
    result = 31 * result + (active != null ? active.hashCode() : 0);
    result = 31 * result + (category != null ? category.hashCode() : 0);
    result = 31 * result + (likelihood != null ? likelihood.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (position != null ? position.hashCode() : 0);
    return result;
  }
}
