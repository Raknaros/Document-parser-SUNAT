package pe.impulsa.SUNATParser.pojo.xmlelements.billingreference;

import jakarta.xml.bind.annotation.XmlElement;
import lombok.Getter;

@Getter
public class BillingReferenceLine {
    private String id;

    @XmlElement(name="ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(String id) {
        this.id = id;
    }
}
