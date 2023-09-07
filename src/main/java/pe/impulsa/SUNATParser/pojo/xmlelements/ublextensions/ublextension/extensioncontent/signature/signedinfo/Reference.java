package pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension.extensioncontent.signature.signedinfo;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet1;
import pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension.extensioncontent.signature.signedinfo.reference.Transforms;
@XmlRootElement
public class Reference {
    private AtrSet1 digestmethod;
    private String digestvalue;
    private Transforms transforms;
    private String uri;

    public AtrSet1 getDigestmethod() {
        return digestmethod;
    }
    @XmlElement(name="DigestMethod",namespace="http://www.w3.org/2000/09/xmldsig#")
    public void setDigestmethod(AtrSet1 digestmethod) {
        this.digestmethod = digestmethod;
    }

    public String getDigestvalue() {
        return digestvalue;
    }
    @XmlElement(name="DigestValue",namespace="http://www.w3.org/2000/09/xmldsig#")
    public void setDigestvalue(String digestvalue) {
        this.digestvalue = digestvalue;
    }

    public Transforms getTransforms() {
        return transforms;
    }
    @XmlElement(name="Transforms",namespace="http://www.w3.org/2000/09/xmldsig#")
    public void setTransforms(Transforms transforms) {
        this.transforms = transforms;
    }

    public String getUri() {
        return uri;
    }
    @XmlAttribute(name="URI")
    public void setUri(String uri) {
        this.uri = uri;
    }
}
