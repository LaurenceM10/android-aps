package techo.apps.isi.uca.com.android_aps.callback;
import android.view.View;

/**
 * Created by farinas09 on 29/03/19.
 */

public interface OnRecyclerViewItemClickListener<Model> {
    void onItemClick(View view, Model model);
}