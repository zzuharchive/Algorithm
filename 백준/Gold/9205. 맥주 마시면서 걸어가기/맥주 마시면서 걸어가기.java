import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Place {

    String type;
    int x;
    int y;
    int beer = 0;
    boolean visited = false;
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int i = 0; i < testCases; i++) {
            int store = input.nextInt();
            Queue<Place> queue = new LinkedList<>();
            LinkedList<Place> placeList = new LinkedList<Place>();
            for (int j = 0; j < store + 2; j++) {
                Place place = new Place();
                place.x = input.nextInt();
                place.y = input.nextInt();

                if (j == 0) {
                    place.type = "home";
                    place.beer = 20;
                } else if (j == store + 1) {
                    place.type = "festival";
                } else {
                    place.type = "store";
                }

                placeList.add(place);
            }

            bfs(queue, placeList, placeList.get(0));
            queue.clear();
            placeList.clear();
        }
    }

    private static void bfs(Queue<Place> queue, LinkedList<Place> placeList, Place place) {

        place.visited = true;
        queue.add(place);

        while (!queue.isEmpty()) {
            Place current = queue.poll();
            if (current.type.equals("festival")) {
                System.out.println("happy");
                return;
            } else if (current.type.equals("store")) {
                current.beer = 20;
            }

            for (Place next : placeList) {
                if (current.beer >= needBeer(current, next) && !next.visited) {
                    next.beer = current.beer - needBeer(current, next);
                    next.visited = true;
                    queue.add(next);
                }
            }
        }

        System.out.println("sad");
    }

    static int needBeer(Place current, Place next) {
        return (int) Math.ceil((double) (Math.abs(next.x - current.x) + Math.abs(next.y - current.y)) / 50);
    }
}