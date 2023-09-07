package pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension.extensioncontent;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension.extensioncontent.signature.KeyInfo;
import pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension.extensioncontent.signature.SignedInfo;

public class Signature {
    private SignedInfo signedInfo;
    private KeyInfo keyInfo;
    private String signatureValue;
    private String id;

    public SignedInfo getSignedInfo() {
        return signedInfo;
    }
    @XmlElement(name="SignedInfo",namespace="http://www.w3.org/2000/09/xmldsig#")
    public void setSignedInfo(SignedInfo signedInfo) {
        this.signedInfo = signedInfo;
    }

    public KeyInfo getKeyInfo() {
        return keyInfo;
    }
    @XmlElement(name="KeyInfo",namespace="http://www.w3.org/2000/09/xmldsig#")
    public void setKeyInfo(KeyInfo keyInfo) {
        this.keyInfo = keyInfo;
    }

    public String getSignatureValue() {
        return signatureValue;
    }
    @XmlElement(name="SignatureValue",namespace="http://www.w3.org/2000/09/xmldsig#")
    public void setSignatureValue(String signatureValue) {
        this.signatureValue = signatureValue;
    }

    public String getId() {
        return id;
    }
    @XmlAttribute(name="Id")
    public void setId(String id) {
        this.id = id;
    }
}
