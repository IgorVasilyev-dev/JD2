package by.it_academy.jd2.core.dto;

import java.io.Serializable;
import java.util.Objects;

public class User  implements Serializable {

    private String login;
    private String fio;
    private String password;
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
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 21 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        if (!Objects.equals(login, user.login)) return false;
        return Objects.equals(password, user.password);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", fio='" + fio + '\'' +
                ", password='" + hashCode() + '\'' +
                ", birthDay='" + birthDay + '\'' +
                '}';
    }
}
