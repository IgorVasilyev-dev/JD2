package by.it_academy.jd2.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name = "Message")
@Table(name = "message", schema = "chat")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id", nullable = false)
    private Long messageId;

    @Column(name = "sent_from")
    private String sentFrom;

    @CreationTimestamp
    @Column(name = "send_date", nullable = false)
    private Timestamp sendDate;

    @Column(name = "send_text")
    private String sendText;

    @Column(name = "recipient")
    private String recipient;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public String getSentFrom() {
        return sentFrom;
    }

    public void setSentFrom(String sentFrom) {
        this.sentFrom = sentFrom;
    }

    public Timestamp getSendDate() {
        return sendDate;
    }

    public void setSendDate(Timestamp sendDate) {
        this.sendDate = sendDate;
    }

    public String getSendText() {
        return sendText;
    }

    public void setSendText(String sendText) {
        this.sendText = sendText;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", sentFrom='" + sentFrom + '\'' +
                ", sendDate='" + sendDate + '\'' +
                ", sendText='" + sendText + '\'' +
                ", recipient='" + recipient + '\'' +
                '}';
    }
}
