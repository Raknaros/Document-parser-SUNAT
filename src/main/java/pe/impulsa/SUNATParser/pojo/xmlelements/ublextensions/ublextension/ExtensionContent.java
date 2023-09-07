package pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension.extensioncontent.AditionalInformation;
import pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension.extensioncontent.Signature;

public class ExtensionContent {
    private Signature signature;
    private AditionalInformation aditionalInformation;

    public Signature getSignature() {
        return signature;
    }
    @XmlElement(name="Signature",namespace="http://www.w3.org/2000/09/xmldsig#")
    public void setSignature(Signature signature) {
        this.signature = signature;
    }

    public AditionalInformation getAditionalInformation() {
        return aditionalInformation;
    }
    @XmlElement(name="AditionalInformation",namespace="urn:sunat:names:specification:ubl:peru:schema:xsd:SunatAggregateComponents-1")
    public void setAditionalInformation(AditionalInformation aditionalInformation) {
        this.aditionalInformation = aditionalInformation;
    }
}
