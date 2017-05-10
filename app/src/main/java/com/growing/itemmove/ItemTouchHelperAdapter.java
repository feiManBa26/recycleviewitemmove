package com.growing.itemmove;

/**
 * File: ItemTouchHelperAdapter.java
 * Author: ejiang
 * Version: V100R001C01
 * Create: 2017-05-10 11:44
 */

public interface ItemTouchHelperAdapter {
    void onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
