package patterns;

public class Person {

    private String firstName;

    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private Person(PersonBuilder personBuilder){
        this.firstName = personBuilder.firstName;
        this.lastName = personBuilder.lastName;
    }

    static class PersonBuilder {

        private String firstName;

        private String lastName;

        public PersonBuilder() {
        }

        public PersonBuilder withFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder withLastName(String lastName){
            this.lastName = lastName;
            return this;
        }

        public Person build(){
            return new Person(this);
        }

    }
}
