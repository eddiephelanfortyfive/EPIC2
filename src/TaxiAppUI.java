import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Random;

public class TaxiAppUI{
        private static final int MAP_SIZE = 10;
        private static final char EMPTY = '.';
        private static final char User = 'O';
        private static final char Taxi = '*';

        private LinkedList<Point> user;
        private Point taxi;
        private char[][] map;
        private Direction direction;



    public TaxiAppUI() {
            user = new LinkedList<>();
            map = new char[MAP_SIZE][MAP_SIZE];

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

            taxi = new Point(taxiX, taxiY);
            map[taxiX][taxiY] = Taxi;
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

