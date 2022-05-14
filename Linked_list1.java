// Implementing a linked list in Java - adding a node at the head and tail
class ll
{
    Node head;
    static int size;
    ll()
    {
        this.size=0;
    }
    class Node
    {
        String data;
        Node next;
        Node(String data)
        {
            this.data=data;
            this.next=null;
        }
    }
    public void addFirst(String data)
    {
        Node newNode=new Node(data);
        size++;
        if(head==null)
        {
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void addLast(String data)
    {
        Node newNode=new Node(data);
        size++;
        if(head==null)
        {
            head=newNode;
            return;
        }
        Node currNode=head;
        while(currNode.next!=null)
        currNode=currNode.next;
        currNode.next=newNode;
    }
    public void addAfterPrev(Node prev,String x)
    {
        if(prev==null)
        {
            System.out.println("Previous node cannot be null");
            return;
        }
        Node newNode=new Node(x);
        newNode.next=prev.next;
        prev.next=newNode;
    }
    public void deleteFirst()
    {
        size--;
        if(head==null)
        {
            System.out.println("List is empty");
            return;
        }
        head=head.next;
    }
    public void deleteLast()
    {
        if(head==null)
        {
            System.out.println("List is empty");
            return;
        }
        size--;
        if(head.next==null)
        head=null;
        else
        {
            Node secondLast=head;
            Node last=head.next;
            while(last.next!=null)
            {
                last=last.next; 
                secondLast=secondLast.next;
            }
            secondLast.next=null;
        }
    }
    public void printList()
    {
        Node currNode=head;
        if(head==null)
        {
            System.out.println("List is empty");
            return;
        }
        while(currNode!=null)
        {
            System.out.print(currNode.data+"-->");
            currNode=currNode.next;
        }
        System.out.println("NULL");
    }
    public static int getSize() { return size;}
    public static void main(String[] args)
    {
        ll list=new ll();
        list.addFirst("first");
        list.addFirst("second");
        list.addLast("Third");
        list.addAfterPrev(list.head, "Zeroth");
        list.printList();
        list.deleteFirst();
        list.deleteLast();
        list.printList();
        System.out.println("The size of the linked list is: "+getSize());
    }
}
