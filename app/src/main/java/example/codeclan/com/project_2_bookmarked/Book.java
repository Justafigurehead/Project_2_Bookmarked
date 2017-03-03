package example.codeclan.com.project_2_bookmarked;


import java.util.Date;

public class Book {

    private String title;
    private Integer pageCount;
    private ReadingStatus readingStatus;
    private Date dateAdded;

    public Book(String title, Integer pageCount, ReadingStatus readingStatus, Date date){
        this.title = title;
        this.pageCount = pageCount;
        this.readingStatus = readingStatus;
        this.dateAdded = date;

    }
}
