package pe.impulsa.DriverSUNAT.impulsadb.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="pjuridica",schema="priv")
@NoArgsConstructor
@Getter
@Setter
@DynamicUpdate
public class IPjuridica {
    @Id
    @Column(name="entity_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long entityId;
    @Basic
    @Column(name="fecha")
    private String fechaConsulta;
    @Basic
    @Column(name="observaciones")
    private String Observaciones;
    @Basic
    @Column(name="fechainscripcionrrpp")
    private String fechaInscripcion;
    @Basic
    @Column(name="numeropartidaregistral")
    private String numeroPartidaRegistral;
    @Basic
    @Column(name="tomoficha")
    private String tomoFicha;
    @Basic
    @Column(name="folio")
    private String Folio;
    @Basic
    @Column(name="asiento")
    private String Asiento;
    @Basic
    @Column(name="origencapital")
    private String origenCapital;
    @Basic
    @Column(name="paisorigencapital")
    private String paisOrigenCapital;
}
