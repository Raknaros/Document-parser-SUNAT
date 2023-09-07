package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;

public class DespatchDocumentReference {
    private String id;
    private String documentTypeCode;
    private String documentType;

    public String getDocumentType() {
        return documentType;
    }
    @XmlElement(name="DocumentType",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getId() {
        return id;
    }

    public DespatchDocumentReference(String id, String documentTypeCode) {
        this.id = id;
        this.documentTypeCode = documentTypeCode;
    }
    @XmlElement(name="ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(String id) {
        this.id = id;
    }

    public String getDocumentTypeCode() {
        return documentTypeCode;
    }
    @XmlElement(name="DocumentTypeCode",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setDocumentTypeCode(String documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
    }

    public DespatchDocumentReference() {
        super();
    }
}

