package pe.impulsa.SUNATParser.pojo.xmlelements.taxtotal.taxsubtotal;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet2;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet3;
import pe.impulsa.SUNATParser.pojo.xmlelements.taxtotal.taxsubtotal.taxcategory.TaxScheme;

public class TaxCategory {
    private AtrSet3 id;
    private TaxScheme taxScheme;
    private float percent;
    private AtrSet2 taxExemptionReasonCode;
    private String tierrange;

    public float getPercent() {
        return percent;
    }
    @XmlElement(name="Percent",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setPercent(float percent) {
        this.percent = percent;
    }

    public AtrSet2 getTaxExemptionReasonCode() {
        return taxExemptionReasonCode;
    }
    @XmlElement(name="TaxExemptionReasonCode",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setTaxExemptionReasonCode(AtrSet2 taxExemptionReasonCode) {
        this.taxExemptionReasonCode = taxExemptionReasonCode;
    }

    public String getTierrange() {
        return tierrange;
    }
    @XmlElement(name="TierRange",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setTierrange(String tierrange) {
        this.tierrange = tierrange;
    }

    public AtrSet3 getId() {
        return id;
    }
    @XmlElement(name="ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(AtrSet3 id) {
        this.id = id;
    }

    public TaxScheme getTaxScheme() {
        return taxScheme;
    }
    @XmlElement(name="TaxScheme",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setTaxScheme(TaxScheme taxScheme) {
        this.taxScheme = taxScheme;
    }
}
