package hashMaps;

import java.util.*;

public class Map<K, V> {
	ArrayList<MapNode<K, V>> buckets;
	int size; // it the number of entries;
	int numBuckets; // it is the number of buckets;
	
	public Map() {
		numBuckets = 5;
		buckets = new ArrayList<>();
		for(int i=0; i<numBuckets; i++)
			buckets.add(null);
	}
	
	public double loadFactor() {
		return (1.0*size)/numBuckets;
	}
	
	private int getBucketIndex(K key) {
		int hashCode = key.hashCode();
		return hashCode%numBuckets;
	}
	
	public void insert(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> LlHead = buckets.get(bucketIndex);
		while(LlHead != null) {
			if(LlHead.key.equals(key)) {
				LlHead.value = value;
				return;
			}
			LlHead = LlHead.next;
		}
		
		LlHead = buckets.get(bucketIndex);
		MapNode<K, V> newElementNode = new MapNode<K, V>(key, value);
		size++;
		newElementNode.next = LlHead;
		buckets.set(bucketIndex, newElementNode);
		double loadFactor = (1.0*size)/numBuckets;
		if(loadFactor > 0.7)
			rehash();
		
	}
	
	private void rehash() {
		System.out.println("Rehashing: buckets - " + numBuckets + ", size -	` " + size);
		ArrayList<MapNode<K, V>> temp = buckets;
		buckets = new ArrayList<>();
		for(int i=0; i<2*numBuckets; i++)
			buckets.add(null);
		
		size = 0;
		numBuckets *= 2;
		
		for(int i=0; i<temp.size(); i++) {
			MapNode<K, V> LlHead = temp.get(i);
			while(LlHead != null) {
				K key = LlHead.key;
				V value = LlHead.value;
				insert(key, value);
				
				LlHead = LlHead.next;
			}
		}
		
	}

	public int size() {
		return size;
	}
	
	public V removeKey(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> LlHead = buckets.get(bucketIndex);
		MapNode<K, V> prev = null;
		while(LlHead != null) {
			if(LlHead.key.equals(key)) {
				size--;
				if(prev == null)
					buckets.set(bucketIndex, LlHead.next);
				else
					prev.next = LlHead.next;
				
				return LlHead.value;
			}
			prev = LlHead;
			LlHead = LlHead.next;
		}
		
		return null;
	}
	
	public V getValue(K key) {
		int bucketIndex = getBucketIndex(key);
		MapNode<K, V> LlHead = buckets.get(bucketIndex);
		while(LlHead != null) {
			if(LlHead.key.equals(key)) {
				return LlHead.value;
			}
			LlHead = LlHead.next;
		}
		
		return null;
	}
}
