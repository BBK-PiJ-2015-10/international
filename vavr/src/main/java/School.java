import java.util.ArrayList;
import java.util.List;

public class School {

    private String name;

    private String location;

    private List<Person> students;

    public School(String name, String location, List<Person> students) {
        this.name = name;
        this.location = location;
        this.students = new ArrayList<>(students);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }
}
