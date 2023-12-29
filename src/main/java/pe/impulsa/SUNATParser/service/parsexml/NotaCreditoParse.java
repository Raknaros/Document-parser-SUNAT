package pe.impulsa.SUNATParser.service.parsexml;

import pe.impulsa.SUNATParser.pojo.Factura;
import pe.impulsa.SUNATParser.pojo.NotaCredito;
import pe.impulsa.SUNATParser.warehouse.models.Compras;
import pe.impulsa.SUNATParser.warehouse.models.Ventas;
import pe.impulsa.SUNATParser.warehouse.repo.CobropagoRepo;
import pe.impulsa.SUNATParser.warehouse.repo.ComprasRepo;
import pe.impulsa.SUNATParser.warehouse.repo.InventarioRepo;
import pe.impulsa.SUNATParser.warehouse.repo.VentasRepo;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class NotaCreditoParse {
    private static VentasRepo ventasRepo = null;
    private static InventarioRepo inventarioRepo = null;
    private static ComprasRepo comprasRepo = null;
    private static CobropagoRepo cobropagoRepo = null;
    private static NotaCredito notaCredito;
    private static DateTimeFormatter anomesdia = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static DateTimeFormatter anomes = DateTimeFormatter.ofPattern("yyyyMM");
    public NotaCreditoParse(VentasRepo ventasRepo, ComprasRepo comprasRepo, InventarioRepo inventarioRepo, CobropagoRepo cobropagoRepo) {
        NotaCreditoParse.ventasRepo = ventasRepo;
        NotaCreditoParse.comprasRepo = comprasRepo;
        NotaCreditoParse.inventarioRepo = inventarioRepo;
        NotaCreditoParse.cobropagoRepo = cobropagoRepo;
        //SI ES TIPO 03 CORRECION POR ERROR EN LA DESCRIPCION
        //SI ES TIPO 13 AJUNTES MONTOS Y/O FECHAS DE PAGO
        //SI ES TIPO 07 DEVOLUCION POR ITEM
        //SI ES TIPO 01 ANULACION DE LA OPERACION
    }
    public static void toDB(List<Long> entidades, String cui, NotaCredito e){
        int z = 0;
        notaCredito = e;
        if(entidades.contains(Long.valueOf(notaCredito.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue()))){
            if(!notaCredito.getDiscrepancyResponse().getResponsecode().equals("01")){
                anulacionOperacion(5);
            }else if(!notaCredito.getDiscrepancyResponse().getResponsecode().equals("03")){

            }else if(!notaCredito.getDiscrepancyResponse().getResponsecode().equals("07")){

            }else if(!notaCredito.getDiscrepancyResponse().getResponsecode().equals("13")){

            }
        }else if (entidades.contains(Long.valueOf(notaCredito.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getValue()))){
            if(!notaCredito.getDiscrepancyResponse().getResponsecode().equals("01")){
                anulacionOperacion(8);
            }else if(!notaCredito.getDiscrepancyResponse().getResponsecode().equals("03")){

            }else if(!notaCredito.getDiscrepancyResponse().getResponsecode().equals("07")){

            }else if(!notaCredito.getDiscrepancyResponse().getResponsecode().equals("13")){

            }
        }
    }
    private static void anulacionOperacion(int z){


        if (z==5){
            Ventas notav=new Ventas();
            Ventas modificadav=ventasRepo.findByCui(Long.toHexString(Long.valueOf(notaCredito.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())) +notaCredito.getBillingReference().getInvoceDocumentReference().getDocumentTypeCode().getValor()+ notaCredito.getBillingReference().getInvoceDocumentReference().getId().split("-")[0].trim() + notaCredito.getBillingReference().getInvoceDocumentReference().getId().split("-")[1].trim());
            notav.setPeriodoTributario(modificadav.getPeriodoTributario());
            notav.setTipoOperacion(modificadav.getTipoOperacion());
            notav.setTipoComprobante(modificadav.getTipoComprobante());
            notav.setFechaEmision(modificadav.getFechaEmision());
            notav.setNumeroSerie(modificadav.getNumeroSerie());
            notav.setNumeroCorrelativo(modificadav.getNumeroCorrelativo());
            notav.setTipoDocumento(modificadav.getTipoDocumento());
            notav.setNumeroDocumento(modificadav.getNumeroDocumento());
            notav.setTipoMoneda(modificadav.getTipoMoneda());
            notav.setTipoComprobanteModificado(modificadav.getTipoComprobanteModificado());
            notav.setNumeroSerieModificado(modificadav.getNumeroSerieModificado());
            notav.setNumeroCorrelativoModificado(modificadav.getNumeroCorrelativoModificado());
            notav.setDestino(modificadav.getDestino());
            notav.setValor(modificadav.getValor());
            notav.setOtrosCargos(modificadav.getOtrosCargos());
            notav.setIcbp(modificadav.getIcbp());
            notav.setIsc(modificadav.getIsc());
            notav.setGlosa("ANULACION DE OPERACION");
            inventarioRepo.deleteByCuiRelacionado();
            cobropagoRepo.deleteByCuiRelacionado();
        }else if (z==8){
            Compras notac=new Compras();
            Compras modificadac=comprasRepo.findByCui(Long.toHexString(Long.valueOf(notaCredito.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())) +notaCredito.getBillingReference().getInvoceDocumentReference().getDocumentTypeCode().getValor()+ notaCredito.getBillingReference().getInvoceDocumentReference().getId().split("-")[0].trim() + notaCredito.getBillingReference().getInvoceDocumentReference().getId().split("-")[1].trim());
            notac.setPeriodoTributario();
            notac.setTipoOperacion();
            notac.setTipoComprobante();
            notac.setNumeroSerie();
            notac.setNumeroCorrelativo();
            notac.setTipoDocumento();
            notac.setNumeroDocumento();
            notac.setTipoMoneda();
            notac.setTipoComprobanteModificado();
            notac.setNumeroSerieModificado();
            notac.setNumeroCorrelativoModificado();
            notac.setDestino();
            notac.setValor();
            notac.setOtrosCargos();
            notac.setIcbp();
            notac.setIsc();
            notac.setGlosa("ANULACIÓN DE OPERACIÓN");
            inventarioRepo.deleteByCuiRelacionado();
            cobropagoRepo.deleteByCuiRelacionado();
        }

    }
    private static void ajustesMontosFechas(int z){

    }
    private static void devolucionItem(int z){

    }
    private static void correcionDescripcion(int z){

    }
}
