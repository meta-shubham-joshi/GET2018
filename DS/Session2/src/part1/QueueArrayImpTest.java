package part1;

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

			assertEquals(1, obj.deQueue());
			assertEquals(1, obj.deQueue());

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

			assertNotEquals(0, obj.deQueue());
			assertNotEquals(0, obj.deQueue());

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
