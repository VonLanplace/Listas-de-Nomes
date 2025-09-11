package model.listaDupla;

import model.listaDupla.NoDuplo;

public class ListaDupla<T extends Comparable<T>> {
  private NoDuplo<T> first;
  private NoDuplo<T> last.
  private int size;

  public ListaDupla() {
    this.first = null;
    this.last = null;
    this.size = 0;
  }
}
