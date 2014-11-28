package com.example.chris.comicalstudios;

import android.app.Fragment;
import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Chris on 11/27/2014.
 */
public class DrawingActivity extends SingleFragmentActivity{
    private static final String draw = "draw";

    Context context;
    AttributeSet attrs;

    @Override
    protected Fragment createFragment() {
        return new DrawingFragment();
    }
}
