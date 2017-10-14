package learn.algorithm.symboltable;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchSTTest {

	private BinarySearchST<String, Integer> symbolTable;

	@Before
	public void setup() {
		symbolTable = new BinarySearchST<>();
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

}
