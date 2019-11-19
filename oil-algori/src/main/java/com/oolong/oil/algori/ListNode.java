package com.oolong.oil.algori;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		val = x;
	}
	public String toString()	{
		ListNode cur = this;
		StringBuffer sb = new StringBuffer();
		while(cur != null)	{
			sb.append(cur.val+" -> ");
			cur= cur.next;
		}
		sb.append(" null ");
		return sb.toString();
	}
	
	public static ListNode makeList(int[] num)	{
		if(num.length == 0)	{
			return null;
		}
		ListNode head = new ListNode(num[0]);
		ListNode cur = head;
		for(int i=1;i<num.length;i++)	{
			ListNode newNode = new ListNode(num[i]);
			cur.next = newNode;
			cur=newNode;
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = makeList(new int[]{4,5,1,3});
		System.out.println(head);
		
		for(char i='0';i<='a';i++)	{
			System.out.print(i);
		}
	}
}
