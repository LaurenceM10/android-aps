package techo.apps.isi.uca.com.android_aps.ui.adapters;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import techo.apps.isi.uca.com.android_aps.R;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.user_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int position) {
        holder.avatar.setImageURI("https://e-fisiomedic.com/wp-content/uploads/2013/11/default-placeholder-300x300.png");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView avatar;
        TextView username;
        TextView career;
        Button message;
        Button profile;

        public ViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            username = itemView.findViewById(R.id.username);
            career = itemView.findViewById(R.id.career);
            //message = itemView.findViewById(R.id.message);
            //profile = itemView.findViewById(R.id.profile);
        }
    }
}
