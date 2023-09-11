package pe.impulsa.SUNATParser.impulsadb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "_10", schema = "acc")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Isunatpagos {
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
    @Column(name = "numero_formulario")
    private String numeroFormulario;
    @Basic
    @Column(name = "numero_orden")
    private Long numeroOrden;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "entidad_financiera")
    private Integer entidadFinanciera;
    @Basic
    @Column(name = "fecha_presentacion")
    private Date fechaPresentacion;
    @Basic
    @Column(name = "codigo_tributo")
    private Integer codigoTributo;
    @Basic
    @Column(name = "detalle")
    private String detalle;
    @Basic
    @Column(name = "importe")
    private BigDecimal importe;
}

