package techo.apps.isi.uca.com.android_aps.ui.adapters;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.models.UserModel;

/**
 * Created by Lauren Steven on 9/5/2018.
 */
public class UserActivedAdapter extends RecyclerView.Adapter<UserActivedAdapter.ViewHolder> {
    private ArrayList<UserModel> user;
    private Context context;

    public UserActivedAdapter(Context context) {
        this.context = context;
    }

    @Override
    public UserActivedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_actived_item, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(UserActivedAdapter.ViewHolder holder, int position) {
        holder.avatar.setImageURI("https://e-fisiomedic.com/wp-content/uploads/2013/11/default-placeholder-300x300.png");
        if (position == 2 || position == 5 || position == 8){
            holder.stateConnection.getHierarchy().setPlaceholderImage(R.color.inactiveState);
        }

        holder.avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.username.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;

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