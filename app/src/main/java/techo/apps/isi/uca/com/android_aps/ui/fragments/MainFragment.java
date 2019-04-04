package techo.apps.isi.uca.com.android_aps.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import javax.inject.Inject;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import techo.apps.isi.uca.com.android_aps.ApplicationProject;
import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.databaseDao.AppDatabase;

/**
 * Created by farinas09 on 29/03/19.
 */
public class MainFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.add_experience_action_button)
    FloatingActionButton newExperienceButton;

    @Inject
    AppDatabase appDatabase;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationProject.getInjectComponent(this).inject(this);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ApplicationProject.getInjectComponent(this).inject(this);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_main;
    }

    @Override
    protected String getTitle() {
        return null;
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        //setAdapter(appDatabase.ExperienceDao().getAllOrganized());
        newExperienceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Estamos trabajando", Toast.LENGTH_SHORT).show();
                //openNewExperience Fragment();
            }
        });

    }

    //private void setAdapter(List<Experience> experiences) {
    //    GridAdapter gridAdapter = new GridAdapter(experiences, getActivity());
    //    recyclerView.setAdapter(gridAdapter);
    //}


}
