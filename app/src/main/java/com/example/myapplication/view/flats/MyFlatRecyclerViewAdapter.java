package com.example.myapplication.view.flats;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.model.Flat;
import com.example.myapplication.model.R;
import com.example.myapplication.model.databinding.FragmentFlatsBinding;
import com.example.myapplication.view.flats.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyFlatRecyclerViewAdapter extends RecyclerView.Adapter<MyFlatRecyclerViewAdapter.ViewHolder> {

    private final List< Flat> mValues;

    private FlatFragment.onFragmentInteractionListener listener;
    public MyFlatRecyclerViewAdapter(List<Flat> items, FlatFragment.onFragmentInteractionListener listener) {
        mValues = items;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_flat, parent, false);
        return new ViewHolder(view);
        //return new ViewHolder(FragmentFlatsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getId());
        //holder.mContentView.setText(mValues.get(position).content);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        //public final TextView mContentView;
        public Flat mItem;

        /*
        public ViewHolder(FragmentFlatsBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

         */

        public ViewHolder(View view){
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.textViewFlatId);
        }

        @Override
        public String toString() {
            return super.toString() + " '";
        }
    }
}