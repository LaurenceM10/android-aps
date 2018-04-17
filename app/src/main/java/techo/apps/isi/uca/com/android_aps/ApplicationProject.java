package techo.apps.isi.uca.com.android_aps;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tumblr.remember.Remember;

import io.realm.Realm;

/**
 * Created by macyarin on 10/4/18.
 */

public class ApplicationProject extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        Remember.init(getApplicationContext(), "techo.apps.isi.uca.com.android_aps");
        Realm.init(getApplicationContext());
    }
}
