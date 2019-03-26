package techo.apps.isi.uca.com.android_aps;

import android.app.Activity;
import android.app.Application;
import androidx.room.Room;
import android.content.Context;
import androidx.fragment.app.Fragment;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tumblr.remember.Remember;

import javax.inject.Inject;

import techo.apps.isi.uca.com.android_aps.databaseDao.AppDatabase;

/**
 * Created by macyarin on 10/4/18.
 */

public class ApplicationProject extends Application {

    private static final String PREFS_NAME = "techo.apps.isi.uca.com.android_aps";

    private AppComponent appComponent;

    @Inject AppDatabase appDatabase;

    public void onCreate() {
        super.onCreate();
        appComponent.inject(this);
        Fresco.initialize(this);
        Remember.init(getApplicationContext(), PREFS_NAME);

        //if (appDatabase.syncTableDao().getAll().isEmpty()) {
        //    createSyncTableList();
        //}

        //if (appDatabase.massiveTableDao().getAll().isEmpty()) {
        //    createMassiveUpdateTableList();
        //}
    }

    public ApplicationProject() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    private AppComponent getComponent() {
        return appComponent;
    }

    public static AppComponent getInjectComponent(Activity activity) {
        return getApplication(activity).getComponent();
    }

    public static AppComponent getInjectComponent(Fragment fragment) {
        return getApplication(fragment).getComponent();
    }

    /**
     * support for leanback fragments
     */
    public static AppComponent getInjectComponent(android.app.Fragment fragment) {
        return getApplication(fragment).getComponent();
    }

    public static AppComponent getInjectComponent(Context context) {
        return getApplication(context).getComponent();
    }

    /**
     * support for leanback fragments
     */
    public static ApplicationProject getApplication(android.app.Fragment fragment) {
        return (ApplicationProject) fragment.getActivity().getApplication();
    }

    public static ApplicationProject getApplication(Fragment fragment) {
        return (ApplicationProject) fragment.getActivity().getApplication();
    }

    public static ApplicationProject getApplication(Activity activity) {
        return (ApplicationProject) activity.getApplication();
    }

    public static ApplicationProject getApplication(Context context) {
        return (ApplicationProject) context.getApplicationContext();
    }

}
