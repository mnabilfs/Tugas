// Source code is decompiled from a .class file using FernFlower decompiler.
class Book {
    private String id;
    private String title;
    private String author;
    private String category;
    private int loanDuration;
    private int stock;

    public Book(String var1, String var2, String var3, String var4, int var5) {
        this.id = var1;
        this.title = var2;
        this.author = var3;
        this.category = var4;
        this.stock = var5;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getCategory() {
        return this.category;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int var1) {
        this.stock = var1;
    }

    public int getLoanDuration() {
        return this.loanDuration;
    }

    public void setLoanDuration(int var1) {
        this.loanDuration = var1;
    }
}
