package fourth;

public class PrimarySchool implements School{

    private String name;

    public PrimarySchool(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Escuela : "+name;
    }
}
