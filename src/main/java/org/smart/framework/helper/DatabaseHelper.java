package org.smart.framework.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/3/27.
 */
public final class DatabaseHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);

    private static final ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<Connection>();

    /**
     * 开启事务
     */
    public static void beginTransaction(){
        Connection conn = getConnection();
        if(conn!=null){
            try{
                conn.setAutoCommit(false);
            } catch (SQLException e){
                LOGGER.error("begin transaction failure",e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.set(conn);
            }
        }
    }


    /**
     * 提交事务
     */
    public static void commitTransaction(){
        Connection conn = getConnection();
        if(conn!=null){
            try{
                conn.commit();
                conn.close();
            } catch (SQLException e){
                LOGGER.error("commit transacyion failure",e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }


    /**
     * 回滚事务
     */
    public static void rollbackTransaction(){
        Connection conn = getConnection();
        if(conn!=null){
            try{
                conn.rollback();
                conn.close();
            } catch (SQLException e){
                LOGGER.error("rollback transaction failure",e);
                throw new RuntimeException(e);
            } finally {
                CONNECTION_HOLDER.remove();
            }
        }
    }

    private static Connection getConnection(){
        Connection conn = null;
        try{
            DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306", "root", "123456");
        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

}
