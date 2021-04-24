package by.it_academy.jd2.core.dto;

import java.io.Serializable;

public class User implements Serializable {

    private String login;
    private String password;
    private String fio;
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
