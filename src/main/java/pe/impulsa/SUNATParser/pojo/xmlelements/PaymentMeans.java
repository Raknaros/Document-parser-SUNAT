package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;
import pe.impulsa.SUNATParser.pojo.xmlelements.paymentsmeans.PayeeFinancialAccount;

@Getter
public class PaymentMeans {
    private String id;
    private String paymentmeanscode;
    private PayeeFinancialAccount payeefinancialaccount;
    @XmlElement(name="ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(String id) {
        this.id = id;
    }
    @XmlElement(name="PaymentMeansCode",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setPaymentmeanscode(String paymentmeanscode) {
        this.paymentmeanscode = paymentmeanscode;
    }
    @XmlElement(name="PayeeFinancialAccount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setPayeefinancialaccount(PayeeFinancialAccount payeefinancialaccount) {
        this.payeefinancialaccount = payeefinancialaccount;
    }
}
