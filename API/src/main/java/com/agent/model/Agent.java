package com.agent.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "AGENT_INFO")
public class Agent implements Serializable {

    @Id
    @Column(name = "id_agent_info")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer agentId;
    @Column(name = "agent_type")
    private Integer agentType;
    @Column(name = "advisor_code")
    private String advisorCode;
    @Column(name = "status_advisor")
    private Integer statusAdvisor;
    @Column(name = "title_id")
    private Integer titleId;
    @Column(name = "gender_id")
    private Integer genderId;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "married_status_id")
    private Integer marriedStatusId;
    @Column(name = "reporting_person")
    private String reportingPerson;
    @Column(name = "mobile_1")
    private String mobile;
    @Column(name = "fins_code")
    private String finsCode;
    @Column(name = "acss_code")
    private String acssCode;
    @Column(name = "acsi_code")
    private String acsiCode;
    @Column(name = "ims_code")
    private String imsCode;
    @Column(name = "designation")
    private String designation;
    @Column(name = "branch_name")
    private String branchName;
    @Column(name = "branch_code")
    private String branchCode;
    @Column(name = "agent_nic")
    private String agentNIC;
    @Column(name = "print_name")
    private String printName;

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getAgentType() {
        return agentType;
    }

    public void setAgentType(Integer agentType) {
        this.agentType = agentType;
    }

    public String getAdvisorCode() {
        return advisorCode;
    }

    public void setAdvisorCode(String advisorCode) {
        this.advisorCode = advisorCode;
    }

    public Integer getStatusAdvisor() {
        return statusAdvisor;
    }

    public void setStatusAdvisor(Integer statusAdvisor) {
        this.statusAdvisor = statusAdvisor;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public Integer getGenderId() {
        return genderId;
    }

    public void setGenderId(Integer genderId) {
        this.genderId = genderId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getMarriedStatusId() {
        return marriedStatusId;
    }

    public void setMarriedStatusId(Integer marriedStatusId) {
        this.marriedStatusId = marriedStatusId;
    }

    public String getReportingPerson() {
        return reportingPerson;
    }

    public void setReportingPerson(String reportingPerson) {
        this.reportingPerson = reportingPerson;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFinsCode() {
        return finsCode;
    }

    public void setFinsCode(String finsCode) {
        this.finsCode = finsCode;
    }

    public String getAcssCode() {
        return acssCode;
    }

    public void setAcssCode(String acssCode) {
        this.acssCode = acssCode;
    }

    public String getAcsiCode() {
        return acsiCode;
    }

    public void setAcsiCode(String acsiCode) {
        this.acsiCode = acsiCode;
    }

    public String getImsCode() {
        return imsCode;
    }

    public void setImsCode(String imsCode) {
        this.imsCode = imsCode;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getAgentNIC() {
        return agentNIC;
    }

    public void setAgentNIC(String agentNIC) {
        this.agentNIC = agentNIC;
    }

    public String getPrintName() {
        return printName;
    }

    public void setPrintName(String printName) {
        this.printName = printName;
    }
}
