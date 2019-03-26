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
import techo.apps.isi.uca.com.android_aps.ui.adapters.MessagesAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MessagesFragment extends Fragment {
    private RecyclerView recyclerView;


    public MessagesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_messages, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        setupRecyclerview();
        fetchMessages();
    }

    /**
     * To get references of the view elements
     */
    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
    }

    /**
     * To setup the recycler view
     */
    private void setupRecyclerview() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    /**
     * To fetch and show the list of messages
     */
    private void fetchMessages() {
        recyclerView.setAdapter(new MessagesAdapter(getActivity()));
    }
}
