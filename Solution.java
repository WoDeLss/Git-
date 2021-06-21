import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;


public class Solution {
	//中缀表达式变成后缀表达式
	public ArrayList<String> postfix(String s) {
		//转换成字符数组
		//创建一个栈
		ArrayList<String> num = new ArrayList<String>();
		//用数组来实现
		String str = "";
		int index = -1;
		//这个for循环的作用是把字符串给分隔开，并没有判断输入的数据是否合法
		for(int i =0;i<s.length();i++) {
			//如果是符号，就单独的加入num里边
			if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='/'||s.charAt(i)=='*'||s.charAt(i)=='('||s.charAt(i)==')'||s.charAt(i)=='%') {
				//先把数存进去
				if(!str.isEmpty()) {
					//先判断是否为空
					//若是空，正常写
					//不是空，则看
					//符号的情况
					if(!num.isEmpty()&&num.get(index).equals("-")) {
						if(index==0||num.get(index-1).equals("(")) {
							num.set(index,"-1");
						}
						else {
							num.set(index, "+");
							num.add("-1");
							index++;
						}
						num.add("*");
						index++;
					}
					//百分号的情况
					num.add(String.valueOf(Math.abs(Double.valueOf(str))));
					index++;
				}
				//特别注意‘-’
				num.add(String.valueOf(s.charAt(i)));
				index++;
				str = "";
			}
			
			//考虑括号的匹配
			//是数字的情况
			else
				str = str+s.charAt(i);
		}
		if(!str.isEmpty()) {
			num.add(str);
		}
		//以上已经转换为了字符串数组
		//我们需要使用num这个字符串数组，所以梦我把这个方法一拆为二
		//其一，返回正常的字符数组
		//其二，返回后缀表达式
		return num;
	}
	
	public String[] houzhui(ArrayList<String> num) {
		ArrayList<String> stack = new ArrayList<String>();//要返回的结果
		//便于字符串相加
		Deque<String> stackfh = new ArrayDeque<String>();//符号来入栈
		int i=0;
		String str = "";
		while(i<num.size()) {
			//是数字的话，加入字符串
			str = num.get(i);
			if(!str.equals("+")&&!str.equals("-")&&!str.equals("/")&&!str.equals("*")&&!str.equals("(")&&!str.equals(")")&&!str.equals("%")) {
				stack.add(str);
			}
			//是符号的话，入栈
			else {
				if(stackfh.isEmpty())
					stackfh.push(str);
				else {
					//当前符号的优先级大于栈顶元素的优先级，则把当前符号入栈
					if(priority(stackfh.peek())<priority(str)) {
						stackfh.push(str);
					}
					else {
						//是），弹到最近的一个（
						if(str.equals(")")) {
							while(!stackfh.peek().equals("(")) {
								stack.add(stackfh.pop());
								if(stackfh.isEmpty()) break;
							}
							if(!stackfh.isEmpty())
								stackfh.pop();
						}
						else {
							while(priority(stackfh.peek())>=priority(str)&&!stackfh.peek().equals("("))
							{
									stack.add(stackfh.pop());
									if(stackfh.isEmpty()) {
										break;
								}
							}
							stackfh.push(str);
						}
					}
				}
			}
			i++;
		}
		while(!stackfh.isEmpty())
		{
			//str.append(stack.pop());
			stack.add(stackfh.pop());
		}
		//Object[]  转换为String[]
		return Arrays.stream(stack.toArray()).toArray(String[]::new);
	}
	
	//传入后缀表达式
	public double calculation(String[] s) {
		
		//创建一个栈
		Deque<Double> stack = new ArrayDeque<Double>();
		int i = 0;
		while(i<s.length) {
			//原来写的，只针对个位数的加减乘除
			//要想做到多位数的加减乘除，这个if限制条件必须要改
			//思路：换成字符串数组，每一个元素既可以存放多位的数据，也可以存放单个的符号
			if(!s[i].equals("+")&&!s[i].equals("-")&&!s[i].equals("/")&&!s[i].equals("*")&&!s[i].equals("(")&&!s[i].equals(")")&&!s[i].equals("%")) {
				stack.push(Double.valueOf(s[i]));
			}
			else {
				double A = stack.pop();
				double B = stack.pop();
				if(s[i].equals("+")) stack.push(A+B);
				else if(s[i].equals("-")) stack.push(B-A);
				else if(s[i].equals("*")) stack.push(A*B);
				else if(s[i].equals("/")) stack.push(B/A);
			}
			i++;
		}
		return (double)stack.peek();
	}
	
	//判断符号的优先级
	public int priority(String c) {
		int find = 0;
		if(c.equals("+")||c.equals("-")) find = 1;
		else if(c.equals("*")||c.equals("/")) find = 2;
		else if(c.equals("(")) find = 3;
		else if(c.equals(")")) find = 0;
		return find;
	}
	

	public double Recursion(String[] s) {//index是

		String str = "";
		int len = s.length;
		for(int i=len-1;i>0;i--) {
			if(!s[i].equals("(")) {//这个判断有问题
				str = s[i] + str;
			}
			else
			  break;
		}
		//如果（右边的式子合法，就加上）
		if(str.equals("")||InputLegal(str)) 
			return 1;
		return 0;
	}    
	public boolean InputLegal(String s) {
		try {
			
			double res = calculation(houzhui(postfix(s)));
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
