package pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.pricingreference;


import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet2;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet4;

public class AlternativeConditionPrice {
    private AtrSet4 priceAmount;
    private AtrSet2 priceTypeCode;

    public AtrSet4 getPriceAmount() {
        return priceAmount;
    }
    @XmlElement(name="PriceAmount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setPriceAmount(AtrSet4 priceAmount) {
        this.priceAmount = priceAmount;
    }

    public AtrSet2 getPriceTypeCode() {
        return priceTypeCode;
    }
    @XmlElement(name="PriceTypeCode",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setPriceTypeCode(AtrSet2 priceTypeCode) {
        this.priceTypeCode = priceTypeCode;
    }
}
