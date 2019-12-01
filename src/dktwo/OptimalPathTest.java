package dktwo;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

public class OptimalPathTest {

    @Test
    public void setupInput() throws FileNotFoundException {
        int[] weight;
        Queue[] edges;

        OptimalPath test = new OptimalPath("input01.txt");
        weight = new int[]{0,1,2,2};
        assertArrayEquals(weight, test.weight);
        edges= new Queue[test.N+1];
        edges[1] = new LinkedList();
        edges[1].add(2); edges[1].add(3);
        edges[2] = new LinkedList();
        edges[2].add(3);
        assertArrayEquals(edges, test.edges);

        test.setupInput("input02.txt");
        weight = new int[]{0,0,10,2,3,1};
        assertArrayEquals(weight, test.weight);
        edges= new Queue[test.N+1];
        edges[1] = new LinkedList();
        edges[1].add(2); edges[1].add(5);
        edges[5] = new LinkedList();
        edges[5].add(3);
        edges[3] = new LinkedList();
        edges[3].add(4);
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