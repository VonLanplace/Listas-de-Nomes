package model;

public class KeyList extends ListaSimples<String> {
	private Character index;

	public KeyList(Character index) {
		super();
		this.setIndex(index);
	}

	public KeyList(Character index, String content) throws IllegalArgumentException {
		if (content == null || content.isEmpty())
			throw new IllegalArgumentException("Conteudo não pode ser nulo ou vazio!!\n\tcontent: " + content);
		this.setFirst(null);
		this.setSize(0);
		this.setIndex(index);
		this.insert(content);
	}

	public void insert(String content) throws IllegalArgumentException {
		if (content == null)
			throw new IllegalArgumentException("Conteudo não pode ser nulo!!");
		if (content.isEmpty())
			throw new IllegalArgumentException("Conteudo não pode ser vazio!!");

		int index = 0;
		No<String> buffer = getFirst();

		while (buffer != null && buffer.getContent().compareTo(content) < 0) {
			buffer = buffer.getNext();
			index++;
		}

		if (buffer == null) {
			super.append(content);
		} else {
			super.insert(index, content);
		}
	}

	public Character getIndex() {
		return index;
	}

	protected void setIndex(Character index) {
		this.index = index;
	}

}
