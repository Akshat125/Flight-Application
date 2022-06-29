package utils.api.airline;

import java.util.Date;

public class Key {
    /**
     * This is a helper-Class to handle the API-Calls for specific Airline information: main: AirlineApiUtil
     */

    private int id;
    private String api_key;
    private String type;
    private Object expired;
    private Date registered;
    private int limits_by_hour;
    private int limits_by_minute;
    private int limits_by_month;
    private int limits_total;

    public Key(int id, String api_key, String type, Object expired, Date registered, int limits_by_hour, int limits_by_minute, int limits_by_month, int limits_total) {
        this.id = id;
        this.api_key = api_key;
        this.type = type;
        this.expired = expired;
        this.registered = registered;
        this.limits_by_hour = limits_by_hour;
        this.limits_by_minute = limits_by_minute;
        this.limits_by_month = limits_by_month;
        this.limits_total = limits_total;
    }

    public Key() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getExpired() {
        return expired;
    }

    public void setExpired(Object expired) {
        this.expired = expired;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public int getLimits_by_hour() {
        return limits_by_hour;
    }

    public void setLimits_by_hour(int limits_by_hour) {
        this.limits_by_hour = limits_by_hour;
    }

    public int getLimits_by_minute() {
        return limits_by_minute;
    }

    public void setLimits_by_minute(int limits_by_minute) {
        this.limits_by_minute = limits_by_minute;
    }

    public int getLimits_by_month() {
        return limits_by_month;
    }

    public void setLimits_by_month(int limits_by_month) {
        this.limits_by_month = limits_by_month;
    }

    public int getLimits_total() {
        return limits_total;
    }

    public void setLimits_total(int limits_total) {
        this.limits_total = limits_total;
    }
}
