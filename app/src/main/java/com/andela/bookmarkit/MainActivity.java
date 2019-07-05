package com.andela.bookmarkit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.andela.bookmarkit.ui.base.BaseFragment;
import com.andela.bookmarkit.ui.base.FragmentSwitcher;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private FragmentSwitcher fragmentSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        fragmentSwitcher = new FragmentSwitcher(this, getSupportFragmentManager());
        getSupportFragmentManager().addOnBackStackChangedListener(this);
        fragmentSwitcher.showMapFragment();
    }

    @Override
    public void onBackStackChanged() {
        try {
            int backStackEntryCount = getSupportFragmentManager().getBackStackEntryCount();

            if (backStackEntryCount > 0) {
                FragmentManager.BackStackEntry backStackEntry = getSupportFragmentManager().getBackStackEntryAt(backStackEntryCount - 1);
                String topMostFragmentTag = backStackEntry.getName();
                if (topMostFragmentTag != null && !topMostFragmentTag.isEmpty()) {
                    BaseFragment fragment = (BaseFragment) getSupportFragmentManager().findFragmentByTag(topMostFragmentTag);
                    fragment.onResume();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.home_full_screen_container);

        if (fragment instanceof BaseFragment && !((BaseFragment) fragment).onBackPressed()) {
            try {
                getSupportFragmentManager().popBackStackImmediate();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}