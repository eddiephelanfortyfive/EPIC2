import java.util.LinkedList;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;
public class TaxiAppUI{
        private static final int MAP_SIZE = 10;
        private static final char EMPTY = '.';
        private static final char User = 'U';
        private static final char TAXI = 'T';

        private LinkedList<Point> user;
        private Map<Point, Integer> taxis;
        //private Point taxi;
        private int taxiCount = 0;
        private char[][] map;
        private Direction direction;



    public TaxiAppUI() {
            user = new LinkedList<>();
            map = new char[MAP_SIZE][MAP_SIZE];
            taxis = new HashMap<>();

            initializeMap();
            spawnUser();
            //looping through the spawnTaxi a random number of times between 5 and 10 to have a random number of taxis
            Random random = new Random();
            int numOfTaxis = random.nextInt(6) + 5;
            for(int i = 0; i < numOfTaxis; i++) {
                spawnTaxi();
            }
        System.out.println("there is " + numOfTaxis + " taxis available right now.");
        }

        private void initializeMap() {
            for (int i = 0; i < MAP_SIZE; i++) {
                for (int j = 0; j < MAP_SIZE; j++) {
                    map[i][j] = EMPTY;
                }
            }
        }

        private void spawnUser() {
            user.clear();
            int startX = MAP_SIZE / 2;
            int startY = MAP_SIZE / 2;

            user.add(new Point(startX, startY));
            map[startX][startY] = User;
        }

        private void spawnTaxi() {
            Random random = new Random();
            int taxiX, taxiY;

            do {
                taxiX = random.nextInt(MAP_SIZE);
                taxiY = random.nextInt(MAP_SIZE);
            } while (map[taxiX][taxiY] != EMPTY);

            Point taxiPoint = new Point(taxiX, taxiY);
            taxis.put(taxiPoint, taxis.size() + 1);
            map[taxiX][taxiY] = TAXI;
        }

    private void move() {

        }



        private void printMap() {
            for (int i = 0; i < MAP_SIZE; i++) {
                for (int j = 0; j < MAP_SIZE; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        public void run() {
            int iterations = 1;
            for (int i = 0; i < iterations; i++) {
                printMap();
            }
        }

        public static void generateMap() {
            TaxiAppUI taxiApp = new TaxiAppUI();
            taxiApp.run();
            System.out.println("Map generated");
        }




    }

