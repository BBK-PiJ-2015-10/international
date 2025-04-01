package veinteream;

import java.util.logging.Logger;

public class CountVisits {

    private Logger logger = Logger.getLogger(this.getClass().getName());


    class VisitNode {
        public int visits = 0;
        public VisitNode north;
        public VisitNode south;
        public VisitNode east;
        public VisitNode west;

        public VisitNode() {
        }

        public void visitNode() {
            visits++;
        }

    }

    private VisitNode processNode(VisitNode existingNode, Character direction) {
        var nextNode = switch (direction) {
            // case north
            case '^' -> {
                var northNode = existingNode.north;
                if (northNode == null) {
                    northNode = new VisitNode();
                    northNode.south = existingNode;
                }
                northNode.visitNode();
                logger.info(String.format("Went north with visits %d", northNode.visits));
                yield northNode;
            }
            // case south
            case 'v' -> {
                var southNode = existingNode.south;
                if (southNode == null) {
                    southNode = new VisitNode();
                    southNode.north = existingNode;
                }
                southNode.visitNode();
                logger.info(String.format("Went south with visits %d", southNode.visits));
                yield southNode;
            }
            // case east
            case '>' -> {
                var eastNode = existingNode.east;
                if (eastNode == null) {
                    eastNode = new VisitNode();
                    eastNode.west = existingNode;
                }
                eastNode.visitNode();
                logger.info(String.format("Went east with visits %d", eastNode.visits));
                yield eastNode;
            }
            // case west;
            default -> {
                var westNode = existingNode.west;
                if (westNode == null) {
                    westNode = new VisitNode();
                    westNode.east = existingNode;
                }
                westNode.visitNode();
                logger.info(String.format("Went west with visits %d", westNode.visits));
                yield westNode;
            }
        };
        return nextNode;
    }


    /**
     * instructions (^,<,>,v) using (N,S,E,W)
     *
     * @return
     */
    public int countVisits(String route) {
        var chars = route.toCharArray();
        int maxVisits = 0;
        VisitNode node = new VisitNode();
        node.visitNode();
        for (int i = 0; i < chars.length; i++) {
            Character direction = chars[i];
            node = processNode(node, direction);
            if (node.visits > maxVisits) {
                maxVisits = node.visits;
            }
        }
        return maxVisits;
    }


}
