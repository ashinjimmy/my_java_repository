package com.java.hackerrank.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeFormatChange {

//	 Conversion of 12 hours to 24 hours of time format
	private static void conversion(String inputTime) throws ParseException {

		SimpleDateFormat convertedFormat = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat parseFomrat = new SimpleDateFormat("hh:mm:ssa");
		//Date time = parseFomrat.parse(inputTime);
		System.out.println(convertedFormat.format(parseFomrat.parse(inputTime)));
	}
	
	public static void main(String[] args) throws ParseException {
		String inputTime = "07:05:45PM"; // Need to convert into 19:05:45
		TimeFormatChange.conversion(inputTime);
	}

	
}
