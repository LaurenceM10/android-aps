package techo.apps.isi.uca.com.android_aps.ui.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import techo.apps.isi.uca.com.android_aps.ui.fragments.ActivedFragment;
import techo.apps.isi.uca.com.android_aps.ui.fragments.MessagesFragment;

/**
 * Created by Lauren Steven on 9/5/2018.
 */
public class PageAdapter extends FragmentPagerAdapter {
    private int numOfTabs;

    public PageAdapter(FragmentManager fragmentManager, int numOfTabs) {
        super(fragmentManager);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MessagesFragment();
            case 1:
                return new ActivedFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
