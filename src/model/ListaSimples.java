package model;

public class ListaSimples<T> {
	private No<T> first;
	private int size;

	public ListaSimples() {
		this.setFirst(null);
		this.size = 0;
	}

	public ListaSimples(T first) {
		this.setFirst(null);
		this.size = 0;
		this.append(first);
	}

	// append Adiciona o elemento no final;
	// get Retorna um no dado um index;
	// index Retorna um indice de um elemento;
	// insert Insere um elemento em uma determinada posição;
	// last Retorna o ultimo elemento;
	// remove Remove um elemento dado o index;
	// total Retorna o total de elementos;

	public void append(T conteudo) throws IllegalArgumentException {
		if (conteudo == null)
			throw new IllegalArgumentException("Conteudo não pode ser nulo!!");

		if (getFirst() == null) {
			this.setFirst(new No<T>(conteudo));
		} else {
			No<T> buffer = this.getFirst();
			while (buffer.getNext() != null) {
				buffer = buffer.getNext();
			}
			buffer.setNext(new No<T>(conteudo));
		}
		this.size++;
	}

	public No<T> get(int index) throws IllegalArgumentException {
		if (index < 0 || index >= this.size)
			throw new IllegalArgumentException("Index out of bounds: " + index);

		if (this.getFirst() == null)
			throw new IllegalArgumentException("List is empty");

		No<T> buffer = getFirst();
		for (int i = 0; i < index; i++) {
			buffer = buffer.getNext();
		}
		return buffer;
	}

	public int index(T content) throws IllegalArgumentException {
		if (content == null)
			throw new IllegalArgumentException("Conteudo não pode ser nulo!!");

		if (this.getFirst() == null)
			throw new IllegalArgumentException("List is empty");

		No<T> buffer = this.getFirst();
		int i = 0;
		while (buffer != null) {
			if (buffer.getContent().equals(content)) {
				return i;
			} else {
				buffer = buffer.getNext();
				i++;
			}
		}

		throw new IllegalArgumentException("Index not found");
		// return -1;
	}

	public void insert(int index, T content) throws IllegalArgumentException {
		if (index < 0 || index > this.size)
			throw new IllegalArgumentException("Index out of bounds: " + index);

		if (content == null)
			throw new IllegalArgumentException("Conteudo não pode ser nulo!!");

		if (index == 0) {
			this.setFirst(new No<T>(content, getFirst()));
		} else {
			No<T> previous = this.get(index - 1);
			No<T> old = previous.getNext();
			No<T> buffer = new No<T>(content, old);
			previous.setNext(buffer);
		}
		this.size++;
	}

	public No<T> last() throws IllegalArgumentException {
		if (this.getFirst() == null)
			throw new IllegalArgumentException("List is empty");

		No<T> aux = this.getFirst();
		while (aux.getNext() != null) {
			aux = aux.getNext();
		}
		return aux;
	}

	public void remove(int index) throws IllegalArgumentException {
		if (index < 0)
			throw new IllegalArgumentException("Index cannot be negative: " + index);
		if (this.getFirst() == null)
			throw new IllegalArgumentException("List is empty");

		if (index == 0) {
			No<T> buffer = getFirst();
			this.setFirst(getFirst().getNext());
			buffer.setNext(null);
			buffer.setContent(null);
		} else {
			No<T> previous = this.get(index - 1);
			No<T> old = previous.getNext();
			previous.setNext(old.getNext());
			old.setNext(null);
			old.setContent(null);
		}
		this.size--;
	}

	protected void setSize(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	protected No<T> getFirst() {
		return first;
	}

	protected void setFirst(No<T> first) {
		this.first = first;
	}
}
