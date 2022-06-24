package utils.api.airlinename;

import java.util.ArrayList;

public class AirlineNameApiUtil {

    private Request request;
    private ArrayList<Response> response;
    private String terms;

    public AirlineNameApiUtil(Request request, ArrayList<Response> response, String terms) {
        this.request = request;
        this.response = response;
        this.terms = terms;
    }

    public AirlineNameApiUtil() {
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
