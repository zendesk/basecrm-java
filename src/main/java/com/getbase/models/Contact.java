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

public class Contact {
  protected @JsonView(Views.ReadOnly.class) Long id;
  protected @JsonView(Views.ReadOnly.class) Long creatorId;
  protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
  protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;
  protected @JsonView(Views.ReadWrite.class) Long contactId;
  protected @JsonView(Views.ReadWrite.class) Long ownerId;
  protected @JsonView(Views.ReadWrite.class) Address address;
  protected @JsonView(Views.ReadWrite.class) String customerStatus;
  protected @JsonView(Views.ReadWrite.class) String description;
  protected @JsonView(Views.ReadWrite.class) String email;
  protected @JsonView(Views.ReadWrite.class) String facebook;
  protected @JsonView(Views.ReadWrite.class) String fax;
  protected @JsonView(Views.ReadWrite.class) String firstName;
  protected @JsonView(Views.ReadWrite.class) String industry;
  protected @JsonView(Views.ReadWrite.class) Boolean isOrganization;
  protected @JsonView(Views.ReadWrite.class) String lastName;
  protected @JsonView(Views.ReadWrite.class) String linkedin;
  protected @JsonView(Views.ReadWrite.class) String mobile;
  protected @JsonView(Views.ReadWrite.class) String name;
  protected @JsonView(Views.ReadWrite.class) String phone;
  protected @JsonView(Views.ReadWrite.class) String prospectStatus;
  protected @JsonView(Views.ReadWrite.class) String skype;
  protected @JsonView(Views.ReadWrite.class) String title;
  protected @JsonView(Views.ReadWrite.class) String twitter;
  protected @JsonView(Views.ReadWrite.class) String website;
  protected @JsonView(Views.ReadWrite.class) List<String> tags = new ArrayList<String>();
  protected @JsonView(Views.ReadWrite.class) Map<String, Object> customFields = new HashMap<String, Object>();

