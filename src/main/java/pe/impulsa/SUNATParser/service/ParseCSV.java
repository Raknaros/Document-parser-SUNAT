package pe.impulsa.SUNATParser.service;

import jakarta.xml.bind.JAXBException;
import org.springframework.stereotype.Service;
import pe.impulsa.SUNATParser.pojo.LogCUI;
import pe.impulsa.SUNATParser.warehouse.repo.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

@Service
public class ParseCSV extends ExtractCSV{
    private final DataMethods dataMethods;
    private static DateTimeFormatter anomesdia = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static DateTimeFormatter anomes = DateTimeFormatter.ofPattern("yyyyMM");
    private final Pdt0621Repo pdt0621Repo;

    public ParseCSV(DataMethods dataMethods, Pdt0621Repo pdt0621Repo) {
        this.dataMethods = dataMethods;
        this.pdt0621Repo = pdt0621Repo;
    }
    public void parse(String ruta) throws JAXBException {
        List<LogCUI> lista = dataMethods.verifyxml();
        List<Long> entidades = dataMethods.fetchEntities();
        for (Map.Entry<String, String> entry : listaCsv(ruta).entrySet())

    }
}
