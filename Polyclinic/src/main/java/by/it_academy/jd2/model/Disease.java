package by.it_academy.jd2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Disease")
@Table(name = "disease_data")
public class Disease  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "disease_id")
    private Long diseaseCode;

    @Column(name = "disease_name")
    private String diseaseName;

    @Column(name = "disease_symptoms")
    private String symptoms;

    @Column(name = "disease_info")
    private String diseaseInfo;

    public Disease() {
    }

    public Disease(Long diseaseCode, String diseaseName, String symptoms, String diseaseInfo) {
        this.diseaseCode = diseaseCode;
        this.diseaseName = diseaseName;
        this.symptoms = symptoms;
        this.diseaseInfo = diseaseInfo;
    }

    public Long getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(Long diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiseaseInfo() {
        return diseaseInfo;
    }

    public void setDiseaseInfo(String diseaseInfo) {
        this.diseaseInfo = diseaseInfo;
    }
}
