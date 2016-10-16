package com.softwares.swamisamarth.datasync.ui;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.softwares.swamisamarth.datasync.MyContactsAdapter;
import com.softwares.swamisamarth.datasync.R;
import com.softwares.swamisamarth.datasync.databinding.ActivityMainBinding;
import com.softwares.swamisamarth.datasync.view_models.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewmodel(new MainViewModel(new MyContactsAdapter(this)));

    }
}
