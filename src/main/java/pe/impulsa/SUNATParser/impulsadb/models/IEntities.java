package pe.impulsa.SUNATParser.impulsadb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="entities",schema="acc")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicUpdate
public class IEntities {
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)
            TABLE,
            generator = "table-generator")
    @TableGenerator(name = "table-generator",
            schema="acc",
            table = "entities",
            pkColumnName = "entity_id",
            valueColumnName = "seq_value")*/
    @Id
    @Column(name = "entity_id")
    private Integer entityId;
    @Basic
    @Column(name="nombre_razon")
    private String nombreRazon;
    @Basic
    @Column(name="tipo_documento")
    private String tipoDocumento;
    @Basic
    @Column(name="numero_documento")
    private String numeroDocumento;
    @Basic
    @Column(name="usuario_sol")
    private String usuarioSol;
    @Basic
    @Column(name="clave_sol")
    private String claveSol;
    @Basic
    @Column(name="observaciones")
    private String observaciones;
    @Basic
    @Column(name="activo")
    private Boolean activo;

}
