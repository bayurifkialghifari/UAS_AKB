/**
 * NIM : 10120003
 * NAMA : BAYU RIFKI ALGHIFARI
 * KELAS : IF-1
 */
package com.uas.notes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uas.notes.R;
import com.uas.notes.auth.LoginActivity;
import com.uas.notes.model.NoteCategory;

import java.util.ArrayList;

public class NotesCategoryRecycleViewAdapter extends RecyclerView.Adapter<NotesCategoryRecycleViewAdapter.MyViewHolder> {

    private Context ctx;
    private ArrayList<NoteCategory> list_category;

    public NotesCategoryRecycleViewAdapter(Context context, ArrayList<NoteCategory> list_category) {
        this.ctx = context;
        this.list_category = list_category;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesCategoryRecycleViewAdapter.MyViewHolder holder, int position) {
        holder.fNoteCategoryTitle.setText(list_category.get(position).title);
        holder.fNoteCategoryTotal.setText(list_category.get(position).total + " Notes");

        // View on click redirect
        holder.lNoteCategory.setOnClickListener(v -> {
            Toast.makeText(ctx, "View",
                    Toast.LENGTH_SHORT).show();
        });

        // Delete button onclick
        holder.bNoteCategoryDelete.setOnClickListener(v -> {
            Toast.makeText(ctx, "DElete",
                    Toast.LENGTH_SHORT).show();
        });
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView fNoteCategoryTitle;
        TextView fNoteCategoryTotal;
        Button bNoteCategoryDelete;
        LinearLayout lNoteCategory;
        public MyViewHolder(@NonNull View v) {
            super(v);
            fNoteCategoryTitle = v.findViewById(R.id.category_notes_title);
            fNoteCategoryTotal = v.findViewById(R.id.category_notes_total);
            bNoteCategoryDelete = v.findViewById(R.id.category_notes_delete);
            lNoteCategory = v.findViewById(R.id.category_notes_layout);
        }
    }

    @NonNull
    @Override
    public NotesCategoryRecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.category_notes, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return list_category.size();
    }

}
