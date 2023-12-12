import java.util.ArrayList;
import java.util.List;
public class Location {
    private int x;
    private int y;
    private List<Taxi> taxis;
    private List<User> users;
    private String mapPoint;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Taxi> getTaxis(){ return taxis; }

    public String getMapPoint() {
        return mapPoint;
    }

    public Location(int x, int y){
        this.x = x;
        this.y = y;
        this.mapPoint = ".\t";
        this.users = new ArrayList<>();
        this.taxis = new ArrayList<>();
    }

    public void addUser(User user){
        System.out.println(user.getUsername()+" added");
        users.add(user);
        mapPoint = "U\t";
    }

   public void addTaxi(Taxi taxi){
        System.out.println(taxi.getRegistration()+" added to x:"+x+", y:"+y);
        taxis.add(taxi);
        mapPoint = "T\t";
    }

   /* public boolean isTaxisOnTile(){
        return !taxis.isEmpty();
    }

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.addAll(taxis);
        users.addAll(customers);

        return users;
    }*/
}
