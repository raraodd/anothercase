package dktwo;

import java.io.FileNotFoundException;
import java.util.*;

public class OptimalPath {

    public int M, N, origin;
    public int weight[];
    public Queue edges[];

    public OptimalPath(String filename) throws FileNotFoundException {
        setupInput(filename);
    }

    public void setupInput(String filename) throws FileNotFoundException {
        String currentDirectory = System.getProperty("user.dir");

        if (filename != null) {
            System.setIn(new java.io.FileInputStream(currentDirectory + "/src/dktwo/" + filename));
        }
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // vertices
        M = sc.nextInt(); // edges
        origin = sc.nextInt(); // origin

        weight = new int[N+1];
        edges = new Queue[N+1];

        for (int i = 1; i <= N; i++) {
            weight[i] = sc.nextInt();
            System.out.println("weight[" + i  + "] = " + weight[i]);
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (edges[x] == null) edges[x] = new LinkedList<>();
            edges[x].add(y);
            System.out.println(x + " -> " + y);
        }
    }

    public int getMaximumPath() {
        int result, max = 0;

        Iterator<Integer> iterator = edges[origin].iterator();

        while (iterator.hasNext()) {
            result = doRecursive(origin, iterator.next()) + weight[origin];
            max = result > max ? result : max;
        }

        return max;
    }

    private int doRecursive(int from, int to) {
        if (!edges[from].contains(to)) return 0;
        if (edges[to] == null) return weight[to];
        int result, max = 0;

        Iterator<Integer> iterator = edges[to].iterator();

        while (iterator.hasNext()) {
            result = doRecursive(to, iterator.next());
            max = result > max ? result : max;
        }

        return max + weight[to];
    }

    public static void main(String[] args) throws FileNotFoundException {

        OptimalPath optimalPath = new OptimalPath(null);

        int maxPath = optimalPath.getMaximumPath();
        System.out.println("Maximum path: " + maxPath);
    }
}
