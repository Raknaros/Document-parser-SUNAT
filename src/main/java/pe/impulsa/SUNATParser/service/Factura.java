package pe.impulsa.SUNATParser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

@Service
public class Factura extends ExtractXml {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

    public void facturas(String ruta) throws ParserConfigurationException, IOException, SAXException {
        for (Map.Entry<String, String> entry : listaXml(ruta).entrySet()){
            if(entry.getKey().startsWith("FACTURA")){
                DocumentBuilder db=dbf.newDocumentBuilder();
                InputSource is = new InputSource(new StringReader(entry.getValue()));
                Document doc=db.parse(is);
                System.out.println(doc.getDocumentElement().getNodeName());
            }
        }
    }
    public void notasCredito(String ruta){

    }
}
