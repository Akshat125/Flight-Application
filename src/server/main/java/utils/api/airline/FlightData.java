package utils.api.airline;

import java.util.ArrayList;

public class FlightData {
    public Pagination pagination;
    public ArrayList<Datum> data;


    public FlightData(Pagination pagination, ArrayList<Datum> data) {
        this.pagination = pagination;
        this.data = data;
    }

    public FlightData() {
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
