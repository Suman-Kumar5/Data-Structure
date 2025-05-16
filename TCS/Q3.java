package TCS;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String eq1 = sc.nextLine();
        String eq2 = sc.nextLine();
        int n = sc.nextInt();
        int[] c1 = parseEquation(eq1);
        int[] c2 = parseEquation(eq2);
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j + i <= n; j++) {
                for (int k = 0; k + i + j <= n; k++) {
                    for (int w = 0; w + i + j + k <= n; w++) {
                        int sum1 = c1[0] * i + c1[1] * j + c1[2] * k + c1[3] * w;
                        int sum2 = c2[0] * i + c2[1] * j + c2[2] * k + c2[3] * w;
                        if (sum1 <= c1[4] && sum2 <= c2[4] && sum1 == sum2) {
                            ans.add(sum1);
                        }
                    }
                }
            }
        }
        System.out.println(ans.size());
    }

    public static int[] parseEquation(String e) {
        e = e.replaceAll("x", " ").replaceAll("y", " ").replaceAll("z", " ").replaceAll("w", " ");
        e = e.replaceAll("[+=]", " ");
        String[] arr = e.split("\\s+");
        int[] c = new int[5];
        int i = 0;
        for (String part : arr) {
            if (!part.isEmpty()) {
                c[i++] = Integer.parseInt(part);
            }
        }
        return c;
    }
}

