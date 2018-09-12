package part1;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackArrayImpTest {

	@Test
	public void testPushPass() {
		StackArrayImp obj = new StackArrayImp();
		try {
			assertEquals(1, obj.push(1));
			assertEquals(1, obj.push(2));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}

	@Test
	public void testPushFail() {
		StackArrayImp obj = new StackArrayImp();
		try {
			assertNotEquals(0, obj.push(1));
			assertNotEquals(0, obj.push(2));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}

	@Test
	public void testPopPass() {
		StackArrayImp obj = new StackArrayImp();
		obj.push(1);
		obj.push(2);
		try {
			assertEquals(1, obj.pop());
			assertEquals(1, obj.pop());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testPopFail() {
		StackArrayImp obj = new StackArrayImp();
		obj.push(1);
		obj.push(2);
		try {
			assertNotEquals(0, obj.pop());
			assertNotEquals(0, obj.pop());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

	}

	@Test
	public void testTopPass() {
		StackArrayImp obj = new StackArrayImp();
		obj.push(1);
		obj.push(2);
		try {
			assertEquals(2, obj.top());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}

	@Test
	public void testTopFail() {
		StackArrayImp obj = new StackArrayImp();
		obj.push(1);
		obj.push(2);
		try {
			assertNotEquals(1, obj.top());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}

}
