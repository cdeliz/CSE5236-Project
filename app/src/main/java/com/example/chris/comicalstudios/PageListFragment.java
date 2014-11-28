package com.example.chris.comicalstudios;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.app.ListFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.UUID;

/**
 * A fragment representing a list of Items.
 * <p />
 * <p />
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class PageListFragment extends ListFragment {

    public static final String EXTRA_BOOK_ID =
            "com.bignerdranch.android.criminalintent.crime_id";

    private ArrayList<Book> Books;
   // private ArrayList<Page> Pages;
    private Book book;
    private static final String TAG = "PageListFragment";
    private static final String PAGE = "page";
    public static final int REQUEST_PAGE = 0;

    private ArrayList<Page> Pages;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.pages_title);

        UUID bookId = (UUID)getActivity().getIntent()
                .getSerializableExtra(EXTRA_BOOK_ID);

        book = BookArray.get(getActivity()).getBook(bookId);    //book = BookArray.get(getActivity()).getBook(bookId).getPages();

        Pages = book.getPages();

        //Pages = PageArray.get();

        String test = "test";
        Log.w("Right before page adapter\n", test);
        PageAdapter adapter = new PageAdapter(book.Pages);

        setHasOptionsMenu(true);
        setListAdapter(adapter);
    }


    @Override
    public void onResume() {
        super.onResume();
      //  ((PageAdapter) getListAdapter()).notifyDataSetChanged();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) return;
        if (requestCode == REQUEST_PAGE) {
            String title = data.getStringExtra(CreateBookDialog.EXTRA_TITLE);
            Page c = new Page();
            c.setTitle(title);
            Pages.add(c);
            ((PageAdapter) getListAdapter()).notifyDataSetChanged();
        }

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Page c = ((PageAdapter)getListAdapter()).getItem(position);

        Intent i = new Intent(getActivity(), DrawingFragment.class);
        //i.putExtra(DrawingFragment.PAGE_ID, c.getID());
        startActivity(i);
    }


    private class PageAdapter extends ArrayAdapter<Page> {
        public PageAdapter(ArrayList<Page> pages) {

            super(getActivity(), 0, pages);
            String test = "test";
            Log.w("Got to configure supergetactivity\n", test);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            String test = "test";
            Log.w("start of performing getview\n", test);
            // If we weren't given a view, inflate one
            if (convertView == null) {
                convertView = getActivity().getLayoutInflater()
                        .inflate(R.layout.list_item_page, null);
            }

            Log.w("Got to configure page view\n", test);
            // Configure the view for this Page
            Page c = getItem(position);
            TextView titleTextView =
                    (TextView) convertView.findViewById(R.id.page_list_item_titleTextView);
            titleTextView.setText(c.getTitle());

            return convertView;
        }
    }



    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.book_array, menu);
        // return true;

        inflater.inflate(R.menu.book_actions, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.create_book) {
            //open dialog
            FragmentManager fm = getFragmentManager();
            CreatePageDialog dialog = new CreatePageDialog();
            dialog.setTargetFragment(PageListFragment.this, REQUEST_PAGE);
            dialog.show(fm, PAGE);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}


