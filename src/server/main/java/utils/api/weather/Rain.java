package utils.api.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
    /**
     * This is a helper-Class to handle the API-Calls for specific Weather: main: WeatherApiUtil
     */

    @JsonProperty("3h")
    private double _3h;

    public Rain(double _3h) {
        this._3h = _3h;
    }

    public Rain() {
    }

    public double get_3h() {
        return _3h;
    }

    public void set_3h(double _3h) {
        this._3h = _3h;
    }
}
