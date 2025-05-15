package healthcalc.person;

public class DefaultPerson implements Person {
    private float weight;
    private float height;
    private int age;
    private Gender gender;

    public DefaultPerson(float weight, float height, int age, Gender gender) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public float weight() {
        return weight;
    }

    @Override
    public float height() {
        return height;
    }

    @Override
    public int age() {
        return age;
    }

    @Override
    public Gender gender() {
        return gender;
    }
}