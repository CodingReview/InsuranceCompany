package runner;

import entity.TypeInsurance;
import org.hibernate.Session;

import java.util.List;

//3. Вывести количество договоров по кажому виду страхования

public class Task_3 {

    public static void Task_3(Session session) {

        List<TypeInsurance> typeInsurances = session.createQuery("FROM TypeInsurance").list();

        for (TypeInsurance typeInsurance : typeInsurances) {
            System.out.println(typeInsurance + "\n" +
                    "Количество договоров: " + typeInsurance.getContract().size());
        }
    }
}
