package by.it_academy.jd2.model.pojo;

import by.it_academy.jd2.model.views.Views;
import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;
import java.util.Date;

public class Passport implements Serializable {

    @JsonView(Views.Public.class)
    private String passportId;

    @JsonView(Views.Public.class)
    private String firstName;

    @JsonView(Views.Public.class)
    private String lastName;

    @JsonView(Views.Public.class)
    private String codeOfIssuing;

    @JsonView(Views.Public.class)
    private String passportNum;

    @JsonView(Views.Public.class)
    private String nationality;

    @JsonView(Views.Public.class)
    private Date birthDate;

    @JsonView(Views.Public.class)
    private String sex;

    @JsonView(Views.Public.class)
    private Date issueDate;

    @JsonView(Views.Public.class)
    private Date expiryDate;

    @JsonView(Views.Public.class)
    private String birthPlace;

    public Passport() {
    }

    public Passport(String passportId, String firstName, String lastName, String codeOfIssuing, String passportNum,
                    String nationality, Date birthDate, String sex, Date issueDate, Date expiryDate, String birthPlace) {
        this.passportId = passportId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.codeOfIssuing = codeOfIssuing;
        this.passportNum = passportNum;
        this.nationality = nationality;
        this.birthDate = birthDate;
        this.sex = sex;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.birthPlace = birthPlace;
    }

    public String getPassportId() {
        return passportId;
    }

    public void setPassportId(String passportId) {
        this.passportId = passportId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCodeOfIssuing() {
        return codeOfIssuing;
    }

    public void setCodeOfIssuing(String codeOfIssuing) {
        this.codeOfIssuing = codeOfIssuing;
    }

    public String getPassportNum() {
        return passportNum;
    }

    public void setPassportNum(String passportNum) {
        this.passportNum = passportNum;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "passportId='" + passportId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", codeOfIssuing='" + codeOfIssuing + '\'' +
                ", passportNum='" + passportNum + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthDate=" + birthDate +
                ", sex='" + sex + '\'' +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate +
                ", birthPlace='" + birthPlace + '\'' +
                '}';
    }
}
