package veinteream;

public class FindClosestPower {

    public int findClosestPower(int number, int base) {
        double target = number;
        double baseD = base;
        Integer power = 0;
        Double poweredNumber;
        while (true) {
            poweredNumber = Math.pow(baseD, power);
            if (poweredNumber >= target) {
                break;
            }
            power++;
        }
        if (poweredNumber == target) {
            return power;
        } else {
            return power - 1;
        }
    }

    public int findPower(int maxVal, int a) {
        Double result = Math.log(maxVal) / Math.log(a);
        return result.intValue();
    }

}
