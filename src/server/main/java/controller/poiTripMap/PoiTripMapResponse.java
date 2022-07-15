package controller.poiTripMap;

public class PoiTripMapResponse {

    private String name;
    private String kinds;

    public PoiTripMapResponse(String name, String kinds) {
        this.name = name;
        this.kinds = kinds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }
}
