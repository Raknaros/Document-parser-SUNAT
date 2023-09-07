package pe.impulsa.SUNATParser.pojo.xmlelements.signature;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.signature.signatorparty.PartyName;

public class SignatorParty {
    public PartyName getPartyName() {
        return partyName;
    }
    @XmlElement(name="PartyName",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setPartyName(PartyName partyName) {
        this.partyName = partyName;
    }

    private PartyName partyName;
}
