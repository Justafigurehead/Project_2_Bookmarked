package example.codeclan.com.project_2_bookmarked;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class updateEntryActivity extends AppCompatActivity {

    EditText edittedTitle;
    EditText edittedPC;
    Button backButton;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_entry);

        edittedTitle = (EditText) findViewById(R.id.editTitle_ET);
        edittedPC = (EditText) findViewById(R.id.edittedPC_ET);
        backButton = (Button) findViewById(R.id.back_replacement_btn);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String title = extras.getString("title");
            Log.d("check extras", title);
        String pagecount = extras.getString("pagecount");
            Log.d("check second extras", pagecount);
        id = extras.getString("id");

        edittedTitle.setText(title, TextView.BufferType.EDITABLE);
        edittedPC.setText(pagecount, TextView.BufferType.EDITABLE);

    }

    public void onBackButtonClicked(View view){
        Intent intent = new Intent(this, IndividualBookInfoActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
