package codility.dream;

import java.util.PriorityQueue;

public class ContributorCalculatorImpl implements ContributorCalculator {

    @Override
    public int maxContribution(int[] A, int[] B, int F) {

        var contribution = 0;
        var teamSize = A.length;

        PriorityQueue<Developer> frontEndTeam = new PriorityQueue<>((Developer c1, Developer c2) -> Integer.compare(c1.frontEndToBackContributionDelta, c2.frontEndToBackContributionDelta));
        PriorityQueue<Developer> backEndTeam = new PriorityQueue<>((Developer c1, Developer c2) -> Integer.compare(-c1.frontEndToBackContributionDelta, -c2.frontEndToBackContributionDelta));

        for (int i = 0; i < A.length; i++) {
            var frontEndContribution = A[i];
            var backEndContribution = B[i];
            var frontToBackDeltaContribution = frontEndContribution - backEndContribution;
            if (frontToBackDeltaContribution >= 0) {
                var developer = new Developer(i, frontEndContribution, backEndContribution);
                frontEndTeam.add(developer);
            } else {
                var developer = new Developer(i, frontEndContribution, backEndContribution);
                backEndTeam.add(developer);
            }
        }

        var frontEndDelta = F - frontEndTeam.size();
        var backEndDelta = (teamSize - F) - backEndTeam.size();

        if (frontEndDelta == 0) {
            var frontContribution = frontEndTeam.stream().map(d -> d.frontEndcontribution).reduce(0, (a, b) -> a + b);
            var backContribution = backEndTeam.stream().map(d -> d.backEndcontribution).reduce(0, (a, b) -> a + b);
            contribution = frontContribution + backContribution;
            return contribution;
        } else if (frontEndDelta > 0) { // i need front enders
            for (int i = 0; i < frontEndDelta; i++) {
                var developer = backEndTeam.poll();
                frontEndTeam.add(developer);
            }
            var frontContribution = frontEndTeam.stream().map(d -> d.frontEndcontribution).reduce(0, (a, b) -> a + b);
            var backContribution = backEndTeam.stream().map(d -> d.backEndcontribution).reduce(0, (a, b) -> a + b);
            contribution = frontContribution + backContribution;
            return contribution;
        } // I need back enders
        else {
            for (int i = 0; i < backEndDelta; i++) {
                var developer = frontEndTeam.poll();
                backEndTeam.add(developer);
            }
            var frontContribution = frontEndTeam.stream().map(d -> d.frontEndcontribution).reduce(0, (a, b) -> a + b);
            var backContribution = backEndTeam.stream().map(d -> d.backEndcontribution).reduce(0, (a, b) -> a + b);
            contribution = frontContribution + backContribution;
            return contribution;
        }

    }
}
