package techo.apps.isi.uca.com.android_aps.ui.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.ui.adapters.UserActivedAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ActivedFragment extends Fragment {
    private RecyclerView recyclerView;

    public ActivedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_actived, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        setupRecyclerView();
        fetchUsersActived();
    }

    /**
     * To get references of the view elements
     *
     * @param view
     */
    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
    }

    /**
     * To setup the recyclerView
     */
    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    /**
     * Fetch active users from the API using web sockets
     */
    private void fetchUsersActived() {
        UserActivedAdapter adapter = new UserActivedAdapter(getActivity());
        recyclerView.setAdapter(adapter);
    }
}
