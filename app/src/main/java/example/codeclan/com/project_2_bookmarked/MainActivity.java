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

    Button viewAllBooks_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewAllBooks_Btn = (Button) findViewById(R.id.launcherViewAllBooks_Btn);
    }


    public void onAllBooksClick(View view){
        Intent intent = new Intent(this, ListAllBooksActivity.class);
        startActivity(intent);
        Log.d("Btn All books", "Clicked!");
    }
}
