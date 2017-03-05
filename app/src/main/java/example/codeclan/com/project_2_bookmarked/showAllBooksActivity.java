package example.codeclan.com.project_2_bookmarked;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class showAllBooksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_books);

        DbHandler db = new DbHandler(this);
        List<Book> allBooks = db.getAllBooks();

        for (Book book : allBooks) {
            Log.d("all my books", book.getTitle());
        }


        db.updateBookEntry(1, "Empire of the sun", 360);
        List<Book> manybooks = db.getAllBooks();
        for (Book book : manybooks){
            Log.d("All my Books & update", book.getTitle());
        }
        db.closeDB();
    }

}
