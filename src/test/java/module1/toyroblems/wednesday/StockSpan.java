package module1.toyroblems.wednesday;

import java.util.ArrayList;

public class StockSpan {

    public static void main(String[] args){
//        ArrayList<Integer> stockPrices = new ArrayList<Integer>(100, 80, 60, 70, 60, 75, 85);

        int[] stocks = {100, 80, 60, 70, 60, 75, 85};
        ArrayList<Integer> stockValues = new ArrayList<>();

        for (int k=0; k<stocks.length; k++) {

            int counter = 1;
            for (int z=k-1; z>=0; z--) {
                if (stocks[k] > stocks[z]) {
                    counter++;
                }
            }
            stockValues.add(counter);
        }

        for (Integer value: stockValues) {
            System.out.print(value + " ");
        }
    }

}
