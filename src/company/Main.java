package company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee[] dsnhanvien = new Employee[10];

        dsnhanvien[0] = new Fulltime(1, "Nguyễn A", 24, "0966325998", "NguyenA@gmail.com", 1500000, 9000000, 500000);
        dsnhanvien[1] = new Fulltime(2, "Nguyễn B", 28, "0369858797", "NguyenB@gmail.com", 2000000, 10000000, 1000000);
        dsnhanvien[2] = new Fulltime(3, "Nguyễn C", 29, "0565444323", "NguyenC@gmail.com", 1000000, 9000000, 500000);
        dsnhanvien[3] = new Fulltime(4, "Nguyễn D", 29, "0565444555", "NguyenD@gmail.com", 1700000, 11000000, 200000); // Sửa Email nếu cần
        dsnhanvien[4] = new Fulltime(5, "Nguyễn E", 29, "0999999999", "NguyenE@gmail.com", 5000000, 22000000, 0); // Sửa tên/email nếu cần
        dsnhanvien[5] = new Parttime(6, "Trần F", 38, "0785968888", "tranF8888@gmail.com", 80.5); // Sửa tên/email nếu cần
        dsnhanvien[6] = new Parttime(7, "Trần G", 38, "0785969999", "tranG9999@gmail.com", 100); // Sửa tên/email nếu cần
        dsnhanvien[7] = new Parttime(11, "Trần H", 38, "0785961111", "tranH1111@gmail.com", 98.5); // Sửa tên/email nếu cần
        dsnhanvien[8] = new Parttime(12, "Trần I", 38, "0785962222", "tranI2222@gmail.com", 60); // Sửa tên/email nếu cần
        dsnhanvien[9] = new Parttime(13, "Trần K", 38, "0785963333", "tranK3333@gmail.com", 70); // Sửa tên/email nếu cần


        Scanner sc = new Scanner(System.in);
        int choice = -1;

        do {
            System.out.println("\n===== Quản lý nhân viên =====");
            System.out.println("1. Tính Trung bình lương của nhân viên cả công ty");
            System.out.println("2. Liệt kê danh sách nhân viên Fulltime có mức lương thấp hơn mức lương trung bình của các nv trong công ty");
            System.out.println("3. Tính tổng số lương phải trả cho nhân viên Parttime");
            System.out.println("4. Sắp xếp nhân viên Fulltime theo số lương tăng dần");
            System.out.println("0. Thoát");
            System.out.println("===============================");
            System.out.print("Mời Sếp nhập vô đây: ");


            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("\n---[1] Lương trung bình toàn Công Ty ---");
                        double tongLuongCongTy = 0;
                        int countNhanVien = 0;
                        for (Employee nv : dsnhanvien) {
                            if (nv != null) {
                                tongLuongCongTy += nv.tinhluongthuclinh();
                                countNhanVien++;
                            }
                        }

                        if (countNhanVien > 0) {
                            double luongTrungBinhCongTy = tongLuongCongTy / countNhanVien;
                            // --- Sửa lỗi printf ---
                            System.out.printf("Tổng lương toàn công ty: ", tongLuongCongTy); // Thêm định dạng và \n
                            System.out.println("Số lượng nhân viên: " + countNhanVien);
                            System.out.printf("Lương trung bình toàn công ty: ", luongTrungBinhCongTy); // Thêm định dạng và \n
                        } else {
                            System.out.println("Danh sách nhân viên trống.");
                        }
                        break;

                    case 2:
                        System.out.println("\n--- [2] Liệt kê nv Fulltime lương thấp hơn TB Fulltime ---");
                        double tongLuongFulltime = 0;
                        int soLuongNvFulltime = 0;
                        for (Employee nv : dsnhanvien) {
                            if (nv != null && nv instanceof Fulltime) {
                                tongLuongFulltime += nv.tinhluongthuclinh();
                                soLuongNvFulltime++;
                            }
                        }
                        if (soLuongNvFulltime == 0) {
                            System.out.println("Không có nhân viên Fulltime nào trong danh sách.");
                        } else {
                            double luongTrungBinhFulltime = tongLuongFulltime / soLuongNvFulltime;
                            System.out.printf("Lương trung bình của Nv Fulltime: ", luongTrungBinhFulltime);

                            boolean timthay = false;
                            System.out.println("Danh sách Nv Fulltime có lương thấp hơn mức trung bình trên:");
                            for (Employee nv : dsnhanvien) {
                                if (nv != null && nv instanceof Fulltime && nv.tinhluongthuclinh() < luongTrungBinhFulltime) {
                                    System.out.println(nv);
                                    timthay = true;
                                }
                            }
                            if (!timthay) {
                                System.out.println("Không có Nv Fulltime nào có lương thấp hơn mức trung bình.");
                            }
                        }
                        break;

                    case 3:
                        System.out.println("\n--- [3] Tổng lương phải trả cho NV Parttime---");
                        double tongLuongParttime = 0;
                        int soLuongNvParttime = 0;
                        for (Employee nv : dsnhanvien) {
                            if (nv != null && nv instanceof Parttime) {
                                tongLuongParttime += nv.tinhluongthuclinh();
                                soLuongNvParttime++;
                            }
                        }
                        System.out.println(" Số lượng nv Parttime: " + soLuongNvParttime);

                        System.out.printf("Tổng lương phải trả cho NV Parttime: %,.0f\n", tongLuongParttime);
                        break;

                    case 4:
                        System.out.println("\n--- [4] Sắp xếp Nv Fulltime theo lương tăng dần ---");
                        int countFulltime = 0;
                        for (Employee nv : dsnhanvien) {
                            if (nv != null && nv instanceof Fulltime) {
                                countFulltime++;
                            }
                        }
                        if (countFulltime == 0) {
                            System.out.println("Không có nhân viên Fulltime nào để sắp xếp");
                        } else {
                            Fulltime[] NvFulltime = new Fulltime[countFulltime];
                            int indexFulltime = 0;
                            for (Employee nv : dsnhanvien) {
                                if (nv != null && nv instanceof Fulltime) {
                                    NvFulltime[indexFulltime++] = (Fulltime) nv;
                                }
                            }
                            Arrays.sort(NvFulltime, Comparator.comparingDouble(Fulltime::tinhluongthuclinh));
                            System.out.println("Danh sách Nv Fulltime sau khi sắp xếp theo lương tăng dần:");
                            for (Fulltime nvft : NvFulltime) {
                                System.out.println(nvft);
                            }
                        }
                        break;

                    case 0:
                        System.out.println("Tạm biệt Sếp!!!");
                        break;

                    default:
                        System.out.println("Lựa chọn không hợp lệ, chọn lại đi sếp");
                        break;
                }


            } catch (InputMismatchException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ!");
                sc.nextLine(); // Quan trọng: đọc bỏ dòng nhập sai
                choice = -1; // Đặt lại để vòng lặp tiếp tục
            } catch (Exception e) { // Bắt các lỗi khác nếu có
                System.out.println("Đã xảy ra lỗi: " + e.getMessage());
                e.printStackTrace(); // In chi tiết lỗi để debug
                choice = -1;
            }

        } while (choice != 0);

        sc.close();
    }
}