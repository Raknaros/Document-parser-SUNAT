package pe.impulsa.SUNATParser.impulsadb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "_6", schema = "acc")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Iinventario {
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
    @Column(name = "fecha")
    private Date fecha;
    @Basic
    @Column(name = "clasificacion_bienes_servicios")
    private Integer clasificacionBienesServicios;
    @Basic
    @Column(name = "codigo_item")
    private String codigoItem;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "unidad_medida")
    private String unidadMedida;
    @Basic
    @Column(name = "cantidad")
    private Integer cantidad;
    @Basic
    @Column(name = "precio_unitario")
    private BigDecimal precioUnitario;
    @Basic
    @Column(name = "tipo_documento_referencia")
    private Integer tipoDocumentoReferencia;
    @Basic
    @Column(name = "numero_documento_referencia")
    private String numeroDocumentoReferencia;
    @Basic
    @Column(name = "observaciones")
    private String observaciones;
    @Basic
    @Column(name = "cuenta_contable",length = 6)
    private String cuentaContable;
    @Basic
    @Column(name = "cui_relacionado")
    private String cuiRelacionado;
    @Basic
    @Column(name="tipo_operacion")
    private Integer tipoOperacion;
}