package pe.impulsa.DriverSUNAT.impulsadb.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="comprobantes_registrados",schema="priv")
@NoArgsConstructor
@Getter
@Setter
@DynamicUpdate
public class IRegistrados {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    @Basic
    @Column(name="entity_id")
    private Integer entityId;
    @Basic
    @Column(name="tipo_comprobante")
    private String tipoComprobante;
    @Basic
    @Column(name="cui")
    private String Cui;
    @Basic
    @Column(name="observaciones")
    private String Observaciones;
}
