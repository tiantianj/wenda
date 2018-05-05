package com.xingjiejian.wenda.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import javax.sql.DataSource;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * 测试类
 */
public class JdbcUtilsTest {
    private static DataSource dataSource;
    static {
        dataSource = new ComboPooledDataSource();
    }

    public static QueryRunner getQueryRuner(){
        return new QueryRunner(dataSource);
    }


    @Test
    public void testDataSource() throws SQLException {
        System.out.println(dataSource.getClass());    //不报错并返回class com.mchange.v2.c3p0.ComboPooledDataSource，说明已经成功的连接数据源
        System.out.println(dataSource.getConnection().toString());
    }
}