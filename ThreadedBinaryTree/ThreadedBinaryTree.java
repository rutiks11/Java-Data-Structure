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
        System.out.println();
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

    public boolean delete(int data) {
        if (root == null) {
            return false;
        }

        // Step 0
        // parent and deletable node
        Node parent = root; // parent of deletable node cause we are unlinking
        Node del = root; // node which we wnat to deleted

        // Step 1
        // Locate the deletable along with their parent
        while (true) {
            // check data and break the loop
            if (del.getData() == data) {
                break;
            }
            if (data < del.getData()) {
                // if we doesnt have that data that we want to delete
                if (del.getLflag() == 'T') {
                    return false;
                }
                // locate the parent
                parent = del;
                // shift to the left node
                del = del.getLeft();
            } else {
                if (del.getRflag() == 'T') {
                    return false;
                }
                parent = del;
                del = del.getRight();
            }
        }

        while (true) {
            // Step 2
            // check if deletable node is the terminal node
            if (del.getLflag() == 'T' && del.getRflag() == 'T') {
                if (parent.getLeft() == del) {
                    parent.setLeft(del.getLeft());
                    parent.setLflag('T');
                } else {
                    parent.setRight(del.getRight());
                    parent.setRflag('T');
                }
                return true;
            }

            // Step 3
            // check if it is not terminal node
            if (del.getLflag() == 'L') {
                Node max = del.getLeft();
                parent = del;

                while (max.getRflag() == 'L') {
                    parent = max;
                    max = max.getRight();
                }
                // Swap the value
                int temp = del.getData();
                del.setData(max.getData());
                max.setData(temp);

                del = max;
            } else {
                Node min = del.getRight();

                while (min.getLflag() == 'L') {
                    parent = min;
                    min = min.getLeft();
                }

                // swap the value
                int temp = del.getData();
                del.setData(min.getData());
                min.setData(temp);

                del = min;
            }
        }

    }

    // public boolean delete(int data) {
    // // if root is null then delete it
    // if (root == null) {
    // return false;
    // }

    // Node parent = root;
    // Node del = root;

    // // Locate the deletable node
    // while (true) {
    // // If we locate the deletable node then break the while loop
    // if (del.getData() == data) {
    // break;
    // }

    // if (data < del.getData()) {
    // if (del.getLflag() == 'T') {
    // return false;
    // }
    // parent = del;
    // del = del.getLeft();
    // } else {
    // if (del.getRflag() == 'T') {
    // return false;
    // }
    // parent = del;
    // del = del.getRight();
    // }
    // }

    // while (true) {
    // // check if deletable node is terminal node
    // if (del.getLflag() == 'T' && del.getRflag() == 'T') {
    // if (del == root) {
    // root = null;
    // return true;
    // }
    // // Check deletable node is right or left
    // if (parent.getLeft() == del) {
    // // if it is a left
    // parent.setLeft(del.getLeft()); // copy del left into parent left -- copy
    // predessesor
    // parent.setLflag('T'); // change the left flag to the T cause we are linking
    // the thread to parent
    // // left
    // } else {
    // parent.setRight(del.getRight()); // copy del right into parent right -- copy
    // successor
    // parent.setRflag('T'); // change the right flag to the T cause we are linking
    // the thread to parent
    // // left
    // }
    // return true;
    // }

    // // If it not the terminal tree
    // if (del.getLflag() == 'L') {
    // // keep del node at the node that you want to delete

    // // create node for swapping
    // // Assign the del left to max node to find the max between the subtree so
    // that
    // // we can replace with the root
    // Node max = del.getLeft();
    // parent = del;

    // while (max.getRflag() == 'L') {
    // parent = max;
    // max = max.getRight();
    // }

    // // swap the nodes del and max
    // // non terminal node becomes the terminal node now
    // int temp = max.getData();
    // max.setData(del.getData());
    // del.setData(temp);

    // // Now change the position of the deletable node to the terminal node
    // del = max;
    // } else {
    // Node min = del.getRight();
    // parent = del;

    // while (min.getLflag() == 'L') {
    // parent = min;
    // min = min.getLeft();
    // }

    // // Now swap the nodes
    // int temp = min.getData();
    // min.setData(del.getData());
    // del.setData(temp);

    // del = min;
    // }

    // }

    // }

}