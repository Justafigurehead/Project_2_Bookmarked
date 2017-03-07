package example.codeclan.com.project_2_bookmarked;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.List;

public class BookListAdapter extends BaseAdapter {

    private List<Book> allMyBooks;
    private Context context;

    public BookListAdapter(Context context, List<Book> allMyBooks){
        this.context = context;
        this.allMyBooks = allMyBooks;
    }


    public void addBookToAdapter(Book book){
        allMyBooks.add(book);
    }

    @Override
    public int getCount(){
        return allMyBooks.size();
    }

    @Override
    public Book getItem(int position){
        return allMyBooks.get(position);
    }

    @Override
    public long getItemId(int position){
        Book book = allMyBooks.get(position);
        return book.getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_layout, parent,false);

           Book book = getItem(position);

            TextView titleTextView = (TextView) rowView.findViewById(R.id.titleView);
            titleTextView.setText(book.getTitle());

            TextView pagecountTextView = (TextView) rowView.findViewById(R.id.pageCountView);
            pagecountTextView.setText(Integer.toString(book.getPageCount()) + " pages");

            TextView dateAddedTextView = (TextView) rowView.findViewById(R.id.DateAddedView);
            dateAddedTextView.setText("Added " + book.getDateAdded());

            ProgressBar progressBar = (ProgressBar) rowView.findViewById(R.id.listProgressBar);
            progressBar.setMax(book.getPageCount());
            progressBar.setProgress(book.getCurrentlyread());
            progressBar.setVisibility(View.VISIBLE);

            return rowView;

    }
}
