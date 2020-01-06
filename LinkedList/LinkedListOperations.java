package LinkedList;
public interface LinkedListOperations{
    // get the size of the linkedlist
    public int Size();

    // check if the linkedlist is empty
    public boolean Empty();

    // Check the value in the target linkedlist index
    public int Value_At(int index);

    // Remove front item and return its value
    public int Pop_Front();

    // Get value of the front item
    public int Front();

    // Get value of the end item
    public int Back();

    // Return the value of the node at nth position from the end of the list
    public int Value_N_From_End(int n) throws Exception;

    // Remove node at given index
    public void Erase(int index);

    // Print the linkedlist node data
    public void PrintList();

    // Add the item in the front
    public void Push_Front(int x);

    // Add the item in the back
    public void Push_Back(int x); 

    // Delete the first item containing x;
    public void Delete(int x);

    // Remove Linkedlist
    public void Clear();
    
    // Reverse Linkedlist
    public void Reverse();
}