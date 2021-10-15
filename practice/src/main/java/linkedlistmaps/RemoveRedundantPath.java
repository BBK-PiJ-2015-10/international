package linkedlistmaps;

import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class RemoveRedundantPath {

    private Logger log = Logger.getLogger(RemoveRedundantPath.class.getName());

    public List<Pair<Integer,Integer>> remoteRedundantPath(List<Pair<Integer,Integer>> path){
        Boolean horizontalChange = false;
        Boolean verticalChange = false;
        int position = 0;
        List<Pair<Integer,Integer>> result = new LinkedList<>();
        while (position < path.size()){
            Pair<Integer,Integer> current = path.get(position);
            int nextPosition = position + 1;
            if (nextPosition < path.size()){
                Pair<Integer,Integer> next = path.get(position);
                boolean incHorizontalChange = current.getLeft() != next.getLeft();
                boolean incVerticalChange = current.getRight() != next.getRight();
                if (horizontalChange == false && incHorizontalChange == false){

                }
            }
        }
        return null;
    }



}
