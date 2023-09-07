package pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.item.SellersItemIdentification;

public class Item {
    private String description;
    private SellersItemIdentification sellersItemIdentification;

    public String getDescription() {
        return description;
    }
    @XmlElement(name="Description",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setDescription(String description) {
        this.description = description;
    }

    public SellersItemIdentification getSellersItemIdentification() {
        return sellersItemIdentification;
    }
    @XmlElement(name="SellersItemIdentification",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setSellersItemIdentification(SellersItemIdentification sellersItemIdentification) {
        this.sellersItemIdentification = sellersItemIdentification;
    }
}
