package com.iokays.algorithms.search;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DigraphGenerator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * A*算法
 * 
 * @author pengyuanbing@gmail.com
 *
 */
public final class Astar {

	private static class Node implements Comparable {
		int v; // 节点
		int c; // 步数

		public Node(int v, int c) {
			this.v = v;
			this.c = c;
		}

		@Override
		public String toString() {
			return "v: " + v + "c: " + c;
		}

		@Override
		public int compareTo(Object o) {
			return c - ((Node) o).c;
		}
	}

	public static void main(String[] args) {
		final int V = 10;
		final int E = 20;
		final Digraph digraph = DigraphGenerator.rootedOutDAG(V, E); // 创建一个有向图一定有且仅有一个起点。
		StdOut.println(digraph);

		int start; // 开始节点
		for (start = 0; start < V; start++) {
			if (digraph.indegree(start) == 0) {
				break;
			}
		}

		int goal = StdRandom.uniform(V); // 结束节点
		if (start == goal) {
			goal = (start + 1) % V;
		}
	}

}
