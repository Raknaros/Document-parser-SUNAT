package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;
@XmlRootElement
public class AtrSet5 {
    private String languageLocaleID;
    private String valor;

    public String getLanguageLocaleID() {
        return languageLocaleID;
    }
    @XmlAttribute(name="languageLocaleID")
    public void setLanguageLocaleID(String languageLocaleID) {
        this.languageLocaleID = languageLocaleID;
    }

    public String getValor() {
        return valor;
    }
    @XmlValue
    public void setValor(String valor) {
        this.valor = valor;
    }
}
