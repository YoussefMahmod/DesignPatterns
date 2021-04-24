package FactoryMethodePatternPackage;

public class CheesePizza implements IPizza{
   
    @Override
    public void preparePizza() {
        System.out.println("Preparing Cheese Pizza");
    }
}