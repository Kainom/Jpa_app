package one_to_many;

import infra.Dao;

import java.util.Date;

public class JogadorPagamento {

    public static void main(String[] args) {
        Jogador jogador = new Jogador();
        jogador.setNome("John Doe");
        jogador.setEmail("johndoe@example.com");
        jogador.setDatanasc(new Date());
        Pagamento pagamento = new Pagamento();
        pagamento.setAno(2022);
        pagamento.setMes(12);
        pagamento.setValor(1000.0);
        pagamento.setJogador(jogador);

        Pagamento pagamento2 = new Pagamento();
        pagamento.setAno(2022);
        pagamento.setMes(12);
        pagamento.setValor(1000.0);
        pagamento.setJogador(jogador);
        Pagamento pagamento3 = new Pagamento();
        pagamento.setAno(2022);
        pagamento.setMes(12);
        pagamento.setValor(1000.0);
        pagamento.setJogador(jogador);

        jogador.getPagamentos().add(pagamento);
        Dao<Object> dao = new Dao<>();
        dao.openTransaction().include(jogador)
                .include(pagamento)
                .include(pagamento2)
                .include(pagamento3)
                .closeTransaction()
                .close();




        // Salvar jogador e pagamento no banco de dados
    }
}
