package com.jimmy.tools.dbexchanger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jimmy.tools.dbexchanger.dbtype.DBType;
import com.jimmy.tools.dbexchanger.helper.ExchangeHelper;

public class Exchanger {
    private final static Map<String, String> TABLE_NAME_MAP;
    private final static List<String> FROM_TABLES;
    static {
        Map<String, String> tableNameMap = new HashMap<String, String>();
        tableNameMap.put("cx_user", "cx_user");
        tableNameMap.put("cx_forum", "cx_forum");
        tableNameMap.put("cx_topic", "cx_topic");
        tableNameMap.put("cx_reply", "cx_reply");
        TABLE_NAME_MAP = Collections.unmodifiableMap(tableNameMap);

        List<String> fromTables = new ArrayList<String>();
        fromTables.add("cx_user");
        fromTables.add("cx_forum");
        fromTables.add("cx_topic");
        fromTables.add("cx_reply");
        FROM_TABLES = Collections.unmodifiableList(fromTables);
    }

    public static void main(String[] args) {

        ExchangeHelper.exchange(FROM_TABLES, TABLE_NAME_MAP, DBType.ORACLE, DBType.ORACLE);
    }
}
