package FactoryMethodePatternPackage;

public class TomatoPizza implements IPizza{

    @Override
    public void preparePizza() {
        System.out.println("Preparing Tomato Pizza");
    }
}