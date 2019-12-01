# Finding Optimal Path
## Input Format
The first line contains three-space separated integers, N (the number of vertices), M (the number of edges) and origin, respectively.

The next line contains weight of each N vertices. Each of the next M lines contains two integers connected vertex.

## Sample Input
```
3 3 1
1 2 2
1 2
2 3
1 3
```

## Explanation
There are 3 vertices with weights:
```
weight[1] = 1
weight[2] = 2
weight[3] = 2
```
and 3 edges:
```
1 -> 2
2 -> 3
1 -> 3
```
Following is complete algorithm for finding optimal path:
- Initialize weight every vertex. 
- Initialize edges and put in on queue.
- Looping from origin through every edges and get the maximum sum value. 

For cyclic graph, first we should remove the cyclic relation using Finding Cycle algorithm and continue finding optimal path using algorithm above.

## Time complexity
The algorithm process runs loop from origin vertex to all adjacent vertices. Total adjacent edges in a graph is O(M). Therefore, overall time complexity of this algorithm is O(M).

## Memory complexity
The memory complexity depends on the number of vertices and edges. For example: 
```
If we have N = 1,000,000
And M = 10,000
Array of weight: 4 bytes x 1,000,000 = 4 MB
Array of edges using LinkedList: 4 bytes x (1,000,000 + 10,000) = 4 MB
```
Therefore, the total memory is 8 MB.
