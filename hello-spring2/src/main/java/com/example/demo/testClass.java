package com.example.demo;

import java.lang.reflect.Field;

public class testClass {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		System.out.println(String.class.getClass().getName());
		
		String temp = "";
		System.out.println(temp.getClass().getSuperclass().getName());
		
		//System.out.println(temp.getClass().getSuperclass().getSuperclass().getName());
		
		//Field field = temp.getClass().getDeclaredField(temp);

	}

}
