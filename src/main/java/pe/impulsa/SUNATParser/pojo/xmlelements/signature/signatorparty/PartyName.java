package pe.impulsa.SUNATParser.pojo.xmlelements.signature.signatorparty;

import jakarta.xml.bind.annotation.XmlElement;

public class PartyName {
    public String getName() {
        return name;
    }
    @XmlElement(name="Name",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setName(String name) {
        this.name = name;
    }
    private String name;
}
