import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Main {
public static void main(String args[]) throws ScriptException {
	Solution s = new Solution();
	Scanner reader = new Scanner(System.in);
	String re = reader.nextLine();
	System.out.print(s.calculation(s.houzhui(s.postfix(re))));
	
}
}
