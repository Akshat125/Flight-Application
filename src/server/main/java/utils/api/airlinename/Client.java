package utils.api.airlinename;

import org.aspectj.weaver.loadtime.Agent;

public class Client {
    private String ip;
    private Geo geo;
    private Connection connection;
    private Device device;
    private Agent agent;
    private Karma karma;

    public Client(String ip, Geo geo, Connection connection, Device device, Agent agent, Karma karma) {
        this.ip = ip;
        this.geo = geo;
        this.connection = connection;
        this.device = device;
        this.agent = agent;
        this.karma = karma;
    }

    public Client() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Karma getKarma() {
        return karma;
    }

    public void setKarma(Karma karma) {
        this.karma = karma;
    }
}
