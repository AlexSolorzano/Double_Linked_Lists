//edu.uga.cs1302.list
import java.io.Serializable;
/**
 * @author Alexandra Solorzano
 * This beautifully completed class has node
 * getters and setters.
 * @param <T>
 */
public class Node <T> implements Serializable{

	private Node<T> next;
	private Node<T> prev;
	private T data;

	/**
	 * Node Constructor
	 */
	public Node()
	{
		this.next=null;
		this.prev=null;
		this.data=null;
		
	}
	/**
	 * @param element
	 */
	public Node(T element)
	{
		this.next=null;
		this.prev=null;
		this.data=element;
	}
	/**
	 * @param node
	 */
	public void setNext(Node<T> node)
	{
		this.next=node;
	}
	/**
	 * @return
	 */
	public Node<T> getNext()
	{
		return next;
	}
	
	/**
	 * @param node
	 */
	public void setPrev(Node<T> node)
	{
		this.prev=node;
	}
	/**
	 * @return prev
	 */
	public Node<T> getPrev()
	{
		return prev;
	}
	/**
	 * @param element
	 */
	public void setData(T element)
	{
		data=element;
	}
	
	/**
	 * @return data
	 */
	public T getData()
	{
		return data;
	}
}
