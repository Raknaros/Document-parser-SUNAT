package pe.impulsa.SUNATParser.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.stereotype.Service;

import pe.impulsa.SUNATParser.impulsadb.models.Iventas;
import pe.impulsa.SUNATParser.impulsadb.models.Icompras;
import pe.impulsa.SUNATParser.pojo.BoletaVenta;
import pe.impulsa.SUNATParser.pojo.Factura;
import pe.impulsa.SUNATParser.pojo.NotaCredito;
import pe.impulsa.SUNATParser.pojo.NotaDebito;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Map;

@Service
public class ParseXML extends ExtractXml {
    private final DataMethods dataMethods;
    private static SimpleDateFormat formatoAnoMes = new SimpleDateFormat("yyyyMM");
    private static SimpleDateFormat formatoAnoMesDia = new SimpleDateFormat("yyyyMMdd");
    private final Iventas iventas;
    private final Icompras icompras;
    Integer i=0;

    public ParseXML(DataMethods dataMethods, Iventas iventas, Icompras icompras) {
        this.dataMethods = dataMethods;
        this.iventas = iventas;
        this.icompras = icompras;
    }

    public Integer facturas(String ruta) throws JAXBException {
        for (Map.Entry<String, String> entry : listaXml(ruta).entrySet()){
            if(entry.getKey().startsWith("FACTURA")){
                StringReader content = new StringReader(entry.getValue());
                JAXBContext jaxbContext = JAXBContext.newInstance(Factura.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                Factura e=(Factura) jaxbUnmarshaller.unmarshal(content);
                String cui=e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue()+e.getInvoiceTypeCode().getValor()+e.getId();
                if(dataMethods.verifyxml(Integer.valueOf(formatoAnoMes.format(e.getIssuedate())),cui)){
                    if(dataMethods.verifysupplier(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())){
                        Iventas venta=new Iventas();
                        venta.setRuc(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValor);
                        venta.setPeriodoTributario();
                        venta.setTipoOperacion(1);
                        venta.setTipoComprobante(Integer.valueOf(e.getInvoiceTypeCode().getValor()));
                        venta.setFechaEmision();
                        venta.setFechaVencimiento();
                        venta.setNumeroSerie();
                        venta.setNumeroCorrelativo();
                        venta.setTipoDocumento();
                        venta.setNumeroDocumento();
                        venta.setDestino();
                        venta.setValor();
                        venta.setIgv();
                        venta.setIcbp();
                        venta.setIsc();
                        venta.setOtrosCargos();
                        venta.setTipoMoneda();
                        venta.setTasaDetraccion();
                        venta.setTasaPercepcion();
                    }else if(dataMethods.verifycustomer(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())){
                        Icompras compra=new Icompras();
                        compra.set
                    }
                }

            }
        }
        return i;
    }
    public Integer notasCredito(String ruta) throws JAXBException {
        for (Map.Entry<String, String> entry : listaXml(ruta).entrySet()){
            if(entry.getKey().startsWith("NOTACREDITO")){
                StringReader content = new StringReader(entry.getValue());
                JAXBContext jaxbContext = JAXBContext.newInstance(NotaCredito.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                NotaCredito e=(NotaCredito) jaxbUnmarshaller.unmarshal(content);
                //System.out.println(doc.getDocumentElement().getNodeName());
            }
        }
        return i;
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
