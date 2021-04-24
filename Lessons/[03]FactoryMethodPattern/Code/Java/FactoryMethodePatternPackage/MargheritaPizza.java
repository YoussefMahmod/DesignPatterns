package FactoryMethodePatternPackage;

public class MargheritaPizza implements IPizza{

    @Override
    public void preparePizza() {
        System.out.println("Preparing Margherita Pizza");
    }
}