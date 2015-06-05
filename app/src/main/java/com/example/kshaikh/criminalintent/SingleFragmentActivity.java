package com.example.kshaikh.criminalintent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kshaikh on 15-06-04.
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    protected FragmentManager mFm;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        mFm = getSupportFragmentManager();
        addSingleFragment();
    }

    private void addSingleFragment()
    {
        Fragment fragment = mFm.findFragmentById(R.id.fragmentContainer);
        if(fragment == null) {
            // This looks confusing, but when activity is re-created on rotation for instance, the fragments
            // are not destroyed
            fragment = createFragment();
            mFm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }
    }

    protected Fragment getFragment()
    {
        return mFm.findFragmentById(R.id.fragmentContainer);
    }
}
