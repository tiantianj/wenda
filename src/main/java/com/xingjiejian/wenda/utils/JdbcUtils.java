package com.xingjiejian.wenda.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;

/**
 * c3p0的数据库连接池
 * @author
 */
public class JdbcUtils {
    private static DataSource dataSource;
    static {
        dataSource = new ComboPooledDataSource();
    }

    public static QueryRunner getQueryRuner(){
        return new QueryRunner(dataSource);
    }
}
