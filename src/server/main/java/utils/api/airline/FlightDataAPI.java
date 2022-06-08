package utils.api.airline;

import java.util.ArrayList;

public class FlightDataAPI {
    public Pagination pagination;
    public ArrayList<Datum> data;


    public FlightDataAPI(Pagination pagination, ArrayList<Datum> data) {
        this.pagination = pagination;
        this.data = data;
    }

    public FlightDataAPI() {
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }















}
