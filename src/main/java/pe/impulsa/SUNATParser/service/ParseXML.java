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
import pe.impulsa.SUNATParser.pojo.xmlelements.taxtotal.TaxSubtotal;

import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class ParseXML extends ExtractXml {
    private final DataMethods dataMethods;
    private static DateTimeFormatter anomesdia = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static DateTimeFormatter anomes = DateTimeFormatter.ofPattern("yyyyMM");
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
                String cui=Long.toHexString(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue()))+e.getInvoiceTypeCode().getValor()+e.getId().split("-")[0].trim()+e.getId().split("-")[1].trim();
                if(dataMethods.verifyxml(Integer.valueOf(anomes.format(e.getIssuedate())),cui)){
                    BigDecimal totalBaseImponible;
                    BigDecimal totalDescuento;
                    BigDecimal totalIgv;
                    BigDecimal totalIsc;
                    BigDecimal totalOtrosCargos;
                    BigDecimal totalExonerado;
                    BigDecimal totalInafecto;
                    BigDecimal totalGratuito;
                    BigDecimal totalOtrosTributos;
                    BigDecimal subTotalVenta;
                    BigDecimal totalAdelanto;
                    if(dataMethods.verifysupplier(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue()))){
                        Iventas venta=new Iventas();
                        venta.setRuc(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue()));
                        venta.setPeriodoTributario(Integer.valueOf(anomes.format(e.getIssuedate())));
                        venta.setTipoOperacion(1);
                        venta.setTipoComprobante(Integer.valueOf(e.getInvoiceTypeCode().getValor()));
                        venta.setFechaEmision(Date.valueOf(e.getIssuedate()));
                        venta.setFechaVencimiento(Date.valueOf(e.getDuedate()));
                        venta.setNumeroSerie(e.getId().split("-")[0].trim());
                        venta.setNumeroCorrelativo(e.getId().split("-")[1].trim());
                        venta.setTipoDocumento(e.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getSchemeID());
                        venta.setNumeroDocumento(e.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getValue());
                        for(TaxSubtotal t:e.getTaxTotal().getTaxSubtotal()){
                            if(t.getTaxCategory().getTaxScheme().getId().getSchemeID().equals("1000")){
                                totalBaseImponible=t.getTaxableAmount().getValor();
                                totalIgv=t.getTaxAmount().getValor();
                            }else if(t.getTaxCategory().getTaxScheme().getId().getSchemeID().equals("2000")){
                                totalIsc=t.getTaxAmount().getValor();
                            }else if(t.getTaxCategory().getTaxScheme().getId().getSchemeID().equals("9999")){
                                totalOtrosTributos=t.getTaxAmount().getValor();
                            }else if(t.getTaxCategory().getTaxScheme().getId().getSchemeID().equals("9998")){
                                totalInafecto=t.getTaxableAmount().getValor();
                            }else if(t.getTaxCategory().getTaxScheme().getId().getSchemeID().equals("9997")){
                                totalExonerado=t.getTaxableAmount().getValor();
                            }else if(t.getTaxCategory().getTaxScheme().getId().getSchemeID().equals("9996")){
                                totalGratuito=t.getTaxableAmount().getValor();
                                totalIgv=t.getTaxAmount().getValor();
                            }
                        }
                        subTotalVenta=e.getLegalMonetaryTotal().getLineExtensionAmount().getValor();
                        totalDescuento=e.getLegalMonetaryTotal().getAllowanceTotalAmount().getValor();
                        totalOtrosCargos=e.getLegalMonetaryTotal().getChargeTotalAmount().getValor();
                        totalAdelanto=e.getLegalMonetaryTotal().getPrepaidAmount().getValor();
                        if((totalIgv.compareTo(BigDecimal.ZERO)==0||totalIgv.equals(null))&&(totalExonerado.compareTo(BigDecimal.ZERO)==0||totalExonerado.equals(null))&&(totalInafecto.compareTo(BigDecimal.ZERO)==0||totalInafecto.equals(null))){
                            venta.setDestino(1);
                        }
                        venta.setIcbp(new BigDecimal(0.00));
                        venta.setTipoMoneda(e.getDocumentCurrencyCode().getValor());
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
