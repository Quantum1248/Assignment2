////////////////////////////////////////////////////////////////////
// [De Franceschi] [Manuel] [1162299]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;

public class User {
    private int id;
    private String name;
    private String surname;
    private int age;

    public User(int id, String name, String surname, int age) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Name is not valid");
        }
        if (surname == null || surname.length() == 0) {
            throw new IllegalArgumentException("Surname is not valid");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age must be > 0");
        }

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
}
