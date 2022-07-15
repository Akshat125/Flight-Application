package controller.weather;

public class WeatherResponse {

    private double temp;
    private double tempFeelsLike;
    private int humidity;
    private double windSpeed;
    private int windDirection;
    private int dateInUTC;
    private String description;
    private String icon;
    private double pop;

    /**
     * This is a helper Class (the response Class for an Weather request)
     */
    public WeatherResponse(int dateInUTC, double temp, double tempFeelsLike, int humidity, double windSpeed, int windDirection, String description, String icon, double pop) {
        this.temp = temp;
        this.tempFeelsLike = tempFeelsLike;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.dateInUTC = dateInUTC;
        this.description = description;
        this.icon = icon;
        this.pop = pop;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getTempFeelsLike() {
        return tempFeelsLike;
    }

    public void setTempFeelsLike(double tempFeelsLike) {
        this.tempFeelsLike = tempFeelsLike;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(int windDirection) {
        this.windDirection = windDirection;
    }

    public int getDateInUTC() {
        return dateInUTC;
    }

    public void setDateInUTC(int dateInUTC) {
        this.dateInUTC = dateInUTC;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public double getPop() {
        return pop;
    }

    public void setPop(double pop) {
        this.pop = pop;
    }
}
