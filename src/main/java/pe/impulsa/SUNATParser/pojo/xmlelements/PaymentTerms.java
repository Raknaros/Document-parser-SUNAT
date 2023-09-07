package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import pe.impulsa.SUNATParser.pojo.DateAdapter;
import pe.impulsa.SUNATParser.pojo.xmlelements.paymentterms.PayeeFinancialAccount;

import java.util.Date;

public class PaymentTerms {
    private String id;
    private String paymentmeanscode;
    private String paymentmeansid;
    private PayeeFinancialAccount payeefinancialaccount;
    private float paymentpercent;
    private AtrSet4 amount;
    private Date paymentduedate;

    public String getId() {
        return id;
    }
    @XmlElement(name="ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentmeanscode() {
        return paymentmeanscode;
    }
    @XmlElement(name="PaymentMeansCode",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setPaymentmeanscode(String paymentmeanscode) {
        this.paymentmeanscode = paymentmeanscode;
    }

    public String getPaymentmeansid() {
        return paymentmeansid;
    }
    @XmlElement(name="PaymentMeansID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setPaymentmeansid(String paymentmeansid) {
        this.paymentmeansid = paymentmeansid;
    }

    public PayeeFinancialAccount getPayeefinancialaccount() {
        return payeefinancialaccount;
    }
    @XmlElement(name="PayeeFinancialAccount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setPayeefinancialaccount(PayeeFinancialAccount payeefinancialaccount) {
        this.payeefinancialaccount = payeefinancialaccount;
    }

    public float getPaymentpercent() {
        return paymentpercent;
    }
    @XmlElement(name="PaymentPercent",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setPaymentpercent(float paymentpercent) {
        this.paymentpercent = paymentpercent;
    }

    public AtrSet4 getAmount() {
        return amount;
    }
    @XmlElement(name="Amount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setAmount(AtrSet4 amount) {
        this.amount = amount;
    }

    public Date getPaymentduedate() {
        return paymentduedate;
    }
    @XmlElement(name="PaymentDueDate",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setPaymentduedate(Date paymentduedate) {
        this.paymentduedate = paymentduedate;
    }
}
