package example.codeclan.com.project_2_bookmarked;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHandler extends SQLiteOpenHelper{

    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "bookmarked";

    //Table name
    private static final String TABLE_BOOKS = "Books";

    //Table columns
    private static final String KEY_ID = "id";
    private static final String TITLE = "title";
    private static final String PAGECOUNT = "pagecount";
    private static final String DATE_ADDED = "date added";

    public DbHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_BOOKS_TABLE = "CREATE TABLE " + TABLE_BOOKS + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + TITLE + " TEXT,"
                + PAGECOUNT + " INTEGER,"
                + DATE_ADDED + " TEXT " + ")";

        db.execSQL(CREATE_BOOKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_BOOKS);
        onCreate(db);
    }


}
