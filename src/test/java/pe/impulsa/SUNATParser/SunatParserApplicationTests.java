package pe.impulsa.SUNATParser;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;
import pe.impulsa.SUNATParser.impulsadb.repo.IentitiesRepo;
import pe.impulsa.SUNATParser.parserdb.repo.PentitiesRepo;
import pe.impulsa.SUNATParser.service.DataMethods;
import pe.impulsa.SUNATParser.service.ParseXML;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@SpringBootTest
class SunatParserApplicationTests {
	@Autowired
	ParseXML parseXML;
	@Autowired
	IentitiesRepo Ientitiesrepo;
	@Autowired
    PentitiesRepo Pentitiesrepo;
	@Autowired
	DataMethods dataMethods;

	@Test
	void contextLoads() throws ParserConfigurationException, IOException, SAXException {
		//dataMethods.resetAllEntities();
		//factura.facturas("D:\\SUNAT-Parser\\xmls");
		Ientitiesrepo.findAllByActivoAndObservacionesIsNot(true,"Problema Autenticacion").forEach(IEntities -> System.out.println(IEntities.getNumeroDocumento()));
	}
}
