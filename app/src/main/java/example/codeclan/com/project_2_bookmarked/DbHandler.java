package example.codeclan.com.project_2_bookmarked;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper{

    String bookInfo;
    //Database Version
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "bookmarked";

    //Table name
    private static final String TABLE_BOOKS = "books";
//    private static final String TABLE_=

    //BOOK Table columns
    private static final String KEY_ID = "id";
    private static final String TITLE = "title";
    private static final String PAGECOUNT = "pagecount";
    private static final String DATE_ADDED = "date_added";

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


    public void addBook(Book book){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE, book.getTitle());
        values.put(PAGECOUNT, book.getPageCount());
        values.put(DATE_ADDED, book.getDateAdded());

        db.insert(TABLE_BOOKS, null, values);

        db.close();
    }


    // View all books
    public List<Book> getAllBooks(){
        List<Book> allBooks = new ArrayList<Book>();

        //Select all from my Books table

        String selectAllQuery = "SELECT * FROM " + TABLE_BOOKS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectAllQuery, null);

        if (cursor.moveToFirst()){
            do {
                Book book = new Book();
                book.setId(Integer.parseInt(cursor.getString(0)));
                book.setTitle(cursor.getString(1));
                book.setPageCount(Integer.parseInt(cursor.getString(2)));
                book.setDateAdded(cursor.getString(3));

                //add all books
                allBooks.add(book);
            } while (cursor.moveToNext());
        }
        return allBooks;
    }

    public String allBooksInfo(){
        List<Book> allBooks = getAllBooks();

        for (Book book : allBooks) {
             bookInfo = book.getTitle() + " " + book.getPageCount() + " " + book.getDateAdded() + "/n";
        }
        return bookInfo;
    }

    //Update a single entry

    public String updateBookEntry(Integer id, String title, int pagecount){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE, title);
        values.put(PAGECOUNT, pagecount);
        db.update(TABLE_BOOKS, values, KEY_ID + "=" + id, null);
        return title + "updated";
    }


    public int getBookCount(){
        List<Book> allBooks = getAllBooks();
        return allBooks.size();
    }

    //close db method
    public void closeDB(){
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }



}
