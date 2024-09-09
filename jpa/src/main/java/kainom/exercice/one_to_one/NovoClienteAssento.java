package kainom.exercice.one_to_one;

import infra.Dao;
import one_to_one.Assento;
import one_to_one.Cliente;

public class NovoClienteAssento {
    public static void main(String[] args) {
        Assento assento = new Assento("77F");
        Cliente cliente = new Cliente("Zortan",assento);
        Dao<Object> dao = new Dao<>();
        dao.openTransaction().include(assento).include(cliente).closeTransaction().close();

    }
}
