package inter.patterns.trees;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class BinaryIntegerNode {

    private Integer value;

    private BinaryIntegerNode left;

    private BinaryIntegerNode right;

    @Override
    public String toString() {
        return "BinaryIntegerNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
