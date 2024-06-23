package ThreadedBinaryTree;

public class ThreadedBinaryTree {
    private Node root;

    ThreadedBinaryTree() {
        root = null;
    }

    // For inserting the Node
    public boolean insert(int data) {
        Node newn = new Node(data);

        if (root == null) {
            root = newn;
            return true;
        }

        // Assigning the root to the temp for the interation
        Node parent = root;

        // while for repeating the same steps
        while (true) {
            // Check for the duplicates
            if (parent.getData() == data) {
                return false;
            }

            // if data is less than current parent node
            if (parent.getData() > data) {
                // Check if left flag of the parent node is T(Thread) then we insert it.
                if (parent.getLflag() == 'T') {
                    newn.setRight(parent); // first we are creating the newn thread to parent
                    newn.setLeft(parent.getLeft()); // coping the parent left to newn node left -- (PREDESSESOR)
                    parent.setLeft(newn); // creating the link to the parent to the newn node
                    parent.setLflag('L'); // changing the left flag of the parent to L because now parent has a left
                                          // child
                    return true;
                }
                // if flag is not T then shift if to the left of the current parent.
                parent = parent.getLeft();
            } else {
                if (parent.getRflag() == 'T') {
                    newn.setLeft(parent); // newn node creating the thread to the parent
                    newn.setRight(parent.getRight()); // newn node coping the parent right to the node right (SUCCESSOR)
                    parent.setRight(newn); // parent creating the link to the newn node
                    parent.setRflag('L'); // parent changing the flag to the L because he has a right child
                    return true;
                }
                parent = parent.getRight();
            }
        }
    }

    public void inOrder() {
        System.out.println("In-order :: ");
        Node temp = root;
        char flag = 'L';

        while (temp != null) {
            while (temp.getLflag() == 'L' && flag == 'L') {
                temp = temp.getLeft();
            }

            System.out.print(temp.getData() + " ");
            flag = temp.getRflag();
            temp = temp.getRight();
        }
        System.out.println();
    }

    public void preOrder() {
        System.out.println("Pre-order ::");
        Node temp = root;
        char flag = 'L';

        while (temp != null) {
            while (temp.getLflag() == 'L' && flag == 'L') {
                System.out.print(temp.getData() + " ");
                temp = temp.getLeft();
            }

            if (flag == 'L') {
                System.out.print(temp.getData() + " ");
            }
            flag = temp.getRflag();
            temp = temp.getRight();
        }
        System.out.println();
    }

    public void postOrder() {
        Node temp = root;
        char flag = 'L';

        System.out.println("Post Order :: ");
        while (temp != null) {
            while (temp.getLflag() == 'L' && flag == 'L') {
                temp = temp.getLeft();
            }

            flag = temp.getRflag();
            if (flag == 'L') {
                temp = temp.getRight();
            } else {
                while (true) {
                    System.out.print(temp.getData() + " ");

                    if (isRightChild(temp)) {
                        while (temp.getLflag() == 'L') {
                            temp = temp.getLeft();
                        }
                        temp = temp.getLeft();
                    } else {
                        while (temp.getRflag() == 'L') {
                            temp = temp.getRight();
                        }
                        temp = temp.getRight();
                        break;
                    }
                }
            }

        }
    }

    public boolean isRightChild(Node node) {
        Node temp = root;
        if (root == node) {
            return false;
        }

        while (true)
            if (temp.getData() > node.getData()) {
                temp = temp.getLeft();
                if (temp == node) {
                    return false;
                }
            } else {
                temp = temp.getRight();
                if (temp == node) {
                    return true;
                }
            }
    }

    public boolean delete() {
        if (root == null) {
            return false;
        }

        Node deletable = root;
        Node parent = root;

        
        return true;
    }
}