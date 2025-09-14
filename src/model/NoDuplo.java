package model;

public class NoDuplo<T> {
	private T content;
	private NoDuplo<T> previous;
	private NoDuplo<T> next;

	public NoDuplo(T content) {
		this(null, content, null);
	}

	public NoDuplo(NoDuplo<T> previous, T content) {
		this(previous, content, null);
	}

	public NoDuplo(T content, NoDuplo<T> next) {
		this(null, content, next);
	}

	public NoDuplo(NoDuplo<T> previous, T content, NoDuplo<T> next) {
		this.content = content;
		this.previous = previous;
		this.next = next;
	}

	public T getContent() {
		return this.content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public NoDuplo<T> getNext() {
		return this.next;
	}

	public void setNext(NoDuplo<T> next) {
		this.next = next;
	}

	public NoDuplo<T> getPrevious() {
		return this.previous;
	}

	public void setPrevious(NoDuplo<T> previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		if (content == null) {
			return "null";
		} else {
			return content.toString();
		}
	}

	public void clearNode() {
		this.content = null;
		this.previous = null;
		this.next = null;
	}
}
