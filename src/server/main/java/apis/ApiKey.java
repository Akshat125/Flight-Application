package apis;

/**
 * Enum to hold the different Api-keys
 * Note: in order to use the APIs, set "USE_MOCKUP = false" inside "..server.main.java.apis.FassadeApi.java"
  */

enum ApiKey {

    /**
     * Find your WEATHER_KEY here: https://openweathermap.org
     */
    WEATHER_KEY("--insert API-KEY here--"),

    /**
     * Find your MAP_KEY here: https://developer.mapquest.com
     */
    MAP_KEY("--insert API-KEY here--"),

    /**
     * Find your AIRLABS_KEY here: https://aviationstack.com
     */
    AIRLABS_KEY("--insert API-KEY here--"),


    /**
     * Find your POI_KEY here: https://opentripmap.io
     */
    POI_KEY("--insert API-KEY here--");

    private final String KEY;

    ApiKey(final String key){
        KEY = key;
    }

    public String getKEY() {
        return KEY;
    }
}