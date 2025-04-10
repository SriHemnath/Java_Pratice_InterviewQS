package GeneralProblems.Pratice.HashSet;

import java.util.Objects;

public class Person {
    private final String name;
    private final String uuid;
    private final int age;
    private final int mobile;
    private final Address address;

    public Person(Address address, int age, int mobile, String name, String uuid) {
        this.address = address;
        this.age = age;
        this.mobile = mobile;
        this.name = name;
        this.uuid = uuid;
    }

    public Address getAddress() {
        return address;
    }

    public int getAge() {
        return age;
    }

    public int getMobile() {
        return mobile;
    }

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return age == person.age && mobile == person.mobile && Objects.equals(name, person.name) && Objects.equals(uuid, person.uuid) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, uuid, age, mobile, address);
    }

//************** MISSING name attribute****************//
//
//    @Override
//    public boolean equals(Object o) {
//        if (!(o instanceof Person person)) return false;
//        return age == person.age && mobile == person.mobile && Objects.equals(uuid, person.uuid) && Objects.equals(address, person.address);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(uuid, age, mobile, address);
//    }

    @Override
    public String toString() {
        return "Person{" +
                "address=" + address +
                ", name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                ", age=" + age +
                ", mobile=" + mobile +
                '}'+ '\n';
    }
}
