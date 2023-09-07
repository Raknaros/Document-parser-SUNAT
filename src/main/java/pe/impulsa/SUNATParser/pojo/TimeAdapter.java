package pe.impulsa.SUNATParser.pojo;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeAdapter extends XmlAdapter<String, Date> {
    private final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    @Override
    public Date unmarshal(String v) throws Exception {
        return timeFormat.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return timeFormat.format(v);
    }
}
