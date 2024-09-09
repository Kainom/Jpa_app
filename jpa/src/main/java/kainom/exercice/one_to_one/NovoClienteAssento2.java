package kainom.exercice.one_to_one;

import infra.Dao;
import jdk.swing.interop.SwingInterOpUtils;
import one_to_one.Assento;
import one_to_one.Cliente;

public class NovoClienteAssento2
{
    public static void main(String[] args) {
        Assento assento = new Assento("50F");
        Cliente cliente = new Cliente("Mugen",assento);

        Dao<Cliente> dao = new Dao<>(Cliente.class);
        Cliente client = dao.getById(1L);
        System.out.println(client.getAssento().getLocal());
        System.out.println(client.getAssento().getCliente().getNome());

        dao.close();

        Dao<Assento> daoAssento = new Dao<>(Assento.class);
        Assento seat = daoAssento.getById(2L);
        System.out.println(seat.getCliente().getNome());

        daoAssento.close();


    }
}
