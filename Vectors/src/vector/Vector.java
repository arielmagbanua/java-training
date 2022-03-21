package vector;

public class Vector<T> implements List<T> {
	
	private T[] data;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;
	
	public Vector(){
		this(INITIAL_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public Vector(int capacity) {
		this.data = (T[])new Object[capacity];
		this.size = 0;
	}
	
	public int capacity() {
		return this.data.length;
	}

	/**
	 * When the underlying array fills up, we need to resize it to accommodate the stack's elements
	 * Ignores the request if the new capacity is too small to fit the elements already in the stack
	 */
	public void resize(int newCapacity){
		if (newCapacity < capacity()) {
			return;
		}

		// temporary container of the array
		T[] temp = (T[])new Object[newCapacity];

		// copy the contents of data to temp
		for (int i = 0; i < this.size; i++) {
			temp[i] = this.data[i];
		}

		// create new data array using the new length
		this.data = (T[])new Object[newCapacity];

		// copy everything back from temp
		for (int i = 0; i < this.size; i++) {
			this.data[i] = temp[i];
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void clear() {
		// create new data array using the original length
		this.data = (T[])new Object[capacity()];

		// reset the size
		this.size = 0;
	}

	@Override
	public void insertAtTail(T data) {
		if (this.size >= this.data.length) {
			// data is full already therefore resize it
			// resize the data first
			this.resize(capacity() + 1);
		}

		// now insert at the end of data
		this.data[this.size] = data;

		// increase the size
		++this.size;
	}

	@Override
	public void insertAtHead(T data) {
		if (this.size >= this.data.length) {
			// data is full already therefore resize it
			// resize the data first
			this.resize(capacity() + 1);
		}

		// temporary container of the array
		T[] temp = (T[])new Object[capacity()];

		for (int i = 0; i < this.size; i++) {
			// set the values + 1 index so that the head will be empty
			temp[i + 1] = this.data[i];
		}

		// now put the data at the beginning
		temp[0] = data;

		// copy everything back from temp
		for (int i = 0; i < temp.length; i++) {
			this.data[i] = temp[i];
		}

		// increase the size
		++this.size;
	}

	@Override
	public void insertAt(int index, T data) {
		if (this.size >= this.data.length) {
			// data is full already therefore resize it
			// resize the data first
			this.resize(capacity() + 1);
		}

		// temporary container of the array
		T[] temp = (T[])new Object[capacity() + 1];

		// increase the size
		++this.size;

		int currentIndex = 0;
		for (int i = 0; i < this.size; i++) {
			if (currentIndex == index) {
				// insert the data
				temp[currentIndex] = data;
				// move to next index
				++currentIndex;
			}

			temp[currentIndex] = this.data[i];
			++currentIndex;
		}

		// copy the data back
		for (int i = 0; i < this.size; i++) {
			this.data[i] = temp[i];
		}
	}

	@Override
	public T removeAtTail() {
		// get the tail data
		T data = this.data[capacity() - 1];

		// resize by reducing it
		this.resize(capacity() - 1);

		// decrement the size
		--this.size;

		return data;
	}

	@Override
	public T removeAtHead() {
		// get the head data
		T data = this.data[0];

		// temporary container of the array
		T[] temp = (T[])new Object[capacity() - 1];

		for (int i = 1; i < this.size; i++) {
			// copy starting at the second index
			temp[i - 1] = this.data[i];
		}

		// resize by reducing it
		this.resize(capacity() - 1);

		// reduce the size
		--this.size;

		// copy back all data
		for (int i = 0; i < this.size; i++) {
			this.data[i] = temp[i];
		}

		return data;
	}

	@Override
	public int find(T data) {
		for (int i = 0; i < this.size; i++) {
			if (data.equals(this.data[i])) {
				// found the index
				return i;
			}
		}

		// did not found it
		return -1;
	}

	@Override
	public T get(int index) {
		if (this.size == 0 || index > this.size) {
			return null;
		}

		return this.data[index];
	}
}
