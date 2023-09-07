package pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.pricingreference.AlternativaConditionPrice;

public class PricingReference {
    private AlternativaConditionPrice alternativaConditionPrice;

    public AlternativaConditionPrice getAlternativaConditionPrice() {
        return alternativaConditionPrice;
    }
    @XmlElement(name="AlternativeConditionPrice",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setAlternativaConditionPrice(AlternativaConditionPrice alternativaConditionPrice) {
        this.alternativaConditionPrice = alternativaConditionPrice;
    }
}
