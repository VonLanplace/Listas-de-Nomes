package model;

public class KeyDupla extends ListaDupla<KeyList> {
	public KeyDupla() {
		super();
	}

	public void insert(String content) throws IllegalArgumentException {
		if (content == null)
			throw new IllegalArgumentException("Conteudo não pode ser nulo!!");
		if (content.isEmpty())
			throw new IllegalArgumentException("Conteudo não pode ser vazio!!");

		Character index = content.toLowerCase().charAt(0);

		NoDuplo<KeyList> node = super.getFirst();
		while (node != null && node.getContent().getIndex().compareTo(index) < 0) {
			node = node.getNext();
		}

		if (node == null) {
			super.append(new KeyList(index, content));
			return;
		}

		if (node.getContent().getIndex().equals(index)) {
			node.getContent().insert(content);

		} else {
			super.insertAntes(new KeyList(index, content), node);

		}
	}

	public int[] index(String content) throws IllegalArgumentException {
		if (content == null)
			throw new IllegalArgumentException("Conteudo não pode ser nulo!!");
		if (content.isEmpty())
			throw new IllegalArgumentException("Conteudo não pode ser vazio!!");

		if (this.getFirst() == null)
			throw new IllegalArgumentException("Conteudo não encontrado: " + content);

		Character key = content.toLowerCase().charAt(0);
		NoDuplo<KeyList> buffer = super.getFirst();
		int index[] = { 0, 0 };

		while (buffer != null) {
			if (buffer.getContent().getIndex().equals(key)) {
				index[1] = buffer.getContent().index(content);
				return index;
			} else {
				buffer = buffer.getNext();
				index[0]++;
			}
		}
		throw new IllegalArgumentException("Conteudo não encontrado: " + content);

	}

	public String get(int indexDupla, int indexLista) throws IllegalArgumentException {

		if (indexDupla < 0 || indexDupla >= this.getSize()) {
			throw new IllegalArgumentException(
					"indexDupla out of  bounds.\n\tindexDupla:" + indexDupla + "\n\tindexLista:" + indexLista);
		}

		if (this.getFirst() == null)
			throw new IllegalArgumentException("The KeyDupla is Empty");

		KeyList list = super.get(indexDupla).getContent();

		if (indexLista < 0 || indexLista >= list.getSize()) {
			throw new IllegalArgumentException(
					"indexLista out of  bounds.\n\tindexDupla:" + indexDupla + "\n\tindexLista:" + indexLista);
		}

		if (list.getFirst() == null)
			throw new IllegalArgumentException("The keylist is Empty");

		return list.get(indexLista).getContent();
	}

	public void remove(String content) throws IllegalArgumentException {
		int[] index = this.index(content);
		remove(index[0], index[1]);
	}

	public void remove(int indexDupla, int indexLista) throws IllegalArgumentException {
		NoDuplo<KeyList> node = this.get(indexDupla);
		node.getContent().remove(indexLista);
		if (node.getContent().getSize() <= 0) {
			this.remove(indexDupla);
		}
	}

}
