package controller;

import model.KeyDupla;

public class Atividade1 {
	public Atividade1() {
		super();
	}

	public void exec() {
		try {
			// 1. Criar uma instância de KeyDupla
			KeyDupla keyDupla = new KeyDupla();
			System.out.println("=== KEYDUPLA CRIADA ===");

			// 2. Testar inserção de elementos
			System.out.println("\n=== INSERINDO ELEMENTOS ===");
			keyDupla.insert("Apple");
			keyDupla.insert("Banana");
			keyDupla.insert("Avocado");
			keyDupla.insert("Cherry");
			keyDupla.insert("Blueberry");
			keyDupla.insert("Apricot");
			keyDupla.insert("Coconut");
			keyDupla.insert("Blackberry");
			System.out.println("8 elementos inseridos com sucesso!");

			// 3. Testar recuperação por coordenadas
			System.out.println("\n=== RECUPERAÇÃO POR COORDENADAS ===");
			System.out.println("Elemento [0, 0]: " + keyDupla.get(0, 0)); // Apple
			System.out.println("Elemento [0, 1]: " + keyDupla.get(0, 1)); // Apricot
			System.out.println("Elemento [0, 2]: " + keyDupla.get(0, 2)); // Avocado
			System.out.println("Elemento [1, 0]: " + keyDupla.get(1, 0)); // Banana
			System.out.println("Elemento [1, 1]: " + keyDupla.get(1, 1)); // Blackberry
			System.out.println("Elemento [1, 2]: " + keyDupla.get(1, 2)); // Blueberry
			System.out.println("Elemento [2, 0]: " + keyDupla.get(2, 0)); // Cherry
			System.out.println("Elemento [2, 1]: " + keyDupla.get(2, 1)); // Coconut

			// 4. Testar busca por conteúdo (index)
			System.out.println("\n=== BUSCA POR CONTEÚDO ===");
			int[] index1 = keyDupla.index("Apple");
			System.out.println("Posição de 'Apple': [" + index1[0] + ", " + index1[1] + "]");

			int[] index2 = keyDupla.index("Coconut");
			System.out.println("Posição de 'Coconut': [" + index2[0] + ", " + index2[1] + "]");

			int[] index3 = keyDupla.index("Blueberry");
			System.out.println("Posição de 'Blueberry': [" + index3[0] + ", " + index3[1] + "]");

			// 5. Testar remoção por conteúdo
			System.out.println("\n=== REMOÇÃO POR CONTEÚDO ===");
			System.out.println("Removendo 'Apricot'...");
			keyDupla.remove("Apricot");
			System.out.println("Removendo 'Banana'...");
			keyDupla.remove("Banana");

			// Verificar se as remoções funcionaram
			System.out.println("Elemento [0, 0] após remoções: " + keyDupla.get(0, 0)); // Apple
			System.out.println("Elemento [0, 1] após remoções: " + keyDupla.get(0, 1)); // Avocado
			System.out.println("Elemento [1, 0] após remoções: " + keyDupla.get(1, 0)); // Blackberry

			// 6. Testar remoção por coordenadas
			System.out.println("\n=== REMOÇÃO POR COORDENADAS ===");
			System.out.println("Removendo elemento [2, 1] (Coconut)...");
			keyDupla.remove(2, 1); // Remove Coconut
			System.out.println("Removendo elemento [2, 0] (Cherry)...");
			keyDupla.remove(2, 0); // Remove Cherry - deve remover a lista inteira da letra C

			// 7. Testar tratamento de erros
			System.out.println("\n=== TESTE DE ERROS ===");

			try {
				keyDupla.insert(null);
			} catch (IllegalArgumentException e) {
				System.out.println("Erro esperado ao inserir null: " + e.getMessage());
			}

			try {
				keyDupla.insert("");
			} catch (IllegalArgumentException e) {
				System.out.println("Erro esperado ao inserir string vazia: " + e.getMessage());
			}

			try {
				keyDupla.get(10, 0); // Índice inválido
			} catch (IllegalArgumentException e) {
				System.out.println("Erro esperado ao acessar índice inválido: " + e.getMessage());
			}

			try {
				keyDupla.index("Manga"); // Elemento não existe
			} catch (IllegalArgumentException e) {
				System.out.println("Erro esperado ao buscar elemento inexistente: " + e.getMessage());
			}

			// 8. Testar inserção após remoções
			System.out.println("\n=== NOVAS INSERÇÕES APÓS REMOÇÕES ===");
			keyDupla.insert("Dragonfruit");
			keyDupla.insert("Date");
			keyDupla.insert("Fig");

			System.out.println("Novo elemento [2, 0]: " + keyDupla.get(2, 0)); // Date
			System.out.println("Novo elemento [2, 1]: " + keyDupla.get(2, 1)); // Dragonfruit
			System.out.println("Novo elemento [3, 0]: " + keyDupla.get(3, 0)); // Fig

			System.out.println("\n=== TODOS OS TESTES CONCLUÍDOS COM SUCESSO! ===");

		} catch (Exception e) {
			System.err.println("Erro inesperado: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
