package com.softwares.swamisamarth.datasync.db;

import com.raizlabs.android.dbflow.converter.TypeConverter;
import com.softwares.swamisamarth.datasync.models.MyContact;
import com.softwares.swamisamarth.datasync.models.OPERATION;

/**
 * Created by Narendra on 10/16/2016.
 */

public class OperationConverter extends TypeConverter<Integer, OPERATION> {

    @Override
    public Integer getDBValue(OPERATION model) {
        return model.getValue();
    }

    @Override
    public OPERATION getModelValue(Integer data) {
        return OPERATION.valueOf(data);
    }
}
