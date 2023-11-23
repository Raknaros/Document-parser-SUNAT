package pe.impulsa.SUNATParser.warehouse.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import pe.impulsa.SUNATParser.pojo.FetchEntities;

import java.sql.Date;

@Entity
@Table(name="entities",schema="priv")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@DynamicUpdate
/*@NamedNativeQueries(value = {
        @NamedNativeQuery(
                name="EntidadesLista",
                query="SELECT nombre_razon, ruc, observaciones FROM acc.entities WHERE activo IS TRUE",
                resultSetMapping="ListaEntidadesMapping")
})
@SqlResultSetMappings(value={
        @SqlResultSetMapping(
                name = "ListaEntidadesMapping",
                classes = @ConstructorResult(
                        targetClass = FetchEntities.class,
                        columns = {
                                @ColumnResult(name = "ruc", type= Long.class),
                                @ColumnResult(name = "ruc"),
                                @ColumnResult(name = "observaciones")
                        }
                )
        )
})*/
public class Entities {
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)
            TABLE,
            generator = "table-generator")
    @TableGenerator(name = "table-generator",
            schema="acc",
            table = "entities",
            pkColumnName = "entity_id",
            valueColumnName = "seq_value")*/
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
    @Basic
    @Column(name="activo")
    private Boolean activo;
    @Basic
    @Column(name="alias")
    private String alias;
    @Basic
    @Column(name="related_user")
    private Long related_user;
    @Basic
    @Column(name="suscribed_until")
    private Date suscribedUntil;
    @Basic
    @Column(name="suscription")
    private Integer suscription;
}
