package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.Item;
import pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.PricingReference;

@Getter
public class CreditNoteLine {
    private String id;
    private AtrSet6 creditedQuantity;
    private AtrSet4 lineExtensionAmount;
    private BillingReference billingReference;
    private PricingReference pricingReference;
    private TaxTotal taxTotal;
    private Item item;
    private AtrSet4 price;
    @XmlElement(name="ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(String id) {
        this.id = id;
    }
    @XmlElement(name="CreditedQuantity",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setCreditedQuantity(AtrSet6 creditedQuantity) {
        this.creditedQuantity = creditedQuantity;
    }
    @XmlElement(name="LineExtensionAmount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setLineExtensionAmount(AtrSet4 lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
    }
    @XmlElement(name="BillingReference",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setBillingReference(BillingReference billingReference) {
        this.billingReference = billingReference;
    }
    @XmlElement(name="PricingReference",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setPricingReference(PricingReference pricingReference) {
        this.pricingReference = pricingReference;
    }
    @XmlElement(name="TaxTotal",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setTaxTotal(TaxTotal taxTotal) {
        this.taxTotal = taxTotal;
    }
    @XmlElement(name="Item",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setItem(Item item) {
        this.item = item;
    }
    @XmlElement(name="Price",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setPrice(AtrSet4 price) {
        this.price = price;
    }
}
