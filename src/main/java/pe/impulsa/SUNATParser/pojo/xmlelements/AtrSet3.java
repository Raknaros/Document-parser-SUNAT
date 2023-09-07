package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;
@XmlRootElement
public class AtrSet3 {
    private String schemeAgencyName;
    private String schemeID;
    private String schemeName;
    private String schemeURI;
    private String value;

    public String getSchemeAgencyName() {
        return schemeAgencyName;
    }
    @XmlAttribute(name="schemeAgencyName")
    public void setSchemeAgencyName(String schemeAgencyName) {
        this.schemeAgencyName = schemeAgencyName;
    }

    public String getSchemeID() {
        return schemeID;
    }
    @XmlAttribute(name="schemeID")
    public void setSchemeID(String schemeID) {
        this.schemeID = schemeID;
    }

    public String getSchemeName() {
        return schemeName;
    }
    @XmlAttribute(name="schemeName")
    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public String getSchemeURI() {
        return schemeURI;
    }
    @XmlAttribute(name="schemeURI")
    public void setSchemeURI(String schemeURI) {
        this.schemeURI = schemeURI;
    }

    public String getValue() {
        return value;
    }
    @XmlValue
    public void setValue(String value) {
        this.value = value;
    }
}
