package pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet4;

public class AllowanceCharge {
    private String chargeIndicator;
    private AtrSet4 amount;

    public String getChargeIndicator() {
        return chargeIndicator;
    }
    @XmlElement(name = "ChargeIndicator",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setChargeIndicator(String chargeIndicator) {
        this.chargeIndicator = chargeIndicator;
    }

    public AtrSet4 getAmount() {
        return amount;
    }
    @XmlElement(name = "Amount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setAmount(AtrSet4 amount) {
        this.amount = amount;
    }
}
