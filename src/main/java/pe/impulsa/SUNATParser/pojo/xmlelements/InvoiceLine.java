package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.AllowanceCharge;
import pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.Item;
import pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.Price;
import pe.impulsa.SUNATParser.pojo.xmlelements.invoiceline.PricingReference;

import java.math.BigDecimal;

public class InvoiceLine {
    private int id;
    private AtrSet6 invoicedQuantity;
    private BigDecimal lineextensionamount;
    private String freeofchangeindicator;

    public int getId() {
        return id;
    }
    @XmlElement(name = "ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(int id) {
        this.id = id;
    }

    public AtrSet6 getInvoicedQuantity() {
        return invoicedQuantity;
    }
    @XmlElement(name = "InvoicedQuantity",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setInvoicedQuantity(AtrSet6 invoicedQuantity) {
        this.invoicedQuantity = invoicedQuantity;
    }

    public BigDecimal getLineextensionamount() {
        return lineextensionamount;
    }
    @XmlElement(name = "LineExtensionAmount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setLineextensionamount(BigDecimal lineextensionamount) {
        this.lineextensionamount = lineextensionamount;
    }

    public String getFreeofchangeindicator() {
        return freeofchangeindicator;
    }
    @XmlElement(name = "FreeOfChargeIndicator",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setFreeofchangeindicator(String freeofchangeindicator) {
        this.freeofchangeindicator = freeofchangeindicator;
    }

    public PricingReference getPricingReference() {
        return pricingReference;
    }
    @XmlElement(name = "PricingReference",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setPricingReference(PricingReference pricingReference) {
        this.pricingReference = pricingReference;
    }

    public AllowanceCharge getAllowanceCharge() {
        return allowanceCharge;
    }
    @XmlElement(name = "AllowanceCharge",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setAllowanceCharge(AllowanceCharge allowanceCharge) {
        this.allowanceCharge = allowanceCharge;
    }

    public TaxTotal getTaxTotal() {
        return taxTotal;
    }
    @XmlElement(name = "TaxTotal",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setTaxTotal(TaxTotal taxTotal) {
        this.taxTotal = taxTotal;
    }

    public Item getItem() {
        return item;
    }
    @XmlElement(name = "Item",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setItem(Item item) {
        this.item = item;
    }

    public Price getPrice() {
        return price;
    }
    @XmlElement(name = "Price",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setPrice(Price price) {
        this.price = price;
    }

    private PricingReference pricingReference;
    private AllowanceCharge allowanceCharge;
    private TaxTotal taxTotal;
    private Item item;
    private Price price;
}
