package pe.impulsa.SUNATParser.pojo;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class LogCUI {
    private Long ruc;
    private Integer periodoTributario;
    private String log;
}
