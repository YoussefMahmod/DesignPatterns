package FactoryMethodePatternPackage;

public class PizzaFactoryClass{
/* هذه الدالة هي من ستسقبل الطلب وسترجع كائن من نوع البيتزا المطلوبة
IPizza وبما ان انواع البيتزا التى لدينا تنفذ الـ IPizza ولاحظ ان الدالة ترجع
فهي تتشارك في نفس هذا الاسم في الانشاء كما وضحنا فوق
*/
    public IPizza CreatePizzaObject(int order){
        if(order == 1)
            return new MargheritaPizza(); // اذا كان رقم الطلب هو 1 نعيد كائن من بيتزا مارغريتا
        
        else if (order == 2)
            
            return new CheesePizza(); // اذا كان رقم الطلب هو 2 نعيد كائن من بيتزا الجبن
        
        else if (order == 3)
            
            return new TomatoPizza(); // اذا كان رقم الطلب هو 3 نعيد كائن من بيتزا الطماطم
        
        else
            return null; // الطلب ليس موجودًا
    }
}