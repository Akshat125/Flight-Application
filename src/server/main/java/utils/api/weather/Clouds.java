package utils.api.weather;

public class Clouds {
    /**
     * This is a helper-Class to handle the API-Calls for specific Weather: main: WeatherApiUtil
     */

    private int all;

    public Clouds(int all) {
        this.all = all;
    }

    public Clouds() {
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}
