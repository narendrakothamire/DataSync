package com.softwares.swamisamarth.datasync.view_models;

import android.databinding.Bindable;
import android.util.Log;

import com.raizlabs.android.dbflow.list.FlowQueryList;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import com.softwares.swamisamarth.datasync.BR;
import com.softwares.swamisamarth.datasync.MyContactsAdapter;
import com.softwares.swamisamarth.datasync.db.MyContactDao;
import com.softwares.swamisamarth.datasync.models.MyContact;
import com.softwares.swamisamarth.datasync.models.OPERATION;

/**
 * Created by Narendra on 10/15/2016.
 */

public class MainViewModel extends BaseViewModel {

    private MyContact myContact = new MyContact();
    private MyContactsAdapter myContactsAdapter;

    public MainViewModel(MyContactsAdapter myContactsAdapter) {
        this.myContactsAdapter = myContactsAdapter;
    }

    public MyContactsAdapter getMyContactsAdapter() {
        return myContactsAdapter;
    }

    private Transaction.Success success = new Transaction.Success() {
        @Override
        public void onSuccess(Transaction transaction) {

            FlowQueryList<MyContact> list = SQLite.select()
                    .from(MyContact.class)
            .flowQueryList();

            myContactsAdapter.setMyContacts(list);
            myContactsAdapter.notifyDataSetChanged();
        }
    };

    private Transaction.Error error = new Transaction.Error() {
        @Override
        public void onError(Transaction transaction, Throwable error) {
            Log.d("Narendra", error.getMessage());
        }
    };

    @Bindable
    public MyContact getMyContact() {
        return myContact;
    }

    public void setMyContact(MyContact myContact) {
        this.myContact = myContact;
        notifyPropertyChanged(BR.myContact);
    }

    public void sendData(){

        myContact.setOperation(OPERATION.INSERT);
        MyContactDao.getInstance().saveMyContact(myContact, success, error);
        Log.d("Narendra", myContact.toString());
    }
}
