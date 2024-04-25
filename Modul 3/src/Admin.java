
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Iterator;
import java.util.Scanner;

class Admin extends User {
    Admin() {
    }

    public void menuAdmin(Scanner var1) {
        if (this.loginAdmin(var1)) {
            while (true) {
                System.out.println("=== Admin Menu ===");
                System.out.println("1. Tambah Mahasiswa");
                System.out.println("2. Lihat Daftar Mahasiswa");
                System.out.println("3. Tambah Buku");
                System.out.println("4. Lihat Daftar Buku");
                System.out.println("5. Keluar");
                System.out.print("Choose option (1-5): ");
                switch (var1.nextLine()) {
                    case "1":
                        this.addStudent(var1);
                        break;
                    case "2":
                        this.displayStudent();
                        break;
                    case "3":
                        this.addBook(var1);
                        break;
                    case "4":
                        this.displayBookList();
                        break;
                    case "5":
                        System.out.println("Logging out from admin account.");
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } else {
            System.out.println("Admin login failed. Exiting.");
        }
    }

    private boolean loginAdmin(Scanner var1) {
        System.out.print("Enter admin username: ");
        String var2 = var1.nextLine();
        System.out.print("Enter admin password: ");
        String var3 = var1.nextLine();
        return var2.equals("admin") && var3.equals("admin123");
    }

    public void addStudent(Scanner var1) {
        System.out.println("Enter student details:");
        System.out.print("Enter student name: ");
        String var2 = var1.nextLine();

        String var3;
        do {
            System.out.print("Enter student NIM: ");
            var3 = var1.nextLine();
            if (var3.length() != 15) {
                System.out.println("NIM must be 15 digits.");
            }
        } while (var3.length() != 15);

        System.out.print("Enter student faculty: ");
        String var4 = var1.nextLine();
        System.out.print("Enter student program: ");
        String var5 = var1.nextLine();
        Main.userStudent.add(new Student(var2, var3, var4, var5));
        System.out.println("Student successfully registered.");
    }

    @SuppressWarnings("rawtypes")
    public void displayStudent() {
        System.out.println("List of Registered Students:");
        Iterator var1 = Main.userStudent.iterator();

        while (var1.hasNext()) {
            Student var2 = (Student) var1.next();
            System.out.println("Nama: " + var2.getName());
            System.out.println("Fakultas: " + var2.getFaculty());
            System.out.println("NIM: " + var2.getNim());
            System.out.println("Prodi: " + var2.getProgram());
            System.out.println();
        }

    }

    public void addBook(Scanner var1) {
        System.out.println("Choose book category:");
        System.out.println("1. Story Book");
        System.out.println("2. History Book");
        System.out.println("3. Text Book");
        System.out.println("4. Keluar");
        System.out.print("Enter choice (1-4): ");
        String var3;
        switch (var1.nextLine()) {
            case "1":
                var3 = "Story Book";
                break;
            case "2":
                var3 = "History Book";
                break;
            case "3":
                var3 = "Text Book";
                break;
            case "4":
                System.out.println("System logout...");
                return;
            default:
                System.out.println("Invalid choice");
                var3 = null;
        }

        System.out.println("Enter book details:");
        System.out.print("Enter book ID: ");
        String var4 = var1.nextLine();
        System.out.print("Enter book title: ");
        String var8 = var1.nextLine();
        System.out.print("Enter book author: ");
        String var6 = var1.nextLine();
        System.out.print("Enter book stock: ");
        int var7 = Integer.parseInt(var1.nextLine());
        Main.bookList.add(new Book(var4, var8, var6, var3, var7));
        System.out.println("Book successfully added to the library.");
    }

    @SuppressWarnings("rawtypes")
    public void displayBookList() {
        System.out.println("List of Books:");
        System.out.println("================================================================");
        System.out.println("|| No. || Id Buku || Nama Buku || Author || Category || Stock ||");
        int var1 = 1;

        for (Iterator var2 = Main.bookList.iterator(); var2.hasNext(); ++var1) {
            Book var3 = (Book) var2.next();
            System.out.println("|| " + var1 + "  || " + var3.getId() + " || " + var3.getTitle() + " || "
                    + var3.getAuthor() + " || " + var3.getCategory() + "  || " + var3.getStock() + " ||");
        }

        System.out.println("================================================================");
    }
}
