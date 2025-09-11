package model.listaSimples;

import model.listaSimples.NoSimples;

public class ListaSimples<T extends Comparable<T>> {
  private int size;
  private NoSimples<T> first;

  public ListaSimples() {
    this.size = 0;
    this.first = null;
  }

  public void add(T content) throws IllegalArgumentException {
    if (content == null) {
      throw new IllegalArgumentException("The content cannot be null");
    }

    if (first == null) {
      this.first = new NoSimples<T>(content);
    } else {
      if (this.first.getContent().comparesTo(content) > 0) {
        this.first = new NoSimples<T>(content, first);
      } else {
        NoSimples<T> buffer = this.first;
        while (buffer.getNext() != null) {
          if (buffer.getNext().getContent().comparesTo(content) > 0) {
            break;
          }
          buffer = buffer.getNext();
        }

        NoSimples<T> old = buffer.getNext();
        buffer.setNext(new NoSimples<T>(content, old));
      }
    }

    this.size++;
  }

  public void remove(T content) throws IllegalArgumentException {
    if (content == null) {
      throw new IllegalArgumentException("The content cannot be null");
    }
    if (this.first == null) {
      throw new IllegalArgumentException("The list is Empty");
    }

    if (this.first.getContent().equals(content)) {
      NoSimples<T> old = this.first;
      this.first = old.getNext();
      old.clearNode();
      this.size--;
      return;
    }
    NoSimples<T> buffer = this.first;
    while (buffer.getNext() != null && !buffer.getNext().getContent().equals(content)) {
      buffer = buffer.getNext();
    }

    if (buffer.getNext() != null) {
      NoSimples<T> old = buffer.getNext();
      buffer.setNext(old.getNext());
      old.clearNode();
      this.size--;
    } else {
      throw new IllegalArgumentException("content not found in list");
    }
  }

  public T getContentByValue(T name) {
    if (name == null) {
      throw new IllegalArgumentException("The content cannot be null");
    }

    if (this.first == null) {
      throw new IllegalArgumentException("The list is Empty");
    }

    NoSimples<T> buffer = this.first;
    while (buffer != null) {
      if (buffer.getContent().comparesTo(name) == 0) {
        break;
      }
      buffer = buffer.getNext();
    }

    if (buffer == null) {
      throw new IllegalArgumentException("File not Found");
    } else {
      return buffer.getContent();
    }
  }

  @Override
  public String toString() {
    if (this.first == null) {
      return "[]";
    }

    StringBuilder text = new StringBuilder("[");
    NoSimples<T> buffer = this.first;
    while (buffer != null) {
      text.append("\n\t").append(buffer.getContent().toString());
      buffer = buffer.getNext();
    }
    text.append("\n]");
    return text.toString();
  }
}
