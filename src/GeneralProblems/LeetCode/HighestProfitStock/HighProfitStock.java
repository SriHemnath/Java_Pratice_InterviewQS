package GeneralProblems.LeetCode.HighestProfitStock;

public class HighProfitStock {
    public static void main(String[] args) {
        int[] stockPrices = {2, 4, 5, 1, 10, 8};
        System.out.println(getProfit(stockPrices));
    }

    private static Profit getProfit(int[] stockPrices){
        int dayBuy = 0,daySell = 0,maxProfit =0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < stockPrices.length; i++) {
            if (stockPrices[i]<minPrice){
                minPrice = stockPrices[i];
                dayBuy = i+1;
            } else if(maxProfit < (stockPrices[i]-minPrice)){
                maxProfit = stockPrices[i]-minPrice;
                daySell = i+1;
            }
        }
        return new Profit(dayBuy,daySell,maxProfit);
    }

    private record Profit(int dayBuy,int daySell, int Profit){}
}
