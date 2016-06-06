package com.iokays.algorithms.search;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 
 *  计算表达式
 * 
 * @author pengyuanbing@gmail.com
 *
 */
public class Evaluate {
	
	/**
	 * Dijkstra 的双栈算术表达式求值
	 */
	public static void dijkstra(final String exps) {
		if (null != exps && !"".equals(exps.trim())) {
			Stack<String> ops = new Stack<>();
			Stack<Double> vals = new Stack<>();
			
			String[] strings = exps.trim().split(" ");
			for (String s : strings) {
				if ("(".equals(s)) {
					//nothing
				} else if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s) || "sqrt".equals(s)) {
					ops.push(s);
				} else if (")".equals(s)) {
					String op = ops.pop();
					double val = vals.pop();
					if ("+".equals(op)) {
						vals.push(val + vals.pop());
					} else if ("-".equals(op)) {
						vals.push(val - vals.pop());
					} else if ("*".equals(op)) {
						vals.push(val * vals.pop());
					} else if ("/".equals(op)) {
						vals.push(val / vals.pop());
					} else if ("sqrt".equals(op)) {
						vals.push(Math.sqrt(val));
					} else {
						vals.push(val);
					}
				} else {
					vals.push(Double.valueOf(s));
				}
			}
			
			StdOut.println(exps + " = " + vals.pop());
		}
	}
	
	/**
	 * 补全 表达式的左括号
	 * @param exps
	 */
	public static void leftDijkstra(final String exps) {
		if (null != exps && !"".equals(exps.trim())) {
			Stack<String> ops = new Stack<>();
			Stack<String> vals = new Stack<>();
			
			String[] strings = exps.trim().split(" ");
			for (String s : strings) {
				if ("(".equals(s)) {
					//nothing
				} else if ("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s) || "sqrt".equals(s)) {
					ops.push(s);
				} else if (")".equals(s)) {
					String op = ops.pop();
					String val = vals.pop();
					
					if ("+".equals(op) || "-".equals(op) || "*".equals(op) || "/".equals(op) || "sqrt".equals(op)) {
						vals.push("( " + val + " " + op + " " + vals.pop() + " )");
					} else {
						vals.push(val);
					}
				} else {
					vals.push(s);
				}
			}
			
			StdOut.print(exps + " = ");
			while (!vals.isEmpty()) {
				StdOut.print(vals.pop());
			}
		}
	}
	
	public static void main(String[] args) {
		dijkstra(" 1 + 2 ) * 1 + 2 ) )");
		leftDijkstra(" 1 + 2 ) * 1 + 2 ) )");
	}
}
