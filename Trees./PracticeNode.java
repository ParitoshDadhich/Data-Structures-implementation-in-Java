package Tree;

import java.util.ArrayList;

public class PracticeNode<T> {
	T data;
	ArrayList<PracticeNode<T>> children;
	
	public PracticeNode(T data) {
		this.data = data;
		children = new ArrayList<PracticeNode<T>>();
	}
}
