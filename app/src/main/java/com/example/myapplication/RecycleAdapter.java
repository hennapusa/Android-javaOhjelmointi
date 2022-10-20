package com.example.myapplication;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


/*public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.GridItemViewHolder> {
    private Context context;
    private List<Detail> mItemList;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    public RecycleAdapter(List<Detail> mItemList) {
        this.mItemList = mItemList;

    }


    @Override


    public GridItemViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new GridItemViewHolder(itemView, this);
    }


    @Override
    public void onBindViewHolder(GridItemViewHolder holder, int position) {
        Detail items = mItemList.get(position);
        holder.mTitle.setText(items.getName());
        holder.mPosition.setText("" + items.getPosition());

    }


    @Override


    public int getItemCount() {
        return mItemList.size();
    }


    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }


    private void onItemHolderClick(GridItemViewHolder itemHolder) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(null, itemHolder.itemView,
                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
        }
    }


    public class GridItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView mTitle, mPosition;

        public RecycleAdapter mAdapter;


        public GridItemViewHolder(View itemView, RecycleAdapter mAdapter) {
            super(itemView);
            this.mAdapter = mAdapter;
            mTitle = (TextView) itemView.findViewById(R.id.item_name);
            //mPosition = (TextView) itemView.findViewById(R.id.item_positi);
            itemView.setOnClickListener(this);
        }

        @Override


        public void onClick(View v) {
            mAdapter.onItemHolderClick(this);
        }

    }

}
*/


public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private ArrayList<Company> dataSet;
    public static final String TAG = "Testi #2";

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewVersion;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.itemName);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.itemBusinessID);

        }
    }

    public RecycleAdapter(ArrayList<Company> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;


        textViewName.setText(dataSet.get(listPosition).getName());
        Log.e("Testi", dataSet.get(listPosition).getName());
        //textViewVersion.setText(dataSet.get(listPosition).getVersion());

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
