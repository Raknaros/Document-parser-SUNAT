package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.UBLExtension;

public class UBLExtensions {
    private UBLExtension ublExtension;

    public UBLExtension getUblExtension() {
        return ublExtension;
    }
    @XmlElement(name="UBLExtension",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2")
    public void setUblExtension(UBLExtension ublExtension) {
        this.ublExtension = ublExtension;
    }
}
