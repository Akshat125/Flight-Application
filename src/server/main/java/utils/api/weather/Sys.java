package utils.api.weather;

public class Sys {
    /**
     * This is a helper-Class to handle the API-Calls for specific Weather: main: WeatherApiUtil
     */

    private String pod;

    public Sys(String pod) {
        this.pod = pod;
    }

    public Sys() {
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }
}
