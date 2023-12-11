package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.AllowanceCharge;
import pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.Item;
import pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.Price;
import pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.PricingReference;

import java.math.BigDecimal;

@Getter
public class InvoiceLine {
    private int id;
    private AtrSet6 invoicedQuantity;
    private BigDecimal lineextensionamount;
    private String freeofchangeindicator;
    private PricingReference pricingReference;
    private AllowanceCharge allowanceCharge;
    private TaxTotal taxTotal;
    private Item item;
    private Price price;

    @XmlElement(name = "ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "InvoicedQuantity",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setInvoicedQuantity(AtrSet6 invoicedQuantity) {
        this.invoicedQuantity = invoicedQuantity;
    }

    @XmlElement(name = "LineExtensionAmount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setLineextensionamount(BigDecimal lineextensionamount) {
        this.lineextensionamount = lineextensionamount;
    }

    @XmlElement(name = "FreeOfChargeIndicator",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setFreeofchangeindicator(String freeofchangeindicator) {
        this.freeofchangeindicator = freeofchangeindicator;
    }

    @XmlElement(name = "PricingReference",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setPricingReference(PricingReference pricingReference) {
        this.pricingReference = pricingReference;
    }

    @XmlElement(name = "AllowanceCharge",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setAllowanceCharge(AllowanceCharge allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }

    @XmlElement(name = "TaxTotal",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setTaxTotal(TaxTotal taxTotal) {
        this.taxTotal = taxTotal;
    }

    @XmlElement(name = "Item",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setItem(Item item) {
        this.item = item;
    }

    @XmlElement(name = "Price",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setPrice(Price price) {
        this.price = price;
    }
}
