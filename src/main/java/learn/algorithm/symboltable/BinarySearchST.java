package learn.algorithm.symboltable;

public class BinarySearchST<Key extends Comparable<Key>, Value> {

	private Key[] keys;
	private Value[] values;
	int n;

	public BinarySearchST() {
		keys = (Key[]) new Comparable[2];
		values = (Value[]) new Object[2];
	}

	public void put(Key key, Value v) {

		int i = rank(key);

		if (i < n && keys[i].compareTo(key) == 0) {
			values[i] = v;
			return;
		}

		if (n == keys.length)
			resize(2 * n);

		for (int j = n; j > i; j--) {
			keys[j] = keys[j - 1];
			values[j] = values[j - 1];
		}
		keys[i] = key;
		values[i] = v;
		n++;

	}

	private void resize(int length) {
		Key[] newKeys = (Key[]) new Comparable[length];
		Value[] newValues = (Value[]) new Object[length];
		for (int i = 0; i < n; i++) {
			newKeys[i] = keys[i];
			newValues[i] = values[i];
		}
		keys = newKeys;
		values = newValues;
	}

	public int size() {
		return n;
	}

	public void remove(Key key) {
		int index = rank(key);

		if (index == n || keys[index].compareTo(key) != 0)
			return;

		for(int i=index; i<n-1; i++){
			keys[i]=keys[i+1];
			values[i]=values[i+1];
		}			
		n--;
		keys[n]=null;
		values[n]=null;
		
		if(n>0 && n < keys.length/4) resize(keys.length/2);
	}

	private int rank(Key key) {
		int low = 0, high = n - 1;
		while (low < high) {
			int middle = low + high / 2;
			int comp = key.compareTo(keys[middle]);

			if (comp < 0)
				low = middle;
			else if (comp > 0)
				high = middle;
			else
				return middle;
		}
		return low;
	}

}