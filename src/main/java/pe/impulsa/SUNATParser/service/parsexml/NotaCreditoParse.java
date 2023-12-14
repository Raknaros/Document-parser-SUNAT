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

            if(!notaCredito.getPaymentTerms().get(z).getPaymentmeansid().equals("Contado")){

            }
        }else if (entidades.contains(Long.valueOf(notaCredito.getAccountingCustomerParty().getParty().getPartyIdentification().getId().getValue()))){

            if(!notaCredito.getPaymentTerms().get(z).getPaymentmeansid().equals("Contado")){
            }
        }
    }
    private static void anulacionOperacion(int z){
        if (z==5){
            Ventas notav=new Ventas();

        }
        if (z==8){
            Compras notac=new Compras();

        }

    }
    private static void ajustesMontosFechas(int z){

    }
    private static void devolucionItem(int z){

    }
    private static void correcionDescripcion(int z){

    }
}
