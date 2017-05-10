package com.growing.itemmove;

import android.graphics.Rect;
import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * File: MyItemDecoration.java
 * Author: ejiang
 * Version: V100R001C01
 * Create: 2017-04-25 10:41
 */

public class MyItemDecoration extends RecyclerView.ItemDecoration {

    public static final int LIST_TYPE = 0;
    public static final int GRID_VIEW_TYPE = 1;
    public static final int WATERFALL = 2;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({LIST_TYPE, GRID_VIEW_TYPE, WATERFALL})
    public @interface recycleItemDecorationListencer {
    }

    @recycleItemDecorationListencer
    private int type = LIST_TYPE;

    private int width = 0;

    public MyItemDecoration(@recycleItemDecorationListencer int type, int width) {
        this.type = type;
        this.width = width;
    }

    public MyItemDecoration(@recycleItemDecorationListencer int type) {
        this.type = type;

    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

        if (width != 0) {
            switch (type) {
                case LIST_TYPE:
                    outRect.set(0, 0, 0, width);
                    break;
                case GRID_VIEW_TYPE:
                    outRect.set(width, width, width, width);
                    break;
                default:
                    outRect.set(0, 0, 0, width);
                    break;
            }
        } else {
            switch (type) {
                case LIST_TYPE:
                    outRect.set(0, 0, 0, 1);
                    break;
                case GRID_VIEW_TYPE:
                    outRect.set(3, 3, 3, 3);
                    break;
                default:
                    outRect.set(0, 0, 0, 1);
                    break;
            }
        }
    }
}
