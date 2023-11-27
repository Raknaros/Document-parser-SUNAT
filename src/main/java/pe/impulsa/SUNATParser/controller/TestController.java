package pe.impulsa.SUNATParser.controller;

import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import pe.impulsa.SUNATParser.service.DataMethods;
import pe.impulsa.SUNATParser.service.ParseXML;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    DataMethods dataMethods;
    @Autowired
    ParseXML parseXML;

    @GetMapping("/facturas")
    public Integer parsearFacturas(@RequestParam String numero) throws ParserConfigurationException, IOException, SAXException, JAXBException {

        return parseXML.facturas("C:\\Users\\Raknaros\\Downloads\\xmls\\test");
    }
}
