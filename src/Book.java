public class Book {
    private String title;
    private String author;
    private int year;
    private int pages;
    private boolean available;

    public Book(String title, String author, int year, int pages, boolean available) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Title: "+title +", author: "+author+", year: "
                +year+", pages: "+pages+", available: "+available;
    }
}
