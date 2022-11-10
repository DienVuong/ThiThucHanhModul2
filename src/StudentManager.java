import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class StudentManager {
    private ArrayList<Student> students;
    Scanner scanner = new Scanner(System.in);
    public StudentManager(){
      students = readFile();
    }
    Pattern p = Pattern.compile("^[a-zA-Z ]+$");
    Pattern p1 = Pattern.compile("^[0-9]+$");
    public void addStudent(Scanner scanner) {
        String code;

            System.out.println("Enter code student ");
            code = scanner.nextLine();
            for (Student s : students) {
                if (p1.matcher(code).find() && s.getCode().equals(code)) {
                    System.out.println("mã sinh vien dã có");
                    addStudent(scanner);
                }
            }
        String name;
        while (true) {
            System.out.println("Enter name student: ");
            name = scanner.nextLine();
            if(p.matcher(name).find()){
                break;
            }
        }
        int age;
        while (true) {
            try {
                System.out.println("Enter age student");
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 17 && age <= 50) {
                    break;
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        String gender;
        while (true) {
            System.out.println("Enter gender student: ");
            gender = scanner.nextLine();
            if(p.matcher(gender).find()){
                break;
            }
        }
        String address;
        while (true) {
            System.out.println("Enter address student: ");
            address = scanner.nextLine();
            if(p.matcher(address).find()){
                break;
            }
        }
        double marksAvg;
        while (true) {
            try{
                System.out.println("Enter marksAvg student: ");
                marksAvg = Double.parseDouble(scanner.nextLine());
                if (marksAvg >= 0.0 && marksAvg <= 10.0) {
                    break;
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }

        students.add(new Student(code,name, age, gender, address, marksAvg ));
        writeFile();
    }


    public void updateStudent( Scanner scanner){
        try{
            System.out.println("Enter code of student you want update: ");
            String code = scanner.nextLine();
            Student studentUpdate;
            if((studentUpdate = checkExist(code)) != null){
                System.out.println("Nhập mã sinh viên mới");
                 code = scanner.nextLine();
                if(!code.equals("") && p1.matcher(code).find()){
                    studentUpdate.setCode(code);
                }
                System.out.println("Nhập tên của sinh viên mới ");
                String name = scanner.nextLine();
                if(!name.equals("") && p1.matcher(name).find()){
                    studentUpdate.setName(name);
                }
                System.out.println("Nhập tuổi của sinh viên mới");
                String age = scanner.nextLine();
                if(!age.equals("")){
                    studentUpdate.setAge(Integer.parseInt(age));
                }
                System.out.println("Nhập giới tính của sinh viên mới");
                String gender = scanner.nextLine();
                if(!gender.equals("")){
                    studentUpdate.setGender(gender);
                }
                System.out.println("Nhập địa ch của sinh viên mới");
                String address = scanner.nextLine();
                if(!address.equals("")){
                    studentUpdate.setAddress(address);
                }
                System.out.println("Nhập điểm trung bình của sinh viên mới");
                String marksAvg = scanner.nextLine();
                if(!marksAvg.equals("")){
                    studentUpdate.setMarksAvg(Double.parseDouble(marksAvg));
                }

                writeFile();
            }else{
                System.out.println(" Không có mã sinh viên, mời bạn nhập lại mã sinh viên ");
            }

        }catch( NumberFormatException | InputMismatchException e){
            System.err.println(e.getMessage());
        }
    }

    public void deleteStudent(Scanner scanner){
        try{
            System.out.println("Nhập mã sinh viên cần xóa");
            String code = scanner.nextLine();
            Student studentDelete;
            if((studentDelete = checkExist(code)) != null ) {
                System.out.println("Bạn cắc chán muốn xóa sinh viên này không , Nhập Y để xóa");
                String choice1 = scanner.nextLine();
                if(choice1.equals("Y")) {
                    students.remove(studentDelete);
                }
                writeFile();
            } else{
                System.out.println("không tìm được sinh viên với mã sinh viên trên");
            }
        }catch( NumberFormatException | InputMismatchException e){
            System.err.println(e.getMessage());
        }
    }

    public void display(){
        System.out.printf("%-5s%-25s%-15s%-20s%-20s%s", "ID", "Name", "Age", "Gender", "Address", "MarksAvg\n");
        for (Student s : students) {
            s.display();
            System.out.println();
        }
    }





    public void displayByMarksSortDown(){
        System.out.printf("%-5s%-25s%-15s%-20s%-20s%s", "ID", "Name", "Age", "Gender", "Address", "MarksAvg\n");
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o2.getMarksAvg() - o1.getMarksAvg());
            }
        });
        for(Student s : students)
            s.display();
        System.out.println();
    }

    public void displayByMarksSortUp(){
        System.out.printf("%-5s%-25s%-15s%-20s%-20s%s", "ID", "Name", "Age", "Gender", "Address", "MarksAvg\n");
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getMarksAvg() - o2.getMarksAvg());
            }
        });
        for(Student s : students)
            s.display();
        System.out.println();
    }



    private Student checkExist(String code){
        for(Student s : students){
            if(s.getCode().equals(code)){
                return s;
            }
        }return null;
    }

    public void writeFile(){
        File file = new File("src/FileSave");
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file))){
            objectOutputStream.writeObject(students);
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
    }

    public ArrayList<Student> readFile(){
        File file =new File("src/FileSave");
        ArrayList<Student> studentArrayList = new ArrayList<>();
        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            if(fileInputStream.available() > 0){
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                studentArrayList = (ArrayList<Student>) objectInputStream.readObject();
            }
            return studentArrayList;
        }catch (IOException | ClassNotFoundException e){
            System.err.println(e.getMessage());
        }
        return studentArrayList;
    }
}
