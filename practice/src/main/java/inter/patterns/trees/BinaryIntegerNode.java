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

    public BinaryIntegerNode(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BinaryIntegerNode{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
