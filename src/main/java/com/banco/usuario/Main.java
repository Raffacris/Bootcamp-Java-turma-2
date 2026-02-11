package com.banco.usuario;

import com.banco.usuario.model.Usuario;
import com.banco.usuario.repository.UsuarioRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        UsuarioRepository repository = new UsuarioRepository();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar usuário");
            System.out.println("5 - Remover usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {

                case 1:
                    System.out.println("\n--- Cadastro de Usuário ---");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    repository.salvar(new Usuario(null, nome, email));
                    System.out.println("✅ Usuário cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("\n--- Lista de Usuários ---");
                    List<Usuario> lista = repository.listar();
                    if (lista.isEmpty()) {
                        System.out.println("⚠ Nenhum usuário cadastrado.");
                    } else {
                        lista.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("\nDigite o ID: ");
                    Long idBusca = scanner.nextLong();

                    Usuario usuarioEncontrado = repository.buscarPorId(idBusca);

                    if (usuarioEncontrado != null) {
                        System.out.println("✅ Usuário encontrado:");
                        System.out.println(usuarioEncontrado);
                    } else {
                        System.out.println("❌ Usuário não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("\nDigite o ID do usuário para atualizar: ");
                    Long idAtualizar = scanner.nextLong();
                    scanner.nextLine();

                    Usuario usuarioAtualizar = repository.buscarPorId(idAtualizar);

                    if (usuarioAtualizar == null) {
                        System.out.println("❌ Usuário não existe. Atualização cancelada.");
                    } else {
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();

                        System.out.print("Novo email: ");
                        String novoEmail = scanner.nextLine();

                        usuarioAtualizar.setNome(novoNome);
                        usuarioAtualizar.setEmail(novoEmail);

                        repository.atualizar(usuarioAtualizar);
                        System.out.println("✅ Usuário atualizado com sucesso!");
                    }
                    break;

                case 5:
                    System.out.print("\nDigite o ID do usuário para remover: ");
                    Long idRemover = scanner.nextLong();

                    Usuario usuarioRemover = repository.buscarPorId(idRemover);

                    if (usuarioRemover == null) {
                        System.out.println("❌ Usuário não existe. Remoção cancelada.");
                    } else {
                        repository.remover(idRemover);
                        System.out.println("🗑 Usuário removido com sucesso!");
                    }
                    break;

                case 0:
                    System.out.println("👋 Encerrando sistema...");
                    break;

                default:
                    System.out.println("⚠ Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
