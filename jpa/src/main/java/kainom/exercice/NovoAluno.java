package kainom.exercice;

import infra.Dao;
import inheritance.Aluno;
import inheritance.AlunoBolsista;

public class NovoAluno {

    public static void main(String[] args) {
        Dao<Aluno> alunoDao = new Dao<>();

        Aluno aluno = new Aluno();
        AlunoBolsista alunoBolsista = new AlunoBolsista();
        aluno.setNome("Simple Aluno");
        aluno.setMedia(10d);
        alunoBolsista.setNome("Aluno Super Muscule");
        alunoBolsista.setMedia(1000d);
        alunoBolsista.setBolsa(100d);
        alunoDao.includeAtomic(aluno);
        alunoDao.includeAtomic(alunoBolsista);

        alunoDao.close();
    }
}