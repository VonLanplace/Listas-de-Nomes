package model.listaSimples;

public class NoSimples<T> {
  private T content;
  private NoSimples<T> next;

  public NoSimples(T content, NoSimples<T> next) {
    this.content = content;
    this.next = next;
  }

  public NoSimples(T content) {
    this(content, null);
  }

  public T getContent() {
    return content;
  }

  public void setContent(T content) {
    this.content = content;
  }

  public NoSimples<T> getNext() {
    return next;
  }

  public void setNext(NoSimples<T> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return this.content.toString();
  }

  public void clearNode() {
    this.content = null;
    this.next = null;
  }
}
