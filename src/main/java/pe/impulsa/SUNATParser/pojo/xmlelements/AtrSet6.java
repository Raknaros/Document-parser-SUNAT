package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;
@XmlRootElement
public class AtrSet6 {
    private String unitCode;
    private String unitCodeListAgencyName;
    private String unitCodeListID;
    private Float valor;

    public String getUnitCode() {
        return unitCode;
    }
    @XmlAttribute(name="unitCode")
    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitCodeListAgencyName() {
        return unitCodeListAgencyName;
    }
    @XmlAttribute(name="unitCodeListAgencyName")
    public void setUnitCodeListAgencyName(String unitCodeListAgencyName) {
        this.unitCodeListAgencyName = unitCodeListAgencyName;
    }

    public String getUnitCodeListID() {
        return unitCodeListID;
    }
    @XmlAttribute(name="unitCodeListID")
    public void setUnitCodeListID(String unitCodeListID) {
        this.unitCodeListID = unitCodeListID;
    }

    public Float getValor() {
        return valor;
    }
    @XmlValue
    public void setValor(Float valor) {
        this.valor = valor;
    }
}
