package pe.impulsa.SUNATParser.pojo.xmlelements.signature;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.signature.digitalsignatureattachment.ExternalReference;

public class DigitalSignatureAttachment {
    private ExternalReference externalReference;

    public ExternalReference getExternalReference() {
        return externalReference;
    }
    @XmlElement(name="ExternalReference",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setExternalReference(ExternalReference externalReference) {
        this.externalReference = externalReference;
    }
}
