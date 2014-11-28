package com.example.chris.comicalstudios;

import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class PageListActivity extends SingleFragmentActivity {
    private static final String PAGE = "page";

    @Override
    protected Fragment createFragment() {
        return new PageListFragment();
    }

}
