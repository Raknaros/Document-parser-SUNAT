package pe.impulsa.SUNATParser.warehouse.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Date;

@Entity
@Table(name = "_9", schema = "acc")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamicInsert
public class Pdt0621 {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "ruc")
    private Long ruc;
    @Basic
    @Column(name = "subdiario")
    private Integer subdiario;
    @Basic
    @Column(name = "periodo_tributario")
    private Integer periodoTributario;
    @Basic
    @Column(name = "numero_orden")
    private Long numeroOrden;
    @Basic
    @Column(name = "fecha_presentacion")
    private Date fechaPresentacion;
    @Basic
    @Column(name = "_100")
    private Integer c100;
    @Basic
    @Column(name = "_101")
    private Integer c101;
    @Basic
    @Column(name = "_102")
    private Integer c102;
    @Basic
    @Column(name = "_103")
    private Integer c103;
    @Basic
    @Column(name = "_160")
    private Integer c160;
    @Basic
    @Column(name = "_161")
    private Integer c161;
    @Basic
    @Column(name = "_162")
    private Integer c162;
    @Basic
    @Column(name = "_163")
    private Integer c163;
    @Basic
    @Column(name = "_106")
    private Integer c106;
    @Basic
    @Column(name = "_127")
    private Integer c127;
    @Basic
    @Column(name = "_105")
    private Integer c105;
    @Basic
    @Column(name = "_109")
    private Integer c109;
    @Basic
    @Column(name = "_112")
    private Integer c112;
    @Basic
    @Column(name = "_107")
    private Integer c107;
    @Basic
    @Column(name = "_108")
    private Integer c108;
    @Basic
    @Column(name = "_110")
    private Integer c110;
    @Basic
    @Column(name = "_111")
    private Integer c111;
    @Basic
    @Column(name = "_113")
    private Integer c113;
    @Basic
    @Column(name = "_114")
    private Integer c114;
    @Basic
    @Column(name = "_115")
    private Integer c115;
    @Basic
    @Column(name = "_116")
    private Integer c116;
    @Basic
    @Column(name = "_117")
    private Integer c117;
    @Basic
    @Column(name = "_119")
    private Integer c119;
    @Basic
    @Column(name = "_120")
    private Integer c120;
    @Basic
    @Column(name = "_122")
    private Integer c122;
    @Basic
    @Column(name = "_172")
    private Integer c172;
    @Basic
    @Column(name = "_169")
    private Integer c169;
    @Basic
    @Column(name = "_173")
    private Float c173;
    @Basic
    @Column(name = "_340")
    private Integer c340;
    @Basic
    @Column(name = "_341")
    private Integer c341;
    @Basic
    @Column(name = "_182")
    private Integer c182;
    @Basic
    @Column(name = "_301")
    private Integer c301;
    @Basic
    @Column(name = "_312")
    private Integer c312;
    @Basic
    @Column(name = "_380")
    private Float c380;
    @Basic
    @Column(name = "_315")
    private Float c315;
    @Basic
    @Column(name = "_140")
    private Integer c140;
    @Basic
    @Column(name = "_145")
    private Integer c145;
    @Basic
    @Column(name = "_184")
    private Integer c184;
    @Basic
    @Column(name = "_171")
    private Integer c171;
    @Basic
    @Column(name = "_168")
    private Integer c168;
    @Basic
    @Column(name = "_164")
    private Integer c164;
    @Basic
    @Column(name = "_179")
    private Integer c179;
    @Basic
    @Column(name = "_176")
    private Integer c176;
    @Basic
    @Column(name = "_165")
    private Integer c165;
    @Basic
    @Column(name = "_681")
    private Integer c681;
    @Basic
    @Column(name = "_185")
    private Integer c185;
    @Basic
    @Column(name = "_187")
    private Integer c187;
    @Basic
    @Column(name = "_188")
    private Integer c188;
    @Basic
    @Column(name = "_353")
    private Integer c353;
    @Basic
    @Column(name = "_351")
    private Integer c351;
    @Basic
    @Column(name = "_352")
    private Integer c352;
    @Basic
    @Column(name = "_347")
    private Integer c347;
    @Basic
    @Column(name = "_683")
    private Integer c683;
    @Basic
    @Column(name = "_342")
    private Integer c342;
    @Basic
    @Column(name = "_343")
    private Integer c343;
    @Basic
    @Column(name = "_344")
    private Integer c344;
    @Basic
    @Column(name = "_302")
    private Integer c302;
    @Basic
    @Column(name = "_303")
    private Integer c303;
    @Basic
    @Column(name = "_304")
    private Integer c304;
    @Basic
    @Column(name = "_326")
    private Integer c326;
    @Basic
    @Column(name = "_327")
    private Integer c327;
    @Basic
    @Column(name = "_305")
    private Integer c305;
    @Basic
    @Column(name = "_328")
    private Integer c328;
    @Basic
    @Column(name = "_682")
    private Integer c682;
    @Basic
    @Column(name = "_317")
    private Integer c317;
    @Basic
    @Column(name = "_319")
    private Integer c319;
    @Basic
    @Column(name = "_324")
    private Integer c324;
}

