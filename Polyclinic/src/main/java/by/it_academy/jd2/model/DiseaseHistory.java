package by.it_academy.jd2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "DiseaseHistory")
@Table(name = "disease_history")
public class DiseaseHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "user_login")
    private String userLogin;

    @Column(name = "sick_with")
    private Timestamp sickWith;

    @Column(name = "sick_before")
    private Timestamp sickBefore;

    @ManyToOne
    @JoinColumn(name = "disease_id")
    private Disease disease;

    public DiseaseHistory() {
    }

    public DiseaseHistory(Long id, String userLogin, Timestamp sickWith, Timestamp sickBefore, Disease disease) {
        this.id = id;
        this.userLogin = userLogin;
        this.sickWith = sickWith;
        this.sickBefore = sickBefore;
        this.disease = disease;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Date getSickWith() {
        return sickWith;
    }

    public void setSickWith(Timestamp sickWith) {
        this.sickWith = sickWith;
    }

    public Date getSickBefore() {
        return sickBefore;
    }

    public void setSickBefore(Timestamp sickBefore) {
        this.sickBefore = sickBefore;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "DiseaseHistory{" +
                "id=" + id +
                ", userLogin='" + userLogin + '\'' +
                ", sickWith=" + sickWith +
                ", sickBefore=" + sickBefore +
                ", disease=" + disease +
                '}';
    }
}
