package pe.impulsa.SUNATParser.service.parsexml;

import org.springframework.stereotype.Component;
import pe.impulsa.SUNATParser.pojo.Factura;
import pe.impulsa.SUNATParser.pojo.NotaCredito;
import pe.impulsa.SUNATParser.warehouse.models.Compras;
import pe.impulsa.SUNATParser.warehouse.models.Ventas;
import pe.impulsa.SUNATParser.warehouse.repo.CobropagoRepo;
import pe.impulsa.SUNATParser.warehouse.repo.ComprasRepo;
import pe.impulsa.SUNATParser.warehouse.repo.InventarioRepo;
import pe.impulsa.SUNATParser.warehouse.repo.VentasRepo;

import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
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
        notaCredito = e;
        if(entidades.contains(Long.valueOf(notaCredito.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue()))){
            if(notaCredito.getDiscrepancyResponse().getResponsecode().equals("01")){
                anulacionOperacion(5);
            }else if(notaCredito.getDiscrepancyResponse().getResponsecode().equals("03")){
                System.out.println("CORRECCION POR ERROR EN LA DESCRIPCION");
            }else if(notaCredito.getDiscrepancyResponse().getResponsecode().equals("07")){
                System.out.println("DEVOLUCION POR ITEM");
            }else if(notaCredito.getDiscrepancyResponse().getResponsecode().equals("13")){
                System.out.println("AJUSTES MONTOS Y/O FECHAS DE PAGO");
            }
        }else if (entidades.contains(Long.valueOf(notaCredito.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getValue()))){
            if(notaCredito.getDiscrepancyResponse().getResponsecode().equals("01")){
                anulacionOperacion(8);
            }else if(notaCredito.getDiscrepancyResponse().getResponsecode().equals("03")){
                System.out.println("CORRECCION POR ERROR EN LA DESCRIPCION");
            }else if(notaCredito.getDiscrepancyResponse().getResponsecode().equals("07")){
                System.out.println("DEVOLUCION POR ITEM");
            }else if(notaCredito.getDiscrepancyResponse().getResponsecode().equals("13")){
                System.out.println("AJUSTES MONTOS Y/O FECHAS DE PAGO");
            }
        }
    }
    private static void anulacionOperacion(int z){
        if (z==5){
            String cuimodificado=Long.toHexString(Long.valueOf(notaCredito.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())) +notaCredito.getBillingReference().getInvoceDocumentReference().getDocumentTypeCode().getValor()+ notaCredito.getBillingReference().getInvoceDocumentReference().getId().split("-")[0].trim() + notaCredito.getBillingReference().getInvoceDocumentReference().getId().split("-")[1].trim();
            Ventas notav=new Ventas();
            Ventas modificadav=ventasRepo.findByCui(cuimodificado);
            notav.setPeriodoTributario(Integer.valueOf(anomes.format(notaCredito.getIssuedate())));
            notav.setTipoOperacion(1);
            notav.setTipoComprobante(7);
            notav.setFechaEmision(Date.valueOf(notaCredito.getIssuedate()));
            notav.setNumeroSerie(notaCredito.getId().split("-")[0].trim());
            notav.setNumeroCorrelativo(notaCredito.getId().split("-")[1].trim());
            notav.setTipoDocumento(modificadav.getTipoDocumento());
            notav.setNumeroDocumento(modificadav.getNumeroDocumento());
            notav.setTipoMoneda(modificadav.getTipoMoneda());
            notav.setTipoComprobanteModificado(modificadav.getTipoComprobante());
            notav.setNumeroSerieModificado(modificadav.getNumeroSerie());
            notav.setNumeroCorrelativoModificado(modificadav.getNumeroCorrelativo());
            notav.setDestino(modificadav.getDestino());
            notav.setValor(modificadav.getValor());
            notav.setOtrosCargos(modificadav.getOtrosCargos());
            notav.setIcbp(modificadav.getIcbp());
            notav.setIsc(modificadav.getIsc());
            notav.setGlosa("ANULACION DE OPERACION");
            inventarioRepo.deleteByCuiRelacionado(cuimodificado);
            cobropagoRepo.deleteByCuiRelacionado(cuimodificado);
            ventasRepo.save(notav);
        }else if (z==8){
            String cuimodificado=Long.toHexString(Long.valueOf(notaCredito.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())) +notaCredito.getBillingReference().getInvoceDocumentReference().getDocumentTypeCode().getValor()+ notaCredito.getBillingReference().getInvoceDocumentReference().getId().split("-")[0].trim() + notaCredito.getBillingReference().getInvoceDocumentReference().getId().split("-")[1].trim();
            Compras notac=new Compras();
            Compras modificadac=comprasRepo.findByCui(Long.toHexString(Long.valueOf(notaCredito.getAccountingSupplierParty().getParty().getPartyIdentification().getId().getValue())) +notaCredito.getBillingReference().getInvoceDocumentReference().getDocumentTypeCode().getValor()+ notaCredito.getBillingReference().getInvoceDocumentReference().getId().split("-")[0].trim() + notaCredito.getBillingReference().getInvoceDocumentReference().getId().split("-")[1].trim());
            notac.setPeriodoTributario(Integer.valueOf(anomes.format(notaCredito.getIssuedate())));
            notac.setTipoOperacion(1);
            notac.setTipoComprobante(7);
            notac.setFechaEmision(Date.valueOf(notaCredito.getIssuedate()));
            notac.setNumeroSerie(notaCredito.getId().split("-")[0].trim());
            notac.setNumeroCorrelativo(notaCredito.getId().split("-")[1].trim());
            notac.setTipoDocumento(modificadac.getTipoDocumento());
            notac.setNumeroDocumento(modificadac.getNumeroDocumento());
            notac.setTipoMoneda(modificadac.getTipoMoneda());
            notac.setTipoComprobanteModificado(modificadac.getTipoComprobante());
            notac.setNumeroSerieModificado(modificadac.getNumeroSerie());
            notac.setNumeroCorrelativoModificado(modificadac.getNumeroCorrelativo());
            notac.setDestino(modificadac.getDestino());
            notac.setValor(modificadac.getValor());
            notac.setOtrosCargos(modificadac.getOtrosCargos());
            notac.setIcbp(modificadac.getIcbp());
            notac.setIsc(modificadac.getIsc());
            notac.setGlosa("ANULACION DE OPERACION");
            inventarioRepo.deleteByCuiRelacionado(cuimodificado);
            cobropagoRepo.deleteByCuiRelacionado(cuimodificado);
            comprasRepo.save(notac);
        }

    }
    private static void ajustesMontosFechas(int z){

    }
    private static void devolucionItem(int z){

    }
    private static void correcionDescripcion(int z){

    }
}
