package techo.apps.isi.uca.com.android_aps.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import techo.apps.isi.uca.com.android_aps.R;

/**
 * Created by Lauren Steven on 10/5/2018.
 */
public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.user_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        holder.wallpaper.setImageURI("https://trello-backgrounds.s3.amazonaws.com/SharedBackground/2560x1707/bde63e08709e184b9ac54dc739d7b443/photo-1488590528505-98d2b5aba04b");
        holder.avatar.setImageURI("https://avatars3.githubusercontent.com/u/13529689?s=400&u=7e716ae5a9be7dcfdbb66e4f880b8550c4c90105&v=4");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView wallpaper;
        SimpleDraweeView avatar;
        TextView username;
        TextView career;
        Button message;
        Button profile;

        public ViewHolder(View itemView) {
            super(itemView);
            wallpaper = itemView.findViewById(R.id.wallpaper);
            avatar = itemView.findViewById(R.id.avatar);
            username = itemView.findViewById(R.id.username);
            career = itemView.findViewById(R.id.career);
            //message = itemView.findViewById(R.id.message);
            //profile = itemView.findViewById(R.id.profile);
        }
    }
}
