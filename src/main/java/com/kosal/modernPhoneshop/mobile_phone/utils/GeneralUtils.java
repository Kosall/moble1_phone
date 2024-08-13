package com.kosal.modernPhoneshop.mobile_phone.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GeneralUtils {
	//convert list of String to list of Integer
	public static List<Integer> conversion(List<String> n){
		 List<Integer> list = n.stream()
			.map(l->l.length())
			.collect(Collectors.toList());
		return list;
	}
}
