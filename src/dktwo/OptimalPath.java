package dktwo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class OptimalPath {

    int M, N;
    int weight[];
    boolean edges[][];
    boolean visited[];
    int max = 0;

    public OptimalPath(String filename) throws FileNotFoundException {
        setupInput(filename);
    }

    public void setupInput(String filename) throws FileNotFoundException {
        String currentDirectory = System.getProperty("user.dir");

        System.setIn(new java.io.FileInputStream(currentDirectory + "/src/dktwo/" + filename));
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // vertices
        M = sc.nextInt(); // edges

        weight = new int[N+1];
        edges = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            weight[i] = sc.nextInt();
            System.out.println("weight[" + i  + "] = " + weight[i]);
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            edges[x][y] = true;
            System.out.println(x + " -> " + y);
        }
    }

    public int getMaximumPath() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                doRecursive(i, j, weight[i]);
            }
        }
        return max;
    }

    private void doRecursive(int from, int to, int sum) {
        if (!edges[from][to]) return;
        if (visited[to]) return;

        visited[to] = true;
        sum += weight[to];
        max = sum > max ? sum : max;

        for (int i = 1; i <= N; i++)

            doRecursive(to, i, sum);

        visited[to] = false;
        sum -= weight[to];
    }
}
