public class Pair {
	TreeNode keyNode;
	int level;

	Pair(TreeNode keyNode, int level) {
		this.keyNode = keyNode;
		this.level = level;

	}

	public Pair() {
		super();
	}

	public TreeNode getKeyNode() {
		return keyNode;
	}

	public void setKeyNode(TreeNode keyNode) {
		this.keyNode = keyNode;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
