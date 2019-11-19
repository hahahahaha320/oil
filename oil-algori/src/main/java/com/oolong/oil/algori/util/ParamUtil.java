package com.oolong.oil.algori.util;


import com.oolong.oil.algori.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ParamUtil {
	
	private static String[] str2Arr(String str)	{
		str = str.replaceAll("[\t\r\n\\[\\]\"]","");
		String[] sa = str.split(",");
		return sa;
	}
	public static List<String> str2List(String str)	{
		String[] sa = str2Arr(str);
		List<String> result = new ArrayList<String>();
		for(String a : sa)	{
			result.add(a);
		}
		return result;
	}
	
	public static TreeNode str2TreeNode(String str)	{
		String[] sa = str2Arr(str);
		if("null".equals(sa[0]))	{
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(sa[0]));
		try	{
			BlockingQueue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
			queue.put(root);
			for(int i=1;i<sa.length;)	{
				TreeNode parent = queue.take();
				if(!"null".equals(sa[i]))	{
					parent.left = new TreeNode(Integer.parseInt(sa[i]));
					queue.put(parent.left);
				}
				i++;
				if(i>=sa.length){
					break;
				}
				if(!"null".equals(sa[i]))	{
					parent.right = new TreeNode(Integer.parseInt(sa[i]));
					queue.put(parent.right);
				}
				i++;
				
			}
		} catch(Exception e)	{
			e.printStackTrace();
			return null;
		}
		return root;
	}
	public static void printTreeNode(TreeNode root)	{
		if(root == null)	{
			System.out.println("null,");
			return;
		} else {
			System.out.print(root.val+",");
		}
		try	{
			BlockingQueue<TreeNode> queue = new LinkedBlockingQueue<TreeNode>();
			queue.put(root);
			int num = 1;
			while(!queue.isEmpty())	{
				TreeNode node = queue.take();
				if(node.left != null)	{
					queue.put(node.left);
					System.out.print(node.left.val+",");
				} else {
					System.out.print("null,");
				}
				if(node.right != null)	{
					queue.put(node.right);
					System.out.print(node.right.val+",");
				} else {
					System.out.print("null,");
				}
				num++;
				if(num % 10 == 0)	{
					System.out.println();
				}
			}
		} catch(Exception e)	{
			e.printStackTrace();
		}
	}
	public static int[] str2IntArr(String str)	{
		String[] sa = str2Arr(str);
		int[]  result = new int[sa.length];
		for(int i=0;i<sa.length;i++)	{
			result[i] = Integer.parseInt(sa[i]);
		}
		return result;
	}
	public static int[][] str2IntArrArr(String str)	{
		String[] sa = str.split("],");
		int[][]  result = new int[sa.length][];
		for(int i=0;i<sa.length;i++)	{
			result[i] = str2IntArr(sa[i]);
		}
		return result;
	}
	public static void printBiArr(int[][] dp)	{
		for(int i=0;i<dp.length;i++)	{
			for(int j=0;j<dp[i].length;j++)	{
				System.out.print(dp[i][j]+",");
			}
			System.out.println();
		}
	}
	public static void printArr(int[] arr)	{
		for(int i=0;i<arr.length;i++)	{
			System.out.print(arr[i]+",");
		}
		System.out.println();
	}

	
	public static void main(String[] args) {		
//		TreeNode root = str2TreeNode(testStr);
//		printTreeNode(root);
		String str = ""+/**~{*/""
			+ "[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]"
		+ "\r\n"/**}*/;
		List<String> result = str2List(str);
		System.out.println(result);
	}
	
	public static String testStr = ""+/**~{*/""
				+ "[100,4,200,1,3,2]"
			+ "\r\n"/**}*/;
}
