package techo.apps.isi.uca.com.android_aps.ui.fragments;


import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import techo.apps.isi.uca.com.android_aps.R;
import techo.apps.isi.uca.com.android_aps.ui.adapters.PageAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PageAdapter pageAdapter;
    private TabItem tabChats;
    private TabItem tabActive;

    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        initActions();
    }

    @Override
    public void onResume() {
        super.onResume();
        setupAdapter();
    }

    /**
     * To get reference of the view elements
     */
    private void initViews(View view) {
        tabLayout = view.findViewById(R.id.tablayout);
        tabChats = view.findViewById(R.id.tabChats);
        tabActive = view.findViewById(R.id.activos);
        viewPager = view.findViewById(R.id.viewPager);
    }

    /**
     * Setup adapter
     */
    private void setupAdapter(){
        pageAdapter = new PageAdapter(getChildFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);
    }

    /**
     * To init actions when events occur on the elements
     */
    private void initActions(){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
