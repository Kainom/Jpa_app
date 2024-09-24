package many_to_many;

import infra.Dao;

public class NovoTioSobrinho {
    public static void main(String[] args) {
        Tio tia = new Tio(30,"Médici","Lorenzo");
        Tio tio = new Tio(25,"Médici","Anna Maria");

        Sobrinho sobrinho = new Sobrinho("Giovanni","Médici",19);
        Sobrinho sobrinha = new Sobrinho("Catarina","Médici",17);

        tia.getSobrinhos().add(sobrinho);
        sobrinho.getTios().add(tia);

        tio.getSobrinhos().add(sobrinha);
        sobrinha.getTios().add(tio);


        tio.getSobrinhos().add(sobrinho);
        sobrinho.getTios().add(tio);


        tia.getSobrinhos().add(sobrinha);
        sobrinha.getTios().add(tia);

        Dao<Object> dao = new Dao<>();
        dao.openTransaction().include(tio).include(tia).include(sobrinho).include(sobrinha).closeTransaction().close();

    }
}
