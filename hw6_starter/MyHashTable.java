import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MyHashTable<DataType> {
	private int numBuckets = 10;
	private ArrayList<DataType>[] buckets;
	private int count = 0;
	public MyHashTable() {
		buckets = new ArrayList[numBuckets];
		for (int i = 0; i < numBuckets; i++) {
			buckets[i] = new ArrayList<DataType>();
		}
	}

	public void put(DataType item) {
		int bucket = Math.abs(item.hashCode() % numBuckets);
		buckets[bucket].add(item);
		count ++;
		if(count >= 0.5* numBuckets) {
			rehash();
		}
	}

	public boolean contains(DataType item) {
		//TODO: your code here
		throw new UnsupportedOperationException();
	}

	public void remove(DataType item) {
		//TODO: your code here
		throw new UnsupportedOperationException();
	}

	private void rehash() {
		//TODO: your code here
		throw new UnsupportedOperationException();
	}

	public int getNumBuckets () {
		return numBuckets;
	}
	@Override
	public String toString() {
		return "{" +
				"numBuckets=" + numBuckets +
				", buckets=" + Arrays.toString(buckets) +
				'}';
	}
}
