package techo.apps.isi.uca.com.android_aps.ui.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tumblr.remember.Remember;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import techo.apps.isi.uca.com.android_aps.ApplicationProject;
import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.api.Api;
import techo.apps.isi.uca.com.android_aps.databaseDao.AppDatabase;
import techo.apps.isi.uca.com.android_aps.models.Person;


public class SyncUpCatalogDialogFragment extends android.app.DialogFragment {


    @Inject
    AppDatabase appDatabase;

    @BindView(R.id.container)
    ViewGroup container;

    @BindView(R.id.empty_container)
    ViewGroup progressBar;

    public static SyncUpCatalogDialogFragment newInstance() {
        SyncUpCatalogDialogFragment resultDialogFragment = new SyncUpCatalogDialogFragment();
        resultDialogFragment.setCancelable(false);

        return resultDialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        ApplicationProject.getInjectComponent(getActivity()).inject(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(getContentView());
        builder.setTitle(R.string.sync_up);

        progressBar.setVisibility(View.GONE);
        container.setVisibility(View.VISIBLE);
        int position = 1000;


            View categoryView = getActivity().getLayoutInflater().inflate(R.layout.view_sync_up_list_item, container, false);

            LinearLayout main = (LinearLayout) categoryView;
            main.setId(position);

            TextView name = categoryView.findViewById(R.id.name);
            name.setText("Personas");

            container.addView(categoryView);

        loadPeople(position);

        builder.setPositiveButton(getString(R.string.acept_label), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });

        return builder.create();
    }

    private View getContentView() {
        View view = getActivity().getLayoutInflater().inflate(R.layout.fragment_sync_up_catalog_dialog, null);
        ButterKnife.bind(this, view);

        return view;
    }

    public void loadPeople(int position){

        LinearLayout main = container.findViewById(Integer.parseInt(String.valueOf(position)));

        final ProgressBar progressBar = main.findViewById(R.id.progressBar);
        final ImageView imageView = main.findViewById(R.id.completed);

        progressBar.setVisibility(View.VISIBLE);

        Call<List<Person>> call = Api.instance().getPeople("Bearer "+ Remember.getString("access_token","" ));
        call.enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                if (response.code() == Api.OK_CODE) {

                    if (response.body() != null) {
                        List<Person> result = response.body();

                        progressBar.setVisibility(View.GONE);
                        imageView.setVisibility(View.VISIBLE);

                        for (Person person : result) {

                            Person vulnerabilitySheetHeaderItem
                                    = appDatabase.personDao().loadById(person.getId());


                            if (vulnerabilitySheetHeaderItem == null) {
                                appDatabase.personDao().insert(person);



                            }

                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Toast.makeText(getContext(), "Error al sincronizar", Toast.LENGTH_SHORT).show();
            }
        });


    }

}
