package cn.edu.gdmec.android.refoit;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 18/5/22.
 */

public class FgNewsFragment extends Fragment {
    public static final int NEWS_TYPE_TOP=0;
    public static final int NEWS_TYPE_NBA=1;
    public static final int NEWS_TYPE_JOKES=2;
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> fragmentTitles=new ArrayList<>();
    private TabLayout tl_news;
    private ViewPager vp_news;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_news,container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tl_news=(TabLayout)view.findViewById(R.id.tl_news);
        vp_news=(ViewPager)view.findViewById(R.id.vp_news);
        setViewPager();

        vp_news.setOffscreenPageLimit(2);
        tl_news.setupWithViewPager(vp_news);
    }

    private void setViewPager() {
        fragments.add(FgNewsListFragment.newInstance(NEWS_TYPE_TOP));
        fragments.add(FgNewsListFragment.newInstance(NEWS_TYPE_NBA));
        fragments.add(FgNewsListFragment.newInstance(NEWS_TYPE_JOKES));
        fragmentTitles.add("头条");
        fragmentTitles.add("NBA");
        fragmentTitles.add("笑话");
        MyFragmentAdapter adapter=new MyFragmentAdapter(getChildFragmentManager(),fragments,fragmentTitles);
        vp_news.setAdapter(adapter);
    }
}