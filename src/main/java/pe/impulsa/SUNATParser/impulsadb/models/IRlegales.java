package pe.impulsa.DriverSUNAT.impulsadb.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="rlegales",schema="priv")
@NoArgsConstructor
@Getter
@Setter
@DynamicUpdate
public class IRlegales {
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
    @Column(name="tiponrodocumento")
    String tipoNroDocumento;
    @Basic
    @Column(name="apellidosnombres")
    private String apellidosNombres;
    @Basic
    @Column(name="cargo")
    private String Cargo;
    @Basic
    @Column(name="fechanacimiento")
    private String fechaNacimiento;
    @Basic
    @Column(name="fechadesde")
    private String fechaDesde;
    @Basic
    @Column(name="nroordenrepresentacion")
    private String nroOrdenRepresentacion;
    @Basic
    @Column(name="direccion")
    private String Direccion;
    @Basic
    @Column(name="ubigeo")
    private String Ubigeo;
    @Basic
    @Column(name="telefono")
    private String Telefono;
    @Basic
    @Column(name="correo")
    private String Correo;
}
