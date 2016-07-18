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

public class Lead {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) Long creatorId;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
  protected @JsonView(Views.ReadWrite.class) Long ownerId;
  protected @JsonView(Views.ReadWrite.class) Long sourceId;
  protected @JsonView(Views.ReadWrite.class) Address address;
  protected @JsonView(Views.ReadWrite.class) String description;
  protected @JsonView(Views.ReadWrite.class) String email;
  protected @JsonView(Views.ReadWrite.class) String facebook;
  protected @JsonView(Views.ReadWrite.class) String fax;
  protected @JsonView(Views.ReadWrite.class) String firstName;
  protected @JsonView(Views.ReadWrite.class) String industry;
  protected @JsonView(Views.ReadWrite.class) String lastName;
  protected @JsonView(Views.ReadWrite.class) String linkedin;
  protected @JsonView(Views.ReadWrite.class) String mobile;
  protected @JsonView(Views.ReadWrite.class) String organizationName;
  protected @JsonView(Views.ReadWrite.class) String phone;
  protected @JsonView(Views.ReadWrite.class) String skype;
  protected @JsonView(Views.ReadWrite.class) String status;
  protected @JsonView(Views.ReadWrite.class) String title;
  protected @JsonView(Views.ReadWrite.class) String twitter;
  protected @JsonView(Views.ReadWrite.class) String website;
  protected @JsonView(Views.ReadWrite.class) List<String> tags = new ArrayList<String>();
  protected @JsonView(Views.ReadWrite.class) Map<String, Object> customFields = new HashMap<String, Object>();

  public Lead() {
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

  public Long getOwnerId() {
    return this.ownerId;
  }

  public Long getSourceId() {
    return this.sourceId;
  }

  public Address getAddress() {
    return this.address;
  }

  public String getDescription() {
    return this.description;
  }

  public String getEmail() {
    return this.email;
  }

  public String getFacebook() {
    return this.facebook;
  }

  public String getFax() {
    return this.fax;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getIndustry() {
    return this.industry;
  }

  public String getLastName() {
    return this.lastName;
  }

  public String getLinkedin() {
    return this.linkedin;
  }

  public String getMobile() {
    return this.mobile;
  }

  public String getOrganizationName() {
    return this.organizationName;
  }

  public String getPhone() {
    return this.phone;
  }

  public String getSkype() {
    return this.skype;
  }

  public String getStatus() {
    return this.status;
  }

  public String getTitle() {
    return this.title;
  }

  public String getTwitter() {
    return this.twitter;
  }

  public String getWebsite() {
    return this.website;
  }

  public List<String> getTags() {
    return this.tags;
  }

  public Map<String, Object> getCustomFields() {
    return this.customFields;
  }

  public void setOwnerId(long ownerId) {
    this.ownerId = ownerId;
  }

  public void setSourceId(Long sourceId) {
    this.sourceId = sourceId;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setFacebook(String facebook) {
    this.facebook = facebook;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setIndustry(String industry) {
    this.industry = industry;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setLinkedin(String linkedin) {
    this.linkedin = linkedin;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public void setOrganizationName(String organizationName) {
    this.organizationName = organizationName;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setSkype(String skype) {
    this.skype = skype;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setTwitter(String twitter) {
    this.twitter = twitter;
  }

  public void setWebsite(String website) {
    this.website = website;
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
    return "Lead{" +
          "id=" + id +
          ", creatorId=" + creatorId +
          ", createdAt=" + createdAt +
          ", updatedAt=" + updatedAt +
          ", ownerId=" + ownerId +
          ", sourceId=" + sourceId +
          ", address=" + address +
          ", description='" + description + '\'' +
          ", email='" + email + '\'' +
          ", facebook='" + facebook + '\'' +
          ", fax='" + fax + '\'' +
          ", firstName='" + firstName + '\'' +
          ", industry='" + industry + '\'' +
          ", lastName='" + lastName + '\'' +
          ", linkedin='" + linkedin + '\'' +
          ", mobile='" + mobile + '\'' +
          ", organizationName='" + organizationName + '\'' +
          ", phone='" + phone + '\'' +
          ", skype='" + skype + '\'' +
          ", status='" + status + '\'' +
          ", title='" + title + '\'' +
          ", twitter='" + twitter + '\'' +
          ", website='" + website + '\'' +
          ", tags=" + tags +
          ", customFields=" + customFields +
          "}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Lead lead = (Lead) o;

    if (id != null ? !id.equals(lead.id) : lead.id != null) return false;
    if (creatorId != null ? !creatorId.equals(lead.creatorId) : lead.creatorId != null) return false;
    if (createdAt != null ? !createdAt.equals(lead.createdAt) : lead.createdAt != null) return false;
    if (updatedAt != null ? !updatedAt.equals(lead.updatedAt) : lead.updatedAt != null) return false;
    if (ownerId != null ? !ownerId.equals(lead.ownerId) : lead.ownerId != null) return false;
    if (address != null ? !address.equals(lead.address) : lead.address != null) return false;
    if (description != null ? !description.equals(lead.description) : lead.description != null) return false;
    if (email != null ? !email.equals(lead.email) : lead.email != null) return false;
    if (facebook != null ? !facebook.equals(lead.facebook) : lead.facebook != null) return false;
    if (fax != null ? !fax.equals(lead.fax) : lead.fax != null) return false;
    if (firstName != null ? !firstName.equals(lead.firstName) : lead.firstName != null) return false;
    if (industry != null ? !industry.equals(lead.industry) : lead.industry != null) return false;
    if (lastName != null ? !lastName.equals(lead.lastName) : lead.lastName != null) return false;
    if (linkedin != null ? !linkedin.equals(lead.linkedin) : lead.linkedin != null) return false;
    if (mobile != null ? !mobile.equals(lead.mobile) : lead.mobile != null) return false;
    if (organizationName != null ? !organizationName.equals(lead.organizationName) : lead.organizationName != null) return false;
    if (phone != null ? !phone.equals(lead.phone) : lead.phone != null) return false;
    if (skype != null ? !skype.equals(lead.skype) : lead.skype != null) return false;
    if (status != null ? !status.equals(lead.status) : lead.status != null) return false;
    if (title != null ? !title.equals(lead.title) : lead.title != null) return false;
    if (twitter != null ? !twitter.equals(lead.twitter) : lead.twitter != null) return false;
    if (website != null ? !website.equals(lead.website) : lead.website != null) return false;
    if (!tags.equals(lead.tags)) return false;
    if (!customFields.equals(lead.customFields)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
    result = 31 * result + (fax != null ? fax.hashCode() : 0);
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (industry != null ? industry.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (linkedin != null ? linkedin.hashCode() : 0);
    result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
    result = 31 * result + (organizationName != null ? organizationName.hashCode() : 0);
    result = 31 * result + (phone != null ? phone.hashCode() : 0);
    result = 31 * result + (skype != null ? skype.hashCode() : 0);
    result = 31 * result + (status != null ? status.hashCode() : 0);
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (twitter != null ? twitter.hashCode() : 0);
    result = 31 * result + (website != null ? website.hashCode() : 0);
    result = 31 * result + tags.hashCode();
    result = 31 * result + customFields.hashCode();
    return result;
  }
}
