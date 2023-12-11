package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import pe.impulsa.SUNATParser.pojo.xmlelements.billingreference.BillingReferenceLine;
import pe.impulsa.SUNATParser.pojo.xmlelements.billingreference.InvoiceDocumentReference;

@Getter
public class BillingReference {
    private InvoiceDocumentReference invoceDocumentReference;
    private BillingReferenceLine billingReferenceLine;

    @XmlElement(name="InvoiceDocumentReference",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setInvoceDocumentReference(InvoiceDocumentReference invoceDocumentReference) {
        this.invoceDocumentReference = invoceDocumentReference;
    }
    @XmlElement(name="BillingReferenceLine",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setBillingReferenceLine(BillingReferenceLine billingReferenceLine) {
        this.billingReferenceLine = billingReferenceLine;
    }
}
