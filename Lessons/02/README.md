<div dir = rtl>

<div align = "center">

# بسم الله الرحمن الرحيم
## السلام عليكم ورحمة الله وبركاته
## --{ Design Patterns #2 }--

</div>

بعد ما اخذنا نبذة عن ما هو الـ `UML Class Diagram` والـ `Design Patterns` سنبدأ مع اول `Design Pattern` معنا وهو الـ `Singleton`  
وهو يعد من الـ `Creational Design Patterns` اي انه يهتم بطريقة وكيفية انشاءنا للكائنات (`Objects`) 

# `Java`

نحن سنستخدم لغة الـ `Java` في التطبيق العملي  
لذلك سنتعرف على بعض المفاهيم المهمة التى توجد في الـ `Java`

اولا لنرى البيئة الخاصة بالـ `Java` لكتابة الاوامر  

<div dir = ltr>

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, Singleton!");
    }
}
```

</div>

لغة الـ `Java` لغة `OOP` بطبعها كل تعاملك معها سيكون عن طريق `فئات` (`classes`) ودوال وامور متعلقة بهما  
لدينا هنا `فئة` اساسية تدعى `Main` وهو اسم المشروع (`اسم الفئة الرئيسية للمشلروع ليس ثابتا يختلف بحسب اسم المشروع`)  
ستلاحظ اننا كتبنا قبل `الفئة` كلمة `public` وهذ معناه انه يمكن استدعائها خارجيا من `فئة` اخرى  
لو كتبنا `private` ولا يمكننا ان نستدعيها من فئة خارجية اخرى  

داخل `الفئة`  الرئيسية `Main` لدينا الدالة الرئيسية الذي يبدأ البرنامج التنفيذ منها وهي الـ `main`  
وهي ايضا `public` وايضا هي `static`  

كما قلنا الـ `static` يجعل المتغير او الدالة يتم استدعائها عن طريق `اسم الفئة` وليس عن طريق `كائن` ( `كائن` ) من هذه `الفئة`    

فمعنى اننا وضعنا للدالة  `static` اننا يمكن استدعائها دون الحاجة لعمل اي `كائن` من `الفئة`  `Main`  

# `مفهوم الـ Static`

ناخد مثال عملي عن كيف تتعامل لغة الـ `Java` مع مفهوم الـ `static`   

<div dir = ltr>

```java
public class Main {
    public String name = "Ahmed";
     
    public static void main(String[] args) {
        System.out.print(name); // خطأ
    }
}
```
</div>

هنا لدينا متغير يدعى `name` داخل `فئة`  الـ `Main`  
اذا حاولنا الوصول لهذا المتغير من داخل دالة الـ `main` سيعطينا خطأ   
يقول  

<div dir = ltr>

```
non-static variable name cannot be referenced from a static context
```
</div>

 بمعنى ان دالة الـ `main` هي `static` بالتالي لا يمكنك ان تستدعي اي متغير `non-static` داخلها بطريقة مباشرة  
والسبب يرجع لان متغير الـ `name` داخل `فئة`  الـ `Main` فان اردت الوصول له يجب ان تنشيء `كائن` من `فئة` الـ` Main`   

<div dir = ltr>

```java
public class Main {
     public String name = "Ahmed";
    
    public static void main(String[] args) {
        Main obj = new Main(); //Main أنشأنا كائن من الفئة الرئيسية

        System.out.print(obj.name);
        // هكذا لن يحدث اي خطأ
        //Main عن طريق عمل كائن من الفئة الرئيسية name لاننا وصلنا للمتغير 
    }
}
```
</div>

هنا لم يحدث اي خطأ لاننا انشأنا `كائن` من `فئة` الـ `Main` واستدعينا المتغير `name` عن طريقه  

الان ماذا سيحدث اذا جعلنا المتغير `name` يكون `static` ؟  
هكذا وعلى حسب مفهوم الـ `static` سيمكننا من استدعاء المتغير دون إنشاء اي  `كائن`  من `الفئة`   
وسنستدعيه عن طريق اسم `الفئة`  فقط  

<div dir = ltr>

```java
public class Main {
     public static String name = "Ahmed";
    
    public static void main(String[] args) {
        System.out.print(Main.name); 
        // لم يحدث اي خطأ
        //فنستطيع الوصول له عن طريق اسم الفئة الرئيسية فقط static لان المتغير نوعه
        //Main دون انشاء كائن من الفئة الرئيسية
    }
}
```
</div>

بهذا الشكل جعنا المتغير `name` يكون `static` ثم استديناه عن طريق كتابة `Main.name`  
استدعيناه عن طريق اسم `الفئة`  وليس عن طريق `كائن` منه كما لاحظت  

هنا لدينا شيء جميل بما اننا داخل `فئة`  الـ `Main` بالفعل فلا حاجة لكتابة اسم `الفئة`  لاستدعاء الـ `static`  

<div dir = ltr>

```java
public class Main {
     public static String name = "Ahmed";
    
