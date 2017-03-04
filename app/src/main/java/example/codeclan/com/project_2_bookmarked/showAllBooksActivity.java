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

        Book book1 = new Book("Book1", 300, "March");
        db.addBook(book1);
//
//        List<Book> allBooks = db.getAllBooks();
//
//        for (Book book : allBooks) {
//            Log.d("all my books", book.getTitle());
//        }

        db.closeDB();
    }

}
