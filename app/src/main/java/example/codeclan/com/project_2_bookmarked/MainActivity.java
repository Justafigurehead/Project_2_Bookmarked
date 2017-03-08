package example.codeclan.com.project_2_bookmarked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    TextView countTV;
    Button createNewBook_Btn;
    Button viewAllBooks_Btn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();

        setContentView(R.layout.activity_main);


        createNewBook_Btn = (Button) findViewById(R.id.launcherAddBook_Btn);
        viewAllBooks_Btn = (Button) findViewById(R.id.launcherViewAllBooks_Btn);
        countTV = (TextView) findViewById(R.id.countTV);

        DbHandler db = new DbHandler(this);
        List<Book> allbooks = db.getAllBooks();
        countTV.setText(allbooks.size() +  " Books On Your List");
    }


    public void onLauncherButtonsClicked(View view){

        switch (view.getId()){
            case R.id.launcherAddBook_Btn :
                 intent = new Intent(this, addPop.class);
                break;
            case R.id.launcherViewAllBooks_Btn :
                 intent = new Intent(this, ListAllBooksActivity.class);
                break;
        }

        startActivity(intent);
        Log.d("Btn All books", "Clicked!");
    }
}
