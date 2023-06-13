package com.java.hackerrank.practice;

import java.util.Arrays;
import java.util.List;

public class MedianOfList {

	
	private static int findMedian(List<Integer> arr) {
		int medianIndex = arr.size()/2;
		System.out.println(medianIndex);
		return arr.get(medianIndex);
	}
	
	
	public static void main(String[] args) {
		
		List<Integer> arr = Arrays.asList(0,1,2,3,4,5,6);
		int medianVal = MedianOfList.findMedian(arr);
		System.out.println(medianVal);
	}

	
	
}
