import java.util.Iterator;

/*
 * @lc app=leetcode id=284 lang=java
 *
 * [284] Peeking Iterator
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
	Integer cur = null;
	Iterator<Integer> mIterator;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		this.mIterator = iterator;
		if (iterator != null && iterator.hasNext()) {
			cur = iterator.next();
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return cur;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (cur == null) {
			return null;
		}
		Integer tmp = cur;
		if(mIterator.hasNext()){
			cur = mIterator.next();
		}else{
			cur = null;
		}
		return tmp;
	}

	@Override
	public boolean hasNext() {
		return cur != null;
	}
}
// @lc code=end
