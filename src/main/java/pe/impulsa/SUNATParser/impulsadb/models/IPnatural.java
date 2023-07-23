package pe.impulsa.DriverSUNAT.impulsadb.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="pnatural",schema="priv")
@NoArgsConstructor
@Getter
@Setter
@DynamicUpdate
public class IPnatural {
    @Id
    @Column(name="entity_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long entity_id;
    @Basic
    @Column(name="fecha")
    private String fechaConsulta;
    @Basic
    @Column(name="observaciones")
    private String Observaciones;
    @Basic
    @Column(name="documentoidentidad")
    private String documentoIdentidad;
    @Basic
    @Column(name="condiciondomiciliado")
    private String condicionDomiciliado;
    @Basic
    @Column(name="fechanacimientosucesion")
    private String fechaNacimientoSucesion;
    @Basic
    @Column(name="sexo")
    private String Sexo;
    @Basic
    @Column(name="nacionalidad")
    private String Nacionalidad;
    @Basic
    @Column(name="paisprocedencia")
    private String paisProcedencia;
}
