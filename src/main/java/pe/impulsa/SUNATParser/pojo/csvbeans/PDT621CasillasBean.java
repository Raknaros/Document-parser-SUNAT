package pe.impulsa.SUNATParser.pojo.csvbeans;

import com.opencsv.bean.CsvBindByName;
import pe.impulsa.SUNATParser.pojo.CsvBean;

public class PDT621CasillasBean extends CsvBean {
    @CsvBindByName(column = "Nro Ruc")
    private Long ruc;

    @CsvBindByName(column = "Nro Orden")
    private Long orden;

    @CsvBindByName
    private String formulario;

    @CsvBindByName
    private Integer periodo;

    @CsvBindByName(column = "Fecha Presentacion")
    private Long fecha;

    @CsvBindByName(column = "Indicador Rectif")
    private String rectificatoria;

    @CsvBindByName(column = "Nro Casilla")
    private String casilla;

    @CsvBindByName(column = "Valor Casilla")
    private String valor;
}
