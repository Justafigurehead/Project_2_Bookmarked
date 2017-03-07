package example.codeclan.com.project_2_bookmarked;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addPop extends Activity {
    DbHandler db;
    Button addBtn;
    EditText title_EV;
    EditText pagecount_EV;
    EditText dateAdded_EV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pop);

        addBtn = (Button) findViewById(R.id.addNewBookBtn_POP);
        title_EV = (EditText) findViewById(R.id.bookTitle_EV);
        pagecount_EV = (EditText) findViewById(R.id.bookPageCount_EV);
        dateAdded_EV = (EditText) findViewById(R.id.bookDateAdded_EV);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height *.6));
    }

    public void onAddBookBtnClicked(View view){

        db = new DbHandler(this);
        String title = title_EV.getText().toString();
        int pagecount = Integer.parseInt(pagecount_EV.getText().toString());
        String dateAdded = dateAdded_EV.getText().toString();

        Book book = new Book(title, pagecount, dateAdded);
        db.addBook(book);

        Intent intent = new Intent(this, ListAllBooksActivity.class);
        startActivity(intent);
    }
}
