import java.util.Scanner;

public class StudentSystem {


    public static void main(String[] args) {
        StudentSystem studentSystem = new StudentSystem();
        StudentManager studentManager =new StudentManager();
        Scanner scanner = new Scanner(System.in);
            do{
                System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN-----");
                System.out.println("1. Xem danh sách sinh viên");
                System.out.println("2. Thêm mới");
                System.out.println("3. Cập nhật");
                System.out.println("4. Xóa");
                System.out.println("5. Sắp xếp");
                System.out.println("6. Đọc từ file");
                System.out.println("7. Ghi vào file");
                System.out.println("8. Thoát");
                System.out.println("Chọn chức năng");
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 0) {
                        break;
                    } else {
                        if (choice < 0 || choice > 8) {
                            System.out.println("Nhập lựa chọn từ 1 - 8, Bạn hãy chọn lại");
                        }
                        switch (choice) {
                            case 1:
                                studentManager.display();
                                break;
                            case 2:
                                studentManager.addStudent(scanner);
                                break;
                            case 3:
                                studentManager.updateStudent(scanner);
                                break;
                            case 4:
                                studentManager.deleteStudent(scanner);
                                break;
                            case 5:
                                menuSortMarksAvg(studentManager);
                                break;
                            case 6:
                                studentManager.readFile1();
                                break;
                            case 7:
                                studentManager.writeFile1();
                                break;
                            case 8:
                                System.exit(8);
                        }
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            } while (true);
        }

        public static void menuSortMarksAvg (StudentManager studentManager){
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("----Sắp xếp sinh viên theo điểm trung bình-----");
                System.out.println("1. Sắp xếp điểm trung bình tăng dần");
                System.out.println("2. Sắp xếp điểm trung bình giảm dần");
                System.out.println("3. thoat");
                System.out.println("Chọn chức năng");
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 3) {
                        break;
                    } else {
                        if (choice < 0 || choice > 3) {
                            System.out.println("Nhập lựa chọn từ 1 - 3, Bạn hãy chọn lại");
                        }
                        switch (choice) {
                            case 1:
                                studentManager.displayByMarksSortUp();
                                break;
                            case 2:
                                studentManager.displayByMarksSortDown();
                                break;
                        }

                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            } while (true);
        }
    }

