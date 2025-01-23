package walmart;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public class DaysAndBouquets {

    private Logger logger = Logger.getLogger(DaysAndBouquets.class.getName());


    record BloomDayFlower(int bloomDay, int flowerPosition) {
    }

    public int minDays(int[] bloomDays, int numberOfBouquetsRequired, int numberOfFlowerPerBouquetRequired) {
        var minDays = -1;
        var numberOfFlowers = bloomDays.length;
        if (numberOfFlowers < numberOfBouquetsRequired * numberOfFlowerPerBouquetRequired) {
            return minDays;
        }
        List<BloomDayFlower> bloomDayFlowerList = new ArrayList<>();
        for (int i = 0; i < numberOfFlowers; i++) {
            var bloomDayFlower = new BloomDayFlower(bloomDays[i], i);
            bloomDayFlowerList.add(bloomDayFlower);
        }
        bloomDayFlowerList.sort(Comparator.comparingInt(a -> a.bloomDay));
        var totalNumberOfBouquets = 0;
        var existingFlowersPerBouquet = 0;
        for (int i = 0; i < bloomDayFlowerList.size(); i++) {
            var dayFlower = bloomDayFlowerList.get(i);
            var bloomDay = dayFlower.bloomDay;
            logger.info(String.format("Evaluating Bloom day %s with flower %s", bloomDay, dayFlower));
            existingFlowersPerBouquet++;
            if (existingFlowersPerBouquet == numberOfFlowerPerBouquetRequired) {
                totalNumberOfBouquets++;
                logger.info(String.format("Bouquet created with flower %s. Total bouquets are %s", dayFlower, totalNumberOfBouquets));
                existingFlowersPerBouquet = 0;
            }
            if (totalNumberOfBouquets == numberOfBouquetsRequired) {
                minDays = bloomDay;
                logger.info(String.format("Minimum days to bloom all flowers is %s", minDays));
                break;
            }
        }
        logger.info(String.format("Seem like no solution is available. Minimum days to bloom all flowers is default %s", minDays));
        return minDays;
    }
}



