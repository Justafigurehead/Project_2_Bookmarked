package example.codeclan.com.project_2_bookmarked;


import java.util.Date;

public class Book {

    private String title;
    private Integer pageCount;
    private String dateAdded;

    public Book(String title, Integer pageCount, String date){
        this.title = title;
        this.pageCount = pageCount;
        this.dateAdded = date;

    }

    // getters
    public String getTitle() {
        return title;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public String getDateAdded() {
        return dateAdded;
    }
}