  public Contact() {
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

  public Long getContactId() {
    return this.contactId;
  }

  public Long getOwnerId() {
    return this.ownerId;
  }

  public Address getAddress() {
    return this.address;
  }

  public String getCustomerStatus() {
    return this.customerStatus;
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

  public Boolean getIsOrganization() {
    return this.isOrganization;
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

  public String getName() {
    return this.name;
  }

  public String getPhone() {
    return this.phone;
  }

  public String getProspectStatus() {
    return this.prospectStatus;
  }

  public String getSkype() {
    return this.skype;
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

  public void setContactId(long contactId) {
    this.contactId = contactId;
  }

  public void setOwnerId(long ownerId) {
    this.ownerId = ownerId;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public void setCustomerStatus(String customerStatus) {
    this.customerStatus = customerStatus;
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

  public void setIsOrganization(boolean isOrganization) {
    this.isOrganization = isOrganization;
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

  public void setName(String name) {
    this.name = name;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public void setProspectStatus(String prospectStatus) {
    this.prospectStatus = prospectStatus;
  }

  public void setSkype(String skype) {
    this.skype = skype;
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
    return "Contact{" +
          "id=" + id +
          ", creatorId=" + creatorId +
          ", createdAt=" + createdAt +
          ", updatedAt=" + updatedAt +
          ", contactId=" + contactId +
          ", ownerId=" + ownerId +
          ", address=" + address +
          ", customerStatus='" + customerStatus + '\'' +
          ", description='" + description + '\'' +
          ", email='" + email + '\'' +
          ", facebook='" + facebook + '\'' +
          ", fax='" + fax + '\'' +
          ", firstName='" + firstName + '\'' +
          ", industry='" + industry + '\'' +
          ", isOrganization=" + isOrganization +
          ", lastName='" + lastName + '\'' +
          ", linkedin='" + linkedin + '\'' +
          ", mobile='" + mobile + '\'' +
          ", name='" + name + '\'' +
          ", phone='" + phone + '\'' +
          ", prospectStatus='" + prospectStatus + '\'' +
          ", skype='" + skype + '\'' +
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

    Contact contact = (Contact) o;

    if (id != null ? !id.equals(contact.id) : contact.id != null) return false;
    if (creatorId != null ? !creatorId.equals(contact.creatorId) : contact.creatorId != null) return false;
    if (createdAt != null ? !createdAt.equals(contact.createdAt) : contact.createdAt != null) return false;
    if (updatedAt != null ? !updatedAt.equals(contact.updatedAt) : contact.updatedAt != null) return false;
    if (contactId != null ? !contactId.equals(contact.contactId) : contact.contactId != null) return false;
    if (ownerId != null ? !ownerId.equals(contact.ownerId) : contact.ownerId != null) return false;
    if (address != null ? !address.equals(contact.address) : contact.address != null) return false;
    if (customerStatus != null ? !customerStatus.equals(contact.customerStatus) : contact.customerStatus != null) return false;
    if (description != null ? !description.equals(contact.description) : contact.description != null) return false;
    if (email != null ? !email.equals(contact.email) : contact.email != null) return false;
    if (facebook != null ? !facebook.equals(contact.facebook) : contact.facebook != null) return false;
    if (fax != null ? !fax.equals(contact.fax) : contact.fax != null) return false;
    if (firstName != null ? !firstName.equals(contact.firstName) : contact.firstName != null) return false;
    if (industry != null ? !industry.equals(contact.industry) : contact.industry != null) return false;
    if (isOrganization != null ? !isOrganization.equals(contact.isOrganization) : contact.isOrganization != null) return false;
    if (lastName != null ? !lastName.equals(contact.lastName) : contact.lastName != null) return false;
    if (linkedin != null ? !linkedin.equals(contact.linkedin) : contact.linkedin != null) return false;
    if (mobile != null ? !mobile.equals(contact.mobile) : contact.mobile != null) return false;
    if (name != null ? !name.equals(contact.name) : contact.name != null) return false;
    if (phone != null ? !phone.equals(contact.phone) : contact.phone != null) return false;
    if (prospectStatus != null ? !prospectStatus.equals(contact.prospectStatus) : contact.prospectStatus != null) return false;
    if (skype != null ? !skype.equals(contact.skype) : contact.skype != null) return false;
    if (title != null ? !title.equals(contact.title) : contact.title != null) return false;
    if (twitter != null ? !twitter.equals(contact.twitter) : contact.twitter != null) return false;
    if (website != null ? !website.equals(contact.website) : contact.website != null) return false;
    if (!tags.equals(contact.tags)) return false;
    if (!customFields.equals(contact.customFields)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (id != null ? id.hashCode() : 0);
    result = 31 * result + (creatorId != null ? creatorId.hashCode() : 0);
    result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
    result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
    result = 31 * result + (contactId != null ? contactId.hashCode() : 0);
    result = 31 * result + (ownerId != null ? ownerId.hashCode() : 0);
    result = 31 * result + (address != null ? address.hashCode() : 0);
    result = 31 * result + (customerStatus != null ? customerStatus.hashCode() : 0);
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (facebook != null ? facebook.hashCode() : 0);
    result = 31 * result + (fax != null ? fax.hashCode() : 0);
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (industry != null ? industry.hashCode() : 0);
    result = 31 * result + (isOrganization != null ? isOrganization.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (linkedin != null ? linkedin.hashCode() : 0);
    result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (phone != null ? phone.hashCode() : 0);
    result = 31 * result + (prospectStatus != null ? prospectStatus.hashCode() : 0);
    result = 31 * result + (skype != null ? skype.hashCode() : 0);
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (twitter != null ? twitter.hashCode() : 0);
    result = 31 * result + (website != null ? website.hashCode() : 0);
    result = 31 * result + tags.hashCode();
    result = 31 * result + customFields.hashCode();
    return result;
  }
}
