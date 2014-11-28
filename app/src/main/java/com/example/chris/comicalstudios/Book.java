package com.example.chris.comicalstudios;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by paul on 11/12/14.
 */
public class Book {
    private UUID bId;
    private String bTitle;
    public ArrayList<Page> Pages;
    //private  PageArray Pages = new PageArray();

    private PageArray pageArray;

    public Book() {
        //Generate Unique Identifier
        bId = UUID.randomUUID();

        Pages = new ArrayList<Page>();

        //placeholder, create new pages later
        for (int i = 0; i < 10; i++) {
            Page c = new Page();
            c.setTitle("Page" + i);
            Pages.add(c);
        }
    }

    /*
    public ArrayList<Page> getPages() {
        return Pages;
    }
    */




    public ArrayList<Page> getPages() {
        return Pages;
    }

    public Page getPage(UUID id) {
        for (Page c : Pages) {
            if (c.getID().equals(id))
                return c;
        }
        return null;
    }


    public UUID getId() {
        return bId;
    }

    public String getTitle() {
        return bTitle;
    }

    public void setId(UUID bId) {
        this.bId = bId;
    }

    public void setTitle(String bTitle) {
        this.bTitle = bTitle;
    }

    @Override
    public String toString() {
        return bTitle;
    }
}
