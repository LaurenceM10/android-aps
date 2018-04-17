package techo.apps.isi.uca.com.android_aps.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.models.ExperienceModel;

/**
 * Created by macyarin on 10/4/18.
 */

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ViewHolder> {
    private ArrayList<ExperienceModel> experiences;

//    public ExperienceAdapter(ArrayList<ExperienceModel> experiences) {
//        this.experiences = experiences;
//    }

    @Override
    public ExperienceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.experience_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExperienceAdapter.ViewHolder holder, int position) {
//        ExperienceModel experienceModel = experiences.get(position);
    }

    @Override
    public int getItemCount() {
        return 10;
        //return experiences.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
