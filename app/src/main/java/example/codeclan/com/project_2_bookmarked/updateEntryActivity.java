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
    EditText edittedReadCount;
    Button backButton;
    Button submit;
    String id;
    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_entry);


        db = new DbHandler(this);

        edittedTitle = (EditText) findViewById(R.id.editTitle_ET);
        edittedPC = (EditText) findViewById(R.id.edittedPC_ET);
        edittedReadCount = (EditText) findViewById(R.id.cRead_ET);
        backButton = (Button) findViewById(R.id.back_replacement_btn);
        submit = (Button) findViewById(R.id.edittedEntry_btn);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String title = extras.getString("title");
            Log.d("check extras", title);
        String pagecount = extras.getString("pagecount");
            Log.d("check second extras", pagecount);
        String readCount = extras.getString("readCount");
            Log.d("readCount", readCount);
        id = extras.getString("id");

        edittedTitle.setText(title, TextView.BufferType.EDITABLE);
        edittedPC.setText(pagecount, TextView.BufferType.EDITABLE);

    }

    public void backToIndividualpg(){
        Intent intent = new Intent(this, IndividualBookInfoActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    public void onBtnClick(View view){

        switch (view.getId()){

            case R.id.back_replacement_btn :
                break;

            case R.id.edittedEntry_btn :
                int bookId = Integer.parseInt(id);
                String updatetitle = edittedTitle.getText().toString();
                int updatePC = Integer.parseInt(edittedPC.getText().toString());
                int updateRC = Integer.parseInt(edittedReadCount.getText().toString());
                db.updateBookEntry(bookId, updatetitle, updateRC , updatePC);
                break;
        }
        backToIndividualpg();
    }
}
