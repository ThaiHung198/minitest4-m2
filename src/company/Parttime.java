package company;

public class Parttime extends Employee {
    private double WorkingHours;
    private final double HourlyWage = 100000;
    public Parttime(int id, String name, int age, String phoneNumber, String email, double WorkingHours) {
        super(id, name, age, phoneNumber, email);
        this.WorkingHours = WorkingHours;
    }

    public Parttime(int id, String name, int age, String phoneNumber, String email) {
        super(id, name, age, phoneNumber, email);
    }


    public double getWorkingHours() {
        return WorkingHours;
    }

    public void setWorkingHours(int WorkingHours) {
        this.WorkingHours = WorkingHours;
    }

    @Override
    public double payroll() {
        return this.WorkingHours * HourlyWage;
    }

    @Override
    public String toString() {
        return super.toString() +
                "NhanvienParttime{" +
                "gioLamViec=" + WorkingHours +
                ", luongThucLinh=" + payroll() +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
