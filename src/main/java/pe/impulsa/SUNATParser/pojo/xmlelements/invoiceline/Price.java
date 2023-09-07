package pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet4;

public class Price {
    private AtrSet4 priceAmount;

    public AtrSet4 getPriceAmount() {
        return priceAmount;
    }
    @XmlElement(name="PriceAmount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setPriceAmount(AtrSet4 priceAmount) {
        this.priceAmount = priceAmount;
    }
}
