package pe.impulsa.SUNATParser.pojo.xmlelements.accountingparty;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.accountingparty.party.PartyIdentification;
import pe.impulsa.SUNATParser.pojo.xmlelements.accountingparty.party.PartyLegalEntity;
import pe.impulsa.SUNATParser.pojo.xmlelements.signature.signatorparty.PartyName;

public class Party {
    private PartyIdentification partyIdentification;
    private PartyName partyName;
    private PartyLegalEntity partyLegalEntity;

    public PartyIdentification getPartyIdentification() {
        return partyIdentification;
    }
    @XmlElement(name="PartyIdentification",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setPartyIdentification(PartyIdentification partyIdentification) {
        this.partyIdentification = partyIdentification;
    }

    public PartyName getPartyName() {
        return partyName;
    }
    @XmlElement(name="PartyName",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setPartyName(PartyName partyName) {
        this.partyName = partyName;
    }

    public PartyLegalEntity getPartyLegalEntity() {
        return partyLegalEntity;
    }
    @XmlElement(name="PartyLegalEntity",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setPartyLegalEntity(PartyLegalEntity partyLegalEntity) {
        this.partyLegalEntity = partyLegalEntity;
    }
}
