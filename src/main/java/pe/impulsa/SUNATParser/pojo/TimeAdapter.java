package pe.impulsa.SUNATParser.pojo;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeAdapter extends XmlAdapter<String, LocalTime> {
    private final DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss.S'Z'");

    @Override
    public LocalTime unmarshal(String v) throws Exception {
        return LocalTime.parse(v, myFormatObj);
    }

    @Override
    public String marshal(LocalTime v) throws Exception {
        return myFormatObj.format(v);
    }
}
