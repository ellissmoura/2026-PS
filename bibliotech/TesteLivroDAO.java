public class TesteLivroDAO {

    public static void main(String[] args) {

        LivroDAO dao = new LivroDAO();

        // 1. Cadastrar O Pequeno Príncipe
        boolean resultado1 = dao.adicionarLivro(
            "O Pequeno Príncipe",
            "Antoine de Saint-Exupéry",
            1943
        );
        System.out.println("O Pequeno Príncipe adicionado: " + resultado1);

        // 2. Cadastrar outro livro (1984)
        boolean resultado2 = dao.adicionarLivro(
            "1984",
            "George Orwell",
            1949
        );
        System.out.println("1984 adicionado: " + resultado2);

        // 3. Atualizar o livro (informando o id correspondente no banco de dados)
        int idParaAtualizar = 1;

        boolean resultadoAtualizacao = dao.atualizarLivro(
            idParaAtualizar,
            "O Pequeno Príncipe - Edição Revisada",
            "Antoine de Saint-Exupéry",
            1943
        );

        System.out.println("Livro atualizado: " + resultadoAtualizacao);
    }
}