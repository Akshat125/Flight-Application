package apis;

public class FassadeAPI {

    // switch between mockup and release version
    private static final boolean USE_MOCKUP = true;

    private AirlinesAPI lufthansaAPI;
    private GoogleMapsAPI googleMapsAPI;
    private WeathersAPI weatherAPI;

    public FassadeAPI(){
        if(USE_MOCKUP){
            this.lufthansaAPI = new AirlinesAPIMockUp();
            this.googleMapsAPI = new GoogleMapsAPIMockUp();
            this.weatherAPI = new WeatherAPIMockUp();
        }else{
            this.lufthansaAPI = new AirlinesAPIRelease();
            this.googleMapsAPI = new GoogleMapsAPIRelease();
            this.weatherAPI = new WeatherAPIRelease();
        }
    }
}
