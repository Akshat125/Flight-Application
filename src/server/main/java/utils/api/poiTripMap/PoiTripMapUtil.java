package utils.api.poiTripMap;

public class PoiTripMapUtil {
    /**
     * This is the main-Class to handle the API-Calls for point-Of-interest information
     */

    private String xid;
    private String name;
    private double dist;
    private int rate;
    private String osm;
    private String wikidata;
    private String kinds;
    private Point point;

    public PoiTripMapUtil(String xid, String name, double dist, int rate, String osm, String wikidata, String kinds, Point point) {
        this.xid = xid;
        this.name = name;
        this.dist = dist;
        this.rate = rate;
        this.osm = osm;
        this.wikidata = wikidata;
        this.kinds = kinds;
        this.point = point;
    }

    public PoiTripMapUtil() {
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDist() {
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getOsm() {
        return osm;
    }

    public void setOsm(String osm) {
        this.osm = osm;
    }

    public String getWikidata() {
        return wikidata;
    }

    public void setWikidata(String wikidata) {
        this.wikidata = wikidata;
    }

    public String getKinds() {
        return kinds;
    }

    public void setKinds(String kinds) {
        this.kinds = kinds;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
