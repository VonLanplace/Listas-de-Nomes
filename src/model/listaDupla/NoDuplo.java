package model.listaDupla;

public class NoDuplo<T> {
  private T content;
  private NoDuplo<T> next;
  private NoDuplo<T> previous;

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
    this.previous = previous;
    this.next = next;
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

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }
}
