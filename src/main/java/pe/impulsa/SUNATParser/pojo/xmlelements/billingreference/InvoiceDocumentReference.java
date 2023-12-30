package pe.impulsa.SUNATParser.pojo.xmlelements.billingreference;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;
import pe.impulsa.SUNATParser.pojo.DateAdapter;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet2;

import java.time.LocalDate;

@Getter
public class InvoiceDocumentReference {
    private String id;
    private LocalDate issuedate;
    private AtrSet2 documentTypeCode;
    private String documenttype;

    @XmlElement(name="ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(String id) {
        this.id = id;
    }
    @XmlElement(name="IssueDate",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setIssuedate(LocalDate issuedate) {
        this.issuedate = issuedate;
    }
    @XmlElement(name="DocumentTypeCode",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setDocumentTypeCode(AtrSet2 documentTypeCode) {
        this.documentTypeCode = documentTypeCode;
    }
    @XmlElement(name="DocumentType",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setDocumenttype(String documenttype) {
        this.documenttype = documenttype;
    }
}
