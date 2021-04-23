package SingletonPatternPackage;

public class Main {
    
    public static void main(String[] args) {
        Manager obj = Manager.getManager(); // هكذا نحضر الكائن الوحيد الذي نمتلكه عن طريق الدالة
            
        obj.setName("Ahmed");
        System.out.println(obj.getName()); //Ahmed :الطباعة ستكون
    }
}