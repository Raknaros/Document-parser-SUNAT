package pe.impulsa.DriverSUNAT.impulsadb.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="tributo",schema="priv")
@NoArgsConstructor
@Getter
@Setter
@DynamicUpdate
public class ITributos {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    @Basic
    @Column(name="entity_id")
    private Integer entityId;
    @Basic
    @Column(name="fecha")
    private String fechaConsulta;
    @Basic
    @Column(name="observaciones")
    private String Observaciones;
    @Basic
    @Column(name="tributo")
    private String Tributo;
    @Basic
    @Column(name="afectodesde")
    private String afectoDesde;
    @Basic
    @Column(name="exoneracion")
    private String Exoneracion;
    @Basic
    @Column(name="desde")
    private String Desde;
    @Basic
    @Column(name="hasta")
    private String Hasta;
}
