package com.softwares.swamisamarth.datasync.models;

import android.support.v4.util.ArrayMap;

public enum OPERATION{
        INSERT(2),
        UPDATE(1),
        DELETE(-2),
        NONE(0);

        private Integer value;
        private static ArrayMap<Integer, OPERATION> map = new ArrayMap<>();

        OPERATION(Integer value) {
            this.value = value;
        }

        static {
            for (OPERATION pageType : OPERATION.values()) {
                map.put(pageType.value, pageType);
            }
        }

        public static OPERATION valueOf(int operation) {
            return map.get(operation);
        }

        public Integer getValue() {
            return value;
        }
    }