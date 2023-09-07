package pe.impulsa.SUNATParser.impulsadb.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "_7", schema = "acc")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ICobropago {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "cui_relacionado")
    private String cuiRelacionado;
    @Basic
    @Column(name = "fecha_cuota1")
    private Date fechaCuota1;
    @Basic
    @Column(name = "importe_cuota1")
    private BigDecimal importeCuota1;
    @Basic
    @Column(name = "fecha_cuota2")
    private Date fechaCuota2;
    @Basic
    @Column(name = "importe_cuota2")
    private BigDecimal importeCuota2;
    @Basic
    @Column(name = "fecha_cuota3")
    private Date fechaCuota3;
    @Basic
    @Column(name = "importe_cuota3")
    private BigDecimal importeCuota3;
    @Basic
    @Column(name = "fecha_cuota4")
    private Date fechaCuota4;
    @Basic
    @Column(name = "importe_cuota4")
    private BigDecimal importeCuota4;
    @Basic
    @Column(name = "fecha_cuota5")
    private Date fechaCuota5;
    @Basic
    @Column(name = "importe_cuota5")
    private BigDecimal importeCuota5;
    @Basic
    @Column(name = "fecha_cuota6")
    private Date fechaCuota6;
    @Basic
    @Column(name = "importe_cuota6")
    private BigDecimal importeCuota6;
    @Basic
    @Column(name = "fecha_cuota7")
    private Date fechaCuota7;
    @Basic
    @Column(name = "importe_cuota7")
    private BigDecimal importeCuota7;
    @Basic
    @Column(name = "fecha_cuota8")
    private Date fechaCuota8;
    @Basic
    @Column(name = "importe_cuota8")
    private BigDecimal importeCuota8;
    @Basic
    @Column(name = "fecha_cuota9")
    private Date fechaCuota9;
    @Basic
    @Column(name = "importe_cuota9")
    private BigDecimal importeCuota9;
    @Basic
    @Column(name = "fecha_cuota10")
    private Date fechaCuota10;
    @Basic
    @Column(name = "importe_cuota10")
    private BigDecimal importeCuota10;
    @Basic
    @Column(name = "fecha_cuota11")
    private Date fechaCuota11;
    @Basic
    @Column(name = "importe_cuota11")
    private BigDecimal importeCuota11;
    @Basic
    @Column(name = "fecha_cuota12")
    private Date fechaCuota12;
    @Basic
    @Column(name = "importe_cuota12")
    private BigDecimal importeCuota12;
    @Basic
    @Column(name = "fecha_cuota13")
    private Date fechaCuota13;
    @Basic
    @Column(name = "importe_cuota13")
    private BigDecimal importeCuota13;
    @Basic
    @Column(name = "fecha_cuota14")
    private Date fechaCuota14;
    @Basic
    @Column(name = "importe_cuota14")
    private BigDecimal importeCuota14;
    @Basic
    @Column(name = "fecha_cuota15")
    private Date fechaCuota15;
    @Basic
    @Column(name = "importe_cuota15")
    private BigDecimal importeCuota15;
    @Basic
    @Column(name = "fecha_cuota16")
    private Date fechaCuota16;
    @Basic
    @Column(name = "importe_cuota16")
    private BigDecimal importeCuota16;
    @Basic
    @Column(name = "fecha_cuota17")
    private Date fechaCuota17;
    @Basic
    @Column(name = "importe_cuota17")
    private BigDecimal importeCuota17;
    @Basic
    @Column(name = "fecha_cuota18")
    private Date fechaCuota18;
    @Basic
    @Column(name = "importe_cuota18")
    private BigDecimal importeCuota18;
    @Basic
    @Column(name = "fecha_cuota19")
    private Date fechaCuota19;
    @Basic
    @Column(name = "importe_cuota19")
    private BigDecimal importeCuota19;
    @Basic
    @Column(name = "fecha_cuota20")
    private Date fechaCuota20;
    @Basic
    @Column(name = "importe_cuota20")
    private BigDecimal importeCuota20;
    @Basic
    @Column(name = "fecha_cuota21")
    private Date fechaCuota21;
    @Basic
    @Column(name = "importe_cuota21")
    private BigDecimal importeCuota21;
    @Basic
    @Column(name = "fecha_cuota22")
    private Date fechaCuota22;
    @Basic
    @Column(name = "importe_cuota22")
    private BigDecimal importeCuota22;
    @Basic
    @Column(name = "fecha_cuota23")
    private Date fechaCuota23;
    @Basic
    @Column(name = "importe_cuota23")
    private BigDecimal importeCuota23;
    @Basic
    @Column(name = "fecha_cuota24")
    private Date fechaCuota24;
    @Basic
    @Column(name = "importe_cuota24")
    private BigDecimal importeCuota24;
    @Basic
    @Column(name = "fecha_cuota25")
    private Date fechaCuota25;
    @Basic
    @Column(name = "importe_cuota25")
    private BigDecimal importeCuota25;
    @Basic
    @Column(name = "fecha_cuota26")
    private Date fechaCuota26;
    @Basic
    @Column(name = "importe_cuota26")
    private BigDecimal importeCuota26;
    @Basic
    @Column(name = "fecha_cuota27")
    private Date fechaCuota27;
    @Basic
    @Column(name = "importe_cuota27")
    private BigDecimal importeCuota27;
    @Basic
    @Column(name = "fecha_cuota28")
    private Date fechaCuota28;
    @Basic
    @Column(name = "importe_cuota28")
    private BigDecimal importeCuota28;
    @Basic
    @Column(name = "fecha_cuota29")
    private Date fechaCuota29;
    @Basic
    @Column(name = "importe_cuota29")
    private BigDecimal importeCuota29;
    @Basic
    @Column(name = "fecha_cuota30")
    private Date fechaCuota30;
    @Basic
    @Column(name = "importe_cuota30")
    private BigDecimal importeCuota30;
    @Basic
    @Column(name = "fecha_cuota31")
    private Date fechaCuota31;
    @Basic
    @Column(name = "importe_cuota31")
    private BigDecimal importeCuota31;
    @Basic
    @Column(name = "fecha_cuota32")
    private Date fechaCuota32;
    @Basic
    @Column(name = "importe_cuota32")
    private BigDecimal importeCuota32;
    @Basic
    @Column(name = "fecha_cuota33")
    private Date fechaCuota33;
    @Basic
    @Column(name = "importe_cuota33")
    private BigDecimal importeCuota33;
    @Basic
    @Column(name = "fecha_cuota34")
    private Date fechaCuota34;
    @Basic
    @Column(name = "importe_cuota34")
    private BigDecimal importeCuota34;
    @Basic
    @Column(name = "fecha_cuota35")
    private Date fechaCuota35;
    @Basic
    @Column(name = "importe_cuota35")
    private BigDecimal importeCuota35;
    @Basic
    @Column(name = "fecha_cuota36")
    private Date fechaCuota36;
    @Basic
    @Column(name = "importe_cuota36")
    private BigDecimal importeCuota36;
    @Basic
    @Column(name = "fecha_cuota37")
    private Date fechaCuota37;
    @Basic
    @Column(name = "importe_cuota37")
    private BigDecimal importeCuota37;
    @Basic
    @Column(name = "fecha_cuota38")
    private Date fechaCuota38;
    @Basic
    @Column(name = "importe_cuota38")
    private BigDecimal importeCuota38;
    @Basic
    @Column(name = "fecha_cuota39")
    private Date fechaCuota39;
    @Basic
    @Column(name = "importe_cuota39")
    private BigDecimal importeCuota39;
    @Basic
    @Column(name = "fecha_cuota40")
    private Date fechaCuota40;
    @Basic
    @Column(name = "importe_cuota40")
    private BigDecimal importeCuota40;
    @Basic
    @Column(name = "fecha_cuota41")
    private Date fechaCuota41;
    @Basic
    @Column(name = "importe_cuota41")
    private BigDecimal importeCuota41;
    @Basic
    @Column(name = "fecha_cuota42")
    private Date fechaCuota42;
    @Basic
    @Column(name = "importe_cuota42")
    private BigDecimal importeCuota42;
    @Basic
    @Column(name = "fecha_cuota43")
    private Date fechaCuota43;
    @Basic
    @Column(name = "importe_cuota43")
    private BigDecimal importeCuota43;
    @Basic
    @Column(name = "fecha_cuota44")
    private Date fechaCuota44;
    @Basic
    @Column(name = "importe_cuota44")
    private BigDecimal importeCuota44;
    @Basic
    @Column(name = "fecha_cuota45")
    private Date fechaCuota45;
    @Basic
    @Column(name = "importe_cuota45")
    private BigDecimal importeCuota45;
    @Basic
    @Column(name = "fecha_cuota46")
    private Date fechaCuota46;
    @Basic
    @Column(name = "importe_cuota46")
    private BigDecimal importeCuota46;
    @Basic
    @Column(name = "fecha_cuota47")
    private Date fechaCuota47;
    @Basic
    @Column(name = "importe_cuota47")
    private BigDecimal importeCuota47;
    @Basic
    @Column(name = "fecha_cuota48")
    private Date fechaCuota48;
    @Basic
    @Column(name = "importe_cuota48")
    private BigDecimal importeCuota48;
    @Basic
    @Column(name = "fecha_cuota49")
    private Date fechaCuota49;
    @Basic
    @Column(name = "importe_cuota49")
    private BigDecimal importeCuota49;
    @Basic
    @Column(name = "fecha_cuota50")
    private Date fechaCuota50;
    @Basic
    @Column(name = "importe_cuota50")
    private BigDecimal importeCuota50;
    @Basic
    @Column(name = "fecha_cuota51")
    private Date fechaCuota51;
    @Basic
    @Column(name = "importe_cuota51")
    private BigDecimal importeCuota51;
    @Basic
    @Column(name = "fecha_cuota52")
    private Date fechaCuota52;
    @Basic
    @Column(name = "importe_cuota52")
    private BigDecimal importeCuota52;
    @Basic
    @Column(name = "fecha_cuota53")
    private Date fechaCuota53;
    @Basic
    @Column(name = "importe_cuota53")
    private BigDecimal importeCuota53;
    @Basic
    @Column(name = "fecha_cuota54")
    private Date fechaCuota54;
    @Basic
    @Column(name = "importe_cuota54")
    private BigDecimal importeCuota54;
    @Basic
    @Column(name = "fecha_cuota55")
    private Date fechaCuota55;
    @Basic
    @Column(name = "importe_cuota55")
    private BigDecimal importeCuota55;
    @Basic
    @Column(name = "fecha_cuota56")
    private Date fechaCuota56;
    @Basic
    @Column(name = "importe_cuota56")
    private BigDecimal importeCuota56;
    @Basic
    @Column(name = "fecha_cuota57")
    private Date fechaCuota57;
    @Basic
    @Column(name = "importe_cuota57")
    private BigDecimal importeCuota57;
    @Basic
    @Column(name = "fecha_cuota58")
    private Date fechaCuota58;
    @Basic
    @Column(name = "importe_cuota58")
    private BigDecimal importeCuota58;
    @Basic
    @Column(name = "fecha_cuota59")
    private Date fechaCuota59;
    @Basic
    @Column(name = "importe_cuota59")
    private BigDecimal importeCuota59;
    @Basic
    @Column(name = "fecha_cuota60")
    private Date fechaCuota60;
    @Basic
    @Column(name = "importe_cuota60")
    private BigDecimal importeCuota60;
}

