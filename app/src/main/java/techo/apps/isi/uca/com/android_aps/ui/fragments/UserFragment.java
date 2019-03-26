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
import techo.apps.isi.uca.com.android_aps.ui.adapters.UserAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {
    private RecyclerView recyclerView;


    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);
        setupRecyclerView();
        fetchUsers();
    }

    /**
     * To get references of the view elements
     */
    private void initViews(View view){
        recyclerView = view.findViewById(R.id.recycler_view);
    }

    /**
     * To setup the recyclerView
     */
    private void setupRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    /**
     * To fetch a list of user from the API
     */
    private void fetchUsers(){
        recyclerView.setAdapter(new UserAdapter());
    }
}
