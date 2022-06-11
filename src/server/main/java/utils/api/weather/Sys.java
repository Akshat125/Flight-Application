package utils.api.weather;

public class Sys {

    private String pod;

    public Sys(String pod) {
        this.pod = pod;
    }

    public Sys() {
    }

    public String getPod() {
        return pod;
    }

    public void setPod(String pod) {
        this.pod = pod;
    }
}
