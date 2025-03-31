package veinteream;

public class FindClosestPower {

    public int findPower(int maxVal, int a) {
        Double result = Math.log(maxVal) / Math.log(a);
        return result.intValue();
    }

}
