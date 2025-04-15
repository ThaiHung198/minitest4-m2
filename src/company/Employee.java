package company;

public abstract class Employee {
    protected int id;
    protected String name;
    protected int age;
    protected String phoneNumber;
    protected String email;

    public Employee(int id, String name, int age, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public abstract double tinhluongthuclinh();


    @Override
    public String toString() {
        return "Nhanvien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}

