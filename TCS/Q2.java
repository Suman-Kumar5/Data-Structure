package TCS;

import java.util.*;

public class Q2 {
    static final int max = Integer.MAX_VALUE / 2;

    public static int minLegMoves(int N, String[] instructions) {
        int[][] cost = {
                {0, 2, 2, 2},
                {2, 0, 2, 2},
                {2, 2, 0, 2},
                {2, 2, 2, 0}
        };
        Map<String, Integer> map = Map.of("up", 0, "down", 1, "left", 2, "right", 3);
        int[][][] dp = new int[N + 1][4][4];
        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, max);
            }
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                dp[0][i][j] = 0;
            }
        }

        for (int s = 0; s < N; s++) {
            int target = map.get(instructions[s]);

            for (int left = 0; left < 4; left++) {
                for (int right = 0; right < 4; right++) {
                    if (dp[s][left][right] == max) continue;

                    dp[s + 1][target][right] = Math.min(dp[s + 1][target][right],
                            dp[s][left][right] + cost[left][target]);

                    dp[s + 1][left][target] = Math.min(dp[s + 1][left][target], dp[s][left][right] + cost[right][target]);
                }
            }
        }

        int minMoves = max;
        for (int left = 0; left < 4; left++) {
            for (int right = 0; right < 4; right++) {
                minMoves = Math.min(minMoves, dp[N][left][right]);
            }
        }

        return minMoves;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] instructions = new String[N];
        for (int i = 0; i < N; i++) {
            instructions[i] = sc.nextLine();
        }

        System.out.println(minLegMoves(N, instructions));
    }
}

