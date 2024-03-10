package fourth;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ContributionCalculatorImpl implements ContributionCalculator {


    @Override
    public Contributions estimateContribution(double salary, double contributionLimit, double desiredContribution, Map<Double, Double> contributionBands) {
        double maxDesiredContribution;
        if (desiredContribution * salary > contributionLimit) {
            maxDesiredContribution = contributionLimit;
        } else {
            maxDesiredContribution = desiredContribution * salary;
        }
        var bands = contributionBands.keySet().stream().sorted().collect(Collectors.toList());
        var firstBand = bands.remove(0);
        return helper(salary, maxDesiredContribution, contributionBands, 0.0, firstBand, bands, 0, 0.0);
    }

    private Contributions helper(double salary, double maxDesiredContribution, Map<Double, Double> contributionBands, double priorBand, double currentBand, List<Double> bands, double employeeContribution, double employerContribution) {
        if (employeeContribution >= maxDesiredContribution) {
            return new Contributions(employeeContribution, employerContribution);
        } else {
            var incEmployeeContribution = salary * (currentBand - priorBand);
            if (incEmployeeContribution + employeeContribution > maxDesiredContribution) {
                incEmployeeContribution = maxDesiredContribution - employeeContribution;
            }
            var matching = contributionBands.get(currentBand);
            var incEmployerContribution = incEmployeeContribution * matching;
            var updatedEmployeeContribution = incEmployeeContribution + employeeContribution;
            var updatedEmployerContribution = incEmployerContribution + employerContribution;
            if (bands.isEmpty()) {
                if (updatedEmployeeContribution < maxDesiredContribution) {
                    return new Contributions(maxDesiredContribution, updatedEmployerContribution);
                } else {
                    return new Contributions(updatedEmployeeContribution, updatedEmployerContribution);
                }
            } else {
                var band = bands.remove(0);
                return helper(salary, maxDesiredContribution, contributionBands, currentBand, band, bands, employeeContribution, employerContribution);
            }
        }
    }

}


