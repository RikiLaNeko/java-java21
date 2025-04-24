package java17.ex02;

import java.util.List;

import org.junit.Test;

import java17.data.Data;
import java17.data.Person;

/**
 * Exercice 02 - Redéfinition
 */
public class Method_02_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();

        // Méthode par défaut pour formater le nombre de personnes
        default String format() {
            return "[" + findAll().size() + " persons]";
        }
    }
    // end::IDao[]

    // tag::DaoA[]
    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

        // Redéfinition de la méthode format()
        @Override
        public String format() {
            return "DaoA" + IDao.super.format();
        }
    }
    // end::DaoA[]

    @Test
    public void test_daoA_format() throws Exception {

        DaoA daoA = new DaoA();

        // Invocation de la méthode format()
        String result = daoA.format();

        assert "DaoA[20 persons]".equals(result);
    }
}