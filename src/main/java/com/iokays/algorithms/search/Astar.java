package com.iokays.algorithms.search;

import java.util.Set;

import com.google.common.collect.Sets;

import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.GraphGenerator;
import edu.princeton.cs.algs4.StdOut;

/**
 * A*算法
 * 
 * @author pengyuanbing@gmail.com
 *
 */
public final class Astar {
	
	public static final void search(final EdgeWeightedGraph graph, final int start, final int goal) {
		Set<Integer> closed = Sets.newHashSet();
		Set<Integer> open = Sets.newHashSet(); 
	}
	
	public static void main(String[] args) {
		final EdgeWeightedGraph graph = GraphGenerator.wheelWeighted(10, 20);	//创建一个联通带权限的无向图
		StdOut.println(graph);
	}
}
