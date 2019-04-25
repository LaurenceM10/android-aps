package techo.apps.isi.uca.com.android_aps.ui.fragments;


import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Contacts;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tumblr.remember.Remember;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techo.apps.isi.uca.com.android_aps.ApplicationProject;
import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.api.Api;
import techo.apps.isi.uca.com.android_aps.models.AccessToken;
import techo.apps.isi.uca.com.android_aps.models.Experience;
import techo.apps.isi.uca.com.android_aps.models.Person;
import techo.apps.isi.uca.com.android_aps.ui.activities.LoginActivity;
import techo.apps.isi.uca.com.android_aps.ui.activities.MainActivity;
import techo.apps.isi.uca.com.android_aps.ui.adapters.ExperienceAdapter;
import techo.apps.isi.uca.com.android_aps.ui.dialog.SyncUpCatalogDialogFragment;

/**
 * farinas09 20/04/19
 */
public class ExperienceFragment extends BaseFragment {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<Experience> experiences;
    private List<Person> people;


    public ExperienceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ApplicationProject.getInjectComponent(this).inject(this);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_experience;
    }

    @Override
    protected String getTitle() {
        return "Experiencias";
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews();
    }


    private void initViews(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Call<List<Experience>> call = Api.instance().getExperiences("Bearer "+ Remember.getString("access_token","" ));
          call.enqueue(new Callback<List<Experience>>() {
          @Override
          public void onResponse(Call<List<Experience>> call, Response<List<Experience>> response) {


              if(response!= null) {
                 
                  // experiences = response.body();
                  Log.e("err","response e");
              //    Toast.makeText(getContext(), "Success to request", Toast.LENGTH_SHORT).show();

              }else{
                  Toast.makeText(getContext(), "Response null", Toast.LENGTH_SHORT).show();
                  Log.e("err","response  null e");}

          }

          @Override
          public void onFailure(Call<List<Experience>> call, Throwable t) {
              Log.e("Err","Request error", t );
          }
      });


        Call<List<Person>> callPeople = Api.instance().getPeople("Bearer "+ Remember.getString("access_token","" ));
        callPeople.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                if(response!= null) {

                  people = response.body();
                    Log.e("err","response no null");
                   //Toast.makeText(getContext(), "Success to request", Toast.LENGTH_SHORT).show();


                }else{
                    Log.e("err","response  null");
                    Toast.makeText(getContext(), "Response null", Toast.LENGTH_SHORT).show();                }
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Log.e("Err","Request error", t);

            }
        });

        setAdapter(people, experiences);
    }

    private void setAdapter(List<Person> people, List<Experience> experiences) {

        ExperienceAdapter adapter = new ExperienceAdapter(people, experiences, getActivity());
        recyclerView.setAdapter(adapter);
    }


}
