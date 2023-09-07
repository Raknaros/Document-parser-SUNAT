package pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.ublextensions.ublextension.ExtensionContent;

public class UBLExtension {
    public ExtensionContent getExtensionContent() {
        return extensionContent;
    }
    @XmlElement(name="ExtensionContent",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonExtensionComponents-2")
    public void setExtensionContent(ExtensionContent extensionContent) {
        this.extensionContent = extensionContent;
    }

    private ExtensionContent extensionContent;
}
