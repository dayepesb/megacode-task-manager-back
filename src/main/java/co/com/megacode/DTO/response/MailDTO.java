package co.com.megacode.DTO.response;

import java.util.HashMap;

public class MailDTO {

    private String to;
    private String subject;
    private String content;
    private HashMap<String, String> model;
    private String nameTemplate;

    public MailDTO() {
    }

    public MailDTO(String to, String subject, String content) {
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HashMap<String, String> getModel() {
        return model;
    }

    public void setModel(HashMap<String, String> model) {
        this.model = model;
    }

    public String getNameTemplate() {
        return nameTemplate;
    }

    public void setNameTemplate(String nameTemplate) {
        this.nameTemplate = nameTemplate;
    }

    @Override
    public String toString() {
        return "Mail{" +
                ", to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}