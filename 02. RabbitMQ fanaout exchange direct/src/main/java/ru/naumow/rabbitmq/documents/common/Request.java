package ru.naumow.rabbitmq.documents.common;

public class Request {

    private String name;
    private String documentType;
    private String documentCode;

    public Request(String name, String documentType, String documentCode) {
        this.name = name;
        this.documentType = documentType;
        this.documentCode = documentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentCode() {
        return documentCode;
    }

    public void setDocumentCode(String documentCode) {
        this.documentCode = documentCode;
    }
}
