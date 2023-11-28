import java.util.ArrayList;

// Best time to buy and sell stock
public class Problem_35 {
public static int maximumProfit(ArrayList<Integer> prices){
        int maxPrice = 0;
        int mini = prices.get(0);
       for(int i = 1; i < prices.size(); i++){
           int currPrice = prices.get(i);
           int currProfit = currPrice - mini;
           maxPrice = Math.max(currProfit,maxPrice);
           mini = Math.min(currPrice,mini);
       }
       return maxPrice;
    }
}