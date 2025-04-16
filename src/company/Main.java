package company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];

        employees[0] = new Fulltime(1, "Nguyễn A", 24, "0966325998", "NguyenA@gmail.com", 1500000, 9000000, 500000);
        employees[1] = new Fulltime(2, "Nguyễn B", 28, "0369858797", "NguyenB@gmail.com", 2000000, 10000000, 1000000);
        employees[2] = new Fulltime(3, "Nguyễn C", 29, "0565444323", "NguyenC@gmail.com", 1000000, 9000000, 500000);
        employees[3] = new Fulltime(4, "Nguyễn D", 29, "0565444555", "NguyenD@gmail.com", 1700000, 11000000, 200000);
        employees[4] = new Fulltime(5, "Nguyễn E", 29, "0999999999", "NguyenE@gmail.com", 5000000, 22000000, 0);
        employees[5] = new Parttime(6, "Trần F", 38, "0785968888", "tranF8888@gmail.com", 80.5);
        employees[6] = new Parttime(7, "Trần G", 38, "0785969999", "tranG9999@gmail.com", 100);
        employees[7] = new Parttime(11, "Trần H", 38, "0785961111", "tranH1111@gmail.com", 98.5);
        employees[8] = new Parttime(12, "Trần I", 38, "0785962222", "tranI2222@gmail.com", 60);
        employees[9] = new Parttime(13, "Trần K", 38, "0785963333", "tranK3333@gmail.com", 70);

        Scanner sc = new Scanner(System.in);
        int choice = -1;
        while (choice != 0) {
            System.out.println();
            System.out.println("========================Menu========================");
            System.out.println("1. Tính trung bình lương của nhân viên cả công ty");
            System.out.println("2. Liệt kê nhân viên toàn thời gian có lương thấp hơn mức trung bình");
            System.out.println("3. Tính tổng lương phải trả cho nhân viên bán thời gian");
            System.out.println("4. Sắp xếp nhân viên toàn thời gian theo lương tăng dần");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.printf("Trung bình lương của cả công ty là: %.2f\n", averageSalary(employees));
                    break;
                case 2:
                    double average = averageSalary(employees);
                    System.out.println("Nhân viên fulltime có lương thấp hơn trung bình (" + average + "):");
                    fulltimeLowerAverageSalary(employees, average);
                    break;
                case 3:
                    System.out.printf("Tổng lương nhân viên parttime: %.2f\n", sumParttimeSalary(employees));
                    break;
                case 4:
                    sortFulltimeByAscendingSalary(employees);
                    break;
                case 0:
                    System.out.println("Đã thoát");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
        sc.close();
    }

    public static double averageSalary(Employee[] employees) {
        double sum = 0;
        for (Employee e : employees) {
            sum += e.payroll();
        }
        return sum / employees.length;
    }

    public static void fulltimeLowerAverageSalary(Employee[] employees, double averageSalary) {
        for (Employee e : employees) {
            if (e instanceof Fulltime && e.payroll() < averageSalary) {
                System.out.println(e);
            }
        }
    }
// tổng sốBán thời gianLương
    public static double sumParttimeSalary(Employee[] employees) {
        double sum = 0;
        for (Employee e : employees) {
            if (e instanceof Parttime) {
                sum += e.payroll();
            }
        }
        return sum;
    }

    public static void sortFulltimeByAscendingSalary(Employee[] employees) {
        // Đếm số lượng nhân viên fulltime
        int count = 0;
        for (Employee e : employees) {
            if (e instanceof Fulltime) count++;
        }

        // Tạo mảng chỉ chứa fulltime
        Fulltime[] fulltimes = new Fulltime[count];
        int index = 0;
        for (Employee e : employees) {
            if (e instanceof Fulltime) {
                fulltimes[index++] = (Fulltime)e;
            }
        }

        // Sắp xếp theo lương tăng dần
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (fulltimes[j].payroll() > fulltimes[j+1].payroll()) {
                    Fulltime temp = fulltimes[j];
                    fulltimes[j] = fulltimes[j+1];
                    fulltimes[j+1] = temp;
                }
            }
        }

        System.out.println("Danh sách nhân viên fulltime theo lương tăng dần:");
        for (Fulltime f : fulltimes) {
            System.out.printf("%s - Lương: %.2f\n", f, f.payroll());
        }
    }
}