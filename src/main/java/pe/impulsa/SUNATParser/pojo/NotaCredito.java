package pe.impulsa.SUNATParser.pojo;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.Getter;
import pe.impulsa.SUNATParser.pojo.xmlelements.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@XmlRootElement(name = "CreditNote",namespace="urn:oasis:names:specification:ubl:schema:xsd:CreditNote-2")
@Getter
public class NotaCredito {
    private UBLExtensions ublExtensions;
    private String ublversionid;
    private String customizationid;
    private String id;
    private LocalDate issuedate;
    private LocalTime issuetime;
    private List<AtrSet5> note;
    private AtrSet2 documentCurrencyCode;
    private DiscrepancyResponse discrepancyResponse;
    private BillingReference billingReference;
    private Signatura signatura;
    private AccountingParty accountingSupplierParty;
    private AccountingParty accountingCustomerParty;
    private AccountingParty buyerCustomerParty;
    private List<PaymentTerms> paymentTerms;
    private TaxTotal taxTotal;
    private LegalMonetaryTotal legalMonetaryTotal;
    private List<CreditNoteLine> creditNoteLines;

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

    @XmlElement(name="ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name="IssueDate",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setIssuedate(LocalDate issuedate) {
        this.issuedate = issuedate;
    }

    @XmlElement(name="IssueTime",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    @XmlJavaTypeAdapter(TimeAdapter.class)
    public void setIssuetime(LocalTime issuetime) {
        this.issuetime = issuetime;
    }

    @XmlElement(name="Note",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setNote(List<AtrSet5> note) {
        this.note = note;
    }

    @XmlElement(name="DocumentCurrencyCode",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setDocumentCurrencyCode(AtrSet2 documentCurrencyCode) {
        this.documentCurrencyCode = documentCurrencyCode;
    }
    @XmlElement(name="DiscrepancyResponse",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setDiscrepancyResponse(DiscrepancyResponse discrepancyResponse) {
        this.discrepancyResponse = discrepancyResponse;
    }
    @XmlElement(name="BillingReference",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setBillingReference(BillingReference billingReference) {
        this.billingReference = billingReference;
    }

    @XmlElement(name="Signature",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setSignatura(Signatura signatura) {
        this.signatura = signatura;
    }

    @XmlElement(name="AccountingSupplierParty",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setAccountingSupplierParty(AccountingParty accountingSupplierParty) {
        this.accountingSupplierParty = accountingSupplierParty;
    }

    @XmlElement(name="AccountingCustomerParty",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setAccountingCustomerParty(AccountingParty accountingCustomerParty) {
        this.accountingCustomerParty = accountingCustomerParty;
    }

    @XmlElement(name="BuyerCustomerParty",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setBuyerCustomerParty(AccountingParty buyerCustomerParty) {
        this.buyerCustomerParty = buyerCustomerParty;
    }

    @XmlElement(name="PaymentTerms",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setPaymentTerms(List<PaymentTerms> paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    @XmlElement(name="TaxTotal",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setTaxTotal(TaxTotal taxTotal) {
        this.taxTotal = taxTotal;
    }

    @XmlElement(name="LegalMonetaryTotal",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setLegalMonetaryTotal(LegalMonetaryTotal legalMonetaryTotal) {
        this.legalMonetaryTotal = legalMonetaryTotal;
    }
    @XmlElement(name="CreditNoteLine",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setCreditNoteLines(List<CreditNoteLine> creditNoteLines) {
        this.creditNoteLines = creditNoteLines;
    }
}