package pe.impulsa.SUNATParser.pojo.xmlelements.accountingparty.party.partylegalentity;

import jakarta.xml.bind.annotation.XmlElement;
import pe.impulsa.SUNATParser.pojo.xmlelements.AtrSet2;
import pe.impulsa.SUNATParser.pojo.xmlelements.accountingparty.party.partylegalentity.registrationaddress.AddressLine;
import pe.impulsa.SUNATParser.pojo.xmlelements.accountingparty.party.partylegalentity.registrationaddress.Country;

public class RegistrationAddress {
    private AtrSet2 addressTypeCode;
    private String buildingnumber;
    private String citysubdivisionname;
    private String cityname;
    private String countrysubentity;
    private String contrysubentitycode;
    private String district;
    private AddressLine addressLine;
    private Country country;

    public AtrSet2 getAddressTypeCode() {
        return addressTypeCode;
    }
    @XmlElement(name="AddressTypeCode",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setAddressTypeCode(AtrSet2 addressTypeCode) {
        this.addressTypeCode = addressTypeCode;
    }

    public String getBuildingnumber() {
        return buildingnumber;
    }
    @XmlElement(name="BuildingNumber",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setBuildingnumber(String buildingnumber) {
        this.buildingnumber = buildingnumber;
    }

    public String getCitysubdivisionname() {
        return citysubdivisionname;
    }
    @XmlElement(name="CitySubdivisionName",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setCitysubdivisionname(String citysubdivisionname) {
        this.citysubdivisionname = citysubdivisionname;
    }

    public String getCityname() {
        return cityname;
    }
    @XmlElement(name="CityName",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCountrysubentity() {
        return countrysubentity;
    }
    @XmlElement(name="CountrySubentity",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setCountrysubentity(String countrysubentity) {
        this.countrysubentity = countrysubentity;
    }

    public String getContrysubentitycode() {
        return contrysubentitycode;
    }
    @XmlElement(name="CountrySubentityCode",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setContrysubentitycode(String contrysubentitycode) {
        this.contrysubentitycode = contrysubentitycode;
    }

    public String getDistrict() {
        return district;
    }
    @XmlElement(name="District",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    public void setDistrict(String district) {
        this.district = district;
    }

    public AddressLine getAddressLine() {
        return addressLine;
    }
    @XmlElement(name="AddressLine",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setAddressLine(AddressLine addressLine) {
        this.addressLine = addressLine;
    }

    public Country getCountry() {
        return country;
    }
    @XmlElement(name="Country",namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
    public void setCountry(Country country) {
        this.country = country;
    }
}
