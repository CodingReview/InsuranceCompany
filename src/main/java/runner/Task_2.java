package runner;


import entity.Agent;
import entity.Contract;
import org.hibernate.Session;

import java.util.List;

//2. Вывести всех клинтов агента

public class Task_2 {

    public static void Task_2(Session session) {

        List<Agent> agents = session.createQuery("FROM Agent").list();
        List<Contract> contracts = session.createQuery("FROM Contract").list();

        System.out.println(agents.get(0));
        String string = " ";

        for (Contract contract : agents.get(0).getContract()) {

            if (!string.contains(contract.getClient().getId() + " ")) {
                System.out.println(contract.getClient());
                string += contract.getClient().getId() + " ";
            }
        }
    }
}
