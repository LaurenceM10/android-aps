package techo.apps.isi.uca.com.android_aps.ui.adapters;

import android.app.Activity;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import techo.apps.isi.uca.com.android_aps.ApplicationProject;
import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.callback.OnRecyclerViewItemClickListener;
import techo.apps.isi.uca.com.android_aps.databaseDao.AppDatabase;
import techo.apps.isi.uca.com.android_aps.models.Experience;
import techo.apps.isi.uca.com.android_aps.utilities.Util;


public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ViewHolder> implements View.OnClickListener {
    private List<Experience> experiences;
    private OnRecyclerViewItemClickListener<Experience> itemClickListener;
    private Activity context;

    @Inject
    AppDatabase database;

    public ExperienceAdapter(List<Experience> experiences, Activity context) {
        this.experiences = experiences;
        this.context = context;
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener<Experience> listener) {
        this.itemClickListener = listener;
    }

    @Override
    public ExperienceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ApplicationProject.getInjectComponent(context).inject(this);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.experience_item, parent, false);
        view.setOnClickListener(this);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //final Experience experience = experiences.get(position);
        holder.profilePicture.setImageURI("https://e-fisiomedic.com/wp-content/uploads/2013/11/default-placeholder-300x300.png");

        if (position == 2 || position == 5 || position == 8){
            holder.stateConnection.getHierarchy().setPlaceholderImage(R.color.inactiveState);
        }

        holder.profilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Util.showDialogProfile(context);
            }
        });

        holder.username.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public void onClick(View view) {
        if (itemClickListener != null) {
            Experience model = (Experience) view.getTag();
            itemClickListener.onItemClick(view, model);
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.avatar)
        SimpleDraweeView profilePicture;

        @BindView(R.id.username)
        TextView username;


        @BindView(R.id.stateConnection)
        SimpleDraweeView stateConnection;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

