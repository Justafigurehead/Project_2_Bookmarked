package example.codeclan.com.project_2_bookmarked;


import java.util.Date;

public class Book {

     int id;
     String title;
     int pageCount;
     String dateAdded;

    public Book(){

    }

    public Book(int id, String title, int pageCount,String dateAdded){
        this.title = title;
        this.pageCount = pageCount;
        this.dateAdded = dateAdded;
    }

    public Book(String title, int pageCount, String dateAdded){
        this.title = title;
        this.pageCount = pageCount;
        this.dateAdded = dateAdded;

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

    public int getId() {
        return id;
    }

    //

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }


}
