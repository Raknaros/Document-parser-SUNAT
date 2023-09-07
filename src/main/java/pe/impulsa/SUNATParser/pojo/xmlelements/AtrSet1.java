package pe.impulsa.SUNATParser.pojo.xmlelements;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AtrSet1 {
    private String algorithm;

    public String getAlgorithm() {
        return algorithm;
    }
    @XmlElement(name="Algorithm")
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}
