package example.codeclan.com.project_2_bookmarked;


import java.util.Date;

public class Book {

     int id;
     String title;
     int currentlyread;
     int pageCount;
     String dateAdded;

    public Book(){

    }

    public Book(int id, String title, int pageCount,String dateAdded){
        this.title = title;
        this.currentlyread = 0;
        this.pageCount = pageCount;
        this.dateAdded = dateAdded;
    }

    public Integer getCurrentlyread() {
        return currentlyread;
    }

    public void setCurrentlyread(int currentlyread) {
        this.currentlyread = currentlyread;
    }

    public Book(String title, int pageCount, String dateAdded){
        this.title = title;
        this.currentlyread = 0;
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
