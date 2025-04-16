package com.example.sponsor.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "SponsorManagement")
public class sponsorModel {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @Column(
            name = "sponsor_name"
    )
    private String sponsorName;
    @Column(
            name = "contact_person"
    )
    private String contactPerson;
    @Column(
            name = "email"
    )
    private String email;
    @Column(
            name = "sponsorship_status"
    )
    private String SponsorshipStatus;
    @Column(
            name = "contribution_amount"
    )
    private double contributionAmount;
    @Column(
            name = "contribution_date"
    )
    private LocalDate contributionDate;
    @Column(
            name = "event_name"
    )
    private String eventName;
    @Column(
            name = "org_name"
    )
    private String organizationName;
    @Column(
            name = "contact_Number"
    )
    private String contactNumber;

    public sponsorModel() {
    }

    public sponsorModel(String sponsorName, String contactPerson, String email, String SponsorshipStatus, double contributionAmount, LocalDate contributionDate, String eventName, String organizationName, String contactNumber) {
        this.sponsorName = sponsorName;
        this.contactPerson = contactPerson;
        this.email = email;
        this.SponsorshipStatus = SponsorshipStatus;
        this.contributionAmount = contributionAmount;
        this.contributionDate = contributionDate;
        this.contactNumber = contactNumber;
        this.organizationName = organizationName;
        this.eventName = eventName;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getOrganizationName() {
        return this.organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getContactNumber() {
        return this.contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSponsorName() {
        return this.sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getContactPerson() {
        return this.contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSponsorshipStatus() {
        return this.SponsorshipStatus;
    }

    public void setSponsorshipStatus(String sponsorshipStatus) {
        this.SponsorshipStatus = sponsorshipStatus;
    }

    public double getContributionAmount() {
        return this.contributionAmount;
    }

    public void setContributionAmount(double contributionAmount) {
        this.contributionAmount = contributionAmount;
    }

    public LocalDate getcontributionDate() {
        return this.contributionDate;
    }

    public void setcontributionDate(LocalDate contributionDate) {
        this.contributionDate = contributionDate;
    }
}
