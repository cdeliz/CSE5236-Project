package com.example.chris.comicalstudios;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by paul on 11/14/14.
 */
public class PageArray {
    private ArrayList<Page> Pages;
    //private Context AppContext;

    private PageArray pageArray;

    public PageArray() {
      //  AppContext = appContext;
        Pages = new ArrayList<Page>();


        for (int i = 0; i < 10; i++) {
            Page c = new Page();
            c.setTitle("Page" + i);
            Pages.add(c);
        }
    }


    public PageArray get() {
        if (pageArray == null) {
            pageArray = new PageArray();
        }
        return pageArray;
    }


    public ArrayList<Page> getPages() {
        return Pages;
    }

    public Page getCrime(UUID id) {
        for (Page c : Pages) {
            if (c.getID().equals(id))
                return c;
        }
        return null;
    }
}
