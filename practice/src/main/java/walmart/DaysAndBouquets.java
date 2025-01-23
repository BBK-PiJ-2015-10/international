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
        List<BloomDayFlower> bloomDayFlowerList = new ArrayList<>();
        for (int i = 0; i < numberOfFlowers; i++) {
            var bloomDayFlower = new BloomDayFlower(bloomDays[i], i);
            bloomDayFlowerList.add(bloomDayFlower);
        }
        var sortByBloomDayAndPosition = Comparator.comparing((BloomDayFlower p) -> p.bloomDay())
                .thenComparingInt(p -> p.flowerPosition());
        bloomDayFlowerList.sort(sortByBloomDayAndPosition);
        var totalNumberOfBouquets = 0;
        List<BloomDayFlower> bouquetFlowers = new ArrayList<>();
        Map<Integer, BloomDayFlower> unsettledAlreadyBloomedDayFlowerMap = new HashMap<>();
        // The list is sorted by day then by position
        for (int i = 0; i < bloomDayFlowerList.size(); i++) {
            var dayFlower = bloomDayFlowerList.get(i);
            var bloomDay = dayFlower.bloomDay;
            var flowerPosition = dayFlower.flowerPosition;
            logger.info(String.format("Evaluating Bloom day %s with flower %s", bloomDay, dayFlower));
            if (bouquetFlowers.isEmpty()) {
                bouquetFlowers.add(dayFlower);
            } else {
                var lastAddedFlowerToBouquetPosition = bouquetFlowers.getLast().flowerPosition;
                var deltaToPosition = flowerPosition - lastAddedFlowerToBouquetPosition;
                if (deltaToPosition == 0 || deltaToPosition == 1 || deltaToPosition == -1) {
                    bouquetFlowers.add(dayFlower);
                    helper(numberOfFlowerPerBouquetRequired, bouquetFlowers, unsettledAlreadyBloomedDayFlowerMap);
                }
            }
            if (bouquetFlowers.size() == numberOfFlowerPerBouquetRequired) {
                totalNumberOfBouquets++;
                logger.info(String.format("Bouquet created with flower %s. Total bouquets are %s", dayFlower, totalNumberOfBouquets));
                bouquetFlowers.clear();
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

    private void helper(int numberOfFlowerPerBouquetRequired, List<BloomDayFlower> bouquetFlowers, Map<Integer, BloomDayFlower> unsettledAlreadyBloomedDayFlowerMap) {
        if (numberOfFlowerPerBouquetRequired == bouquetFlowers.size() || unsettledAlreadyBloomedDayFlowerMap.isEmpty()) {
            //return;
        } else {
            var latestAddedPosition = bouquetFlowers.getLast().flowerPosition;
            var bloomedOnSamePosition = bouquetFlowers.get(latestAddedPosition);
            if (bloomedOnSamePosition != null) {
                bouquetFlowers.add(bloomedOnSamePosition);
                if (bouquetFlowers.size() == numberOfFlowerPerBouquetRequired) {
                    //return;
                } else {
                    helper(numberOfFlowerPerBouquetRequired, bouquetFlowers, unsettledAlreadyBloomedDayFlowerMap);
                }
            }
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



