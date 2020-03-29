package treebylevels;

import java.util.*;

public class Kata {
	public static List<Integer> treeByLevels(Node node) {
		List<Integer> leveltr = new ArrayList<>();
		if (node == null) {
			return leveltr;
		}
		List<Node> queue = new ArrayList<>();
		queue.add(node);
		while (queue.size() > 0) {
			Node tpt = queue.get(0);
			leveltr.add(tpt.value);
			queue.remove(tpt);
			if (tpt.left != null)
				queue.add(tpt.left);
			if (tpt.right != null)
				queue.add(tpt.right);
		}

		return leveltr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// List<Integer> leveltr = new ArrayList<>();
		System.out.print(treeByLevels(new Node(new Node(null, new Node(null, null, 4), 2),
				new Node(new Node(null, null, 5), new Node(null, null, 6), 3), 1)));
	}
}
