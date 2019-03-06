package ule.edi.limitedpriorityqueue;

public class LinkedQueue<T> implements QueueADT<T> {
	
	protected static class Node<D> {
		D element;
		Node<D> next;
		
		Node() {
		this.element = null;
		this.next = null;
		}
		Node(D element) {
		this.element = element;
		this.next = null;
		}
		
		}

	private int count;
	private Node<T> front, rear; 
	
	public LinkedQueue()
	 {
		// TODO Auto-generated method stub
		front = new Node<T>();
		rear = new Node <T>();
	 } 
	
	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		
		if (element != null)
		{
			Node<T> nuevo = new Node<T>(element);
			
			if(front.element ==  null)
			{
				front = nuevo;
				count++;
			}
			else
			{
				rear.next = nuevo;
				count++;
			}
			rear = nuevo;
		}
		else
		{
			throw new NullPointerException();
		}
		
	}

	@Override
	public T dequeue() throws EmptyCollectionException
	{
		// TODO Auto-generated method stub
		if (front.element == null)
		{
			throw new EmptyCollectionException("La cola esta vacia");
		}
		else
		{
			T aux = front.element;
			front = front.next;
			count --;
			
			return aux;
		}
		
	}

	@Override
	public T first()  throws EmptyCollectionException{
		// TODO Auto-generated method stub
		if(front.element == null)
		{
			throw new EmptyCollectionException("La cola esta vacia");
		}
		else
		{
			return front.element;
		}		
	}

	@Override
	public boolean isEmpty() {
		 // TODO Auto-generated method stub
		if(front.element == null)
		{
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public T dequeueLast() throws EmptyCollectionException {
	  // TODO Auto-generated method stub
		if(front.element == null)
		{
			throw new EmptyCollectionException("La cola esta vacia");
		}
		else
		{
			T devolver = rear.element;
			Node<T> aux = front.next;
			Node<T> nodAnt = front;
			
			while(aux != rear)
			{
				aux = aux.next;
				nodAnt = nodAnt.next;
			}
			nodAnt.next = null;
			count--;
			return devolver;
		}
		
	}

	@Override
	public String toString() {
		if (! this.isEmpty()) {
			StringBuffer rx = new StringBuffer();
			Node<T> actual=front;
			while (actual!=null) {
				rx.append(actual.element.toString());
				rx.append(", ");
				actual=actual.next;
			}
			rx.delete(rx.length() - 2, rx.length());
			return rx.toString();
		}
		return ""; 


};

}
