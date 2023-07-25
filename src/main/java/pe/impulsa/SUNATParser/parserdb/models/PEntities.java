package pe.impulsa.SUNATParser.parserdb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="entities")
@NoArgsConstructor
@Getter
@Setter
@DynamicUpdate
public class PEntities {
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

    public PEntities(Integer entity_id, String nombre_razon, String tipo_documento, String numero_documento, String usuario_sol, String clave_sol) {
        this.entityId = entity_id;
        this.nombreRazon = nombre_razon;
        this.tipoDocumento = tipo_documento;
        this.numeroDocumento = numero_documento;
        this.usuarioSol = usuario_sol;
        this.claveSol = clave_sol;
    }


}
