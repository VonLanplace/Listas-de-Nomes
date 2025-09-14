package model;

public class No<T> {
	private T content;
	private No<T> next;

	public No() {
		this(null, null);
	}

	public No(T content) {
		this(content, null);
	}

	public No(T content, No<T> next) {
		this.content = content;
		this.next = next;
	}

	public T getContent() {
		return this.content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public No<T> getNext() {
		return this.next;
	}

	public void setNext(No<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		if (content != null) {
			return this.content.toString();
		} else {
			return null;
		}
	}
}
