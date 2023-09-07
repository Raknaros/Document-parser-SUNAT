package pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension.extensioncontent.signature;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet1;
import pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension.extensioncontent.signature.signedinfo.Reference;

public class SignedInfo {
    private AtrSet1 canonicalizationmethod;
    private AtrSet1 signaturemethod;
    private Reference reference;

    public AtrSet1 getCanonicalizationmethod() {
        return canonicalizationmethod;
    }
    @XmlElement(name="CanonicalizationMethod",namespace="http://www.w3.org/2000/09/xmldsig#")
    public void setCanonicalizationmethod(AtrSet1 canonicalizationmethod) {
        this.canonicalizationmethod = canonicalizationmethod;
    }

    public AtrSet1 getSignaturemethod() {
        return signaturemethod;
    }
    @XmlElement(name="SignatureMethod",namespace="http://www.w3.org/2000/09/xmldsig#")
    public void setSignaturemethod(AtrSet1 signaturemethod) {
        this.signaturemethod = signaturemethod;
    }

    public Reference getReference() {
        return reference;
    }
    @XmlElement(name="Reference",namespace="http://www.w3.org/2000/09/xmldsig#")
    public void setReference(Reference reference) {
        this.reference = reference;
    }
}
