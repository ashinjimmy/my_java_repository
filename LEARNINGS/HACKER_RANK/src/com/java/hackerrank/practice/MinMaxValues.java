package com.java.hackerrank.practice;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Given five positive integers, find the minimum and maximum values
 *  that can be calculated by summing exactly four of the five integers. 
 *  Then print the respective minimum and maximum values as a single line 
 *  of two space-separated long integers.*/

public class MinMaxValues {

	public static void miniMaxSum(List<Integer> arr) {

		long minSum = 0, maxSum = 0;
		int arraySize = arr.size();
		Collections.sort(arr);
		for (int i = 1; i < arraySize; i++) {
			maxSum = maxSum + arr.get(i);
		}

		for (int i = 0; i < arraySize - 1; i++) {
			minSum = minSum + arr.get(i);
		}
		
		System.out.println(minSum + " " + maxSum);

	}

	public static void main(String[] args) throws IOException {
		List<Integer> arr = Arrays.asList(7,69,2,221,8974);
		MinMaxValues.miniMaxSum(arr);
	}

}
