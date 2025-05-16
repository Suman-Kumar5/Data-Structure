package TCS;

import java.util.*;

public class Q4 {
    static class Pair {
        int vet, distance;
        Pair(int v, int distance) {
            this.vet = v;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] distanceMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distanceMatrix[i][j] = sc.nextInt();
            }
        }
        int[] em = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            em[i] = sc.nextInt();
        }
        int capacity = sc.nextInt();
        int[] shortDistances = dijkstra(distanceMatrix, n);
        int totalBuses = 0;

        for (int i = 1; i < n; i++) {
            int busesNeeded = (em[i - 1] + capacity - 1) / capacity; // Ceiling division
            totalBuses += busesNeeded;
        }
        System.out.println(totalBuses);
    }

    private static int[] dijkstra(int[][] matrix, int M) {
        int[] dist = new int[M];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.distance));
        pq.add(new Pair(0, 0));

        boolean[] visited = new boolean[M];

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.vet;
            if (visited[node]) continue;
            visited[node] = true;
            for (int i = 0; i < M; i++) {
                if (!visited[i] && matrix[node][i] > 0) {
                    int newDist = dist[node] + matrix[node][i];
                    if (newDist < dist[i]) {
                        dist[i] = newDist;
                        pq.add(new Pair(i, newDist));
                    }
                }
            }
        }
        return dist;
    }
}

