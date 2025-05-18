package jerry;

import java.util.List;

public interface IntensityProcessor {

    List<Segment> add(int fromSegment, int toSegment, int intensity);

    List<Segment> set(int fromSegment, int toSegment, int intensity);

}
