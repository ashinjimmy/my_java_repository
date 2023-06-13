package com.java.hackerrank.practice;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array of integers, calculate the ratios of its elements that are positive, 
 *negative, and zero.
 *
 * Print the ratios of positive, negative and zero values in the array. 
 * Each value should be printed on a separate line with  digits after the decimal. 
 * The function should not return a value.
 * 
 * Print the following  lines, each to  decimals:
   proportion of positive values
   proportion of negative values
   proportion of zeros
 * Example
   0.400000
   0.400000
   0.200000
 *
 **/

public class PlusMinus {

	private static void plusMinus(List<Integer> arr) {
		double positive = 0, negative = 0, zero = 0;
		int arraySize = arr.size();
		for (int i = 0; i < arr.size(); i++) {

			if (arr.get(i) > 0)
				positive++;
			else if (arr.get(i) < 0)
				negative++;
			else
				zero++;

		}
		System.out.println(positive / arraySize);
		System.out.println(negative / arraySize);
		System.out.println(zero / arraySize);

	}

	public static void main(String[] args) throws IOException {
		List<Integer> arr = Arrays.asList(-4, 3, -9, 0, 4, 1);
		PlusMinus.plusMinus(arr);
	}

}
