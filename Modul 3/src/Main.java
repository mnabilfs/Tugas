import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
@SuppressWarnings({ "rawtypes", "unchecked" })
class Main {
    static ArrayList<Book> bookList = new ArrayList();
    
    static ArrayList<Student> userStudent = new ArrayList();

    Main() {
    }

    public static void main(String[] var0) {
        initializeData();
        Scanner var1 = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Library System =====");
            System.out.println("1. Login as Student");
            System.out.println("2. Login as Admin");
            System.out.println("3. Exit");
            System.out.print("Choose option (1-3): ");
            switch (var1.nextLine()) {
                case "1":
                    inputNim(var1);
                    break;
                case "2":
                    Admin var5 = new Admin();
                    var5.menuAdmin(var1);
                    break;
                case "3":
                    System.out.println("Thank you. Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public static void inputNim(Scanner var0) {
        System.out.print("Enter your NIM (input 99 for back): ");
        String var1 = var0.nextLine();
        if (!var1.equals("99")) {
            if (checkNim(var1)) {
                Student var2 = new Student(var1);
                var2.menuStudent(var0);
            } else {
                System.out.println("Invalid NIM. Please try again.");
                inputNim(var0);
            }

        }
    }

    public static boolean checkNim(String var0) {
        Iterator var1 = userStudent.iterator();

        Student var2;
        do {
            if (!var1.hasNext()) {
                return false;
            }

            var2 = (Student) var1.next();
        } while (!var2.getNim().equals(var0));

        return true;
    }

    public static void initializeData() {
        bookList.add(new Book("388c-e681-9152", "title1", "author1", "Sejarah", 8));
        bookList.add(new Book("ed90-be30-5cdb", "title2", "author2", "Sejarah", 11));
        bookList.add(new Book("d95e-0c4a-9523", "title3", "author3", "Sejarah", 3));
        userStudent.add(new Student("Taufiq Ramadhan", "202210370311288", "Teknik", "Informatika"));
        userStudent.add(new Student("Who", "202310370311135", "Teknik", "Informatika"));
        userStudent.add(new Student("Sutrisno Adit Pratama", "202210370311203", "Teknik", "Informatika"));
    }
}
