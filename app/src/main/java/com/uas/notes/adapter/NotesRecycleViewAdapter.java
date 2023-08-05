/**
 * NIM : 10120003
 * NAMA : BAYU RIFKI ALGHIFARI
 * KELAS : IF-1
 */
package com.uas.notes.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uas.notes.model.Note;

import java.util.ArrayList;

public class NotesRecycleViewAdapter extends RecyclerView.Adapter<NotesRecycleViewAdapter.MyViewHolder> {

    private Context ctx;
    private ArrayList<Note> notes;

    public NotesRecycleViewAdapter(Context context, ArrayList<Note> notes) {
        this.ctx = context;
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesRecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NotesRecycleViewAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView v_note_id, v_note_category, v_note_title, v_note_created_at, v_note_description;
        LinearLayout mainLayout;
        Button delete_btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
