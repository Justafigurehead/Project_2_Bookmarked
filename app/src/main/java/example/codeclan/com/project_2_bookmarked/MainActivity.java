package example.codeclan.com.project_2_bookmarked;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView allBooksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create new DBhandler
        DbHandler db = new DbHandler(this);

        Log.d("Books info", db.allBooksInfo());
        Log.d("Book count", db.getBookCount() + " books");


// Find by ids
        allBooksList = (ListView) findViewById(R.id.allBooks_lv);
        List<Book> allBooks = db.getAllBooks();
        ArrayAdapter<Book> bookArrayAdapter = new ArrayAdapter<Book>(MainActivity.this, android.R.layout.simple_list_item_1, allBooks);
        allBooksList.setAdapter(bookArrayAdapter);
        allBooksList.setOnItemClickListener(MainActivity.this);

        db.closeDB();
    }

    public void onItemClick(AdapterView<?> parent, View view, int i, long id){
        String toastText = "Book was clicked";

        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();

    }


}
