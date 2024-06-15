package codility.dream;

public class Developer {

    public int position;

    public int frontEndcontribution;

    public int backEndcontribution;

    int frontEndToBackContributionDelta;

    public Developer(int position, int frontEndcontribution, int backEndcontribution) {
        this.position = position;
       this.frontEndcontribution = frontEndcontribution;
       this.backEndcontribution = backEndcontribution;
       this.frontEndToBackContributionDelta = frontEndcontribution - backEndcontribution;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "position=" + position +
                ", frontEndcontribution=" + frontEndcontribution +
                ", backEndcontribution=" + backEndcontribution +
                ", frontEndToBackContributionDelta=" + frontEndToBackContributionDelta +
                '}';
    }
}
