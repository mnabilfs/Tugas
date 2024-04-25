import java.util.ArrayList;
import java.util.Iterator;
@SuppressWarnings({ "unchecked", "rawtypes" })
class User {
    
    protected static ArrayList<Book> bookList = new ArrayList();

    User() {
    }

    public void displayBooks() {
        System.out.println("List of Books:");
        System.out.println("================================================================");
        System.out.println("|| No. || Id Buku || Nama Buku || Author || Category || Stock ||");
        System.out.println("================================================================");
        int var1 = 1;

        for (Iterator var2 = bookList.iterator(); var2.hasNext(); ++var1) {
            Book var3 = (Book) var2.next();
            System.out.println("  || " + var1 + "        || " + var3.getId() + " || " + var3.getTitle() + " || "
                    + var3.getAuthor() + " || " + var3.getCategory() + "  || " + var3.getStock() + " ||");
        }

        System.out.println("================================================================");
    }
}