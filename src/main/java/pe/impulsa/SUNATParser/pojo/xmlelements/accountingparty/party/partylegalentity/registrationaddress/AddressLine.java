package pe.impulsa.SUNATParser.pojo.xmlelements.accountingparty.party.partylegalentity.registrationaddress;

import jakarta.xml.bind.annotation.XmlElement;

public class AddressLine {
    private String line;

    public String getLine() {
        return line;
    }
    @XmlElement(name="Line",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setLine(String line) {
        this.line = line;
    }
}
