package sampleQueue;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class QueueTest<item> {

	/**
	 * Tests for Queue.
	 */
	private static final String SOME_ITEM = "some-content";
	private Queue<String> q;
	@SuppressWarnings("rawtypes")
	Queue queue;

	@BeforeEach
	void init() {
		this.q = new Queue<String>();
	}
	@Test
	@DisplayName("Verify Queue Constructor when an empty queue is initiated")
	void QueueShouldBeEmpty()
	{		
		    assertTrue(q.isEmpty());
	}
	

	@Test
	@DisplayName("Verify Parameterized Contructer")
	void ParameterizedConstructor()
	{		
		    queue = new Queue(5);
		    for (int i = 0; i < 20; i++) {
			      q.enqueue("100 + i");
			    }
			    assertEquals(20, q.size());
	}
	
	
	@Test
	@DisplayName("Verify Empty Method")
	void QueueIsEmpty()
	{
		 boolean result = q.isEmpty();
		    assertTrue(result);
		    q.enqueue("1");
		    result = q.isEmpty();
		    assertFalse(result);
	}
	@Test
	@DisplayName("Verify Dequeue Method")
	void Dequeue()
	{
		String first = "102";
	    String last = "201";
	    q.enqueue(first);
	    q.enqueue(last);
	    assertEquals(2, q.size());
	    assertEquals(first, q.dequeue());
	    assertEquals(1, q.size());
	    assertEquals(last, q.dequeue());
	    assertTrue(q.isEmpty());
	}
	@Test
	@DisplayName("Verify Peek")
	void Peek()
	{
		String sample = "123";
	    q.enqueue(sample);
	    String result = q.peek();
	    assertEquals(sample, result);
	}
	
	@Test
	@DisplayName("Verify Empty Dequeue")
	  void testDequeueEmpty() throws Exception{
		Assertions.assertThrows(NoSuchElementException.class, () -> q.dequeue());
	  }

	  @Test
	  @DisplayName("Verify Empty Peek")
	  void testPeekEmpty() throws Exception {
		  Assertions.assertThrows(NoSuchElementException.class, () ->q.peek());
	  }
	  
	  @Test
	  @DisplayName("Verify Dequeue Method")
		void RemoveAllTest()
		{
			String first = "102";
		    String last = "201";
		    q.enqueue(first);
		    q.enqueue(last);
		    q.removeAll();
		    assertTrue(q.isEmpty());
		}
	  @Test
	  @Disabled
		@DisplayName("Enqueue method overflowing")
		  void testEnqueue() throws Exception{
			fail("Queue overflow Exception not thrown");
		  }
	 
	//Example of Wrong Test! 
	@Test
	@Disabled
	@DisplayName("Verify Queue isEmpty returns false when queue is not empty")
	void isEmptyShouldGiveFalseWhenQueueIsNotEmpty() {
		this.q.enqueue(SOME_ITEM);
		assertFalse(q.isEmpty());
	}

	
}