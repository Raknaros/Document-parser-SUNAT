package pe.impulsa.SUNATParser.pojo.xmlelements.accountingparty.party;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet3;

public class PartyIdentification {
    private AtrSet3 id;

    public AtrSet3 getId() {
        return id;
    }
    @XmlElement(name="ID",namespace ="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(AtrSet3 id) {
        this.id = id;
    }
}
