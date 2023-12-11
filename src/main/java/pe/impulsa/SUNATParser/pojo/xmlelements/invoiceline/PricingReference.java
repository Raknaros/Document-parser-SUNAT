package pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.pricingreference.AlternativeConditionPrice;

public class PricingReference {
    private AlternativeConditionPrice alternativeConditionPrice;

    public AlternativeConditionPrice getAlternativaConditionPrice() {
        return alternativeConditionPrice;
    }
    @XmlElement(name="AlternativeConditionPrice",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setAlternativaConditionPrice(AlternativeConditionPrice alternativeConditionPrice) {
        this.alternativeConditionPrice = alternativeConditionPrice;
    }
}
