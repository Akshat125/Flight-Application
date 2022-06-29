package utils.api.airline;

public class Request {
    /**
     * This is a helper-Class to handle the API-Calls for specific Airline information: main: AirlineApiUtil
     */

    private String lang;
    private String currency;
    private int time;
    private String id;
    private String server;
    private String host;
    private int pid;
    private Key key;
    private Params params;
    private int version;
    private String method;
    private Client client;

    public Request(String lang, String currency, int time, String id, String server, String host, int pid, Key key, Params params, int version, String method, Client client) {
        this.lang = lang;
        this.currency = currency;
        this.time = time;
        this.id = id;
        this.server = server;
        this.host = host;
        this.pid = pid;
        this.key = key;
        this.params = params;
        this.version = version;
        this.method = method;
        this.client = client;
    }

    public Request() {
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
