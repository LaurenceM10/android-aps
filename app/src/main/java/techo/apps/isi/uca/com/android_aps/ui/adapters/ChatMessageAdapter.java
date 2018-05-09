package techo.apps.isi.uca.com.android_aps.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import techo.apps.isi.uca.com.android_aps.R;

/**
 * Created by Lauren Steven on 5/5/2018.
 */
public class ChatMessageAdapter extends RecyclerView.Adapter<ChatMessageAdapter.ViewHolder>  {

    @Override
    public ChatMessageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_message_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChatMessageAdapter.ViewHolder holder, int position) {
        if (position == 1 ||position == 0) {
            holder.text.setText("Hola, ¿cómo estás? **************************************");
        } else if (position == 2){
            holder.text.setText("Hace mucho que no te vemos por la universidad, nos preguntábamos qué te ha sucedido");
        } else if (position == 3){
            holder.text.setText("Es nuestra universidad tratamos de apoyar a nuestros estudiantes en todo.");
        } else if (position == 4) {
            holder.text.setText("*****************************************");
        } else if (position == 5){
            holder.text.setText("Hace mucho que no te vemos por la universidad, nos preguntábamos qué te ha sucedido");
        } else if (position == 6){
            holder.text.setText("Es nuestra universidad tratamos de apoyar a nuestros estudiantes en todo.");
        } else {
            holder.text.setText("Test");
        }
    }

    @Override
    public int getItemCount() {
        return 15;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout message;
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message);
            text = itemView.findViewById(R.id.text);
        }
    }
}