    public static void main(String[] args) {
        System.out.print(name);
        // بداخله بالفعل Main لا حاجة لكتابة اسم الفئة
        // لكن إن كنا خارجه فيجب كتابة اسم الفئة
    }
}
```
</div>

فطالما نحن داخل `الفئة`  فلا حاجة لتكرار اسمه  
لكن ان كنا خارج `الفئة`  فيجب كتابة اسمه ثم المتغير الـ `static`  

# `Singleton Pattern`

احيانًا يوجد بعض الاشياء في مشروعك لا تريد ان يكون لديها اكثر من `كائن`  

امثلة افتراضية لهذه الحالة  
- نريد  `كائن`  واحد لقاعدة البيانات `Database`، نحن لدينا قاعدة بيانات واحدة فقط ولا يمكن ان يكون هناك اكثر  
- نريد  `كائن`  واحد لكلاس الـ `Manager`، لا يمكن ان يكون لدينا مديران في الشركة  
- نريد  `كائن`  واحد لكلاس `Login`, `register`  
اي شيء تفكر فيه تريده ان يكون له  `كائن`  وحيد لا غير  

فهذه بحد ذاتها مشكلة تريد حلها، تريد ان تصمم `الفئة`  خاصتك بحيث يجب ان يكون لديه  `كائن`  واحد فقط  

هنا ظهر الحل وهو الـ `Singleton Pattern` ليحل لنا هذه المشكلة  
وهو عبارة عن مجموعة من القواعد التى تتبعها وتضيفها `للفئة` خاصتك   
لكي يجعل `الفئة`  يسمح بإنشاء  `كائن`  واحد فقط  

دعونا ننشيء `فئة`  يدعى `Manager`

<div dir = ltr align = "center">

|Manager|
|:-:|
|- id : int <br> - name : string|
|+ setName(string) <br> + getName() : string|

</div>

هذا الجدول  سنترجمة في لغة الـ `Java` بهذا الشكل  

<div dir = ltr>

```java
public class Manager{
    // Private Variables
    private int id;
    private String name;
    
    // Public Methods
    public void setName(String name){
        this.name = name;
    }	
    public String getName(){
        return name;
    }
}
```  
</div>

لدينا `فئة`  الـ `Manager` بالمتغيرات والدوال التى كانت موضحة في جدول الـ `UML`   

هذه `الفئة`  كتبناها في ملف خارجي لكنها ضمن الـ `Package` (`حزمة`)  
في الجافا سنتعامل مع البرنامج او المشروع كمجموعة `فئات` تكون في `Package` موحد يضمها  
كل `فئة`  نكتبها في ملف منفصل   

فمعنى ان المشروع خاصتنا ملفاته تبدوا كهذا  

<div dir = ltr>

```
Package
|
+-- Main.java
|
+-- Manager.java
```  
</div>

فكلا `الفئتين` الـ `Main` والـ `Manager` متواجدتين في نفس الـ `Package`  
فهكذا كلتيهما تريان بعضهما البعض  


# `قواعد الـ Singleton`  

الان لدينا `فئة`  الـ `Manager` ونريد ان نجعلها نمتلك  `كائن`  واحد فقط  
ولا نريد ان نسمح لها بإنشاء اكثر من  `كائن`  واحد  

لذا سنحاول ان نطبق عليه قواعد الـ `Singleton`

وهي كالأتي  

- إنشاء  `كائن`  من نفس نوع `الفئة`  يكون `private` و`static`
- إنشاء `Constructor` وجعله `private`
- إنشاء دالة تكون `public` تقوم دائما بارجاع نفس `الكائن`  الذي انشأناه اول مرة داخل `الفئة`  


<div dir = ltr align = "center">

|Singleton|
|:-:|
|- <u> singleton </u>: Singleton|
|- Singleton() <br> + <u> getObject() </u> : Singleton|

</div>

هذه `فئة`  افتراضية تدعى `Singleton` (`مجرد اسم لا اكثر`) طبقنا فيها قواعد الـ `Singleton Pattern`  


<div dir = ltr>

> \- <u> singleton </u>: Singleton
</div>

هنا انشأنا  `كائن`  يدعى `singleton` من نوع `الفئة`  `Singleton` وجعلناه `static` وهو `private` بسبب اشارة الـ `-`  

<div dir = ltr>

> \- Singleton()
</div>

هنا جعلنا الـ `Constructor` يكون `private` لنمنع انشاء اي  `كائن`  من `الفئة`  بشكل دائم  
وان كان لديك اكثر من `constructor` يجب ان تجعلهم `private`  

<div dir = ltr>

> \+ <u> getObject() </u> : Singleton
</div>

هنا ننشيء الدالة التى سترجع لنا في كل مرة نستدعيها نفس `الكائن` الذي انشأناه  

دعونا نرى مثال عملي على `فئة`  الـ `Manager` خاصتنا  


<div dir = ltr align = "center">

|Manager|
|:-:|
|- id : int <br> - name : string <br> - <u> manager </u> : Manager|
|- Manager() <br> + <u> getManager() </u> : Manager <br> + setName(string) <br> + getName() : string|

</div>

لقد اضفنا  `كائن`  يدعى `manager` من نفس نوع `الفئة`  `Manager` وهو `private` و`static`  
ثم جعلنا الـ `constructor` يكون `private` هكذا لا يمكننا انشاء اي `كائن` من الـ `Manager`  
ثم اخيرا لدينا دالة هي من سترجع لنا في كل مرة  `الكائن`  الذي انشأه اول مرة وهو الـ `manager`  

دعونا نرى ترجمة كل ما قلناه `للفئة` الـ `Manager` في الـ `Java`

<div dir = ltr>

```java
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
```
</div>

هكذا اصبح `فئة`  الـ `Manager` تمتلك  `كائن`  واحد فقط وهو `manager` الذي جعلناه `private` و`static`  
وجعلنا الـ `constructer` يكون `private` ليمنع انشاء اي  `كائن`  اخر من `فئة`  الـ `Manager`  
ثم لدينا اهم دالة هنا وهي `getManager` وهي `static` لكي يستطيع المستخدم استدعائها دون الحاجة لعمل  `كائن`  من `الفئة`   
(`وبالمناسبة لن يستطيع عمل اي كائن على اي حال`)  

وان حاول فعل هذا

<div dir = ltr>

```java
public class Main {
    
