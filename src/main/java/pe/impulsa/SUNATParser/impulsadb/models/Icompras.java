package pe.impulsa.SUNATParser.impulsadb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "_8", schema = "acc")
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Getter
@Setter
public class Icompras {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "ruc")
    private Long ruc;
    @Basic
    @Column(name = "subdiario")
    private Integer subdiario;
    @Basic
    @Column(name = "periodo_tributario")
    private Integer periodoTributario;
    @Basic
    @Column(name = "tipo_operacion")
    private Integer tipoOperacion;
    @Basic
    @Column(name = "tipo_comprobante")
    private Integer tipoComprobante;
    @Basic
    @Column(name = "fecha_emision")
    private Date fechaEmision;
    @Basic
    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;
    @Basic
    @Column(name = "numero_serie")
    private String numeroSerie;
    @Basic
    @Column(name = "numero_correlativo")
    private String numeroCorrelativo;
    @Basic
    @Column(name = "importe_final")
    private Integer importeFinal;
    @Basic
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic
    @Column(name = "numero_documento")
    private String numeroDocumento;
    @Basic
    @Column(name = "clasificacion_bienes_servicios")
    private Integer clasificacionBienesServicios;
    @Basic
    @Column(name = "destino")
    private Integer destino;
    @Basic
    @Column(name = "valor",precision = 10,scale = 2)
    private BigDecimal valor;
    @Basic
    @Column(name = "icbp",precision = 4,scale = 2)
    private BigDecimal icbp;
    @Basic
    @Column(name = "isc",precision = 8,scale = 2)
    private BigDecimal isc;
    @Basic
    @Column(name = "otros_cargos",precision = 8,scale = 2)
    private BigDecimal otrosCargos;
    @Basic
    @Column(name = "tipo_moneda")
    private String tipoMoneda;
    @Basic
    @Column(name = "tasa_detraccion")
    private Integer tasaDetraccion;
    @Basic
    @Column(name = "tasa_percepcion")
    private Integer tasaPercepcion;
    @Basic
    @Column(name = "medio_pago")
    private Integer medioPago;
    @Basic
    @Column(name = "tipo_comprobante_modificado")
    private Integer tipoComprobanteModificado;
    @Basic
    @Column(name = "numero_serie_modificado")
    private String numeroSerieModificado;
    @Basic
    @Column(name = "numero_correlativo_modificado")
    private String numeroCorrelativoModificado;
    @Basic
    @Column(name = "glosa")
    private String glosa;
    @Basic
    @Column(name = "cui")
    private String cui;
    @Basic
    @Column(name = "observaciones")
    private String observaciones;
    @Basic
    @Column(name = "igv",precision = 8,scale = 2)
    private BigDecimal igv;
    @Basic
    @Column(name = "cuenta_contable",length = 6)
    private String cuentaContable;
}
