package structure;

import java.util.Objects;

public class Student {
    private int many;
    private int health;
    double time;

    public Student(int many, int health, double time) {
        this.many = many;
        this.health = health;
        this.time = time;
    }

    public Student(Student student) {
        this(student.getMany(), student.getHealth(), student.getTime());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return many == student.many &&
                health == student.health &&
                Double.compare(student.time, time) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(many, health, time);
    }

    public int getMany() {
        return many;
    }

    public void setMany(int many) {
        this.many = many;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
