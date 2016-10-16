package com.softwares.swamisamarth.datasync;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.raizlabs.android.dbflow.list.FlowQueryList;
import com.softwares.swamisamarth.datasync.models.MyContact;

/**
 * Created by Narendra on 10/16/2016.
 */

public class MyContactsAdapter extends BaseAdapter {

    private FlowQueryList<MyContact> myContacts;
    private LayoutInflater inflater;
    private Context context;

    public MyContactsAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public MyContactsAdapter(FlowQueryList<MyContact> myContacts, Context context) {
        this(context);
        this.myContacts = myContacts;

    }

    public void setMyContacts(FlowQueryList<MyContact> myContacts){
        this.myContacts = myContacts;
    }

    @Override
    public int getCount() {
        return (myContacts != null ? myContacts.size() : 0);
    }

    @Override
    public MyContact getItem(int position) {
        return (myContacts != null ? myContacts.get(position) : null);
    }

    @Override
    public long getItemId(int position) {
        return (myContacts != null ? myContacts.get(position).hashCode() : -1);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        MyContactViewHolder viewHolder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_contacts_list, viewGroup, false);
            viewHolder = new MyContactViewHolder();
            viewHolder.nameTextView = (TextView) convertView.findViewById(R.id.name_tv);
            viewHolder.contactTextView = (TextView) convertView.findViewById(R.id.contact_tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (MyContactViewHolder) convertView.getTag();
        }

        viewHolder.nameTextView.setText(getItem(position).getFirstName() + " " + getItem(position).getLastName());
        viewHolder.contactTextView.setText(getItem(position).getContactNo());

        return convertView;
    }

    static class MyContactViewHolder{
        TextView nameTextView, contactTextView;
    }

}
