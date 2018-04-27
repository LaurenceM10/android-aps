package techo.apps.isi.uca.com.android_aps.ui.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.models.ExperienceModel;
import techo.apps.isi.uca.com.android_aps.utilities.Util;

/**
 * Created by macyarin on 10/4/18.
 */

public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ViewHolder> {
    private ArrayList<ExperienceModel> experiences;
    private Context context;

    public ExperienceAdapter(Context context) {
        this.context = context;
    }

    //public ExperienceAdapter(ArrayList<ExperienceModel> experiences) {
    //   this.experiences = experiences;
    //}

    @Override
    public ExperienceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.experience_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExperienceAdapter.ViewHolder holder, int position) {
        //ExperienceModel experienceModel = experiences.get(position);
        holder.avatar.setImageURI("https://avatars3.githubusercontent.com/u/13529689?s=400&u=7e716ae5a9be7dcfdbb66e4f880b8550c4c90105&v=4");

        if (position == 2 || position == 5 || position == 8){
            holder.stateConnection.getHierarchy().setPlaceholderImage(R.color.inactiveState);
        }

        holder.avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.showDialogProfile(context);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
        //return experiences.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView avatar;
        TextView username;
        SimpleDraweeView stateConnection;

        ViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            username = itemView.findViewById(R.id.username);
            stateConnection = itemView.findViewById(R.id.stateConnection);
        }
    }
}
