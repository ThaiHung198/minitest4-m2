package company;

public class Fulltime extends Employee {
    private double basesalary; // Lương cứng
    private double fined;      // Tiền phạt
    private double bonus;      // Tiền thưởng

    // Constructor đầy đủ tham số
    public Fulltime(int id, String name, int age, String phoneNumber, String email,
                    double bonus, double basesalary, double fined) {
        super(id, name, age, phoneNumber, email); // Gọi constructor lớp cha Employee
        this.basesalary = basesalary;
        this.fined = fined;
        this.bonus = bonus;
    }

    public Fulltime(int id, String name, int age, String phoneNumber, String email) {
        super(id, name, age, phoneNumber, email);

    }

    public double getBasesalary() {
        return basesalary;
    }

    public void setBasesalary(double basesalary) {
        this.basesalary = basesalary;
    }

    public double getFined() {
        return fined;
    }

    public void setFined(double fined) {
        this.fined = fined;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Loại: Fulltime" +
                ", Lương cứng: " + basesalary +
                ", Phạt: " + fined +
                ", Thưởng: " + bonus +
                ", Lương thực lĩnh: " + tinhluongthuclinh();
    }

    @Override
    public double tinhluongthuclinh() {
        return this.basesalary + (this.bonus - this.fined);
    }
}