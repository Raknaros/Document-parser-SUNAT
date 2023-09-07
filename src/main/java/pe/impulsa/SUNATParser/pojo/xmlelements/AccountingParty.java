package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.accountingparty.Party;

public class AccountingParty {
    private Party party;

    public Party getParty() {
        return party;
    }
    @XmlElement(name="Party",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setParty(Party party) {
        this.party = party;
    }
}
