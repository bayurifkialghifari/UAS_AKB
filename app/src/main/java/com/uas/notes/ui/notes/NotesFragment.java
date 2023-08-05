/**
 * NIM : 10120003
 * NAMA : BAYU RIFKI ALGHIFARI
 * KELAS : IF-1
 */
package com.uas.notes.ui.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.uas.notes.R;
import com.uas.notes.adapter.NotesRecycleViewAdapter;
import com.uas.notes.databinding.FragmentNotesBinding;

public class NotesFragment extends Fragment {

    private FragmentNotesBinding binding;
    private RecyclerView recyclerView;
    private FloatingActionButton bAdd;
    private NotesRecycleViewAdapter notesView;
    private DatabaseReference DB;
    private FirebaseAuth Auth;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Set component
        recyclerView = root.findViewById(R.id.recycle_note);
        bAdd = root.findViewById(R.id.note_add_btn);

        // Move to add note activity
        bAdd.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), AddNotesActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            getActivity().startActivity(intent);
            getActivity().finish();
        });

        // Get data


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}