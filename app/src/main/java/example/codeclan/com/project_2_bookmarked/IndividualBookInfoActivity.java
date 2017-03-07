package example.codeclan.com.project_2_bookmarked;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IndividualBookInfoActivity extends AppCompatActivity {
    DbHandler db;

    TextView title_TV;
    TextView pageCount_TV;
    TextView dateAdded_TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_book_info);

        title_TV = (TextView) findViewById(R.id.viewIndividualTitle_TV);
        pageCount_TV = (TextView) findViewById(R.id.viewIndividualPC_TV);
        dateAdded_TV = (TextView) findViewById(R.id.viewWhenAdded_TV);

        db = new DbHandler(this);

//getting intent extras back
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String id = extras.getString("Id");
        int bookId = Integer.parseInt(id);

        Book retrievedBook = db.getBook(bookId);


        String title = retrievedBook.getTitle();
        String pagecount = retrievedBook.getPageCount().toString();
        String dateAdded = retrievedBook.getDateAdded();
        title_TV.setText(title);
        pageCount_TV.setText(pagecount);
        dateAdded_TV.setText(dateAdded);


    }

}
