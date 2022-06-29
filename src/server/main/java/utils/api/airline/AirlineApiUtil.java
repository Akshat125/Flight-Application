package utils.api.airline;

import java.util.ArrayList;

public class AirlineApiUtil {
    /**
     * This is the main-Class to handle the API-Calls for specific Airline information
     */

    private Request request;
    private ArrayList<Response> response;
    private String terms;

    public AirlineApiUtil(Request request, ArrayList<Response> response, String terms) {
        this.request = request;
        this.response = response;
        this.terms = terms;
    }

    public AirlineApiUtil() {
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public ArrayList<Response> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<Response> response) {
        this.response = response;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }
}

