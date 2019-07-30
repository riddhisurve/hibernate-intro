package com.lti.ui;

import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import com.lti.dao.CustomerDao;
import com.lti.entity.Customer;

public class Main {
	public String gRSOLF() {		
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz"; 
		StringBuilder sb = new StringBuilder(4); for (int i = 0; i < 4; i++) { sb.append(AlphaNumericString.charAt((int)(AlphaNumericString.length() * Math.random()))); }
		return sb.toString();
	}
	
	@Test
	public void testAdd() {
		Scanner sc = new Scanner(System.in);		
				
		//System.out.println("Enter customer details:");
		
		//System.out.println("NAME:");
		String name = gRSOLF();
		
		//System.out.println("EMAIL:");
		String email = gRSOLF()+"@"+gRSOLF()+".com";
		
		//System.out.println("CITY:");
		String city = gRSOLF();
		
		//System.out.println("PASSWORD:");
		String password = gRSOLF()+gRSOLF();
		
		Customer c = new Customer();
		c.setName(name);
		c.setEmail(email);
		c.setCity(city);
		c.setPassword(password);
		
		CustomerDao cd = new CustomerDao();
		cd.add(c);
	}
	
	@Test
	public void testFetchById() {	
		CustomerDao dao = new CustomerDao();
		
		Customer c = dao.fetchById(41);
		assertNotNull(c);
		System.out.println(c.getName());
		System.out.println(c.getEmail());
		System.out.println(c.getCity());
		System.out.println(c.getPassword());
	}
	
	@Test
	public void testUpdate() {
		Scanner sc = new Scanner(System.in);
		
		//System.out.println("Enter customer details:");

		//System.out.println("ID:");
		int id = 41;//Integer.parseInt(sc.next());
		
		//System.out.println("NAME:");
		String name = gRSOLF();
		
		//System.out.println("EMAIL:");
		String email = gRSOLF()+"@"+gRSOLF()+".com";
		
		//System.out.println("CITY:");
		String city = gRSOLF();
		
		//System.out.println("PASSWORD:");
		String password = gRSOLF()+gRSOLF();
		
		Customer c = new Customer();
		c.setId(id);
		c.setName(name);
		c.setEmail(email);
		c.setCity(city);
		c.setCity(password);
		
		CustomerDao cd = new CustomerDao();
		cd.update(c);
	}
	
	@Test
	public void testFetchByEmail() {
		Scanner sc = new Scanner(System.in);

		//System.out.println("NAME:");
		String email = "sOHy@yMBy.com";
		
		//System.out.println("EMAIL:");
		String password = "eQTJZDUS";
		
		CustomerDao cd = new CustomerDao();
		
		Customer c=cd.fetchByEmail(email,password);
		System.out.println(c.toString());
	}	
	
	@Test
	public void testFetchByCity() {
		Scanner sc = new Scanner(System.in);

		String city = "Mumbai";
		
		CustomerDao cd = new CustomerDao();
		
		List<Customer> list=cd.fetchByCity(city);
		
		/*for(Customer c:list)
		{
			System.out.println(c.getName());
			System.out.println(c.getCity());
			System.out.println(c.getEmail()+"\n");
		}*/

		//Printing in lambda style
		list.forEach(c ->
		{
			System.out.println(c.getName());
			System.out.println(c.getCity());
			System.out.println(c.getEmail()+"\n");
		});
		//System.out.println(list.toString()+"\n");
	}
	
}
