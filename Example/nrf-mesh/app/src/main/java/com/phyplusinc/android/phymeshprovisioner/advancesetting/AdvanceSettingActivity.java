package com.phyplusinc.android.phymeshprovisioner.advancesetting;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.phyplusinc.android.phymeshprovisioner.R;
import com.phyplusinc.android.phymeshprovisioner.di.Injectable;
import com.phyplusinc.android.phymeshprovisioner.utils.Utils;
import com.phyplusinc.android.phymeshprovisioner.viewmodels.AdvanceSettingModel;
import com.phyplusinc.android.phymeshprovisioner.viewmodels.NodeConfigurationViewModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdvanceSettingActivity extends AppCompatActivity implements Injectable {
    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    private AdvanceSettingModel mViewModel;
    private boolean mIsConnected;
    @BindView(R.id.container)
    CoordinatorLayout container;
    /**
     * 高级设置layout
     */
    private TabLayout myTabLayout;
    /**
     * 高级设置viewpage
     */
    private ViewPager myViewPager;
    /**
     * tab标题
     */
    private List<String> myTitle;
    /**
     * 页面内容
     */
    private List<Fragment>myFragment;
    //懸浮窗
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_setting);
        ButterKnife.bind(this);
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(AdvanceSettingModel.class);
        // Set up views
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.title_node_config_adv);
        mViewModel.isConnectedToProxy().observe(this, isConnected -> {
            if (isConnected != null) {
                mIsConnected = isConnected;
            }
         //  updateClickableViews();
            invalidateOptionsMenu();
        });
        invalidateOptionsMenu();
        //去掉阴影
        getSupportActionBar().setElevation(0);
        myTabLayout  = (TabLayout)findViewById(R.id.tabLayout);
        myViewPager = (ViewPager)findViewById(R.id.myView);
        initData();
        initView();
    }
    private void initData(){
        myTitle = new ArrayList<>();
        String[] string = getResources().getStringArray(R.array.advsetting);
        for (int i = 0;i < string.length;i++){
            myTitle.add(string[i]);
        }
        myFragment = new ArrayList<>();
        myFragment.add(new LoadFragment());
        myFragment.add(new BatteryFragment());
        myFragment.add(new OtherFragment());

    }
    private void initView(){
        //预加载
        myViewPager.setOffscreenPageLimit(myFragment.size());
        //适配器（容器都需要适配器）
        myViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            //选中的item
            @Override
            public Fragment getItem(int position) {
                return myFragment.get(position);
            }

            @Override
            public int getCount() {
                return myFragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return myTitle.get(position);
            }
        });
        //将TabLayout与Viewager绑定
        myTabLayout.setupWithViewPager(myViewPager);
    /*    myTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                myViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/
    }
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        if (mIsConnected) {
            getMenuInflater().inflate(R.menu.disconnect, menu);
        } else {
            getMenuInflater().inflate(R.menu.connect, menu);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull final MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_connect:
                mViewModel.navigateToScannerActivity(this, false, Utils.CONNECT_TO_NETWORK, false);
                return true;
            case R.id.action_disconnect:
                mViewModel.disconnect();
                return true;
            default:
                return false;
        }
    }

    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    private boolean isConnected() {
        if (!mIsConnected) {
            mViewModel.displaySnackBar(this, container, getString(R.string.please_connect_to_network), Snackbar.LENGTH_SHORT);
            return false;
        }
        return true;
    }
}
