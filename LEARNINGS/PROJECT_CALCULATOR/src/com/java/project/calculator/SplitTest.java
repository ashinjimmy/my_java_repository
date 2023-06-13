package com.java.project.calculator;

import java.util.Arrays;

public class SplitTest {

	public static void main(String[] args) {
		String var = "123233-33335";
		String[]arr = var.split("[0-9]+");
		System.out.println(Arrays.toString(arr));
	}
}
