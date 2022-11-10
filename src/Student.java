import java.io.Serializable;

public class Student implements Serializable {
    private String code;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double marksAvg;

    public Student(String code,String name, int age, String gender,String address, double marksAvg) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.marksAvg = marksAvg;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getMarksAvg() {
        return marksAvg;
    }

    public void setMarksAvg(double marksAvg) {
        this.marksAvg = marksAvg;
    }


    @Override
    public String toString() {
            return "Student{" +
                    "code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    ", gender='" + gender + '\'' +
                    ", address='" + address + '\'' +
                    ", marksAvg='" + marksAvg + '\'' +
                    '}';

    }

    public void display(){
            System.out.printf("%-5s%-25s%-15s%-20s%-20s%s", code, name, age, gender, address, marksAvg +"\n" );
        }

}
