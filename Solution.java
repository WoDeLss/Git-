import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;


public class Solution {
	//��׺���ʽ��ɺ�׺���ʽ
	public ArrayList<String> postfix(String s) {
		//ת�����ַ�����
		//����һ��ջ
		ArrayList<String> num = new ArrayList<String>();
		//��������ʵ��
		String str = "";
		int index = -1;
		//���forѭ���������ǰ��ַ������ָ�������û���ж�����������Ƿ�Ϸ�
		for(int i =0;i<s.length();i++) {
			//����Ƿ��ţ��͵����ļ���num���
			if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='/'||s.charAt(i)=='*'||s.charAt(i)=='('||s.charAt(i)==')'||s.charAt(i)=='%') {
				//�Ȱ������ȥ
				if(!str.isEmpty()) {
					//���ж��Ƿ�Ϊ��
					//���ǿգ�����д
					//���ǿգ���
					//���ŵ����
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
					//�ٷֺŵ����
					num.add(String.valueOf(Math.abs(Double.valueOf(str))));
					index++;
				}
				//�ر�ע�⡮-��
				num.add(String.valueOf(s.charAt(i)));
				index++;
				str = "";
			}
			
			//�������ŵ�ƥ��
			//�����ֵ����
			else
				str = str+s.charAt(i);
		}
		if(!str.isEmpty()) {
			num.add(str);
		}
		//�����Ѿ�ת��Ϊ���ַ�������
		//������Ҫʹ��num����ַ������飬�������Ұ��������һ��Ϊ��
		//��һ�������������ַ�����
		//��������غ�׺���ʽ
		return num;
	}
	
	public String[] houzhui(ArrayList<String> num) {
		ArrayList<String> stack = new ArrayList<String>();//Ҫ���صĽ��
		//�����ַ������
		Deque<String> stackfh = new ArrayDeque<String>();//��������ջ
		int i=0;
		String str = "";
		while(i<num.size()) {
			//�����ֵĻ��������ַ���
			str = num.get(i);
			if(!str.equals("+")&&!str.equals("-")&&!str.equals("/")&&!str.equals("*")&&!str.equals("(")&&!str.equals(")")&&!str.equals("%")) {
				stack.add(str);
			}
			//�Ƿ��ŵĻ�����ջ
			else {
				if(stackfh.isEmpty())
					stackfh.push(str);
				else {
					//��ǰ���ŵ����ȼ�����ջ��Ԫ�ص����ȼ�����ѵ�ǰ������ջ
					if(priority(stackfh.peek())<priority(str)) {
						stackfh.push(str);
					}
					else {
						//�ǣ������������һ����
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
		//Object[]  ת��ΪString[]
		return Arrays.stream(stack.toArray()).toArray(String[]::new);
	}
	
	//�����׺���ʽ
	public double calculation(String[] s) {
		
		//����һ��ջ
		Deque<Double> stack = new ArrayDeque<Double>();
		int i = 0;
		while(i<s.length) {
			//ԭ��д�ģ�ֻ��Ը�λ���ļӼ��˳�
			//Ҫ��������λ���ļӼ��˳������if������������Ҫ��
			//˼·�������ַ������飬ÿһ��Ԫ�ؼȿ��Դ�Ŷ�λ�����ݣ�Ҳ���Դ�ŵ����ķ���
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
	
	//�жϷ��ŵ����ȼ�
	public int priority(String c) {
		int find = 0;
		if(c.equals("+")||c.equals("-")) find = 1;
		else if(c.equals("*")||c.equals("/")) find = 2;
		else if(c.equals("(")) find = 3;
		else if(c.equals(")")) find = 0;
		return find;
	}
	

	public double Recursion(String[] s) {//index��

		String str = "";
		int len = s.length;
		for(int i=len-1;i>0;i--) {
			if(!s[i].equals("(")) {//����ж�������
				str = s[i] + str;
			}
			else
			  break;
		}
		//������ұߵ�ʽ�ӺϷ����ͼ��ϣ�
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
