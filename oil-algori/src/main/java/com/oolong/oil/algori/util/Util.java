package com.oolong.oil.algori.util;

public class Util {
	public static void printArray(int[] arr)	{
		for(int i : arr)	{
			System.out.print(i+",");
		}
	}
	public static void printMatrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
	}
	public static void printMatrix(byte[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
	}
}
