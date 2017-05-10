package com.growing.itemmove;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * File: MoveItemRecycleViewAdapter.java
 * Author: ejiang
 * Version: V100R001C01
 * Create: 2017-05-10 11:22
 */

public class MoveItemRecycleViewAdapter extends RecyclerView.
        Adapter<MoveItemRecycleViewAdapter.ViewHolder> implements ItemTouchHelperAdapter {
    private ArrayList<String> mStrings;

    private static final String TAG = "MoveItemAdapter";

    public MoveItemRecycleViewAdapter() {
        mStrings = new ArrayList<>();
        mStrings.add("one");
        mStrings.add("two");
        mStrings.add("three");
        mStrings.add("four");
        mStrings.add("fiver");
        mStrings.add("six");
        mStrings.add("seven");
        mStrings.add("enight");
        mStrings.add("1");
        mStrings.add("1");
        mStrings.add("2");
        mStrings.add("3");
        mStrings.add("4");
        mStrings.add("5");
        mStrings.add("6");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.recycle_view_item_list, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            String str = mStrings.get(position);
            holder.mTxt.setText(str);
        }
    }


    @Override
    public int getItemCount() {
        return mStrings.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mStrings, fromPosition, toPosition);
        Log.i(TAG, "onItemMove: fromPosition" + fromPosition);
        Log.i(TAG, "onItemMove: toPostion" + toPosition);
        notifyItemMoved(fromPosition, toPosition);
        for (String str : mStrings) {
            Log.i(TAG, "onItemMove: " + str);
        }
    }

    @Override
    public void onItemDismiss(int position) {
        Log.i(TAG, "onItemDismiss: " + position);
        mStrings.remove(position);
        notifyItemRemoved(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTxt;

        public ViewHolder(View itemView) {
            super(itemView);
            mTxt = (TextView) itemView.findViewById(R.id.txt);

        }
    }
}
