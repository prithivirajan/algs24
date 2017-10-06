package algorithm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TestArrayOfProducts {
	
	private ArrayOfProduct array;
	
	@Before
	public void setup(){
		array = new ArrayOfProduct();
	}

	@Test
	public void arrayOfOneIntegerProduct(){
		int[] outArray = array.getProduct(new int[]{10});		
		assertEquals("array should be empty", 0, outArray.length);
	}
	
	@Test
	public void arrayOfTwoIntegerProduct(){
		int[] outArray = array.getProduct(new int[]{10, 20});		
		assertArrayEquals(new int[]{20, 10}, outArray);
	}
	
	@Test
	public void testArrayOfThreeIntegers(){
		int[] outArray = array.getProduct(new int[]{10, 20, 30});		
		assertArrayEquals(new int[]{600, 300, 200}, outArray);
	}
	
	@Test
	public void testArrayOfFourIntegers(){
		int[] outArray = array.getProduct(new int[]{10, 20, 30, 40});		
		assertArrayEquals(new int[]{24000, 12000, 8000, 6000}, outArray);
	}

}
