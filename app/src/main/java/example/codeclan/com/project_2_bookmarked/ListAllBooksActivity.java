package example.codeclan.com.project_2_bookmarked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;

public class ListAllBooksActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView allBooksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_books);

        //Create new DBhandler
        DbHandler db = new DbHandler(this);

        Log.d("Books info", db.allBooksInfo());
        Log.d("Book count", db.getBookCount() + " books");


// Find by ids
        allBooksList = (ListView) findViewById(R.id.allBooks_lv);
        List<Book> allBooks = db.getAllBooks();


        BookListAdapter bookArrayAdapter = new BookListAdapter(this, allBooks);

        allBooksList.setAdapter(bookArrayAdapter);
        allBooksList.setOnItemClickListener(this);

        db.closeDB();
    }

    public void onItemClick(AdapterView<?> parent, View view, int i, long id){
        String bookId = Integer.toString(allBooksList.getPositionForView(view) + 1);

        Intent intent = new Intent(this, IndividualBookInfoActivity.class);
        intent.putExtra("id", bookId);
        startActivity(intent);

        //On click to move to a new activity.

    }


}
