package techo.apps.isi.uca.com.android_aps;


import android.app.Application;
import androidx.room.Room;
import android.content.ContentResolver;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import techo.apps.isi.uca.com.android_aps.databaseDao.AppDatabase;

@Module(
        includes = {
                AndroidModule.class,
        }
)
public class AppModule {

    private final ApplicationProject app;

    public AppModule(ApplicationProject app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    AppDatabase provideDatabase() {
        return  Room.databaseBuilder(app, AppDatabase.class, "APS")
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    ContentResolver provideContentResolver() {
        return app.getContentResolver();
    }
}
