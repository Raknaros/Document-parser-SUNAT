package pe.impulsa.SUNATParser.parserdb.models;

import jakarta.persistence.*;
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
public class Pentities {
    @Id
    @Column(name = "ruc")
    private Long ruc;
    @Basic
    @Column(name="nombre_razon")
    private String nombreRazon;
    @Basic
    @Column(name="usuario_sol")
    private String usuarioSol;
    @Basic
    @Column(name="clave_sol")
    private String claveSol;
    @Basic
    @Column(name="observaciones")
    private String observaciones;

    public Pentities(Long ruc, String nombre_razon, String usuario_sol, String clave_sol) {
        this.ruc = ruc;
        this.nombreRazon = nombre_razon;
        this.usuarioSol = usuario_sol;
        this.claveSol = clave_sol;
    }


}
