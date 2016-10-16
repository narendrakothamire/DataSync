package com.softwares.swamisamarth.datasync.view_models;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Created by Narendra on 10/15/2016.
 */

public class BaseViewModel extends BaseObservable {

    @BindingAdapter("binding:adapter")
    public static void setAdapter(ListView listView, BaseAdapter baseAdapter){
        listView.setAdapter(baseAdapter);
    }
}
