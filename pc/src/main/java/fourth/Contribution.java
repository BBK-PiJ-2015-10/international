package fourth;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;


public class Contribution {

    private double salary;

    private double totalContribution = 0.0;

    private double contributionCap;

    private double maxContributionPercentage;

    private List<Pair<Double,Double>> matchingPlanBands;

    public Contribution(double salary, double maxContributionPercentage, double contributionCap,
                        List<Pair<Double, Double>> matchingPlanBands) {
        this.salary = salary;
        this.contributionCap = contributionCap;
        this.matchingPlanBands = matchingPlanBands;
        this.maxContributionPercentage = maxContributionPercentage;

        double cumulativePercentageContribution = 0.0;
        double runningContribution = 0.0;

        for (int i = 0; i < matchingPlanBands.size(); i++) {
            if (cumulativePercentageContribution < maxContributionPercentage) {
                Pair<Double, Double> match = matchingPlanBands.get(i);
                Double actualIncrementalPercentage;
                if (maxContributionPercentage > cumulativePercentageContribution + match.getLeft()) {
                    actualIncrementalPercentage = match.getLeft();
                } else {
                    actualIncrementalPercentage = maxContributionPercentage - cumulativePercentageContribution;
                }
                cumulativePercentageContribution += actualIncrementalPercentage;
                double incrementalContribution = (actualIncrementalPercentage / 100) * (match.getRight() / 100) * salary;
                runningContribution += incrementalContribution;
                if (runningContribution > contributionCap) {
                    runningContribution = contributionCap;
                    break;
                }
            } else {
                break;
            }
        }
        totalContribution = runningContribution;
    }


}
