package modul4.tugas.com.main;

import modul4.tugas.books.*;
import modul4.tugas.data.Admin;
import modul4.tugas.data.Student;
import modul4.tugas.data.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    // menyimpan semua object dalam satu array dengan teknik polymorphism
    public static Book daftarBuku[] = new Book[100]; // array satu dimensi untuk menyimpan buku
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static int i = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        daftarBuku[i++] = new StoryBook("SB32F", "Laskar Pelangi", 17, "Story", "Hoshino");
        daftarBuku[i++] = new HistoryBook("HB324", "Insecurity", 2, "Motivation", "Shiroko");
        daftarBuku[i++] = new TextBook("TB323", "Word War 2", 4, "History", "Chinatsu");

        // Mengisi daftar mahasiswa
        studentList.add(0, new Student("202310370311258", "Dapa Maulana", "Teknik","Informatika"));
        studentList.add(1, new Student("202310370311259", "Muhammad Nabil", "Teknik","Informatika"));
        studentList.add(2, new Student("202310370311299", "Thariq Abdurrahman", "Teknik","Informatika"));

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("===== Library System =====");
            System.out.println("1. Login sebagai Mahasiswa");
            System.out.println("2. Login sebagai Admin");
            System.out.println("3. Keluar");
            System.out.print("Pilih antara (1-3): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Eneter NIM : ");
                    String nimStudent = scanner.next();
                    scanner.nextLine();
                    while(true){
                        if (nimStudent.length() != 15 ) {
                            System.out.print("Nim must be 15 Digit!!!\n");
                            System.out.print("Enter NIM : ");
                            nimStudent = scanner.nextLine();

                        } else if (checkNim(nimStudent)){
                            Student student = new Student(nimStudent);
                            student.login();
                            break;
                        } else {
                            System.out.println("Nim tidak terdaftar!");
                            break;
                        }
                    }
                    break;
                case 2:
                    Admin admin = new Admin();
                    admin.login();
                    break;
                case 3:
                    System.out.println("Thank you. Exiting program.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    public static boolean checkNim(String nim) {
        for (Student student : studentList) {
            if (student.getNim().equals(nim)) {
                return true;
            }
        }
        return false;
    }
}
