package by.it_academy.jd2.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "User")
@Table(name = "user", schema = "chat")
public class User implements Serializable {

    @Id
    @Generated(GenerationTime.NEVER)
    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String fio;

    @Column(name = "birthday")
    private String birthDay;

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", fio='" + fio + '\'' +
                ", password='" + password + '\'' +
                ", birthDay='" + birthDay + '\'' +
                '}';
    }
}
