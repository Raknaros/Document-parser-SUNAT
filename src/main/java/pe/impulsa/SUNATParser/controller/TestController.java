package pe.impulsa.SUNATParser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;
import pe.impulsa.SUNATParser.parserdb.models.PEntities;
import pe.impulsa.SUNATParser.parserdb.repo.PEntitiesRepo;
import pe.impulsa.SUNATParser.service.DataMethods;
import pe.impulsa.SUNATParser.service.Factura;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    DataMethods dataMethods;
    @Autowired
    PEntitiesRepo Pentitiesrepo;
    @Autowired
    Factura factura;

    @GetMapping("/facturas")
    public Integer parsearFacturas() throws ParserConfigurationException, IOException, SAXException {

        return factura.facturas("D:\\SUNAT-Parser\\xmls");
    }
    @GetMapping("/reset")
    public String iniciarEntidades(){
        try {
            dataMethods.resetAllEntities();
            return "Entidades Iniciadas";
        } catch (Exception e) {
            return "Error al iniciar entidades";
        }
    }
}
