package org.smart4j.chapter2.service;

import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.util.PropsUtil;

import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

/**
 * @Author shijiapeng
 * @Date 2016/11/1 14:10
 * Created by shijiapeng on 2016/11/1.
 */
public class CustomerService {

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties conf = PropsUtil.loadProps("config.properties");
        DRIVER = conf.getProperty("jdbc.driver");
        URL = conf.getProperty("jdbc.url");
        USERNAME = conf.getProperty("jdbc.username");
        PASSWORD = conf.getProperty("jdbc.password");

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public List<Customer> getCustomerList(String keyword) {
        Connection conn = DatabaseHelper.getConnection();
        List<Customer> customerList = new ArrayList<Customer>();
        try {
            String sql = "select * from customer";
            return DatabaseHelper.queryEntityList(Customer.class, sql, conn);
        } finally {
            DatabaseHelper.closeConnection(conn);
        }
    }

    public Customer getCustomer(long id) {
        // TODO: 2016/11/1
        return null;
    }

    public boolean createCustomer(Customer customer) {
        // TODO: 2016/11/1
        return false;
    }

    public boolean updateCustomer(long id, Customer customer) {
        // TODO: 2016/11/1
        return false;
    }

    public boolean deleteCustomer(long id) {
        // TODO: 2016/11/1
        return false;
    }
}
