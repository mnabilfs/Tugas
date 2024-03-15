import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {
    //private String adminUsername;
    //private String adminPassword;
    private List<String> studentList;

    public Admin(String adminUsername, String adminPassword) {
        //this.adminUsername = adminUsername;
        //this.adminPassword = adminPassword;
        this.studentList = new ArrayList<>();
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name : ");
        String name = scanner.nextLine();

        System.out.print("Enter student NIM : ");
        String nim = scanner.nextLine();

        while(String.valueOf(nim).length() != 15){
            System.out.println("NIM harus 15 digit!");
            System.out.print("Enter your NIM : ");
            nim = scanner.next();
        }
        System.out.print("Enter student faculty : ");
        String faculty = scanner.nextLine();

        System.out.print("Enter student program study : ");
        String programStudi = scanner.nextLine();

        studentList.add("Name: " + name + ", NIM: " + nim + ", Faculty: " + faculty + ", Program Study: " + programStudi);
        Main.menuAdmin();
        scanner.close();
    }

    public void displayStudent() {
        System.out.println("List of Students : ");
        for (String student : studentList) {
            System.out.println(student);
        }
    }
}