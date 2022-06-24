package utils.api.airlinename;

public class Geo {

    private String country_code;
    private String country;
    private String continent;
    private String city;
    private double lat;
    private double lng;
    private String timezone;

    public Geo(String country_code, String country, String continent, String city, double lat, double lng, String timezone) {
        this.country_code = country_code;
        this.country = country;
        this.continent = continent;
        this.city = city;
        this.lat = lat;
        this.lng = lng;
        this.timezone = timezone;
    }

    public Geo() {
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