    public static void main(String[] args) {
        Manager obj = new Manager(); //خاص وليس عام constructor خطأ، لان الـ 
    }
}
```
</div>

كيف اذًا نحصل على `الكائن`  لنتعامل مع `الفئة`  خاصتنا والدوال التى بها ؟  
هنا يأتي دور الدالة المهمة `getManager`  

دعونا نناقش هذه الدالة قليلا  

<div dir = ltr>

```java
private static Manager manager = null;

public static Manager getManager(){
    if(manager == null) // التأكد اذا كان الكائن خاصتنا تم انشاءه من قبل ام لا
        manager = new Manager(); // انشاء الكائن في حال عدم وجوده

    return manager; // ارجاع الكائن الوحيد الذي لدينا
}
```
</div>

هي حلقة الوصل بينك وبين `الفئة` ، هي من تعطيك نفس `الكائن`  الوحيد الذي انشأناه  
وهي دالة بسيطة جدا، تقول ان كان `الكائن`  الذي انشأناه يساوي `null` معنى هذا انها المرة الاولى التي يتم استدعاء الدالة  
فأنشيء له  `كائن`  جديد، ثم ارجع له `الكائن` ، ثم في كل مرة سيستدعي الدالة ستعطيه نفس `الكائن`   


<div dir = ltr>

```java
public class Main {
    
    public static void main(String[] args) {
        Manager obj = Manager.getManager(); // هكذا نحضر الكائن الوحيد الذي نمتلكه عن طريق الدالة
            
        obj.setName("Ahmed");
        System.out.println(obj.getName()); //Ahmed :الطباعة ستكون
    }
}
```
</div>

لاحظ اننا استخدمنا اسم `الفئة`  `Manager` لاستدعاء دالة الـ `getManager` لانها `static`

يمكننا ان نختصر الدالة في سطر واحد هكذا  

<div dir = ltr>

```java
// ننشيء الكائن في لحظة تعريفنا له
private static final Manager manager = new Manager();

public static Manager getManager(){
    return manager; // ارجاع الكائن الوحيد الذي لدينا
}
```
</div>

كلمة `final` تعني ان اول قيمة سيتلقاها المتغير او `الكائن`  ستكون ثابتة ولن يستطيع ان تغيرها شبيهه بالـ `const`

هنا ينتعي درسنا عن الـ `Singleton`  
الـ `Singleton Pattern` قد يختلف في الشكل والاسلوب عن ما كتبناه لكن تظل قواعده ومفاهيمه ثابتة

</div> 