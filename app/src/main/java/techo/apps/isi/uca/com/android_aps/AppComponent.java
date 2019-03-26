package techo.apps.isi.uca.com.android_aps;


import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import techo.apps.isi.uca.com.android_aps.ui.activities.MainActivity;
import techo.apps.isi.uca.com.android_aps.ui.dialog.SyncUpCatalogDialogFragment;

@Singleton
@Component(
        modules = {
                AppModule.class,
        }
)

public interface AppComponent {
    // Exported for child-components.
    Application application();

    void inject(ApplicationProject application);

    // Activities
    void inject(MainActivity target);
    void inject(SyncUpCatalogDialogFragment target);
}
