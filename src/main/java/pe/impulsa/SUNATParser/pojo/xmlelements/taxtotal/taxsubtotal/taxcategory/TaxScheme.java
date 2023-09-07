package pe.impulsa.SUNATParser.pojo.xmlelements.taxtotal.taxsubtotal.taxcategory;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet3;

public class TaxScheme {
    private AtrSet3 id;
    private String name;
    private String taxtypecode;

    public AtrSet3 getId() {
        return id;
    }
    @XmlElement(name="ID",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setId(AtrSet3 id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    @XmlElement(name="Name",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setName(String name) {
        this.name = name;
    }

    public String getTaxtypecode() {
        return taxtypecode;
    }
    @XmlElement(name="TaxTypeCode",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setTaxtypecode(String taxtypecode) {
        this.taxtypecode = taxtypecode;
    }
}
