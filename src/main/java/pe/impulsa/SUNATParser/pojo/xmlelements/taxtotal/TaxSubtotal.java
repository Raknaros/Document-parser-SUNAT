package pe.impulsa.SUNATParser.pojo.xmlelements.taxtotal;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet4;
import pe.impulsa.SUNATParser.pojo.xmlelements.taxtotal.taxsubtotal.TaxCategory;

public class TaxSubtotal {
    private AtrSet4 taxAmount;
    private AtrSet4 taxableAmount;
    private TaxCategory taxCategory;

    public AtrSet4 getTaxAmount() {
        return taxAmount;
    }
    @XmlElement(name = "TaxAmount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setTaxAmount(AtrSet4 taxAmount) {
        this.taxAmount = taxAmount;
    }

    public AtrSet4 getTaxableAmount() {
        return taxableAmount;
    }
    @XmlElement(name = "TaxableAmount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setTaxableAmount(AtrSet4 taxableAmount) {
        this.taxableAmount = taxableAmount;
    }

    public TaxCategory getTaxCategory() {
        return taxCategory;
    }
    @XmlElement(name = "TaxCategory",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setTaxCategory(TaxCategory taxCategory) {
        this.taxCategory = taxCategory;
    }
}
