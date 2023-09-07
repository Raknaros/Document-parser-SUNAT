package pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension.extensioncontent.signature;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension.extensioncontent.signature.keyinfo.X509data;

public class KeyInfo {
    private X509data x509data;

    public X509data getX509data() {
        return x509data;
    }
    @XmlElement(name="X509Data",namespace="http://www.w3.org/2000/09/xmldsig#")
    public void setX509data(X509data x509data) {
        this.x509data = x509data;
    }
}
