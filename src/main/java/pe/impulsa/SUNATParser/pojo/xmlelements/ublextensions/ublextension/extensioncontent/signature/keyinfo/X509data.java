package pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension.extensioncontent.signature.keyinfo;

import jakarta.xml.bind.annotation.XmlElement;

public class X509data {
    private String x509certificate;

    public String getX509certificate() {
        return x509certificate;
    }
    @XmlElement(name="X509Certificate",namespace="http://www.w3.org/2000/09/xmldsig#")
    public void setX509certificate(String x509certificate) {
        this.x509certificate = x509certificate;
    }
}
