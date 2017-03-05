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

            Log.d("All my Books", db.allBooksInfo());
            Log.d("Book count", db.getBookCount() + " books");
        db.closeDB();
    }

}
