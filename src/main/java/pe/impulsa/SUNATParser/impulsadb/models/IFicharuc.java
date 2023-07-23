package pe.impulsa.DriverSUNAT.impulsadb.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="ficharuc",schema="priv")
@NoArgsConstructor
@Getter
@Setter
@DynamicUpdate
public class IFicharuc {
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
    @Column(name="a_nombrerazon")
    private String anombreRazon;
    @Basic
    @Column(name="a_tipocontribuyente")
    private String atipoContribuyente;
    @Basic
    @Column(name="a_fechainscripcion")
    private String afechaInscripcion;
    @Basic
    @Column(name="a_fechainicioactividades")
    private String afechaInicioActividades;
    @Basic
    @Column(name="a_estadocontribuyente")
    private String aestadoContribuyente;
    @Basic
    @Column(name="a_dependenciasunat")
    private String adependenciaSunat;
    @Basic
    @Column(name="a_condiciondomiciliofiscal")
    private String acondicionDomicilioFiscal;
    @Basic
    @Column(name="a_emisorelectronico")
    private String aemisorElectronico;
    @Basic
    @Column(name="a_comprobanteselectronicos")
    private String acomprobantesElectronicos;
    @Basic
    @Column(name="b_nombrecomercial")
    private String bnombreComercial;
    @Basic
    @Column(name="b_tiporepresentacion")
    private String btipoRepresentacion;
    @Basic
    @Column(name="b_acteconprincipal")
    private String bactEconPrincipal;
    @Basic
    @Column(name="b_acteconsecundaria1")
    private String bactEconSecundaria1;
    @Basic
    @Column(name="b_acteconsecundaria2")
    private String bactEconSecundaria2;
    @Basic
    @Column(name="b_acteconprincipa_l")
    private String bactEconPrincipal2;
    @Basic
    @Column(name="b_acteconsecundaria_1")
    private String bactEconSecundaria3;
    @Basic
    @Column(name="b_acteconsecundaria_2")
    private String bactEconSecundaria4;
    @Basic
    @Column(name="b_sistemaemision")
    private String bsistemaEmision;
    @Basic
    @Column(name="b_sistemacontabilidad")
    private String bsistemaContabilidad;
    @Basic
    @Column(name="b_codigoprofesionoficio")
    private String bcodigoProfesionOficio;
    @Basic
    @Column(name="b_actividadcomercioexterior")
    private String bactividadComercioExterior;
    @Basic
    @Column(name="b_fax")
    private String bFax;
    @Basic
    @Column(name="b_fijo1")
    private String bFijo1;
    @Basic
    @Column(name="b_fijo2")
    private String bFijo2;
    @Basic
    @Column(name="b_movil1")
    private String bMovil1;
    @Basic
    @Column(name="b_movil2")
    private String bMovil2;
    @Basic
    @Column(name="b_correo1")
    private String bCorreo1;
    @Basic
    @Column(name="b_correo2")
    private String bCorreo2;
    @Basic
    @Column(name="c_actecon")
    private String cactEcon;
    @Basic
    @Column(name="c_departamento")
    private String cDepartamento;
    @Basic
    @Column(name="c_provincia")
    private String cProvincia;
    @Basic
    @Column(name="c_distrito")
    private String cDistrito;
    @Basic
    @Column(name="c_tiponombrezona")
    private String ctipoNombreZona;
    @Basic
    @Column(name="c_tiponombrevia")
    private String ctipoNombreVia;
    @Basic
    @Column(name="c_nro")
    private String cNro;
    @Basic
    @Column(name="c_km")
    private String cKm;
    @Basic
    @Column(name="c_mz")
    private String cMz;
    @Basic
    @Column(name="c_lote")
    private String cLote;
    @Basic
    @Column(name="c_dpto")
    private String cDpto;
    @Basic
    @Column(name="c_interior")
    private String cInterior;
    @Basic
    @Column(name="c_otrasreferencias")
    private String cotrasReferencias;
    @Basic
    @Column(name="c_condiciondomiciliofiscal")
    private String ccondicionDomicilioFiscal;
}
