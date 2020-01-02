package solver.tree;

public class Node<T> {
    private final T value;
    private final T right;
    private final T left;

    public Node(T value, T right, T left) {
        this.value = value;
        this.right = right;
        this.left = left;
    }

    public T value() {
        return value;
    }

    public T right() {
        return right;
    }

    public T left() {
        return left;
    }
}
