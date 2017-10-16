package learn.algorithm.symboltable;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class BinarySearchTreeSTTest {

	private BinarySearchTreeST<String, Integer> symbolTable;

	@Before
	public void setup() {
		symbolTable = new BinarySearchTreeST<>();
	}

	@Test
	public void testAddingIntoSymbolTable() {
		symbolTable.put("A", 1);
		symbolTable.put("B", 2);
		symbolTable.put("C", 3);
		assertEquals(3, symbolTable.size());
	}

	@Test
	public void testRemoveFromSymbolTable() {
		symbolTable.put("A", 1);
		symbolTable.remove("A");
		assertEquals(0, symbolTable.size());
	}

	@Test
	public void testAddDuplicateKey() {
		symbolTable.put("A", 1);
		symbolTable.put("A", 1);
		symbolTable.put("B", 2);
		assertEquals(2, symbolTable.size());
	}
	
	@Test
	public void testFindMin(){
		symbolTable.put("S", 1);
		symbolTable.put("E", 2);
		symbolTable.put("A", 3);
		symbolTable.put("R", 4);
		symbolTable.put("C", 5);
		symbolTable.put("H", 6);
		
		assertEquals(3, symbolTable.min().intValue());
	}
	
	@Test
	public void testFloor(){
		symbolTable.put("S", 1);
		symbolTable.put("E", 2);
		symbolTable.put("A", 3);
		symbolTable.put("R", 4);
		symbolTable.put("C", 5);
		symbolTable.put("H", 6);
		
		assertEquals(2, symbolTable.floor("G").intValue());
	}
	
	@Test
	public void testRank(){
		symbolTable.put("S", 1);
		symbolTable.put("E", 2);
		symbolTable.put("A", 3);
		symbolTable.put("R", 4);
		symbolTable.put("C", 5);
		symbolTable.put("H", 6);
		
		assertEquals(3, symbolTable.rank("E"));
	}

}
