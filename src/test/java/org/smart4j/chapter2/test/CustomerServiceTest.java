package org.smart4j.chapter2.test;

import org.junit.Assert;
import org.junit.Test;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.service.CustomerService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/**
 * @Author shijiapeng
 * @Date 2016/11/1 14:17
 * Created by shijiapeng on 2016/11/1.
 */
public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService = new CustomerService();
    }

//    @Before
//    public void init() {
//        // TODO: 2016/11/1 初始化数据库
//
//    }


    /**
     *
     * Method: getCustomerList(String keyword)
     *
     */
    @Test
    public void testGetCustomerList() throws Exception {
        List<Customer> customerList = customerService.getCustomerList("");
        Assert.assertEquals(2, customerList.size());
    }

    /**
     *
     * Method: getCustomer(long id)
     *
     */
    @Test
    public void testGetCustomer() throws Exception {
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    /**
     *
     * Method: createCustomer(Map<String, Objects> fieldMap)
     *
     */
    @Test
    public void testCreateCustomer() throws Exception {
        Customer insertCustomer = new Customer();
        insertCustomer.setContact("john");
        insertCustomer.setName("customer100");
        insertCustomer.setTelephone("12345678901");
        boolean result = customerService.createCustomer(insertCustomer);
        Assert.assertTrue(result);
    }

    /**
     *
     * Method: updateCustomer(long id, Map<String, Object> fieldMap)
     *
     */
    @Test
    public void testUpdateCustomer() throws Exception {
        long id = 1;
        Customer updateCustomer = new Customer();
        updateCustomer.setContact("Eric");
        boolean result = customerService.updateCustomer(id, updateCustomer);
        Assert.assertTrue(result);
    }

    /**
     *
     * Method: deleteCustomer(long id)
     *
     */
    @Test
    public void testDeleteCustomer() throws Exception {
        long id = 1;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}
