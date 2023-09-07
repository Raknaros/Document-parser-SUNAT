package pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension.extensioncontent.signature.signedinfo.reference;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet1;

public class Transforms {
    private AtrSet1 transform;

    public AtrSet1 getTransform() {
        return transform;
    }
    @XmlElement(name="Transform",namespace="http://www.w3.org/2000/09/xmldsig#")
    public void setTransform(AtrSet1 transform) {
        this.transform = transform;
    }
}
