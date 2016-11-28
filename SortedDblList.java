//edu.uga.cs1302.list
import java.util.Iterator;
import java.io.Serializable;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@SuppressWarnings({ "serial", "unused" })
public class SortedDblList<T> implements Serializable{
	
	public int size;
	private Node<T> head;
	private Node<T> tail;
	
	/**
	 * SortedDblList Constructor
	 */
	public SortedDblList()
	{
		
	}
	/**
	 * @param size
	 */
	public SortedDblList(int size)
	{	
		this.size=size;
	}
	/**
	 * @return boolean
	 */
	public boolean isEmpty()
	{
		if(size==0)
			return true;
		return false;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the head
	 */
	public Node<T> getHead() {
		return head;
	}
	/**
	 * @param head the head to set
	 */
	public void setHead(Node<T> head) {
		this.head = head;
	}
	/**
	 * @return the tail
	 */
	public Node<T> getTail() {
		return tail;
	}
	/**
	 * @param tail the tail to set
	 */
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	/**
	 * @param index
	 * @return element
	 */
	public T get(int index)
	{
		Node<T> temp;
		if((index<0) || (index>= size) )
			throw new IndexOutOfBoundsException();
		else
		{	
			temp=head;
			for(int i=0;i<index;i++)
			{
				temp=temp.getNext();
				
			}
		}
		return temp.getData();
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * @param element
	 * @return boolean
	 */
	public boolean add(T element)
	{
		Node<T> temp=head;
		boolean passed=false;
		boolean test=true;
		
     	if(element==null)
     	{
			passed=false;
			test=false;
     	}
		else
		{
			for(int i=0; i<size;i++)
			{
				if (temp.getData()==element)
				{
					test=false;
					break;
				}
				temp=temp.getNext();
		    }
		}
     	temp=this.head;
     	Node<T> newNode= new Node<T>(element);
     	Comparable<T> com = (Comparable<T>) element;
		if (test==true)
		{
			if(this.isEmpty()==true)
			{
				head=newNode;
				tail=newNode;
				size++;
				passed=true;
			}
			else if(com.compareTo(head.getData())==-1)
			{
				newNode.setNext(head);
				head.setPrev(newNode);
				head=newNode;
				size++;
				passed=true;
			}
			else if(com.compareTo(tail.getData())==1)
			{
				tail.setNext(newNode);
				newNode.setPrev(tail);
				tail=newNode;
				size++;
				passed=true;
			}
			else if(com.compareTo(temp.getData())==0)
			{
				passed=false;
				
			}
			else
			{
				for(int i=0;i<size;i++)
				{
					if ( ((com.compareTo(temp.getData()) )==1) 
							&& (com.compareTo(temp.getNext().getData())==-1) )
					{
						newNode.setPrev(temp);
						newNode.setNext(temp.getNext());
						temp.setNext(newNode);
						passed=true;
						size++;
						break;
					}
					else
					{
						temp=temp.getNext();
					}
				}
			}
		}
		return passed;
		
	}
	
	
	/**
	 * @param o
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean remove(Object o)
	{
		//Node<T> rmvNode =(Node<T>) o;
		Node<T> temp=head;
		boolean found=false;
		
		for(int i=0;i<size;i++)
		{
			if(o.equals(temp.getData()))
			{
				if(temp==head)
				{
					head=temp.getNext();
					head.setPrev(null);
					size--;
					found=true;
					break;
				}
				else if(temp==tail)
				{
					tail=temp.getPrev();
					size--;
					found=true;
					break;
				}
				else
				{
					Node<T> next=temp.getNext();
					Node<T> prev=temp.getPrev();
					prev.setNext(next);
					next.setPrev(prev);
					size--;
					found=true;
					break;
				
				}
			}
			temp=temp.getNext();
		}
		return found;
	}

	
	/**
	 * @param otherList
	 * @return list3
	 */
	public SortedDblList<T> union(SortedDblList<? extends T> otherList)
	{
		SortedDblList list3= new SortedDblList();
		SortedDblList list2= (SortedDblList) otherList;
		Node<T> temp = this.head;
		for(int i=0;i<this.getSize();i++)
		{
			list3.add(temp.getData());
			temp=temp.getNext();
		}
		temp=list2.getHead();
		for(int i=0;i<otherList.getSize();i++)
		{
			list3.add(temp.getData());
			temp=temp.getNext();
		}
		return list3;
	}
	
	/**
	 * @param otherList
	 * @return newList
	 */

	@SuppressWarnings("unchecked")
	public SortedDblList<T> intersection(SortedDblList<? extends T> otherList)
	{
		@SuppressWarnings("rawtypes")
		SortedDblList list2 = (SortedDblList) otherList;
		@SuppressWarnings("rawtypes")
		SortedDblList newList= new SortedDblList();
		Node temp=this.head;
		Node temp2=otherList.getHead();
		for(int i=0; i<otherList.size;i++)
		{
			for(int a=0; a<this.size;i++)
			{
				if(temp.getData().equals(temp2.getData()))
				{
					newList.add((T)temp.getData());
					break;
				}
				temp=temp.getNext();
			}
			temp=this.head;
			temp2=temp2.getNext();
		}
		return newList;
	}
	
	/**
	 * Prints out List
	 */
	public void printList()
	{
		Node<T> temp=head;
		for(int i=0; i<this.size;i++)
		{
			System.out.println(temp.getData().toString());
			temp=temp.getNext();
		}
	}
	
	/**
	 * @param o
	 * @return 
	 */
	
	public int indexOf(Object o)
	{
		int index=-1;
		@SuppressWarnings("unchecked")
		T element = (T) o;
		int counter=0;
		Node<T> temp=head;
		for(int i=0;i<this.size;i++)
		{
			if(temp.getData().equals(element))
			{
				index=counter;
				break;
			}
			counter++;
			temp=temp.getNext();
		}
		return index;
	}
	
	/**
	 * @param fileName
	 * @return
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public SortedDblList<T> readObject(String fileName) throws ClassNotFoundException
	{
		FileInputStream input = null;
		ObjectInputStream input2 = null;
		SortedDblList<T> newList = new SortedDblList<T>();
		System.out.println("I think it's working...");

		try{
			input = new FileInputStream(fileName);
			input2 = new ObjectInputStream(input);

			int count = (int) input2.readObject();

			for(int i= 0; i< count; i++)
			{
				newList.add((T)input2.readObject());

			}
		System.out.println("IT WORKED!!!");
		}

		catch(FileNotFoundException notFound)
		{
			notFound.printStackTrace();
		}
		catch(IOException notFound)
		{
			notFound.printStackTrace();
		}
		finally
		{
			try
			{
				input2.close();
			}
			catch(IOException notFound)
			{
				notFound.printStackTrace();
			}
		}

		return newList;

	}
	
	/**
	 * @param fileName
	 */
	public void writeObject(String fileName)
	{
		FileOutputStream output = null;
		ObjectOutputStream output2 = null;
		try
		{
			output = new FileOutputStream(fileName);
			output2 = new ObjectOutputStream(output);
			output2.writeObject(this.size);

			for(int i= 0; i<this.size; i++)
			{
				output2.writeObject(this.get(i));
	
			}
				System.out.println("IT WORKED!!!");
		}

		catch(FileNotFoundException notFound)
		{
			notFound.printStackTrace();
		}
		catch(IOException notFound)
		{
			notFound.printStackTrace();
		}
		finally
		{
			try
			{
				output2.flush();
				output2.close();
			}
		catch(IOException notFound)
			{
				notFound.printStackTrace();
			}
		}

	}
}
	
