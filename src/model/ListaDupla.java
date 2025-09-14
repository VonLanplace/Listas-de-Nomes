package model;

public class ListaDupla<T> {
	private NoDuplo<T> first;
	private NoDuplo<T> last;
	private int size;

	public ListaDupla() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	// append Adiciona o elemento no final;
	// get Retorna um no dado um index;
	// index Retorna um indice de um elemento;
	// insert Insere um elemento em uma determinada posicao;
	// last Retorna o ultimo elemento;
	// prepend Insere um elemento na cabeça da lista;
	// remove Remove um elemento dado o index;
	// total Retorna o total de elementos;

	public void append(T content) throws IllegalArgumentException {
		if (content == null)
			throw new IllegalArgumentException("The content cannot be null");

		if (this.last == null) {
			NoDuplo<T> novo = new NoDuplo<>(null, content, null);
			this.first = novo;
			this.last = novo;
		} else {
			NoDuplo<T> novo = new NoDuplo<>(this.last, content, null);
			this.last.setNext(novo);
			this.last = novo;
		}
		this.size++;
	}

	public NoDuplo<T> get(int index) throws IllegalArgumentException {
		if (index < 0)
			throw new IllegalArgumentException("Index cannot be negative.\n\tindex:" + index);

		if (index >= this.size)
			throw new IllegalArgumentException("Index out of  bounds.\n\tindex:" + index);

		if (this.first == null)
			throw new IllegalArgumentException("The list is Empty");

		if (index <= (size / 2)) {
			NoDuplo<T> buffer = this.first;
			for (int i = 0; i < index; i++) {
				buffer = buffer.getNext();
			}
			return buffer;
		} else {
			NoDuplo<T> buffer = this.last;
			for (int i = size - 1; i > index; i--) {
				buffer = buffer.getPrevious();
			}
			return buffer;
		}
	}

	public int index(T content) throws IllegalArgumentException {
		if (content == null)
			throw new IllegalArgumentException("Content cannot be null");

		NoDuplo<T> current = this.first;
		for (int i = 0; i < this.size; i++) {
			if (content.equals(current.getContent())) {
				return i;
			}
			current = current.getNext();
		}

		throw new IllegalArgumentException("Content not found in list");
	}

	public void insert(int index, T content) throws IllegalArgumentException {
		if (index < 0 || index > this.size)
			throw new IllegalArgumentException("Index out of bounds for insertion.\n\tindex:" + index);

		if (content == null)
			throw new IllegalArgumentException("The content cannot be null");

		if (index == 0) {
			prepend(content);
		} else if (index == size) {
			append(content);
		} else {
			NoDuplo<T> old = this.get(index);
			NoDuplo<T> previous = old.getPrevious();
			NoDuplo<T> inserted = new NoDuplo<>(previous, content, old);
			previous.setNext(inserted);
			old.setPrevious(inserted);
			this.size++;
		}
	}

	public void insertAntes(T content, NoDuplo<T> next) {
		if (next != null) {
			NoDuplo<T> previous = next.getPrevious();
			NoDuplo<T> newNode = new NoDuplo<T>(previous, content, next);
			if (previous != null) {
				previous.setNext(newNode);
			}
			next.setPrevious(newNode);

			if (next == first) {
				this.first = newNode;
			}

			this.size++;
		} else {
			append(content);
		}
	}

	public void insertDepois(NoDuplo<T> previous, T content) {
		if (previous != null) {
			NoDuplo<T> next = previous.getNext();
			NoDuplo<T> newNode = new NoDuplo<T>(previous, content, next);
			previous.setNext(newNode);
			if (next != null)
				next.setPrevious(newNode);

			if (previous == last) {
				this.last = newNode;
			}

			this.size++;
		} else {
			prepend(content);
		}
	}

	public NoDuplo<T> last() {
		return this.last;
	}

	public void prepend(T content) throws IllegalArgumentException {
		if (content == null)
			throw new IllegalArgumentException("The content cannot be null");

		if (this.first == null) {
			NoDuplo<T> inserted = new NoDuplo<>(null, content, null);
			this.first = inserted;
			this.last = inserted;
		} else {
			NoDuplo<T> inserted = new NoDuplo<>(null, content, this.first);
			this.first.setPrevious(inserted);
			this.first = inserted;
		}
		this.size++;
	}

	public void remove(int index) {
		if (index < 0 || index >= this.size)
			throw new IllegalArgumentException("Index out of bounds.\n\tindex:" + index);

		NoDuplo<T> removed;
		if (index == 0) {
			removed = this.first;
			this.first = first.getNext();
			if (first != null) {
				first.setPrevious(null);
			} else {
				this.last = null;
			}
		} else if (index == size - 1) {
			removed = this.last;
			this.last = last.getPrevious();
			if (last != null) {
				last.setNext(null);
			} else {
				this.first = null;
			}
		} else {
			removed = this.get(index);
			NoDuplo<T> next = removed.getNext();
			NoDuplo<T> previous = removed.getPrevious();

			previous.setNext(next);
			next.setPrevious(previous);
		}
		removed.clearNode();
		this.size--;
	}

	public int total() {
		return size;
	}

	protected NoDuplo<T> getFirst() {
		return first;
	}

	protected void setFirst(NoDuplo<T> first) {
		this.first = first;
	}

	protected NoDuplo<T> getLast() {
		return last;
	}

	protected void setLast(NoDuplo<T> last) {
		this.last = last;
	}

	protected int getSize() {
		return size;
	}

	protected void setSize(int size) {
		this.size = size;
	}
}
