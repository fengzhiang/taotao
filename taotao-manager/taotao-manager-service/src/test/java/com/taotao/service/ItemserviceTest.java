package com.taotao.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ItemserviceTest {

	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {

		applicationContext = new ClassPathXmlApplicationContext(new String[] {
				
				"spring/applicationContext-dao.xml",
				"spring/applicationContext-service.xml"

		});
	}

	@Test
	
	public void testGetItemByid() {
		
		
	}

}
