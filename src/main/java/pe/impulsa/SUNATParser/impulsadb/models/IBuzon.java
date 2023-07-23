package pe.impulsa.DriverSUNAT.impulsadb.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Entity
@Table(name="buzon_electronico",schema="acc")
@NoArgsConstructor
@Getter
@Setter
@DynamicUpdate
public class IBuzon {
    @Id
    @Column(name="id")
    private Long Id;
    @Basic
    @Column(name="entity_id")
    private Integer entityId;
    @Basic
    @Column(name="asunto")
    private String Asunto;
    @Basic
    @Column(name="fecha_recepcion")
    private Date fechaRecepcion;
    @Basic
    @Column(name="leido")
    private Boolean Leido;
    @Basic
    @Column(name="fecha_revision")
    private Date fechaRevision;
    @Basic
    @Column(name="observaciones")
    private String Observaciones;
}
