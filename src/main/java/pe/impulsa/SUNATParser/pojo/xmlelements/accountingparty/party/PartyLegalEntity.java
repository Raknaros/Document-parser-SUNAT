package pe.impulsa.SUNATParser.pojo.xmlelements.accountingparty.party;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.accountingparty.party.partylegalentity.RegistrationAddress;

public class PartyLegalEntity {
    private String registrationname;
    private RegistrationAddress registrationAddress;

    public String getRegistrationname() {
        return registrationname;
    }
    @XmlElement(name="RegistrationName",namespace = "urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setRegistrationname(String registrationname) {
        this.registrationname = registrationname;
    }

    public RegistrationAddress getRegistrationAddress() {
        return registrationAddress;
    }
    @XmlElement(name="cac:RegistrationAddress",namespace ="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setRegistrationAddress(RegistrationAddress registrationAddress) {
        this.registrationAddress = registrationAddress;
    }
}
