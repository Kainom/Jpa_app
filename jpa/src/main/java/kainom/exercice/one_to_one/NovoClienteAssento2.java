package kainom.exercice.one_to_one;

import infra.Dao;
import one_to_one.Assento;
import one_to_one.Cliente;

public class NovoClienteAssento2
{
    public static void main(String[] args) {
        Assento assento = new Assento("50F");
        Cliente cliente = new Cliente("Mugen",assento);

        Dao<Cliente> dao = new Dao<>(Cliente.class);
        dao.includeAtomic(cliente);
    }
}
