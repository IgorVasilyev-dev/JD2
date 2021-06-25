package by.it_academy.jd2.model;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity(name = "Message")
@Table(name = "message", schema = "chat")
public class Message implements Serializable {

    @Id
    @Generated(GenerationTime.NEVER)
    @Column(name = "sent_from")
    private String sentFrom;

    @Column(name = "send_date")
    private String sendDate;

    @Column(name = "send_text")
    private String sendText;

    @Column(name = "recipient")
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    private String recipient;

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getSentFrom() {
        return sentFrom;
    }

    public void setSentFrom(String sentFrom) {
        this.sentFrom = sentFrom;
    }

    public String getSendText() {
        return sendText;
    }

    public void setSendText(String sendText) {
        this.sendText = sendText;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sentFrom='" + sentFrom + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", sendText='" + sendText + '\'' +
                ", recipient='" + recipient + '\'' +
                '}';
    }
}
