import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Aluno> gaveteiro = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;

        do {
            System.out.println("==================================================");
            System.out.println("       SISTEMA DE SECRETARIA - CAMPUS ELLIS       ");
            System.out.println("==================================================");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Listar Todos os Alunos");
            System.out.println("3 - Buscar Aluno por Matrícula");
            System.out.println("4 - Buscar Aluno por Nome (Melhoria A)");
            System.out.println("5 - Atualizar Dados do Aluno");
            System.out.println("6 - Remover Aluno");
            System.out.println("7 - Relatório por Curso");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(" Opção inválida! Digite apenas um número do menu.");
                continue;
            }

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscarPorMatriculaMenu();
                    break;
                case 4:
                    buscarPorNome();
                    break;
                case 5:
                    atualizar();
                    break;
                case 6:
                    remover();
                    break;
                case 7:
                    gerarRelatorio();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema da secretaria... Até logo!");
                    break;
                default:
                    System.out.println(" Opção inexistente. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void cadastrar() {
        System.out.println("\n--- [ NOVO CADASTRO DE ALUNO ] ---");
        int matricula = lerInteiroValido("Digite a matrícula: ");

        if (buscarPorMatricula(matricula) != null) {
            System.out.println(" Erro: Já existe um aluno cadastrado com a matrícula " + matricula + "!");
            return;
        }

        String nome = lerTextoNaoVazio("Digite o nome completo: ");
        String curso = lerTextoNaoVazio("Digite o curso do aluno: ");
        double ira = lerDoubleValido("Digite o IRA (0.0 a 10.0): ", 0.0, 10.0);

        Aluno aluno = new Aluno(matricula, nome, curso, ira);
        gaveteiro.add(aluno);
        System.out.println(" Aluno " + nome + " cadastrado com sucesso!");
    }

    private static void listar() {
        System.out.println("\n--- [ LISTAGEM DE ALUNOS ] ---");
        if (gaveteiro.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado no momento.");
            return;
        }

        for (Aluno a : gaveteiro) {
            System.out.println(a);
        }
    }

    private static Aluno buscarPorMatricula(int matricula) {
        for (Aluno a : gaveteiro) {
            if (a.getMatricula() == matricula) {
                return a;
            }
        }
        return null;
    }

    private static void buscarPorMatriculaMenu() {
        System.out.println("\n--- [ BUSCA POR MATRÍCULA ] ---");
        int matricula = lerInteiroValido("Digite a matrícula do aluno: ");
        Aluno aluno = buscarPorMatricula(matricula);

        if (aluno != null) {
            System.out.println("Aluno encontrado:\n" + aluno);
        } else {
            System.out.println(" Nenhuma matrícula encontrada com o número: " + matricula);
        }
    }

    private static void buscarPorNome() {
        System.out.println("\n--- [ BUSCA POR NOME ] ---");
        String nomeBusca = lerTextoNaoVazio("Digite o nome (ou parte dele) para buscar: ").toLowerCase();
        boolean encontrado = false;

        for (Aluno a : gaveteiro) {
            if (a.getNome().toLowerCase().contains(nomeBusca)) {
                System.out.println(a);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println(" Nenhum aluno localizado contendo o nome digitado.");
        }
    }

    private static void atualizar() {
        System.out.println("\n--- [ ATUALIZAR DADOS DE ALUNO ] ---");
        int matricula = lerInteiroValido("Digite a matrícula do aluno a ser alterado: ");
        Aluno aluno = buscarPorMatricula(matricula);

        if (aluno == null) {
            System.out.println(" Aluno não encontrado!");
            return;
        }

        System.out.println("Dados atuais: " + aluno);
        String novoNome = lerTextoNaoVazio("Digite o novo nome: ");
        String novoCurso = lerTextoNaoVazio("Digite o novo curso: ");
        double novoIra = lerDoubleValido("Digite o novo IRA (0.0 a 10.0): ", 0.0, 10.0);

        aluno.setNome(novoNome);
        aluno.setCurso(novoCurso);
        aluno.setIra(novoIra);

        System.out.println(" Dados do aluno atualizados com sucesso!");
    }

    private static void remover() {
        System.out.println("\n--- [ REMOVER ALUNO ] ---");
        int matricula = lerInteiroValido("Digite a matrícula do aluno a remover: ");
        Aluno aluno = buscarPorMatricula(matricula);

        if (aluno == null) {
            System.out.println(" Aluno não encontrado!");
            return;
        }

        gaveteiro.remove(aluno);
        System.out.println(" Aluno " + aluno.getNome() + " removido com sucesso!");
    }

    private static void gerarRelatorio() {
        System.out.println("\n--- [ RELATÓRIO POR CURSO ] ---");
        String cursoBusca = lerTextoNaoVazio("Digite o nome do curso: ").toLowerCase();
        boolean encontrado = false;

        for (Aluno a : gaveteiro) {
            if (a.getCurso().toLowerCase().equals(cursoBusca)) {
                System.out.println(a);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println(" Nenhum aluno cadastrado nesse curso.");
        }
    }

    // --- MÉTODOS AUXILIARES DE VALIDAÇÃO ---

    private static int lerInteiroValido(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    private static String lerTextoNaoVazio(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            if (!entrada.isEmpty()) {
                return entrada;
            }
            System.out.println(" O campo não pode ficar vazio. Tente novamente.");
        }
    }

    private static double lerDoubleValido(String mensagem, double min, double max) {
        while (true) {
            System.out.print(mensagem);
            try {
                double valor = Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println(" Valor deve estar entre " + min + " e " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println(" Entrada inválida. Digite um valor numérico decimal válido.");
            }
        }
    }
}