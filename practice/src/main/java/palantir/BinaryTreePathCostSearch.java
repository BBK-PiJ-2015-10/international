package palantir;

import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class BinaryTreePathCostSearch {

    Logger logger = Logger.getLogger("SearchPath");

    public List<String> findPathsMeetingCost(int costTarget, BinaryNode root) {
        var solutionsPath = new LinkedList<String>();
        findPathsMeetingCost(costTarget, 0, root, "", solutionsPath);
        return solutionsPath;
    }

    public void findPathsMeetingCost(int costTarget, int cumCost, BinaryNode currentBinaryNode, String currentPath, List<String> solutionsPath) {
        var updatedPath = "";
        var updatedCumCost = currentBinaryNode.cost + cumCost;
        if (StringUtils.isBlank(currentPath)) {
            updatedPath = currentPath + currentBinaryNode.cost;
            logger.info(String.format("Updating path to %s", updatedPath));
        } else {
            updatedPath = currentPath + "-" + currentBinaryNode.cost;
            logger.info(String.format("Updating path to %s", updatedPath));
        }
        // The currentNode is a leaf
        if (currentBinaryNode.left == null && currentBinaryNode.right == null) {
            logger.info(String.format("Evaluating leaf with left null and right null at %s ", updatedPath));
            if (updatedCumCost == costTarget) {
                logger.info(String.format("Meeting target at %s", updatedPath));
                solutionsPath.add(updatedPath);
            }
            return;
        }
        if (currentBinaryNode.left != null) {
            findPathsMeetingCost(costTarget, updatedCumCost, currentBinaryNode.left, updatedPath, solutionsPath);
        } else {
            if (updatedCumCost == costTarget) {
                logger.info(String.format("Meeting target at %s", updatedPath));
                solutionsPath.add(updatedPath);
            }
        }
        if (currentBinaryNode.right != null) {
            findPathsMeetingCost(costTarget, updatedCumCost, currentBinaryNode.right, updatedPath, solutionsPath);
        } else {
            if (updatedCumCost == costTarget) {
                logger.info(String.format("Meeting target at %s", updatedPath));
                solutionsPath.add(updatedPath);
            }
        }
    }

}
