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
    List<Book> allBooks = getAllBooks();
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
    private static final String CURRENTLYREAD = "currently_read";
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
                + CURRENTLYREAD + " INTEGER,"
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
        values.put(CURRENTLYREAD, book.getCurrentlyread());
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
                book.setCurrentlyread(Integer.parseInt(cursor.getString(2)));
                book.setPageCount(Integer.parseInt(cursor.getString(3)));
                book.setDateAdded(cursor.getString(4));

                //add all books
                allBooks.add(book);
            } while (cursor.moveToNext());
        }
        return allBooks;
    }

    // get a String that contains all book info - not updated to view currently read.
    public String allBooksInfo(){

        for (Book book : allBooks) {
            System.out.println(book.getTitle() + " " + book.getPageCount() + " " + book.getDateAdded() + "Book id = " +  book.getId());

        }
        return " All books";
    }


    //an array of Strings

    public ArrayList<String> bookInfoForList(){
        ArrayList<String> title = new ArrayList<String>();
        for (Book book : allBooks){
            String newTitle = book.getTitle();
            title.add(newTitle);
        }
        return title;
    }

    //get a single entry

    public Book getBook(int id){
        Book book = new Book();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor bookCursor =  db.rawQuery( "SELECT * FROM " + TABLE_BOOKS + " where " + KEY_ID + " = " + id + ";", null );

        if (bookCursor != null ){
            bookCursor.moveToNext();
            book.setId(bookCursor.getInt(bookCursor.getColumnIndex(KEY_ID)));
            book.setTitle(bookCursor.getString(bookCursor.getColumnIndex(TITLE)));
            book.setCurrentlyread(bookCursor.getInt(bookCursor.getColumnIndex(CURRENTLYREAD)));
            book.setPageCount(bookCursor.getInt(bookCursor.getColumnIndex(PAGECOUNT)));
            book.setDateAdded(bookCursor.getString(bookCursor.getColumnIndex(DATE_ADDED)));
        }

        return book;

    }


    //Update a single entry
    public String updateBookEntry(Integer id, String title, int currentlyRead, int pagecount){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TITLE, title);
        values.put(CURRENTLYREAD, currentlyRead);
        values.put(PAGECOUNT, pagecount);
        db.update(TABLE_BOOKS, values, KEY_ID + "=" + id, null);
        return title + "updated";
    }


    public int getBookCount(){
        return allBooks.size();
    }

    //close db method
    public void closeDB(){
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }



}
