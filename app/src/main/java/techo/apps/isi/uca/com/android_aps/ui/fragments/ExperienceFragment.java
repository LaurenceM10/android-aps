package techo.apps.isi.uca.com.android_aps.ui.fragments;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.ui.adapters.ExperienceAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExperienceFragment extends Fragment {
    private RecyclerView recyclerView;


    public ExperienceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_experience, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        setupRecyclerView();
        fetchExperiencesData();
    }

    /**
     * To get references of the view elements
     */
    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
    }


    /**
     * To setup recycler view
     */
    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    /**
     * To fetch experience data from PSE Service (API)
     */
    private void fetchExperiencesData() {
        // Request with Refrofit
        // Pass data to the adapter
        // Set adapter in Recycler View
        ExperienceAdapter adapter = new ExperienceAdapter(getActivity());
        recyclerView.setAdapter(adapter);
    }
}
