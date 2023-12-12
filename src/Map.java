

public class Map {

        private Location[][] grid;
        private int mapRadius;
        private LinkedList<Taxi> taxis;
        private LinkedList<User> users;
        public Map(int radius){
            /*LinkedList<User> listUser= new LinkedList<>();
            LinkedList<Taxi> listTaxi= new LinkedList<>();
            this.users = listUser;
            this.taxis = listTaxi;*/
            this.grid = new Location[radius][radius];
            this.mapRadius = radius;

            for(int i=0; i < radius; i++) { // columns
                for (int j = 0; j < radius; j++) { // rows
                    this.grid[i][j] = new Location(i, j); // init new location item;
                }
            }TextHandler text = new TextHandler();
            LinkedList<User> usernames =text.readUsersAndPasswords();
            usernames.moveToFirst();
            grid[0][5].addUser(usernames.getData());
        }

        public void printMap(){
            for(int i=0; i<mapRadius; i++) { // columns
                for (int j = 0; j < mapRadius; j++) { // rows
                    Location location = grid[j][i]; // changed as was mixed up
                    System.out.print(location.getMapPoint());
                }
                System.out.println("");
            }
        }
}
