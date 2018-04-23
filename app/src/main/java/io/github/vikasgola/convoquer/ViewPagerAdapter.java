package io.github.vikasgola.convoquer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Results();
            case 2:
                Bundle bundle1 =new Bundle();
                bundle1.putString("key","upcoming");
                Current current1 = new Current();
                current1.setArguments(bundle1);
                return current1;
            case 3:
                Bundle bundle2 =new Bundle();
                bundle2.putString("key","finished");
                Current current2 = new Current();
                current2.setArguments(bundle2);
                return current2;
            case 1:
                Bundle bundle =new Bundle();
                bundle.putString("key","live");
                Current current = new Current();
                current.setArguments(bundle);
                return current;
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Results";
            case 2:
                return "Upcoming";
            case 3:
                return "Finished";
            case 1:
                return "Live";
            default:
                break;
        }
        return "";
    }


}
