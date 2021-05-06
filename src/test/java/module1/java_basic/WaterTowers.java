package module1.java_basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class WaterTowers {
    public static void main(String[] args) {

        int[] t = {5, 3, 7, 2, 6, 4, 5, 9, 1, 2};

        LinkedList<Integer> peaksHeight = new LinkedList<>();
        peaksHeight.add(t[0]);
        LinkedList<Integer> peaksPosition = new LinkedList<>();
        peaksPosition.add(0);
        Stack<Integer> valleys = new Stack<>();
        Integer lowerPeak;

        for (int i = 1; i <= t.length - 1; i++) {
            if (t[i] >= peaksHeight.peekLast()) {
                peaksHeight.add(t[i]);
                peaksPosition.add(i);
            }

            if (peaksHeight.size() > 2) {
                peaksHeight.remove(0);
                peaksPosition.remove(0);
            }

            int dif = peaksHeight.get(0) - peaksHeight.get(1);
            System.out.println("dif: " + dif);
            if (dif < 0) {
                lowerPeak = peaksHeight.get(0);
                System.out.println("lower peak: " + lowerPeak);
            } else {
                lowerPeak = peaksHeight.get(1);
                System.out.println("lower peak: " + lowerPeak);
            }
            valleys.push(lowerPeak - t[i]);

            System.out.println("valles: " + valleys);

        }
    }
}
