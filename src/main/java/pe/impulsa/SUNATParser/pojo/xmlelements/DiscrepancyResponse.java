package pe.impulsa.SUNATParser.pojo.xmlelements;

import lombok.Getter;

@Getter
public class DiscrepancyResponse {
    private String referenceid;
    private String responsecode;
    private String description;

    public void setReferenceid(String referenceid) {
        this.referenceid = referenceid;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
