package inter.patterns.dynamic;

public class NeighborhoodBurglary {

    public int maxProfit(int[] houses) {
        int twoPriorHousesMax = houses[0];
        int priorHouseMax = Math.max(twoPriorHousesMax, houses[1]);
        for (int h = 2; h < houses.length; h++) {
            var currentHouseMax = Math.max(priorHouseMax, houses[h] + twoPriorHousesMax);
            twoPriorHousesMax = priorHouseMax;
            priorHouseMax = currentHouseMax;
        }
        return priorHouseMax;
    }


}
