package pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.item;

import jakarta.xml.bind.annotation.XmlElement;

public class SellersItemIdentification {
    private String id;

    public String getId() {
        return id;
    }
    @XmlElement(name="ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(String id) {
        this.id = id;
    }
}
