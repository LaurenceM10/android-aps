package techo.apps.isi.uca.com.android_aps.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import techo.apps.isi.uca.com.android_aps.models.ExperienceModel;

/**
 * Created by macyarin on 10/4/18.
 */

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ViewHolder> {
    private ArrayList<ExperienceModel> experiences;

    public ExperienceAdapter(ArrayList<ExperienceModel> experiences) {
        this.experiences = experiences;
    }

    @Override
    public ExperienceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ExperienceAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return experiences.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
