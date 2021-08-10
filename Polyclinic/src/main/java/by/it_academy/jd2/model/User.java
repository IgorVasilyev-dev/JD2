package by.it_academy.jd2.model;

import by.it_academy.jd2.model.pojo.Address;
import by.it_academy.jd2.model.pojo.Passport;
import by.it_academy.jd2.model.views.Views;
import by.it_academy.jd2.utils.annotation.Parse;
import com.fasterxml.jackson.annotation.JsonView;
import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;


@Entity(name = "User")
@Table(name = "users_data", schema = "polyclinic")
@TypeDef(name = "json", typeClass = JsonType.class)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @JsonView(Views.Public.class)
    private Long id;

    @Column(name = "user_login")
    @JsonView(Views.Public.class)
    private String login;

    @Column(name = "user_password")
    @JsonView(Views.Internal.class)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    @JsonView(Views.Public.class)
    private RolesEnum userRole = RolesEnum.PATIENT;

    @Column(name = "user_email")
    @JsonView(Views.Public.class)
    private String email;

    @Column(name = "user_tel")
    @JsonView(Views.Public.class)
    private String tel;


    @Parse
    @Type(type = "json")
    @Column(name = "passport", columnDefinition = "json")
    @JsonView(Views.Public.class)
    private Passport passport;

    @Column(name = "verified_status")
    @JsonView(Views.Public.class)
    private boolean verifiedStatus;

    @Parse
    @Type(type = "json")
    @Column(name = "address", columnDefinition = "json")
    @JsonView(Views.Public.class)
    private Address address;

    public User() {
    }

    public User(Long id, String login, String password, RolesEnum userRole, String email, String tel, Passport passport, boolean verifiedStatus, Address address) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.userRole = userRole;
        this.email = email;
        this.tel = tel;
        this.passport = passport;
        this.verifiedStatus = verifiedStatus;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolesEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(RolesEnum userRole) {
        this.userRole = userRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public boolean isVerifiedStatus() {
        return verifiedStatus;
    }

    public void setVerifiedStatus(boolean verifiedStatus) {
        this.verifiedStatus = verifiedStatus;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", userRole=" + userRole +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", passport=" + passport +
                ", verifiedStatus=" + verifiedStatus +
                ", address=" + address +
                '}';
    }
}
