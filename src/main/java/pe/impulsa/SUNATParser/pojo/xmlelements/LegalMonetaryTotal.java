package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;

public class LegalMonetaryTotal {
    private AtrSet4 lineExtensionAmount;
    private AtrSet4 allowanceTotalAmount;
    private AtrSet4 chargeTotalAmount;
    private AtrSet4 prepaidAmount;
    private AtrSet4 payableAmount;

    public AtrSet4 getLineExtensionAmount() {
        return lineExtensionAmount;
    }
    @XmlElement(name="LineExtensionAmount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setLineExtensionAmount(AtrSet4 lineExtensionAmount) {
        this.lineExtensionAmount = lineExtensionAmount;
    }

    public AtrSet4 getAllowanceTotalAmount() {
        return allowanceTotalAmount;
    }
    @XmlElement(name="AllowanceTotalAmount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setAllowanceTotalAmount(AtrSet4 allowanceTotalAmount) {
        this.allowanceTotalAmount = allowanceTotalAmount;
    }

    public AtrSet4 getChargeTotalAmount() {
        return chargeTotalAmount;
    }
    @XmlElement(name="ChargeTotalAmount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setChargeTotalAmount(AtrSet4 chargeTotalAmount) {
        this.chargeTotalAmount = chargeTotalAmount;
    }

    public AtrSet4 getPrepaidAmount() {
        return prepaidAmount;
    }
    @XmlElement(name="PrepaidAmount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setPrepaidAmount(AtrSet4 prepaidAmount) {
        this.prepaidAmount = prepaidAmount;
    }

    public AtrSet4 getPayableAmount() {
        return payableAmount;
    }
    @XmlElement(name="PayableAmount",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setPayableAmount(AtrSet4 payableAmount) {
        this.payableAmount = payableAmount;
    }
}
