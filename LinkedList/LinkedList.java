package LinkedList;

public class LinkedList implements LinkedListOperations {
    ListNode head = null;

    public LinkedList(ListNode Head) {
        this.head = Head;
    }

    public int Size() {
        int sum = 0;
        ListNode dummyNode = head;
        while (dummyNode != null) {
            sum++;
            dummyNode = dummyNode.next;
        }
        return sum;
    }

    public boolean Empty() {
        return head == null;
    }

    public int Value_At(int index) {
        int cur = 0;
        ListNode dummyNode = head;

        while (dummyNode != null) {
            if (cur == index)
                return dummyNode.data;
            cur++;
            dummyNode = dummyNode.next;
        }

        return Integer.MIN_VALUE;
    }

    public int Pop_Front() {
        if (head != null) {
            int val = head.data;
            head = head.next;
            return val;
        }
        return Integer.MIN_VALUE;
    }

    public int Front() {
        if (head != null)
            return head.data;
        return Integer.MIN_VALUE;
    }

    public int Back() {
        int last = Integer.MIN_VALUE;
        ListNode dummyNode = head;
        while (dummyNode != null) {
            last = dummyNode.data;
            dummyNode = dummyNode.next;
        }
        return last;
    }

    public int Value_N_From_End(int n) throws Exception {
        ListNode dummyNode = head;
        int target = Integer.MIN_VALUE;

        if (n > Size()) {
            throw new Exception("Overflow");
        }

        int value_n_from_front = Size() - n - 1;
        for (int i = 0; i <= value_n_from_front; i++) {
            target = dummyNode.data;
            dummyNode = dummyNode.next;
        }
        return target;
    }

    public void Erase(int index) {
        int cur = 0;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        while (dummyNode.next != null) {
            if (cur == index) {
                dummyNode.next = dummyNode.next.next;
                break;
            }
            cur++;
            dummyNode = dummyNode.next;
        }
    }

    public void PrintList() {
        ListNode dummyNode = head;
        while (dummyNode != null) {
            System.out.print(dummyNode.data + ", ");
            dummyNode = dummyNode.next;
        }
        System.out.println();
    }

    public void Push_Front(int x) {
        ListNode new_node = new ListNode(x);
        if (head == null) {
            head = new_node;
        } else {
            new_node.next = head;
            head = new_node;
        }
    }

    public void Push_Back(int x) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        while (dummyNode.next != null) {
            dummyNode = dummyNode.next;
        }
        dummyNode.next = new ListNode(x);
    }

    public void Delete(int x) {
        if(head == null){
            return;
        }
        while (head.next != null) {
            if (head.next.data == x) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
    }

    public void Clear() {
        head = null;
    }

    public void Reverse() {
        ListNode cur = head;
        ListNode next = null;
        ListNode prev = null;

        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);

        LinkedList linkedList = new LinkedList(head);
        System.out.print("Print LinkedList: ");
        linkedList.PrintList();

        System.out.print("Size: ");
        System.out.print(Integer.toString(linkedList.Size()));
        System.out.println();

        System.out.print("Empty: ");
        System.out.print(Boolean.toString(linkedList.Empty()));
        System.out.println();

        System.out.print("Value at index 3: ");
        System.out.print(Integer.toString(linkedList.Value_At(3)));
        System.out.println();

        System.out.print("Pop the front item: ");
        System.out.print(Integer.toString(linkedList.Pop_Front()));
        System.out.println();
        System.out.print("LinkedList: ");
        linkedList.PrintList();

        System.out.print("Front item: ");
        System.out.print(Integer.toString(linkedList.Front()));
        System.out.println();

        System.out.print("Back item: ");
        System.out.print(Integer.toString(linkedList.Back()));
        System.out.println();

        System.out.print("Value 2 from end: ");
        try {
            System.out.print(Integer.toString(linkedList.Value_N_From_End(2)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        
        System.out.print("Linkedlist before erasing: ");
        linkedList.PrintList();
        System.out.println("Erase the linkedList item with index 2");
        linkedList.Erase(2);
        System.out.print("Linkedlist after erasing: ");
        linkedList.PrintList();

        System.out.print("Push 1 in the front: ");
        linkedList.Push_Front(1);
        linkedList.PrintList();

        System.out.print("Push 5 in the back: ");
        linkedList.Push_Back(5);
        linkedList.PrintList();

        System.out.print("Delete First item with 0: ");
        linkedList.Delete(1);
        linkedList.PrintList();

        System.out.print("Reverse a Linkedlist: ");
        linkedList.Reverse();
        linkedList.PrintList();

        System.out.print("Clear Linkedlist: ");
        linkedList.Clear();
        linkedList.PrintList();
    }

}