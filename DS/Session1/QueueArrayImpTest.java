package Queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueArrayImpTest {

	@Test
	public void testEnQueuePass() {
		try {
			QueueArrayImp obj = new QueueArrayImp();
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
			QueueArrayImp obj = new QueueArrayImp();
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
			QueueArrayImp obj = new QueueArrayImp();
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
			QueueArrayImp obj = new QueueArrayImp();
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
			QueueArrayImp obj = new QueueArrayImp();
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
			QueueArrayImp obj = new QueueArrayImp();
			assertNotEquals(0, obj.enQueue(1));
			assertNotEquals(0, obj.enQueue(2));
			obj.display();
			assertNotEquals(true, obj.isEmpty());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testIsFullPass() {
		try {
			QueueArrayImp obj = new QueueArrayImp();
			assertEquals(false, obj.isFull());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testIsFullFail() {
		try {
			QueueArrayImp obj = new QueueArrayImp();
			assertNotEquals(true, obj.isFull());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}


}
