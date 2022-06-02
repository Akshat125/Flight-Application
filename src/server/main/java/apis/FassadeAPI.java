package apis;

public class FassadeAPI {

    // switch between mockup and release version
    private static final boolean USE_MOCKUP = true;

    private LufthansaAPI lufthansaAPI;
    private GoogleMapsAPI googleMapsAPI;
    private WeatherAPI weatherAPI;

    public FassadeAPI(){
        if(USE_MOCKUP){
            this.lufthansaAPI = new LufthansaAPIMockUp();
            this.googleMapsAPI = new GoogleMapsAPIMockUp();
            this.weatherAPI = new WeatherAPIMockUp();
        }else{
            this.lufthansaAPI = new LufthansaAPIRelease();
            this.googleMapsAPI = new GoogleMapsAPIRelease();
            this.weatherAPI = new WeatherAPIRelease();
        }
    }
}
