public class Client extends Observer {

    private String news;
    private int zone;

    public Client(int zone) {
        this.zone = zone;
        news = "";
    }

    @Override
    public void update(Object o) {
        news = o.toString();

    }

    @Override
    public int getZone() {
        return zone;
    }

    @Override
    public String getNews() {
        return news;
    }
}