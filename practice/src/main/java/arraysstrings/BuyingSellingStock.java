package arraysstrings;

import java.util.logging.Logger;

public class BuyingSellingStock {

    private Logger logger = Logger.getLogger(BuyingSellingStock.class.getName());

    public int maxProfit(int[] pricesPerDay){
        return maxProfitHelper(0,pricesPerDay[0],pricesPerDay[0],0,pricesPerDay,pricesPerDay[0]);
    }

    public int maxProfitTwoSales(int[] pricesPerDay){
        return maxProfitHelper(0,pricesPerDay[0],pricesPerDay[0],0,0,pricesPerDay,pricesPerDay[0]);
    }

    public int maxProfitUnlimited(int[] pricesPerDay){
        int cumProfit = 0;
        Integer buyPrice = null;
        for (int i=0;i<pricesPerDay.length;i++){
            int todaysPrice = pricesPerDay[i];
            //evaluate sell
            if (buyPrice!=null && todaysPrice>buyPrice ){
                //sell
                cumProfit += todaysPrice - buyPrice;
                buyPrice = null;
            }
            //evaluate buy
            int nextDay = i+1;
            if (nextDay<pricesPerDay.length){
                int nextDayPrice = pricesPerDay[nextDay];
                if (nextDayPrice>todaysPrice){
                    //buy
                    buyPrice = todaysPrice;
                }
            }
        }
        return cumProfit;
    }

    private int maxProfitHelper(
        int position,
        int lower,
        int higher,
        int maxProfitToDate,
        int[] pricesPerDay,
        int priorPrice
    ) {
        String msg = String.format("Evaluating pos %s, lower %s, higher %s, maxProfit %s, priorPrice %s",position,lower,higher,maxProfitToDate,priorPrice);
        logger.info(msg);
        if (pricesPerDay.length - 1 < position) {
            return maxProfitToDate;
        } else {
            int newPrice = pricesPerDay[position];
            //New buy opportunity reset hight
            if (priorPrice > newPrice) {
                higher = 0;
            } else {
                if (higher < newPrice) {
                    higher = newPrice;
                }
            }
            if (lower > newPrice) {
                lower = newPrice;
            }
            int newMaxProfit = higher - lower;
            if (newMaxProfit > maxProfitToDate) {
                maxProfitToDate = newMaxProfit;
            }
            return maxProfitHelper(position + 1,lower, higher, maxProfitToDate, pricesPerDay, newPrice);
        }
    }

    private int maxProfitHelper(
        int position,
        int lower,
        int higher,
        int maxProfitToDate,
        int secondMaxProfitToDate,
        int[] pricesPerDay,
        int priorPrice
    ) {
        String msg = String.format(
            "Evaluating pos %s, lower %s, higher %s, maxProfit %s, secondMaxProfit %s, priorPrice %s",
            position,
            lower,
            higher,
            maxProfitToDate,
            secondMaxProfitToDate,
            priorPrice);
        logger.info(msg);
        if (pricesPerDay.length - 1 < position) {
            return maxProfitToDate + secondMaxProfitToDate;
        } else {
            int newPrice = pricesPerDay[position];
            //New buy opportunity reset hight
            if (priorPrice > newPrice) {
                higher = 0;
            } else {
                if (higher < newPrice) {
                    higher = newPrice;
                }
            }
            if (lower > newPrice) {
                lower = newPrice;
            }
            int newMaxProfit = higher - lower;
            if (newMaxProfit > maxProfitToDate) {
                secondMaxProfitToDate = maxProfitToDate;
                maxProfitToDate = newMaxProfit;
            } else if(newMaxProfit > secondMaxProfitToDate) {
                secondMaxProfitToDate = newMaxProfit;
            }
            return maxProfitHelper(position + 1,lower, higher, maxProfitToDate, secondMaxProfitToDate, pricesPerDay, newPrice);
        }
    }
}
