package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.signature.DigitalSignatureAttachment;
import pe.impulsa.SUNATParser.pojo.xmlelements.signature.SignatorParty;

public class Signatura {
    private String id;
    private SignatorParty signatorParty;
    private DigitalSignatureAttachment digitalSignatureAttachment;

    public String getId() {
        return id;
    }
    @XmlElement(name="ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(String id) {
        this.id = id;
    }

    public SignatorParty getSignatorParty() {
        return signatorParty;
    }
    @XmlElement(name="SignatorParty",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setSignatorParty(SignatorParty signatorParty) {
        this.signatorParty = signatorParty;
    }

    public DigitalSignatureAttachment getDigitalSignatureAttachment() {
        return digitalSignatureAttachment;
    }
    @XmlElement(name="DigitalSignatureAttachment",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setDigitalSignatureAttachment(DigitalSignatureAttachment digitalSignatureAttachment) {
        this.digitalSignatureAttachment = digitalSignatureAttachment;
    }
}
