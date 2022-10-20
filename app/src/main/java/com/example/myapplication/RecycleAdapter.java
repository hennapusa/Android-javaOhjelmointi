package com.example.myapplication;

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



public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private ArrayList<Company> dataSet;
    public static final String TAG = "Testi #2";

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewVersion;
        TextView textViewForm;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.itemName);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.itemBusinessID);
            this.textViewForm = (TextView) itemView.findViewById(R.id.itemForm);

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
       TextView textViewForm = holder.textViewForm;


        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getBusinessId());
        textViewForm.setText(dataSet.get(listPosition).getCompanyForm());
        //textViewName.setText(dataSet.get(listPosition).getRegistrationDate());

        Log.e("Testi", dataSet.get(listPosition).getName());
        Log.e( "HEI", dataSet.get(listPosition).getBusinessId());
        //textViewVersion.setText(dataSet.get(listPosition).getVersion());



    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
*/

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    private ArrayList<Company> dataSet;
    public static final String TAG ="MyAppMessage";

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView itemPosition;
        TextView textViewName;
        TextView textViewBusinessId;
        TextView textViewRegistrationDate;
        TextView textViewCompanyForm;



        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewBusinessId = (TextView) itemView.findViewById(R.id.textViewBusinessId);
            this.textViewRegistrationDate = (TextView) itemView.findViewById(R.id.textViewRegistrationDate);
            this.textViewCompanyForm = (TextView) itemView.findViewById(R.id.textViewCompanyForm);
        }
    }

    public RecycleAdapter(ArrayList<Company> data) {
        this.dataSet = data;
        Log.e(TAG, String.valueOf(dataSet.size()));
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {


        TextView textViewName = holder.textViewName;
        TextView textViewBusinessId = holder.textViewBusinessId;
        TextView textViewRegistrationDate= holder.textViewRegistrationDate;
        TextView textViewCompanyForm = holder.textViewCompanyForm;

        textViewName.setText("Nimi: " + dataSet.get(listPosition).getName());
        textViewBusinessId.setText("ID: " + dataSet.get(listPosition).getBusinessId());
        textViewRegistrationDate.setText("Rekisteröintipäivä: " + dataSet.get(listPosition).getRegistrationDate());
        textViewCompanyForm.setText("Yritysmuoto: " + dataSet.get(listPosition).getCompanyForm());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View hiddenView = holder.itemView.findViewById(R.id.lytHidden);
                hiddenView.setVisibility( hiddenView.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}
