package com.example.chris.comicalstudios;

import android.graphics.Bitmap;
import android.graphics.Paint;

import java.util.UUID;

/**
 * Created by paul on 11/14/14.
 */
public class Page {
    private UUID pageId;
    private String pTitle;

    private Bitmap pBitmap;
    private Paint pPaint;   //this defines certain universal drawing parameters for pBitmap


    public Page() {
        //Generate Unique Identifier
        pageId = UUID.randomUUID();
    }

    public UUID getID() {
        return pageId;
    }

    public String getTitle() {
        return pTitle;
    }

    public Bitmap getBitmap() { return pBitmap; }

    public Paint getPaint() { return pPaint; }

    public void setId(UUID pageId) {
        this.pageId = pageId;
    }

    public void setTitle(String pTitle) {
        this.pTitle = pTitle;
    }


    @Override
    public String toString() {
        return pTitle;
    }
}


