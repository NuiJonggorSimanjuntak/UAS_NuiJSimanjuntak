package nui.app.uas_NuiJSimanjuntak.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import nui.app.uas_NuiJSimanjuntak.Tab1Fragment;
import nui.app.uas_NuiJSimanjuntak.Tab2Fragment;

public class MyFragmentAdapter extends FragmentStateAdapter {



    public MyFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1){
            return new Tab2Fragment();
        }
        return new Tab1Fragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

