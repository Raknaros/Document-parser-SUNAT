package pe.impulsa.SUNATParser.pojo;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;
import pe.impulsa.SUNATParser.pojo.xmlelements.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@XmlRootElement(name = "Invoice",namespace="urn:oasis:names:specification:ubl:schema:xsd:Invoice-2")
@Getter
public class Factura {
    private UBLExtensions ublExtensions;
    private String ublversionid;
    private String customizationid;
    private String id;
    private LocalDate issuedate;
    private LocalTime issuetime;
    private LocalDate duedate;

    @XmlElement(name="UBLExtensions",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2")
    public void setUblExtensions(UBLExtensions ublExtensions) {
        this.ublExtensions = ublExtensions;
    }

    @XmlElement(name="UBLVersionID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setUblversionid(String ublversionid) {
        this.ublversionid = ublversionid;
    }

    @XmlElement(name="CustomizationID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setCustomizationid(String customizationid) {
        this.customizationid = customizationid;
    }

    public String getId() {
        return id;
    }
    @XmlElement(name="ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getIssuedate() {
        return issuedate;
    }
    @XmlElement(name="IssueDate",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setIssuedate(LocalDate issuedate) {
        this.issuedate = issuedate;
    }

    public LocalTime getIssuetime() {
        return issuetime;
    }
    @XmlElement(name="IssueTime",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    @XmlJavaTypeAdapter(TimeAdapter.class)
    public void setIssuetime(LocalTime issuetime) {
        this.issuetime = issuetime;
    }

    public LocalDate getDuedate() {
        return duedate;
    }
    @XmlElement(name="DueDate",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    public AtrSet2 getInvoiceTypeCode() {
        return invoiceTypeCode;
    }
    @XmlElement(name="InvoiceTypeCode",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setInvoiceTypeCode(AtrSet2 invoiceTypeCode) {
        this.invoiceTypeCode = invoiceTypeCode;
    }

    @XmlElement(name="Note",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setNote(List<AtrSet5> note) {
        this.note = note;
    }

    public OrderReference getOrderReference() {
        return orderReference;
    }
    @XmlElement(name="OrderReference",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setOrderReference(OrderReference orderReference) {
        this.orderReference = orderReference;
    }

    public List<PaymentTerms> getPaymentTerms() {
        return paymentTerms;
    }
    @XmlElement(name="PaymentTerms",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setPaymentTerms(List<PaymentTerms> paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public AtrSet2 getDocumentCurrencyCode() {
        return documentCurrencyCode;
    }
    @XmlElement(name="DocumentCurrencyCode",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setDocumentCurrencyCode(AtrSet2 documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }

    public DespatchDocumentReference getDespatchDocumentReference() {
        return despatchDocumentReference;
    }
    @XmlElement(name="DespatchDocumentReference",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setDespatchDocumentReference(DespatchDocumentReference despatchDocumentReference) {
        this.despatchDocumentReference = despatchDocumentReference;
    }

    public Signatura getSignature() {
        return signatura;
    }
    @XmlElement(name="Signature",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setSignature(Signatura signatura) {
        this.signatura = signatura;
    }

    public AccountingParty getAccountingSupplierParty() {
        return accountingSupplierParty;
    }
    @XmlElement(name="AccountingSupplierParty",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setAccountingSupplierParty(AccountingParty accountingSupplierParty) {
        this.accountingSupplierParty = accountingSupplierParty;
    }

    public AccountingParty getAccountingCustomerParty() {
        return accountingCustomerParty;
    }
    @XmlElement(name="AccountingCustomerParty",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setAccountingCustomerParty(AccountingParty accountingCustomerParty) {
        this.accountingCustomerParty = accountingCustomerParty;
    }

    public AccountingParty getBuyerCustomerParty() {
        return buyerCustomerParty;
    }
    @XmlElement(name="BuyerCustomerParty",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setBuyerCustomerParty(AccountingParty buyerCustomerParty) {
        this.buyerCustomerParty = buyerCustomerParty;
    }

    public TaxTotal getTaxTotal() {
        return taxTotal;
    }
    @XmlElement(name="TaxTotal",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setTaxTotal(TaxTotal taxTotal) {
        this.taxTotal = taxTotal;
    }

    public LegalMonetaryTotal getLegalMonetaryTotal() {
        return legalMonetaryTotal;
    }
    @XmlElement(name="LegalMonetaryTotal",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setLegalMonetaryTotal(LegalMonetaryTotal legalMonetaryTotal) {
        this.legalMonetaryTotal = legalMonetaryTotal;
    }

    public List<InvoiceLine> getInvoiceLine() {
        return invoiceLine;
    }
    @XmlElement(name="InvoiceLine",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setInvoiceLine(List<InvoiceLine> invoiceLine) {
        this.invoiceLine = invoiceLine;
    }

    private AtrSet2 invoiceTypeCode;
    @Getter
    private List<AtrSet5> note;
    private OrderReference orderReference;
    private List<PaymentTerms> paymentTerms;
    private AtrSet2 documentCurrencyCode;
    private DespatchDocumentReference despatchDocumentReference;
    private Signatura signatura;
    private AccountingParty accountingSupplierParty;
    private AccountingParty accountingCustomerParty;
    private AccountingParty buyerCustomerParty;
    private TaxTotal taxTotal;
    private LegalMonetaryTotal legalMonetaryTotal;
    private List<InvoiceLine> invoiceLine;
}
