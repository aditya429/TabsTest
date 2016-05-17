package mapintegration.com.tabstest;

/**
 * Created by Aditya SMT on 17-05-2016.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapterActivity extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapterActivity(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabFragment1 tab1 = new TabFragment1();

                return tab1;
            case 1:
                TabFragment2 tab2 = new TabFragment2();

                return tab2;
            case 2:
                TabFragment3 tab3 = new TabFragment3();

                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}