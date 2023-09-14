package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import pe.impulsa.SUNATParser.pojo.DateAdapter;

import java.time.LocalDate;

public class PaymentTerms {
    private String id;
    private String paymentmeansid;
    private float paymentpercent;
    private AtrSet4 amount;
    private LocalDate paymentduedate;

    public String getId() {
        return id;
    }
    @XmlElement(name="ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentmeansid() {
        return paymentmeansid;
    }
    @XmlElement(name="PaymentMeansID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setPaymentmeansid(String paymentmeansid) {
        this.paymentmeansid = paymentmeansid;
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

    public LocalDate getPaymentduedate() {
        return paymentduedate;
    }
    @XmlElement(name="PaymentDueDate",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    @XmlJavaTypeAdapter(DateAdapter.class)
    public void setPaymentduedate(LocalDate paymentduedate) {
        this.paymentduedate = paymentduedate;
    }
}
