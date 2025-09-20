package memoryleaks;

// Java code​​​​​​‌‌‌​​​​‌‌​‌​‌‌‌​​‌​‌​‌‌‌‌ below
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

// Write your answer here, and then test your code.
// Your job is to implement the equals and hashCode method

class Answer {

    // Change these boolean values to control whether you see
    // the expected result and/or hints.
    static boolean showExpectedResult = false;
    static boolean showHints = false;

    static PotentialMemoryLeakHashSet createPotentialMemoryLeakHashSet() {
        // Your code goes here.
        return new PotentialMemoryLeakHashSet();
    }

}

class PotentialMemoryLeakHashSet {
    private Set<CustomObject> objects = new HashSet<>();

    public void addObject(CustomObject obj) {
        objects.add(obj);
    }

    public int getObjectsSize() {
        return objects.size();
    }
}

class CustomObject {
    private String data;

    public CustomObject(String data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomObject that = (CustomObject) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }
// Your task: Implement hashCode and equals methods

}
