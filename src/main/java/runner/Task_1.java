package runner;

import entity.Contract;
import org.hibernate.Session;

import java.util.List;

//1. Вывести самую дорогую сумму в контракте

public class Task_1 {

    public static void Task_1(Session session) {

        List<Contract> contracts = session.createQuery("FROM Contract").list();

        double max = 0;

        for (Contract contract : contracts) {
            if (contract.getInsuranceAmount() > max) {
                max = contract.getInsuranceAmount();
            }
        }

        System.out.println("Сумма: " + max);
    }
}
