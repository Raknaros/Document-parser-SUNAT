package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;

import java.math.BigDecimal;

@XmlRootElement
public class AtrSet4 {
    private String currencyID;
    private BigDecimal valor;

    public String getCurrencyID() {
        return currencyID;
    }
    @XmlAttribute(name="currencyID")
    public void setCurrencyID(String currencyID) {
        this.currencyID = currencyID;
    }

    public BigDecimal getValor() {
        return valor;
    }
    @XmlValue
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
