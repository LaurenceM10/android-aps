package techo.apps.isi.uca.com.android_aps.utilities;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.InsetDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.ui.activities.ProfileActivity;

/**
 * Created by macyarin on 18/4/18.
 */

public class Util {

    /**
     * To
     *
     * @param context from which the dialogue is invoked
     */
    public static void showDialogProfile(Context context){
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_profile_placeholder);
        ColorDrawable back = new ColorDrawable(Color.TRANSPARENT);
        InsetDrawable inset = new InsetDrawable(back, 20);
        dialog.getWindow().setBackgroundDrawable(inset);

        //Elements of the dialog
        Button visitProfile = dialog.findViewById(R.id.visitProfile);
        Button message = dialog.findViewById(R.id.message);
        dialogActions(visitProfile, message, context);


        //Popup properties
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.horizontalMargin = 2;
        layoutParams.gravity = Gravity.CENTER;

        //To set the animation appear and disappear in the dialog
        dialog.getWindow().setAttributes(layoutParams);
        dialog.setCancelable(true);

        //To show popup dialog
        dialog.show();
    }

    /**
     * To init actions when events occur in the elements of the dialog
     */
    private static void dialogActions(Button visitProfile, Button message, final Context context) {
        visitProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ProfileActivity.class));
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "We are working on this", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * To show a dialog with messages options
     */
    public static void showMessagesOptions(){
        
    }
}
