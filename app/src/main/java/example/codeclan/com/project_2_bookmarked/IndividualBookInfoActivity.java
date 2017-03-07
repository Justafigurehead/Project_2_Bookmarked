package example.codeclan.com.project_2_bookmarked;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IndividualBookInfoActivity extends AppCompatActivity {
    DbHandler db;

    TextView title_TV;
    TextView pageCount_TV;
    TextView dateAdded_TV;
    Button update_Btn;
    Book retrievedBook;
    String title;
    String pagecount;
    String dateAdded;
    String id;
    String readCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_book_info);

        title_TV = (TextView) findViewById(R.id.viewIndividualTitle_TV);
        pageCount_TV = (TextView) findViewById(R.id.viewIndividualPC_TV);
        dateAdded_TV = (TextView) findViewById(R.id.viewWhenAdded_TV);
        update_Btn = (Button) findViewById(R.id.update_on_individual_pg_btn);


        db = new DbHandler(this);

//getting intent extras back
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        id = extras.getString("id");
        int bookId = Integer.parseInt(id);

        retrievedBook = db.getBook(bookId);

        title = retrievedBook.getTitle();
        pagecount = retrievedBook.getPageCount().toString();
        dateAdded = retrievedBook.getDateAdded();
        readCount = retrievedBook.getCurrentlyread().toString();


        title_TV.setText(title);
        pageCount_TV.setText(pagecount);
        dateAdded_TV.setText(dateAdded);


    }

    public void onIndividualBtnCLicked(View view){
        Intent intent = new Intent(this, updateEntryActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("title", title);
        intent.putExtra("readCount", readCount);
        intent.putExtra("pagecount", pagecount);
        startActivity(intent);
    }


}
