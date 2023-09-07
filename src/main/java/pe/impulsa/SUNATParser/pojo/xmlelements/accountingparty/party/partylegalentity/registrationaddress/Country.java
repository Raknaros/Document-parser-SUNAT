package pe.impulsa.SUNATParser.pojo.xmlelements.accountingparty.party.partylegalentity.registrationaddress;

import jakarta.xml.bind.annotation.XmlElement;

public class Country {
    private String identificationcode;

    public String getIdentificationcode() {
        return identificationcode;
    }
    @XmlElement(name="cbc:IdentificationCode",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setIdentificationcode(String identificationcode) {
        this.identificationcode = identificationcode;
    }
}
