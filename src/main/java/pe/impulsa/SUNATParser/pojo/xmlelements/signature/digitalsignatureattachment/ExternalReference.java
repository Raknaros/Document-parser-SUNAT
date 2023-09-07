package pe.impulsa.SUNATParser.pojo.xmlelements.signature.digitalsignatureattachment;

import jakarta.xml.bind.annotation.XmlElement;

public class ExternalReference {
    private String uri;

    public String getUri() {
        return uri;
    }
    @XmlElement(name="URI",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setUri(String uri) {
        this.uri = uri;
    }
}
