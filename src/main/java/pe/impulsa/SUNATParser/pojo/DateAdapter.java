package pe.impulsa.SUNATParser.pojo;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class DateAdapter extends XmlAdapter<String, LocalDate> {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public LocalDate unmarshal(String v) throws Exception {
        return LocalDate.parse(v);
    }

    @Override
    public String marshal(LocalDate v) throws Exception {
        return dateFormat.format(v);
    }
}
