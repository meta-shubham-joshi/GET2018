package Stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackArrayImpTest {

	@Test
	public void testPushPass() {
		try {
			StackArrayImp obj = new StackArrayImp();
			assertEquals(1, obj.push(1));
			assertEquals(1, obj.push(2));
			assertEquals(1, obj.push(3));
			obj.display();

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testPushFail() {
		try {
			StackArrayImp obj = new StackArrayImp();
			assertNotEquals(0, obj.push(1));
			assertNotEquals(0, obj.push(2));
			assertNotEquals(0, obj.push(3));
			obj.display();

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testPopPass() {
		try {
			StackArrayImp obj = new StackArrayImp();
			assertEquals(1, obj.push(1));
			assertEquals(1, obj.push(2));
			assertEquals(1, obj.push(3));
			obj.display();
			assertEquals(1, obj.pop());
			assertEquals(1, obj.pop());

			obj.display();

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testPopFail() {
		try {
			StackArrayImp obj = new StackArrayImp();
			assertNotEquals(0, obj.push(1));
			assertNotEquals(0, obj.push(2));
			assertNotEquals(0, obj.push(3));
			obj.display();
			assertNotEquals(0, obj.pop());
			assertNotEquals(0, obj.pop());

			obj.display();

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testTopPass() {
		try {
			StackArrayImp obj = new StackArrayImp();
			assertEquals(1, obj.push(1));
			assertEquals(1, obj.push(2));
			obj.display();
			assertEquals(2, obj.top());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testTopFail() {
		try {
			StackArrayImp obj = new StackArrayImp();
			assertNotEquals(0, obj.push(1));
			assertNotEquals(0, obj.push(2));
			obj.display();
			assertNotEquals(1, obj.top());

			obj.display();

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testIsEmptyPass() {
		try {
			StackArrayImp obj = new StackArrayImp();
			assertEquals(true, obj.isEmpty());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testIsEmptyFail() {
		try {
			StackArrayImp obj = new StackArrayImp();
			assertNotEquals(false, obj.isEmpty());

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

}
