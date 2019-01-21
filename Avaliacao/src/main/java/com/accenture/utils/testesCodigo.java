package com.accenture.utils;

public class testesCodigo {
	
	public static void main(String[] args) {
		String valor = "Price: $270";		
		valor = valor.substring(8,valor.length());
		System.out.println(valor);
		
		Integer price = new Integer(valor);
		price = price + 270;
		System.out.println(price.toString());
	}

}
