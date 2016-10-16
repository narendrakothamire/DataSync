package com.softwares.swamisamarth.datasync.db;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;
import com.raizlabs.android.dbflow.structure.database.transaction.Transaction;
import com.softwares.swamisamarth.datasync.models.MyContact;

/**
 * Created by Narendra on 10/16/2016.
 */

public class MyContactDao {

    private static MyContactDao instance;
    private DatabaseDefinition database;

    private MyContactDao() {
        database = FlowManager.getDatabase(AppDatabase.class);
    }

    public static synchronized MyContactDao getInstance(){
        if(instance == null){
            instance = new MyContactDao();
        }
        return instance;
    }

    public void saveMyContact(final MyContact myContact, Transaction.Success success, Transaction.Error error){
        Transaction transaction = database.beginTransactionAsync(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
                myContact.insert(databaseWrapper);
            }
        }).success(success)
                .error(error)
                .build();
        transaction.execute();

    }

}
