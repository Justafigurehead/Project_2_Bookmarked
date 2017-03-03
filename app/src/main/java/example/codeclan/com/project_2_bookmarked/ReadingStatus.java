package example.codeclan.com.project_2_bookmarked;

/**
 * Created by user on 03/03/2017.
 */

public enum ReadingStatus {
    READING("Currently Reading"),
    COMPLETED("Completed"),
    ABANDONED("Abandoned");

    private String text;

    ReadingStatus(String text){
        this.text = text;
    }
}
