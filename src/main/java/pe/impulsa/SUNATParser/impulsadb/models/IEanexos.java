package pe.impulsa.DriverSUNAT.impulsadb.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="eanexos",schema="acc")
@NoArgsConstructor
@Getter
@Setter
@DynamicUpdate
public class IEanexos {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    @Basic
    @Column(name="entity_id")
    private Integer entityId;
    @Basic
    @Column(name="fecha_consulta") //noombre cambiado, verificar
    private String fechaConsulta;
    @Basic
    @Column(name="observaciones")
    private String Observaciones;
    @Basic
    @Column(name="codigo")
    private Integer Codigo;
    @Basic
    @Column(name="tipo")
    private String Tipo;
    @Basic
    @Column(name="denomicacion")
    private String Denominacion;
    @Basic
    @Column(name="ubigeo")
    private String Ubigeo;
    @Basic
    @Column(name="domicilio")
    private String Domicilio;
    @Basic
    @Column(name="otras_referencias") //nombre cambiado verificar
    private String otrasReferencias;
    @Basic
    @Column(name="cond_legal")
    private String condLegal;
}
