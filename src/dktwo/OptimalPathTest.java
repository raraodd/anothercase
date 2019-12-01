package dktwo;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class OptimalPathTest {

    @Test
    public void setupInput() throws FileNotFoundException {
        int[] weight;
        boolean[][] edges;

        OptimalPath test = new OptimalPath("input01.txt");
        weight = new int[]{0,1,2,2};
        assertArrayEquals(weight, test.weight);
        edges= new boolean[test.N+1][test.N+1];
        edges[1][2] = edges[1][3] = edges[2][3] = true;
        assertArrayEquals(edges, test.edges);

        test.setupInput("input02.txt");
        weight = new int[]{0, 0,10,2,3,1};
        assertArrayEquals(weight, test.weight);
        edges= new boolean[test.N+1][test.N+1];
        edges[1][2] = edges[1][5] = edges[5][3] = edges[3][4] = true;
        assertArrayEquals(edges, test.edges);
    }

    @Test
    public void getMaximumPath() throws FileNotFoundException {
        OptimalPath test = new OptimalPath("input01.txt");
        assertEquals(5, test.getMaximumPath());

        test.setupInput("input02.txt");
        assertEquals(10, test.getMaximumPath());

        test.setupInput("input03.txt");
        assertEquals(25, test.getMaximumPath());
    }
}