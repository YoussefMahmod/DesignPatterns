package FactoryMethodePattern;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /* Codes
            هنا نفترض ان الطلب الذي يختارة العميل يرسل علي هيئة قيم رمزية لكل طلب

            1 => Margherita
            2 => Cheese
            3 => Tomato
         */

        // الثلاثة سطور التالية تقوم باخذ رقم الطلب من العمل
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Order's Number: ");
        int order = scan.nextInt(); // order ويتم تخزين رقم الطلب في متغير الـ 

        // ننشئ كائن من كل نوع من انواع البيتزا لكي نتمكن من استخدام دالة الانشاء على حسب رقم الطلب
        MargheritaPizza margheritaPizzaObject = new MargheritaPizza();
        CheesePizza cheesePizzaObject = new CheesePizza();
        TomatoPizza tomatoPizzaObject = new TomatoPizza();

        if (order == 1)
            margheritaPizzaObject.create();
        
        else if (order == 2)
            cheesePizzaObject.create();
        
        else if (order == 3) 
            tomatoPizzaObject.create();
        
        else
            System.out.print("Not Found");
    }
}
