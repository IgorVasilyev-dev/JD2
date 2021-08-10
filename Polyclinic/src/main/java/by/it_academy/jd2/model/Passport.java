package by.it_academy.jd2.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Passport")
@Table(name = "passports_data")
public class Passport {

    @Id
    @Generated(GenerationTime.NEVER)
    private Long id;

    @Column(name = "passport_id", nullable = false)
    private String passportId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "code_issuing", nullable = false)
    private String codeOfIssuing;

    @Column(name = "passport_number", nullable = false)
    private String passportNum;

    @Column(name = "nationality", nullable = false)
    private String nationality;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "issue_date", nullable = false)
    private Date issueDate;

    @Column(name = "expiry_date", nullable = false)
    private Date expiryDate;

    @Column(name = "birth_place", nullable = false)
    private String birthPlace;

    public Passport(Long id, String passportId, String firstName, String lastName, String codeOfIssuing, String passportNum, String nationality, Date birthDate, String sex, Date issueDate, Date expiryDate, String birthPlace) {
        this.id = id;
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

    public Passport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                "id=" + id +
                ", passportId='" + passportId + '\'' +
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
