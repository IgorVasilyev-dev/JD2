package by.it_academy.jd2.core.dto;

import java.io.Serializable;

public class Message implements Serializable {

    private String sendDate;
    private String sentFrom;
    private String sendText;

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
                "sendDate=" + sendDate +
                ", sentFrom='" + sentFrom + '\'' +
                ", sendText='" + sendText + '\'' +
                '}';
    }
}
