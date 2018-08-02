package Queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueLinkedListImpTest {

	@Test
	public void testEnQueuePass() {
		try {
			QueueLinkedListImp obj = new QueueLinkedListImp();
			assertEquals(1, obj.enQueue(1));
			assertEquals(1, obj.enQueue(2));
			assertEquals(1, obj.enQueue(3));
			obj.display();

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testEnQueueFail() {
		try {
			QueueLinkedListImp obj = new QueueLinkedListImp();
			assertNotEquals(0, obj.enQueue(1));
			assertNotEquals(0, obj.enQueue(2));
			assertNotEquals(0, obj.enQueue(3));
			obj.display();

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testDeQueuePass() {
		try {
			QueueLinkedListImp obj = new QueueLinkedListImp();
			assertEquals(1, obj.enQueue(1));
			assertEquals(1, obj.enQueue(2));
			assertEquals(1, obj.enQueue(3));
			obj.display();
			assertEquals(1, obj.deQueue());
			assertEquals(1, obj.deQueue());

			obj.display();

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testDeQueueFail() {
		try {
			QueueLinkedListImp obj = new QueueLinkedListImp();
			assertNotEquals(0, obj.enQueue(1));
			assertNotEquals(0, obj.enQueue(2));
			assertNotEquals(0, obj.enQueue(3));
			obj.display();
			assertNotEquals(0, obj.deQueue());
			assertNotEquals(0, obj.deQueue());

			obj.display();

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testIsEmptyPass() {
		try {
			QueueLinkedListImp obj = new QueueLinkedListImp();
			assertEquals(1, obj.enQueue(1));
			assertEquals(1, obj.enQueue(2));
			obj.display();
			assertEquals(false, obj.isEmpty());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testIsEmptyFail() {
		try {
			QueueLinkedListImp obj = new QueueLinkedListImp();
			assertNotEquals(0, obj.enQueue(1));
			assertNotEquals(0, obj.enQueue(2));
			obj.display();
			assertNotEquals(true, obj.isEmpty());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}


}
