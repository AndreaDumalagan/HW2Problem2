public class HW2Problem3 {
    public static void main(String[] args) {

        linkedList quick3Sort = new linkedList();

        //Pushing arbitrary values below:
        quick3Sort.add(33);
        quick3Sort.add(12);
        quick3Sort.add(78);
        quick3Sort.add(3);
        quick3Sort.add(14);
        quick3Sort.add(7);
        quick3Sort.add(9);
        quick3Sort.add(11);
        quick3Sort.add(8);
        quick3Sort.add(1);

        //Print linked list as is:
        System.out.println("Values in linked list: ");
        quick3Sort.printList();
        System.out.println(" ");

        //Use "shuffle" function and print shuffled list:
        quick3Sort.shuffle();
        System.out.print("Shuffled list: ");
        quick3Sort.printList();
        System.out.println(" ");

        //Use "quickSort" function and print out sorted linked list:
        quick3Sort.quickSort();
        quick3Sort.printList();
    }

    //LinkedList data structure
    public static class linkedList{

        Node last;
        private Node head;

        //Node class
        public class Node{
            Node node;
            int data;

            //Constructor for the Node class
            Node(int a) {
                data = a;
            }
        }

        //LinkedList constructor
        linkedList(){
            //Constructor: empty
        }

        //Function "add": pushes new values whenever called in main
        public void add(int a) {
            Node currentHead = new Node(a);
            if(head == null) {
                //If linked list is empty, both the head of the linked list
                //and last of the linked list equal the same value
                head = currentHead;
                last = currentHead;
            }
            else {
                //Last: meaning, last in but first out
                //The last inserted value (which is the first to pop off the linked list) will equal currentHead
                //currentHead is assigned to parameter 'a' of the function argument
                last.node = currentHead;
                last = currentHead;
            }
        }
        //Function "partition":
        private Node partition(Node x,Node y) {
            Node a = x;
            Node b = x;
            while(b != null) {
                a = a.node;
                b = b.node;

                if (b == null){
                    break;
                }
                b = b.node;
            }

            int help = x.data;
            int me = y.data;
            int ugh = a.data;

            if ((help > me && help <= ugh) || (help < me && help >= ugh)) {
                return x;
            }
            else if ((me > help && me <= ugh)||(me < help && me >= ugh)) {
                return y;
            }
            else {
                return a;
            }
        }

        private Node decrement(Node x) {
            Node a = head;
            while (a.node != x)
            {
                a = a.node;
            }
            return a;
        }

        //Function "printList": prints values in linked list when called in main
        public void printList() {
            Node o = head;

            //While 'o' does not equal null, it will continue printing down the linked list
            while(o != null) {
                System.out.print(o.data + ",");
                o = o.node;
            }
        }

        //Function "shuffle": shuffles the linked list arbitrarily
        public void shuffle() {
            int total = 0;
            Node a = head;
            while(a != null) {
                total++;
                a = a.node;
            }

            a = head;
            Node b;
            int r;
            int temp;

            for(int i = 0; i < total; i++) {
                r = (int)(Math.random()*total);
                b = head;
                for(int j = 0; j < r; j++) {
                    b = b.node;
                }
                temp = a.data;
                a.data = b.data;
                b.data = temp;
                a = a.node;
            }

        }

        //Function "quickSort": 3-way quickSort done on linked list when called in main
        public void quickSort()
        {
            sort(head, last);
        }

        //Function "sort": work behind the "quickSort" function--actually implemented below
        private void sort(Node x, Node y) {

            if(checkVal(y,x)) {
                return;
            }

            Node a = x;
            Node b = y;
            Node c = partition(x, y);

            int vd = c.data;
            swap(partition(x, y), x);

            Node i = x;
            while (checkVal(i, b))
            {
                if (i.data < vd)
                {
                    swap(i,a);
                    a=a.node;
                    if(i.node == null)
                        break;
                    i = i.node;
                }
                else if(i.data > vd) {
                    swap(i,b);
                    b = decrement(b);
                }
                else {
                    if (i.node == null){
                        break;
                    }
                    i = i.node;

                }
            }
            sort(x, decrement(a));
            sort(b.node,y);
        }

        //Function "swap": prints out the values that are swapped in the linked list;
        //called in "sort" function
        private void swap(Node x, Node y) {

            System.out.println("Swapped " + x.data + " and " + y.data);

            int t = x.data;
            x.data = y.data;
            y.data = t;
        }

        //Function "checkVal":
        private boolean checkVal(Node x, Node y) {
            if (y == null) {
                return true;
            }
            if (x == null) {
                return true;
            }
            while(x != null) {
                if(x == y) {
                    return true;
                }
                x = x.node;
            }
            return false;
        }
    }
}
