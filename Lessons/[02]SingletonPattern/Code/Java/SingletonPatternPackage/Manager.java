package SingletonPatternPackage;

public class Manager{
    
    // Private Variables
    private int id;
    private String name;

    // الكائن الوحيد الخاص بالفئة
    private static Manager manager = null;
        
    // Private Methods
    // Constructor
    private Manager(){} // جعلناه خاص لكي لا ينشيء اي كائن اخر من الفئة 
        
    // Public Methods
    public static Manager getManager(){
        if(manager == null) // التأكد اذا كان الكائن خاصتنا تم انشاءه من قبل ام لا
            manager = new Manager(); // انشاء الكائن في حال عدم وجوده

        return manager; // ارجاع الكائن الوحيد الذي لدينا
    }
    public void setName(String name){
        this.name = name;
    }                   
    public String getName(){
        return name;
    }
}