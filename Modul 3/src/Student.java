
// Source code is decompiled from a .class file using FernFlower decompiler.
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

@SuppressWarnings("rawtypes")
class Student extends User {
    private String name;
    private String nim;
    private String faculty;
    private String program;
    private ArrayList<Book> borrowedBooks;
    private int loanDuration;

    @SuppressWarnings("unchecked")
    public Student(String var1, String var2, String var3, String var4) {
        this.name = var1;
        this.nim = var2;
        this.faculty = var3;
        this.program = var4;
        this.borrowedBooks = new ArrayList();
    }

    public Student(String var1) {
        Iterator var2 = Main.userStudent.iterator();

        while (var2.hasNext()) {
            Student var3 = (Student) var2.next();
            if (var3.getNim().equals(var1)) {
                this.name = var3.getName();
                this.nim = var3.getNim();
                this.faculty = var3.getFaculty();
                this.program = var3.getProgram();
                this.borrowedBooks = var3.getBorrowedBooks();
                break;
            }
        }

    }

    public String getNim() {
        return this.nim;
    }

    public void menuStudent(Scanner var1) {
        while (true) {
            System.out.println("\n=== Student Menu ===");
            System.out.println("1. Buku terpinjam");
            System.out.println("2. Pinjam buku");
            System.out.println("3. Pinjam Buku atau Logout");
            System.out.print("Choose option (1-3): ");
            switch (var1.nextLine()) {
                case "1":
                    System.out.println("Buku terpinjam:");
                    this.displayBorrowedBooks();
                    break;
                case "2":
                    this.displayBooks();
                    this.borrowBook(var1);
                    break;
                case "3":
                    System.out.println("System logout...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void borrowBook(Book var1) {
        this.borrowedBooks.add(var1);
    }

    public void returnBook(Book var1) {
        this.borrowedBooks.remove(var1);
    }

    public void displayBorrowedBooks() {
        if (this.borrowedBooks.isEmpty()) {
            System.out.println("No books currently borrowed.");
        } else {
            System.out.println("=================================================================================");
            System.out.println("|| No. || Id Buku        || Nama Buku    || Author       || Category   || Durasi ||");
            System.out.println("=================================================================================");
            int var1 = 1;

            for (Iterator var2 = this.borrowedBooks.iterator(); var2.hasNext(); ++var1) {
                Book var3 = (Book) var2.next();
                System.out.println("|| " + var1 + "  || " + var3.getId() + " || " + var3.getTitle() + " || "
                        + var3.getAuthor() + " || " + var3.getCategory() + " || " + var3.getLoanDuration() + " ||");
            }

            System.out.println("=================================================================================");
        }

    }

    
    public void displayBooks() {
        System.out.println("================================================================");
        System.out.println("|| No. || Id Buku        || Nama Buku || Author || Category || Stock ||");
        int var1 = 1;

        for (Iterator var2 = Main.bookList.iterator(); var2.hasNext(); ++var1) {
            Book var3 = (Book) var2.next();
            System.out.println("|| " + var1 + "   || " + var3.getId() + " || " + var3.getTitle() + "    || "
                    + var3.getAuthor() + " || " + var3.getCategory() + "  || " + var3.getStock() + " ||");
        }

        System.out.println("================================================================");
    }

    public void borrowBook(Scanner var1) {
        System.out.print("Input list buku yang ingin dipinjam: ");
        int var2 = Integer.parseInt(var1.nextLine()) - 1;
        if (var2 >= 0 && var2 < Main.bookList.size()) {
            Book var3 = (Book) Main.bookList.get(var2);
            System.out.print("Berapa lama buku akan dipinjam? (maksimal 14 hari):  ");
            int var4 = Integer.parseInt(var1.nextLine());
            if (var3.getStock() > 0) {
                var3.setStock(var3.getStock() - 1);
                var3.setLoanDuration(var4);
                this.borrowBook(var3);
                PrintStream var10000 = System.out;
                String var10001 = var3.getTitle();
                var10000.println("Buku '" + var10001 + "' berhasil dilakukan selama " + var4 + " hari.\nTerima Kasih...");
            } else {
                System.out.println("Stock buku kosong!\nSilahkan pilih yang lain.");
            }

        } else {
            System.out.println("Input salah.");
        }
    }

    public void setLoanDuration(int var1) {
        this.loanDuration = var1;
    }

    public int getLoanDuration() {
        return this.loanDuration;
    }

    public String getName() {
        return this.name;
    }

    public String getFaculty() {
        return this.faculty;
    }

    public String getProgram() {
        return this.program;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return this.borrowedBooks;
    }
}
