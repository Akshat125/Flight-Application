package utils.api.airlinename;

public class Karma {

    private boolean is_blocked;
    private boolean is_crawler;
    private boolean is_bot;
    private boolean is_friend;
    private boolean is_regular;

    public Karma(boolean is_blocked, boolean is_crawler, boolean is_bot, boolean is_friend, boolean is_regular) {
        this.is_blocked = is_blocked;
        this.is_crawler = is_crawler;
        this.is_bot = is_bot;
        this.is_friend = is_friend;
        this.is_regular = is_regular;
    }

    public Karma() {
    }

    public boolean isIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(boolean is_blocked) {
        this.is_blocked = is_blocked;
    }

    public boolean isIs_crawler() {
        return is_crawler;
    }

    public void setIs_crawler(boolean is_crawler) {
        this.is_crawler = is_crawler;
    }

    public boolean isIs_bot() {
        return is_bot;
    }

    public void setIs_bot(boolean is_bot) {
        this.is_bot = is_bot;
    }

    public boolean isIs_friend() {
        return is_friend;
    }

    public void setIs_friend(boolean is_friend) {
        this.is_friend = is_friend;
    }

    public boolean isIs_regular() {
        return is_regular;
    }

    public void setIs_regular(boolean is_regular) {
        this.is_regular = is_regular;
    }
}
