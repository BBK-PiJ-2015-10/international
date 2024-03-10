package fourth;

import java.util.Map;

public interface ContributionCalculator {

    Contributions estimateContribution(double salary, double contributionLimit, double maxDesiredContribution,
                                       Map<Double,Double> contributionBands
    );

}
