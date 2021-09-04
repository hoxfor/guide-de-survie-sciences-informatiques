
public class Pair<String, Integer> {

    private String alert;
    private Integer zone;

    public Pair(String alert, Integer zone){
        this.alert = alert;
        this.zone = zone;
    }

    public Integer getZone() {
        return zone;
    }

    public String getAlert() {
        return alert;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Pair){
            Pair that = (Pair) o;
            return that.getZone() == this.getZone();
        }
        return false;
    }

}
