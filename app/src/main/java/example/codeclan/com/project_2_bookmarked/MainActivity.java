package example.codeclan.com.project_2_bookmarked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
    ListView allBooksList;

    Button createNewBook_Btn;
    Button viewAllBooks_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNewBook_Btn = (Button) findViewById(R.id.launcherAddBook_Btn);
        viewAllBooks_Btn = (Button) findViewById(R.id.launcherViewAllBooks_Btn);
    }


    public void onAllBooksClick(View view){
        Intent intent = new Intent(this, ListAllBooksActivity.class);
        startActivity(intent);
        Log.d("Btn All books", "Clicked!");
    }

    public void addButton_Click(View view){
        Intent intent = new Intent(this, addPop.class);
        startActivity(intent);
        Log.d("Btn Add Book", "Clicked");
    }
}
