package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;

@Getter
public class DiscrepancyResponse {
    private String referenceid;
    private String responsecode;
    private String description;
    @XmlElement(name="ReferenceID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setReferenceid(String referenceid) {
        this.referenceid = referenceid;
    }
    @XmlElement(name="ResponseCode",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode;
    }
    @XmlElement(name="Description",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setDescription(String description) {
        this.description = description;
    }
}
