package walmart;

import java.util.*;
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
        List<BloomDayFlower> flowers = new ArrayList<>();
        for (int i = 0; i < numberOfFlowers; i++) {
            var bloomDayFlower = new BloomDayFlower(bloomDays[i], i);
            flowers.add(bloomDayFlower);
        }
        var sortByBloomDayAndPosition = Comparator.comparing((BloomDayFlower p) -> p.bloomDay())
                .thenComparingInt(p -> p.flowerPosition());
        flowers.sort(sortByBloomDayAndPosition);
        var totalNumberOfBouquets = 0;
        List<BloomDayFlower> bouquet = new ArrayList<>();
        Map<Integer, BloomDayFlower> unsettledAlreadyBloomedPositionDayFlowerMap = new HashMap<>();
        // The list is sorted by day then by position
        for (int i = 0; i < flowers.size(); i++) {
            var flower = flowers.get(i);
            var flowerBloomDay = flower.bloomDay;
            var flowerPosition = flower.flowerPosition;
            logger.info(String.format("Evaluating Bloom day %s with flower %s", flowerBloomDay, flower));
            if (bouquet.isEmpty()) {
                logger.info(String.format("Bouquet is empty, adding %s",flower));
                bouquet.add(flower);
            } else {
                var lastAddedFlowerToBouquetPosition = bouquet.getLast().flowerPosition;
                var deltaToPosition = flowerPosition - lastAddedFlowerToBouquetPosition;
                if (deltaToPosition == 0 || deltaToPosition == 1 || deltaToPosition == -1) {
                    bouquet.add(flower);
                    helper(numberOfFlowerPerBouquetRequired, bouquet, unsettledAlreadyBloomedPositionDayFlowerMap);
                } else {
                    logger.info(String.format("Adding to unsettled %s",flower));
                    unsettledAlreadyBloomedPositionDayFlowerMap.put(flowerPosition,flower);
                }
            }
            if (bouquet.size() == numberOfFlowerPerBouquetRequired) {
                totalNumberOfBouquets++;
                logger.info(String.format("Bouquet created with flower %s. Total bouquets are %s", flower, totalNumberOfBouquets));
                bouquet.clear();
            }
            if (totalNumberOfBouquets == numberOfBouquetsRequired) {
                minDays = flowerBloomDay;
                logger.info(String.format("Minimum days to bloom all flowers is %s", minDays));
                break;
            }
        }
        logger.info(String.format("Seem like no solution is available. Minimum days to bloom all flowers is default %s", minDays));
        return minDays;
    }

    private void helper(int numberOfFlowerPerBouquetRequired, List<BloomDayFlower> bouquetFlowers, Map<Integer, BloomDayFlower> unsettledAlreadyBloomedDayFlowerMap) {
        if (numberOfFlowerPerBouquetRequired == bouquetFlowers.size() || unsettledAlreadyBloomedDayFlowerMap.isEmpty()) {
        } else {
            var latestAddedPosition = bouquetFlowers.getLast().flowerPosition;
            // evaluate if above
            Integer oneAbovePosition = latestAddedPosition + 1;
            var bloomedOneAbovePosition = unsettledAlreadyBloomedDayFlowerMap.get(oneAbovePosition);
            if (bloomedOneAbovePosition != null) {
                bouquetFlowers.add(bloomedOneAbovePosition);
                if (bouquetFlowers.size() == numberOfFlowerPerBouquetRequired) {
                    //return;
                } else {
                    helper(numberOfFlowerPerBouquetRequired, bouquetFlowers, unsettledAlreadyBloomedDayFlowerMap);
                }
            }
            Integer oneBelowPosition = latestAddedPosition - 1;
            var bloomedOneBelowPosition = unsettledAlreadyBloomedDayFlowerMap.get(oneBelowPosition);
            if (bloomedOneBelowPosition != null) {
                bouquetFlowers.add(bloomedOneBelowPosition);
                if (bouquetFlowers.size() == numberOfFlowerPerBouquetRequired) {
                    //return;
                } else {
                    helper(numberOfFlowerPerBouquetRequired, bouquetFlowers, unsettledAlreadyBloomedDayFlowerMap);
                }
            }
        }
    }


}



