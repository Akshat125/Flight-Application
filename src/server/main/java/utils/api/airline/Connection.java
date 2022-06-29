package utils.api.airline;

public class Connection {
    /**
     * This is a helper-Class to handle the API-Calls for specific Airline information: main: AirlineApiUtil
     */

    private String type;
    private int isp_code;
    private String isp_name;

    public Connection(String type, int isp_code, String isp_name) {
        this.type = type;
        this.isp_code = isp_code;
        this.isp_name = isp_name;
    }

    public Connection() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIsp_code() {
        return isp_code;
    }

    public void setIsp_code(int isp_code) {
        this.isp_code = isp_code;
    }

    public String getIsp_name() {
        return isp_name;
    }

    public void setIsp_name(String isp_name) {
        this.isp_name = isp_name;
    }
}
