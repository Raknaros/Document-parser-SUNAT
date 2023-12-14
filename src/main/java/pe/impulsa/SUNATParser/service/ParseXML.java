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
import java.time.format.DateTimeFormatter;
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
    public List<Integer> parse(String ruta) throws JAXBException {
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
                if (!lista.stream()
                        .filter(c -> c.getRuc().equals(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())) && c.getPeriodoTributario() > Integer.parseInt(anomes.format(e.getIssuedate())))
                        .map(LogCUI::getLog).toList().contains(cui)) {
                    FacturaParse.toDB(entidades, cui, e);
                }
            } else if (entry.getKey().startsWith("NOTACREDITO")) {
                JAXBContext jaxbContext = JAXBContext.newInstance(NotaCredito.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                NotaCredito e = (NotaCredito) jaxbUnmarshaller.unmarshal(content);
                String cui = Long.toHexString(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())) + "07" + e.getId().split("-")[0].trim() + e.getId().split("-")[1].trim();
                //
                if (!lista.stream()
                        .filter(c -> c.getRuc().equals(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())) && c.getPeriodoTributario() > Integer.parseInt(anomes.format(e.getIssuedate())))
                        .map(LogCUI::getLog).toList().contains(cui)) {
                    NotaCreditoParse.toDB(entidades, cui, e);
                }
            }
        }
        return null;
    }
    public Integer facturas(String ruta) throws JAXBException {
        List<LogCUI> lista=dataMethods.verifyxml();
        List <Long> entidades = dataMethods.fetchEntities();
        for (Map.Entry<String, String> entry : listaXml(ruta).entrySet()) {
            if (entry.getKey().startsWith("FACTURA")) {
                StringReader content = new StringReader(entry.getValue());
                JAXBContext jaxbContext = JAXBContext.newInstance(Factura.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                Factura e = (Factura) jaxbUnmarshaller.unmarshal(content);
                String cui = Long.toHexString(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())) + e.getInvoiceTypeCode().getValor() + e.getId().split("-")[0].trim() + e.getId().split("-")[1].trim();
                //Listo para cambiar metodo verifyxml y probar el facturaparse, corregir tambien ingreso de cobropago.
                try {
                    if (!lista.stream()
                            .filter(c -> c.getRuc().equals(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())) && c.getPeriodoTributario() > Integer.parseInt(anomes.format(e.getIssuedate())))
                            .map(LogCUI::getLog).toList().contains(cui)) {
                        FacturaParse.toDB(entidades,cui,e);
                        /*
                        BigDecimal totalBaseImponible = new BigDecimal(0);
                        BigDecimal totalDescuento = new BigDecimal(0);
                        BigDecimal totalIgv = new BigDecimal(0);
                        BigDecimal totalIsc = new BigDecimal(0);
                        BigDecimal totalOtrosCargos = new BigDecimal(0);
                        BigDecimal totalExonerado = new BigDecimal(0);
                        BigDecimal totalInafecto = new BigDecimal(0);
                        BigDecimal totalGratuito = new BigDecimal(0);
                        BigDecimal totalOtrosTributos = new BigDecimal(0);
                        BigDecimal subTotalVenta = new BigDecimal(0);
                        BigDecimal totalAdelanto = new BigDecimal(0);
                        if (dataMethods.verifysupplier(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue()))) {
                            //INGRESAR VENTA

                            Ventas venta = new Ventas();
                            venta.setRuc(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue()));
                            venta.setPeriodoTributario(Integer.valueOf(anomes.format(e.getIssuedate())));
                            venta.setTipoOperacion(1);
                            venta.setTipoComprobante(Integer.valueOf(e.getInvoiceTypeCode().getValor()));
                            venta.setFechaEmision(Date.valueOf(e.getIssuedate()));
                            venta.setNumeroSerie(e.getId().split("-")[0].trim());
                            venta.setNumeroCorrelativo(e.getId().split("-")[1].trim());
                            if(e.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getSchemeID().equals("-")){
                                venta.setTipoDocumento("0");
                            }else {
                                venta.setTipoDocumento(e.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getSchemeID());
                            }
                            venta.setNumeroDocumento(e.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getValue());
                            int z = 0;
                            try {
                                for (AtrSet5 k : e.getNote()) {
                                    if (k.getLanguageLocaleID().equals("2006")) {
                                        venta.setTasaDetraccion(Integer.valueOf(e.getPaymentTerms().get(0).getPaymentmeansid()));
                                        z = 1;
                                    }
                                }
                            }catch (Exception ignored){}
                        if(!e.getPaymentTerms().get(z).getPaymentmeansid().equals("Contado")){
                            venta.setFechaVencimiento(Date.valueOf(e.getDuedate()));
                            Icobropago cobropago=new Icobropago();
                            try {
                                cobropago.setCuiRelacionado(cui);
                                cobropago.setFechaCuota1(Date.valueOf(e.getPaymentTerms().get(z+1).getPaymentduedate()));
                                cobropago.setImporteCuota1(e.getPaymentTerms().get(z+1).getAmount().getValor());
                                cobropago.setFechaCuota2(Date.valueOf(e.getPaymentTerms().get(z+2).getPaymentduedate()));
                                cobropago.setImporteCuota2(e.getPaymentTerms().get(z+2).getAmount().getValor());
                                cobropago.setFechaCuota3(Date.valueOf(e.getPaymentTerms().get(z+3).getPaymentduedate()));
                                cobropago.setImporteCuota3(e.getPaymentTerms().get(z+3).getAmount().getValor());
                                cobropago.setFechaCuota4(Date.valueOf(e.getPaymentTerms().get(z+4).getPaymentduedate()));
                                cobropago.setImporteCuota4(e.getPaymentTerms().get(z+4).getAmount().getValor());
                                cobropago.setFechaCuota5(Date.valueOf(e.getPaymentTerms().get(z+5).getPaymentduedate()));
                                cobropago.setImporteCuota5(e.getPaymentTerms().get(z+5).getAmount().getValor());
                                cobropago.setFechaCuota6(Date.valueOf(e.getPaymentTerms().get(z+6).getPaymentduedate()));
                                cobropago.setImporteCuota6(e.getPaymentTerms().get(z+6).getAmount().getValor());
                                cobropago.setFechaCuota7(Date.valueOf(e.getPaymentTerms().get(z+7).getPaymentduedate()));
                                cobropago.setImporteCuota7(e.getPaymentTerms().get(z+7).getAmount().getValor());
                            }catch (Exception ignored){}finally {
                                icobropagoRepo.save(cobropago);
                            }
                        }
                            for (TaxSubtotal t : e.getTaxTotal().getTaxSubtotal()) {
                                switch (t.getTaxCategory().getTaxScheme().getId().getValue()) {
                                    case "1000" -> {
                                        totalBaseImponible = t.getTaxableAmount().getValor();
                                        totalIgv = t.getTaxAmount().getValor();
                                    }
                                    case "2000" -> totalIsc = t.getTaxAmount().getValor();
                                    case "9999" -> totalOtrosTributos = t.getTaxAmount().getValor();
                                    case "9998" -> totalInafecto = t.getTaxableAmount().getValor();
                                    case "9997" -> totalExonerado = t.getTaxableAmount().getValor();
                                    case "9996" -> {
                                        totalGratuito = t.getTaxableAmount().getValor();
                                        totalIgv = t.getTaxAmount().getValor();
                                    }
                                }
                            }
                            subTotalVenta = e.getLegalMonetaryTotal().getLineExtensionAmount().getValor();
                            totalDescuento = e.getLegalMonetaryTotal().getAllowanceTotalAmount().getValor();
                            totalOtrosCargos = e.getLegalMonetaryTotal().getChargeTotalAmount().getValor();
                            totalAdelanto = e.getLegalMonetaryTotal().getPrepaidAmount().getValor();
                            venta.setTipoMoneda(e.getDocumentCurrencyCode().getValor());
                            //Si Base imponible no es null y suma de exonerado e inafecto no es null ni 0 destino es 3
                            //Si base imponible es null y sumat de exonerado e inafecto no es null ni 0 destino 2
                            //Si base imponible no es null y suma de exonerado e inafecto es null o 0 destino 1
                            if (totalBaseImponible.compareTo(BigDecimal.ZERO) != 0 && totalExonerado.add(totalInafecto).compareTo(BigDecimal.ZERO) != 0) {
                                venta.setDestino(3);
                                venta.setValor(totalBaseImponible);
                                venta.setIgv(totalIgv);
                                venta.setIsc(totalIsc);
                                venta.setOtrosCargos(totalOtrosCargos.add(totalOtrosTributos).add(totalInafecto).add(totalExonerado));
                            } else if (totalBaseImponible.compareTo(BigDecimal.ZERO) == 0) {
                                venta.setDestino(2);
                                venta.setValor(totalExonerado.add(totalInafecto));
                                venta.setIgv(new BigDecimal(0));
                                venta.setIsc(totalIsc);
                                venta.setOtrosCargos(totalOtrosCargos.add(totalOtrosTributos));
                            } else if (totalExonerado.add(totalInafecto).compareTo(BigDecimal.ZERO) == 0) {
                                venta.setDestino(1);
                                venta.setValor(totalBaseImponible);
                                venta.setIgv(totalIgv);
                                venta.setIsc(totalIsc);
                                venta.setOtrosCargos(totalOtrosCargos.add(totalOtrosTributos));
                            }
                            //venta.setIcbp(new BigDecimal(0));
                            //venta.setTasaDetraccion(null);
                            //venta.setTasaPercepcion(null);
                            venta.setObservaciones("PRUEBA");
                            ventasRepo.save(venta);
                            //INGRESAR INVENTARIO
                            Inventario inventario = new Inventario();
                            for (InvoiceLine i : e.getInvoiceLine()) {
                                inventario.setRuc(Long.valueOf(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue()));
                                inventario.setTipoOperacion(1);
                                inventario.setPeriodoTributario(Integer.valueOf(anomes.format(e.getIssuedate())));
                                inventario.setFecha(Date.valueOf(e.getIssuedate()));
                                inventario.setCodigoItem(i.getItem().getSellersItemIdentification().getId());
                                inventario.setDescripcion(i.getItem().getDescription());
                                inventario.setUnidadMedida(i.getInvoicedQuantity().getUnitCode());
                                inventario.setCantidad(i.getInvoicedQuantity().getValor());
                                inventario.setPrecioUnitario(i.getPrice().getPriceAmount().getValor());
                                for (TaxSubtotal a : i.getTaxTotal().getTaxSubtotal()) {
                                    if (a.getTaxCategory().getTaxScheme().getId().getValue().equals("1000")) {
                                        inventario.setIgv(a.getTaxCategory().getPercent());
                                    }
                                }
                                try {
                                    inventario.setTipoDocumentoReferencia(Integer.valueOf(e.getDespatchDocumentReference().getDocumentTypeCode()));
                                    inventario.setNumeroDocumentoReferencia(e.getDespatchDocumentReference().getId());
                                } catch (NullPointerException ex) {
                                    inventario.setTipoDocumentoReferencia(Integer.valueOf(e.getInvoiceTypeCode().getValor()));
                                    inventario.setNumeroDocumentoReferencia(e.getId());
                                }
                                inventario.setCuiRelacionado(cui);
                                inventario.setObservaciones("NUEVO");
                                inventarioRepo.save(inventario);
                            }
                        }
                        if (dataMethods.verifycustomer(Long.valueOf(e.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getValue()))) {
                            //INGRESAR COMPRA
                            Compras compra = new Compras();
                            compra.setRuc(Long.valueOf(e.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getValue()));
                            compra.setPeriodoTributario(Integer.valueOf(anomes.format(e.getIssuedate())));
                            compra.setTipoOperacion(2);
                            compra.setTipoComprobante(Integer.valueOf(e.getInvoiceTypeCode().getValor()));
                            compra.setFechaEmision(Date.valueOf(e.getIssuedate()));
                            compra.setNumeroSerie(e.getId().split("-")[0].trim());
                            compra.setNumeroCorrelativo(e.getId().split("-")[1].trim());
                            compra.setTipoDocumento(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getSchemeID());
                            compra.setNumeroDocumento(e.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue());
                            compra.setTipoMoneda(e.getDocumentCurrencyCode().getValor());
                            int z = 0;
                            try {
                                for (AtrSet5 k : e.getNote()) {
                                    if (k.getLanguageLocaleID().equals("2006")) {
                                        compra.setTasaDetraccion(Integer.valueOf(e.getPaymentTerms().get(0).getPaymentmeansid()));
                                        z = 1;
                                    }
                                }
                            }catch (Exception ignored){}
                            /*(
                        if(!e.getPaymentTerms().get(z).getPaymentmeansid().equals("Contado")){
                            compra.setFechaVencimiento(Date.valueOf(e.getDuedate()));
                            Icobropago cobropago=new Icobropago();
                            try {
                                cobropago.setCuiRelacionado(cui);
                                cobropago.setFechaCuota1(Date.valueOf(e.getPaymentTerms().get(z+1).getPaymentduedate()));
                                cobropago.setImporteCuota1(e.getPaymentTerms().get(z+1).getAmount().getValor());
                                cobropago.setFechaCuota2(Date.valueOf(e.getPaymentTerms().get(z+2).getPaymentduedate()));
                                cobropago.setImporteCuota2(e.getPaymentTerms().get(z+2).getAmount().getValor());
                                cobropago.setFechaCuota3(Date.valueOf(e.getPaymentTerms().get(z+3).getPaymentduedate()));
                                cobropago.setImporteCuota3(e.getPaymentTerms().get(z+3).getAmount().getValor());
                                cobropago.setFechaCuota4(Date.valueOf(e.getPaymentTerms().get(z+4).getPaymentduedate()));
                                cobropago.setImporteCuota4(e.getPaymentTerms().get(z+4).getAmount().getValor());
                                cobropago.setFechaCuota5(Date.valueOf(e.getPaymentTerms().get(z+5).getPaymentduedate()));
                                cobropago.setImporteCuota5(e.getPaymentTerms().get(z+5).getAmount().getValor());
                                cobropago.setFechaCuota6(Date.valueOf(e.getPaymentTerms().get(z+6).getPaymentduedate()));
                                cobropago.setImporteCuota6(e.getPaymentTerms().get(z+6).getAmount().getValor());
                                cobropago.setFechaCuota7(Date.valueOf(e.getPaymentTerms().get(z+7).getPaymentduedate()));
                                cobropago.setImporteCuota7(e.getPaymentTerms().get(z+7).getAmount().getValor());
                            }catch (Exception ignored){}finally {
                                icobropagoRepo.save(cobropago);
                            }
                        }

                            for (TaxSubtotal t : e.getTaxTotal().getTaxSubtotal()) {
                                switch (t.getTaxCategory().getTaxScheme().getId().getValue()) {
                                    case "1000" -> {
                                        totalBaseImponible = t.getTaxableAmount().getValor();
                                        totalIgv = t.getTaxAmount().getValor();
                                    }
                                    case "2000" -> totalIsc = t.getTaxAmount().getValor();
                                    case "9999" -> totalOtrosTributos = t.getTaxAmount().getValor();
                                    case "9998" -> totalInafecto = t.getTaxableAmount().getValor();
                                    case "9997" -> totalExonerado = t.getTaxableAmount().getValor();
                                    case "9996" -> {
                                        totalGratuito = t.getTaxableAmount().getValor();
                                        totalIgv = t.getTaxAmount().getValor();
                                    }
                                }
                            }
                            subTotalVenta = e.getLegalMonetaryTotal().getLineExtensionAmount().getValor();
                            totalDescuento = e.getLegalMonetaryTotal().getAllowanceTotalAmount().getValor();
                            totalOtrosCargos = e.getLegalMonetaryTotal().getChargeTotalAmount().getValor();
                            totalAdelanto = e.getLegalMonetaryTotal().getPrepaidAmount().getValor();
                            //Si Base imponible no es null y suma de exonerado e inafecto no es null ni 0 destino es 3
                            //Si base imponible es null y sumat de exonerado e inafecto no es null ni 0 destino 2
                            //Si base imponible no es null y suma de exonerado e inafecto es null o 0 destino 1
                            if (totalBaseImponible.compareTo(BigDecimal.ZERO) != 0 && totalExonerado.add(totalInafecto).compareTo(BigDecimal.ZERO) != 0) {
                                compra.setDestino(5);
                                compra.setValor(totalBaseImponible);
                                compra.setIgv(totalIgv);
                                compra.setIsc(totalIsc);
                                compra.setOtrosCargos(totalOtrosCargos.add(totalOtrosTributos).add(totalInafecto).add(totalExonerado));
                            } else if (totalBaseImponible.compareTo(BigDecimal.ZERO) == 0) {
                                compra.setDestino(4);
                                compra.setValor(totalExonerado.add(totalInafecto));
                                compra.setIgv(new BigDecimal(0));
                                compra.setIsc(totalIsc);
                                compra.setOtrosCargos(totalOtrosCargos.add(totalOtrosTributos));
                            } else if (totalExonerado.add(totalInafecto).compareTo(BigDecimal.ZERO) == 0) {
                                compra.setDestino(1);
                                compra.setValor(totalBaseImponible);
                                compra.setIgv(totalIgv);
                                compra.setIsc(totalIsc);
                                compra.setOtrosCargos(totalOtrosCargos.add(totalOtrosTributos));
                            }
                            //compra.setIcbp(new BigDecimal(0));
                            //compra.setTasaDetraccion(null);
                            //compra.setTasaPercepcion(null);
                            compra.setObservaciones("PRUEBA");
                            comprasRepo.save(compra);
                            //INGRESAR INVENTARIO
                            Inventario inventario = new Inventario();
                            for (InvoiceLine i : e.getInvoiceLine()) {
                                inventario.setRuc(Long.valueOf(e.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getValue()));
                                inventario.setTipoOperacion(2);
                                inventario.setPeriodoTributario(Integer.valueOf(anomes.format(e.getIssuedate())));
                                inventario.setFecha(Date.valueOf(e.getIssuedate()));
                                inventario.setCodigoItem(i.getItem().getSellersItemIdentification().getId());
                                inventario.setDescripcion(i.getItem().getDescription());
                                inventario.setUnidadMedida(i.getInvoicedQuantity().getUnitCode());
                                inventario.setCantidad(i.getInvoicedQuantity().getValor());
                                inventario.setPrecioUnitario(i.getPrice().getPriceAmount().getValor());
                                for (TaxSubtotal a : i.getTaxTotal().getTaxSubtotal()) {
                                    if (a.getTaxCategory().getTaxScheme().getId().getValue().equals("1000")) {
                                        inventario.setIgv(a.getTaxCategory().getPercent());
                                    }
                                }
                                try {
                                    inventario.setTipoDocumentoReferencia(Integer.valueOf(e.getDespatchDocumentReference().getDocumentTypeCode()));
                                    inventario.setNumeroDocumentoReferencia(e.getDespatchDocumentReference().getId());
                                } catch (NullPointerException ex) {
                                    inventario.setTipoDocumentoReferencia(Integer.valueOf(e.getInvoiceTypeCode().getValor()));
                                    inventario.setNumeroDocumentoReferencia(e.getId());
                                }
                                inventario.setCuiRelacionado(cui);
                                inventario.setObservaciones("NUEVO");
                                inventarioRepo.save(inventario);
                            }
                        }*/
                    }

                } catch (Exception ex) {
                    System.out.println(entry.getKey());
                    System.out.println(ex.getMessage());

                }


            }

        }return i;
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
