package TCS;

import java.util.*;

public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] time = sc.next().split(":");
        int startInt = Integer.parseInt(time[0]);
        int startMin = Integer.parseInt(time[1]);
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int[] angles = new int[k];
        for (int i = 0; i < k; i++) {
            angles[i] = sc.nextInt();
        }
        double startingHourPos = (startInt % 12) * 30 + (startMin / 60.0) * 30;
        double startingMinPos = startMin * 6;
        int cost = 0;
        for (int angle : angles) {
            cost += computeMinimumCost(startingHourPos, startingMinPos, angle, a,b,c,d);
        }
        System.out.println(cost);
    }

    private static int computeMinimumCost(double hourPos, double minutePos, int targetAngle, int a, int b, int c, int d) {

        int minCost = Integer.MAX_VALUE;

        int innAngle = targetAngle;
        int extAngle = 360 - targetAngle;
        for (int angle : new int[]{innAngle, extAngle}) {
            minCost = Math.min(minCost, calculateCost(hourPos, minutePos, angle, true, false, a, b, c, d));
            minCost = Math.min(minCost, calculateCost(hourPos, minutePos, angle, false, true, a, b, c, d));
        }
        return minCost;
    }

    private static int calculateCost(double hPos, double minPos, int angle, boolean hourClockwise, boolean minuteClockwise, int a, int b, int c, int d) {
        double target = (hPos + (hourClockwise ? angle : -angle)) % 360;
        double targetMinutePos = (minPos + (minuteClockwise ? -angle : angle)) % 360;
        if (target < 0){
            target += 360;
        }
        if (targetMinutePos < 0){
            targetMinutePos += 360;
        }
        int hourMovement = (int) Math.abs(target - hPos);
        int minuteMovement = (int) Math.abs(targetMinutePos - minPos);
        int hourCost = hourMovement * (hourClockwise ? a : b) * c;
        int minuteCost = minuteMovement * (minuteClockwise ? a : b) * d;
        return hourCost + minuteCost;
    }
}

