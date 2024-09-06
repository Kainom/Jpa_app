package kainom.exercice;

import basic.model.Produto;
import infra.ProdutoDao;

import java.util.List;

public class ObterProduto {
    public static void main(String[] args) {
        ProdutoDao dao = new ProdutoDao();
        List<Produto> produtos = dao.getAll();
        produtos.forEach(e -> System.out.println(e.getNome()));
        dao.close();
    }
}
