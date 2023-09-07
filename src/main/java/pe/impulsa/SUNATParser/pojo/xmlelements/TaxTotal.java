package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.taxtotal.TaxSubtotal;

import java.util.List;

public class TaxTotal {
    private AtrSet4 taxAmount;
    private List<TaxSubtotal> taxSubtotal;

    public AtrSet4 getTaxAmount() {
        return taxAmount;
    }
    @XmlElement(name = "TaxAmount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setTaxAmount(AtrSet4 taxAmount) {
        this.taxAmount = taxAmount;
    }

    public List<TaxSubtotal> getTaxSubtotal() {
        return taxSubtotal;
    }
    @XmlElement(name = "TaxSubtotal",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setTaxSubtotal(List<TaxSubtotal> taxSubtotal) {
        this.taxSubtotal = taxSubtotal;
    }
}
