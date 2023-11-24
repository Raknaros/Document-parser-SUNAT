package pe.impulsa.SUNATParser.service.parsexml;

import pe.impulsa.SUNATParser.warehouse.models.Cobropago;
import pe.impulsa.SUNATParser.warehouse.models.Compras;
import pe.impulsa.SUNATParser.warehouse.models.Inventario;
import pe.impulsa.SUNATParser.warehouse.models.Ventas;
import pe.impulsa.SUNATParser.warehouse.repo.CobropagoRepo;
import pe.impulsa.SUNATParser.warehouse.repo.ComprasRepo;
import pe.impulsa.SUNATParser.warehouse.repo.InventarioRepo;
import pe.impulsa.SUNATParser.warehouse.repo.VentasRepo;
import pe.impulsa.SUNATParser.pojo.Factura;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet5;
import pe.impulsa.SUNATParser.pojo.xmlelements.InvoiceLine;
import pe.impulsa.SUNATParser.pojo.xmlelements.taxtotal.TaxSubtotal;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FacturaParse {
    private static VentasRepo ventasRepo = null;
    private static ComprasRepo comprasRepo = null;
    private static InventarioRepo inventarioRepo = null;
    private static CobropagoRepo cobropagoRepo = null;
    private static Factura factura;
    private static DateTimeFormatter anomesdia = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static DateTimeFormatter anomes = DateTimeFormatter.ofPattern("yyyyMM");
    private static BigDecimal totalBaseImponible = new BigDecimal(0);
    private static BigDecimal totalDescuento = new BigDecimal(0);
    private static BigDecimal totalIgv = new BigDecimal(0);
    private static BigDecimal totalIsc = new BigDecimal(0);
    private static BigDecimal totalOtrosCargos = new BigDecimal(0);
    private static BigDecimal totalExonerado = new BigDecimal(0);
    private static BigDecimal totalInafecto = new BigDecimal(0);
    private static BigDecimal totalGratuito = new BigDecimal(0);
    private static BigDecimal totalOtrosTributos = new BigDecimal(0);
    private static BigDecimal subTotalVenta = new BigDecimal(0);
    private static BigDecimal totalAdelanto = new BigDecimal(0);

    public FacturaParse(VentasRepo ventasRepo, ComprasRepo comprasRepo, InventarioRepo inventarioRepo, CobropagoRepo cobropagoRepo, Factura factura) {
        FacturaParse.ventasRepo = ventasRepo;
        FacturaParse.comprasRepo = comprasRepo;
        FacturaParse.inventarioRepo = inventarioRepo;
        FacturaParse.cobropagoRepo = cobropagoRepo;
        FacturaParse.factura =factura;
    }
    public static Integer toDB(String cui, List<Long> entidades){
        Integer i=0;

        String cui = Long.toHexString(Long.parseLong(factura.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())) + factura.getInvoiceTypeCode().getValor() + factura.getId().split("-")[0].trim() + factura.getId().split("-")[1].trim();

      return i;
    };
    private static void registrarVenta(){
        Ventas venta = new Ventas();
        venta.setRuc(Long.valueOf(factura.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue()));
        venta.setPeriodoTributario(Integer.valueOf(anomes.format(factura.getIssuedate())));
        venta.setTipoOperacion(1);
        venta.setTipoComprobante(Integer.valueOf(factura.getInvoiceTypeCode().getValor()));
        venta.setFechaEmision(Date.valueOf(factura.getIssuedate()));
        venta.setNumeroSerie(factura.getId().split("-")[0].trim());
        venta.setNumeroCorrelativo(factura.getId().split("-")[1].trim());
        if(factura.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getSchemeID().equals("-")){
            venta.setTipoDocumento("0");
        }else {
            venta.setTipoDocumento(factura.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getSchemeID());
        }
        venta.setNumeroDocumento(factura.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getValue());
        int z = 0;
        try {
            for (AtrSet5 k : factura.getNote()) {
                if (k.getLanguageLocaleID().equals("2006")) {
                    venta.setTasaDetraccion(Integer.valueOf(factura.getPaymentTerms().get(0).getPaymentmeansid()));
                    z = 1;
                }
            }
        }catch (Exception ignored){}
        for (TaxSubtotal t : factura.getTaxTotal().getTaxSubtotal()) {
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
        subTotalVenta = factura.getLegalMonetaryTotal().getLineExtensionAmount().getValor();
        totalDescuento = factura.getLegalMonetaryTotal().getAllowanceTotalAmount().getValor();
        totalOtrosCargos = factura.getLegalMonetaryTotal().getChargeTotalAmount().getValor();
        totalAdelanto = factura.getLegalMonetaryTotal().getPrepaidAmount().getValor();
        venta.setTipoMoneda(factura.getDocumentCurrencyCode().getValor());
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
        venta.setObservaciones("PARSER");
        ventasRepo.save(venta);
    }
    private static void registrarCompra(){
        Compras compra = new Compras();
        compra.setRuc(Long.valueOf(factura.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getValue()));
        compra.setPeriodoTributario(Integer.valueOf(anomes.format(factura.getIssuedate())));
        compra.setTipoOperacion(2);
        compra.setTipoComprobante(Integer.valueOf(factura.getInvoiceTypeCode().getValor()));
        compra.setFechaEmision(Date.valueOf(factura.getIssuedate()));
        compra.setNumeroSerie(factura.getId().split("-")[0].trim());
        compra.setNumeroCorrelativo(factura.getId().split("-")[1].trim());
        compra.setTipoDocumento(factura.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getSchemeID());
        compra.setNumeroDocumento(factura.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue());
        compra.setTipoMoneda(factura.getDocumentCurrencyCode().getValor());
        int z = 0;
        try {
            for (AtrSet5 k : factura.getNote()) {
                if (k.getLanguageLocaleID().equals("2006")) {
                    compra.setTasaDetraccion(Integer.valueOf(factura.getPaymentTerms().get(0).getPaymentmeansid()));
                    z = 1;
                }
            }
        }catch (Exception ignored){}
        for (TaxSubtotal t : factura.getTaxTotal().getTaxSubtotal()) {
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
        subTotalVenta = factura.getLegalMonetaryTotal().getLineExtensionAmount().getValor();
        totalDescuento = factura.getLegalMonetaryTotal().getAllowanceTotalAmount().getValor();
        totalOtrosCargos = factura.getLegalMonetaryTotal().getChargeTotalAmount().getValor();
        totalAdelanto = factura.getLegalMonetaryTotal().getPrepaidAmount().getValor();
        //Si Base imponible no es null y suma de exonerado e inafecto no es null ni 0 destino es 5
        //Si base imponible es null y sumat de exonerado e inafecto no es null ni 0 destino 4
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
        compra.setObservaciones("PARSER");
        comprasRepo.save(compra);
    }
    private static void registrarCobroPago(){
        Cobropago cobropago=new Cobropago();
        try {
            cobropago.setCuiRelacionado(cui);
            cobropago.setFechaCuota1(Date.valueOf(factura.getPaymentTerms().get(z+1).getPaymentduedate()));
            cobropago.setImporteCuota1(factura.getPaymentTerms().get(z+1).getAmount().getValor());
            cobropago.setFechaCuota2(Date.valueOf(factura.getPaymentTerms().get(z+2).getPaymentduedate()));
            cobropago.setImporteCuota2(factura.getPaymentTerms().get(z+2).getAmount().getValor());
            cobropago.setFechaCuota3(Date.valueOf(factura.getPaymentTerms().get(z+3).getPaymentduedate()));
            cobropago.setImporteCuota3(factura.getPaymentTerms().get(z+3).getAmount().getValor());
            cobropago.setFechaCuota4(Date.valueOf(factura.getPaymentTerms().get(z+4).getPaymentduedate()));
            cobropago.setImporteCuota4(factura.getPaymentTerms().get(z+4).getAmount().getValor());
            cobropago.setFechaCuota5(Date.valueOf(factura.getPaymentTerms().get(z+5).getPaymentduedate()));
            cobropago.setImporteCuota5(factura.getPaymentTerms().get(z+5).getAmount().getValor());
            cobropago.setFechaCuota6(Date.valueOf(factura.getPaymentTerms().get(z+6).getPaymentduedate()));
            cobropago.setImporteCuota6(factura.getPaymentTerms().get(z+6).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+8).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+8).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+9).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+9).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+10).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+10).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+11).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+11).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+12).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+12).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+13).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+13).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+14).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+14).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+15).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+15).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());
            cobropago.setFechaCuota7(Date.valueOf(factura.getPaymentTerms().get(z+7).getPaymentduedate()));
            cobropago.setImporteCuota7(factura.getPaymentTerms().get(z+7).getAmount().getValor());

        }catch (Exception ignored){}finally {
            cobropagoRepo.save(cobropago);
        }
    }
    private static void registrarInventario(){
        Inventario inventario = new Inventario();
        for (InvoiceLine i : factura.getInvoiceLine()) {
            inventario.setRuc(Long.valueOf(factura.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue()));
            inventario.setTipoOperacion(1);
            inventario.setPeriodoTributario(Integer.valueOf(anomes.format(factura.getIssuedate())));
            inventario.setFecha(Date.valueOf(factura.getIssuedate()));
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
                inventario.setTipoDocumentoReferencia(Integer.valueOf(factura.getDespatchDocumentReference().getDocumentTypeCode()));
                inventario.setNumeroDocumentoReferencia(factura.getDespatchDocumentReference().getId());
            } catch (NullPointerException ex) {
                inventario.setTipoDocumentoReferencia(Integer.valueOf(factura.getInvoiceTypeCode().getValor()));
                inventario.setNumeroDocumentoReferencia(factura.getId());
            }
            inventario.setCuiRelacionado(cui);
            inventario.setObservaciones("PARSER");
            inventarioRepo.save(inventario);
        }
    }

}
