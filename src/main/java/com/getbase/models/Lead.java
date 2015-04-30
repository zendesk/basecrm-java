package com.getbase.models;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.getbase.utils.Precondition.*;

public class Lead {
    protected @JsonView(Views.ReadOnly.class) Long id;
    protected @JsonView(Views.ReadOnly.class) Long creatorId;
    protected @JsonView(Views.ReadOnly.class) Long ownerId;
    protected @JsonView(Views.ReadWrite.class) String firstName;
    protected @JsonView(Views.ReadWrite.class) String lastName;
    protected @JsonView(Views.ReadWrite.class) String organizationName;
    protected @JsonView(Views.ReadWrite.class) String status;
    protected @JsonView(Views.ReadWrite.class) String title;
    protected @JsonView(Views.ReadWrite.class) String description;
    protected @JsonView(Views.ReadWrite.class) String industry;
    protected @JsonView(Views.ReadWrite.class) String webiste;
    protected @JsonView(Views.ReadWrite.class) String email;
    protected @JsonView(Views.ReadWrite.class) String phone;
    protected @JsonView(Views.ReadWrite.class) String mobile;
    protected @JsonView(Views.ReadWrite.class) String fax;
    protected @JsonView(Views.ReadWrite.class) String twitter;
    protected @JsonView(Views.ReadWrite.class) String facebook;
    protected @JsonView(Views.ReadWrite.class) String linkedin;
    protected @JsonView(Views.ReadWrite.class) String skype;
    protected @JsonView(Views.ReadWrite.class) Address address;
    protected @JsonView(Views.ReadWrite.class) List<String> tags = new ArrayList<String>();
    protected @JsonView(Views.ReadWrite.class) Map<String, Object> customFields = new HashMap<String, Object>();
    protected @JsonView(Views.ReadOnly.class) DateTime createdAt;
    protected @JsonView(Views.ReadOnly.class) DateTime updatedAt;

    public Long getId() {
        return id;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getIndustry() {
        return industry;
    }

    public String getWebiste() {
        return webiste;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getFax() {
        return fax;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public String getSkype() {
        return skype;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getTags() {
        return tags;
    }

    public Map<String, Object> getCustomFields() {
        return customFields;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setWebiste(String webiste) {
        this.webiste = webiste;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setTags(List<String> tags) {
        checkNotNull(tags, "tags must not be null");
        this.tags = tags;
    }

    public void setCustomFields(Map<String, Object> customFields) {
        checkNotNull(customFields, "customFields must not be null");
        this.customFields = customFields;
    }

    public void setCustomField(String fieldName, Object fieldValue) {
        checkNotNull(fieldName, "custom field's field name must not be null");
        this.customFields.put(fieldName, fieldValue);
    }
}
