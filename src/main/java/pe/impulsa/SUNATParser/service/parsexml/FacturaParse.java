package pe.impulsa.SUNATParser.service.parsexml;

import pe.impulsa.SUNATParser.impulsadb.repo.IcobropagoRepo;
import pe.impulsa.SUNATParser.impulsadb.repo.IcomprasRepo;
import pe.impulsa.SUNATParser.impulsadb.repo.IinventarioRepo;
import pe.impulsa.SUNATParser.impulsadb.repo.IventasRepo;
import pe.impulsa.SUNATParser.pojo.Factura;

public class FacturaParse {
    private final IventasRepo iventasRepo;
    private final IcomprasRepo icomprasRepo;
    private final IinventarioRepo iinventarioRepo;
    private final IcobropagoRepo icobropagoRepo;
    private static Factura factura;

    public FacturaParse(IventasRepo iventasRepo, IcomprasRepo icomprasRepo, IinventarioRepo iinventarioRepo, IcobropagoRepo icobropagoRepo, Factura factura) {
        this.iventasRepo = iventasRepo;
        this.icomprasRepo = icomprasRepo;
        this.iinventarioRepo = iinventarioRepo;
        this.icobropagoRepo = icobropagoRepo;
        this.factura=factura;
    }
    private static void registrarVenta(){}
    private static void registrarCompra(){}
    private static void registrarCobroPago(){}
    private static void registrarInventario(){}

}
