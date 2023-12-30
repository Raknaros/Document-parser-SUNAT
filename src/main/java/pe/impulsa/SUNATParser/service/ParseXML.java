package pe.impulsa.SUNATParser.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import pe.impulsa.SUNATParser.pojo.*;
import pe.impulsa.SUNATParser.service.parsexml.FacturaParse;
import pe.impulsa.SUNATParser.service.parsexml.NotaCreditoParse;
import pe.impulsa.SUNATParser.warehouse.models.Entities;
import pe.impulsa.SUNATParser.warehouse.models.Inventario;
import pe.impulsa.SUNATParser.warehouse.models.Ventas;
import pe.impulsa.SUNATParser.warehouse.models.Compras;
import pe.impulsa.SUNATParser.warehouse.repo.CobropagoRepo;
import pe.impulsa.SUNATParser.warehouse.repo.ComprasRepo;
import pe.impulsa.SUNATParser.warehouse.repo.InventarioRepo;
import pe.impulsa.SUNATParser.warehouse.repo.VentasRepo;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet5;
import pe.impulsa.SUNATParser.pojo.xmlelements.InvoiceLine;
import pe.impulsa.SUNATParser.pojo.xmlelements.taxtotal.TaxSubtotal;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ParseXML extends ExtractXml {
    private final DataMethods dataMethods;
    private static DateTimeFormatter anomesdia = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static DateTimeFormatter anomes = DateTimeFormatter.ofPattern("yyyyMM");
    private final VentasRepo ventasRepo;
    private final ComprasRepo comprasRepo;
    private final InventarioRepo inventarioRepo;
    private final CobropagoRepo cobropagoRepo;
    Integer i=0;

    public ParseXML(DataMethods dataMethods, VentasRepo ventasRepo, ComprasRepo comprasRepo, InventarioRepo inventarioRepo, CobropagoRepo cobropagoRepo) {
        this.dataMethods = dataMethods;
        this.ventasRepo = ventasRepo;
        this.comprasRepo = comprasRepo;
        this.inventarioRepo = inventarioRepo;
        this.cobropagoRepo = cobropagoRepo;
    }
    public void parse(String ruta) throws JAXBException {
        List<LogCUI> lista = dataMethods.verifyxml();
        List<Long> entidades = dataMethods.fetchEntities();
        for (Map.Entry<String, String> entry : listaXml(ruta).entrySet()) {
            StringReader content = new StringReader(entry.getValue());
                if (entry.getKey().startsWith("FACTURA")) {
                    JAXBContext jaxbContext = JAXBContext.newInstance(Factura.class);
                    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    Factura e = (Factura) jaxbUnmarshaller.unmarshal(content);
                    String cui = Long.toHexString(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())) + e.getInvoiceTypeCode().getValor() + e.getId().split("-")[0].trim() + e.getId().split("-")[1].trim();
                    //REVISAR METODO VERIFY XML
                    FacturaParse.toDB(entidades, cui, e);
                    /*if (!lista.stream()
                            .filter(c -> c.getRuc().equals(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())) && c.getPeriodoTributario() > Integer.parseInt(anomes.format(e.getIssuedate())))
                            .map(LogCUI::getLog).toList().contains(cui)) {
                        FacturaParse.toDB(entidades, cui, e);
                    }*/
                } else if (entry.getKey().startsWith("NOTA_CREDITO")) {
                    JAXBContext jaxbContext = JAXBContext.newInstance(NotaCredito.class);
                    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                    NotaCredito e = (NotaCredito) jaxbUnmarshaller.unmarshal(content);
                    String cui = Long.toHexString(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())) + "07" + e.getId().split("-")[0].trim() + e.getId().split("-")[1].trim();
                    NotaCreditoParse.toDB(entidades, cui, e);
                }
        }
    }
    public Integer notasDebito(String ruta) throws JAXBException {
        for (Map.Entry<String, String> entry : listaXml(ruta).entrySet()){
            if(entry.getKey().startsWith("NOTADEBITO")){
                StringReader content = new StringReader(entry.getValue());
                JAXBContext jaxbContext = JAXBContext.newInstance(NotaDebito.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                NotaDebito e=(NotaDebito) jaxbUnmarshaller.unmarshal(content);
                //System.out.println(doc.getDocumentElement().getNodeName());
            }
        }
        return i;
    }
    public Integer boletasVenta(String ruta) throws JAXBException {
        for (Map.Entry<String, String> entry : listaXml(ruta).entrySet()){
            if(entry.getKey().startsWith("BOLETA")){
                StringReader content = new StringReader(entry.getValue());
                JAXBContext jaxbContext = JAXBContext.newInstance(BoletaVenta.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                BoletaVenta e=(BoletaVenta) jaxbUnmarshaller.unmarshal(content);
                //System.out.println(doc.getDocumentElement().getNodeName());
            }
        }
        return i;
    }
}
