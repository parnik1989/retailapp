package com.parnik.application.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.parnik.bean.InputBillRequest;
import com.parnik.helper.DiscountCalculationHelper;
import com.parnik.service.DiscountService;
import com.parnik.service.DiscountServiceImpl;

@RunWith(SpringRunner.class)
public class DiscountServiceImplTest {
 
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {
  
        @Bean
        public DiscountService employeeService() {
            return new DiscountServiceImpl();
        }
    }
 
    @Autowired
    private DiscountService discountService;
 
    @MockBean
    private DiscountCalculationHelper helper;
 
    @Before
    public void setUp() {     
        // Mockito.when(helper.calculateAmountEligibleForDiscount(itemList)).thenReturn(alex);
    }
    
    @Test
    public void calculateDiscountWithNullInputTest() {
    	InputBillRequest inputBillRequest = null;
    	discountService.calculateDiscount(inputBillRequest);
    	
    }
}
