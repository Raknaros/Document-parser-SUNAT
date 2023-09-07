package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlValue;

@XmlRootElement
public class AtrSet2 {
    private String listAgencyName;
    private String listSchemeURI;
    private String listURI;
    private String listName;
    private String listID;
    private String name;
    private String valor;

    public String getListAgencyName() {
        return listAgencyName;
    }
    @XmlAttribute(name="listAgencyName")
    public void setListAgencyName(String listAgencyName) {
        this.listAgencyName = listAgencyName;
    }

    public String getListSchemeURI() {
        return listSchemeURI;
    }
    @XmlAttribute(name="listSchemeURI")
    public void setListSchemeURI(String listSchemeURI) {
        this.listSchemeURI = listSchemeURI;
    }

    public String getListURI() {
        return listURI;
    }
    @XmlAttribute(name="listURI")
    public void setListURI(String listURI) {
        this.listURI = listURI;
    }

    public String getListName() {
        return listName;
    }
    @XmlAttribute(name="listName")
    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getListID() {
        return listID;
    }
    @XmlAttribute(name="listID")
    public void setListID(String listID) {
        this.listID = listID;
    }

    public String getName() {
        return name;
    }
    @XmlAttribute(name="name")
    public void setName(String name) {
        this.name = name;
    }

    public String getValor() {
        return valor;
    }
    @XmlValue
    public void setValor(String valor) {
        this.valor = valor;
    }
}
