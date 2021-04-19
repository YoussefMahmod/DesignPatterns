<div dir = rtl>

<div align = "center">

# بسم الله الرحمن الرحيم
## السلام عليكم ورحمة الله وبركاته
## --{ Design Patterns #2 }--

</div>

بعد ما اخذنا نبذة عن ما هو الـ `UML Class Diagram` والـ `Design Patterns` سنبدأ مع اول `Design Pattern` معنا وهو الـ `Singleton`

قبل ذلك، نحن سنستخدم لغة الـ `Java` في التطبيق العملي  
لذلك سنتعرف على بعض المفاهيم المهمة التى توجد في الـ `Java`

# `Java`

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

لغة الـ `Java` لغة `OOP` بطبعها كل تعاملك معها سيكون عن طريق كلاسات ودوال وامور متعلقة بهما  
لدينا هنا كلاس اساسي يدعى `Main` وهو اسم المشروع (`اسم الكلاس الرئيسي ليس ثابتا يختلف بحسب اسم المشروع`)  
ستلاحظ اننا كتبنا قبل الكلاس `public` وهذ معناه انه يمكن استدعائه خارجيا من كلاس اخر  
لو كتبنا `private` ولا يمكننا ان نستدعيه من كلاس خارجي اخر  

داخل الكلاس الرئيسي `Main` لدينا الدالة الرئيسية الذي يبدأ البرنامج التنفيذ منها وهي الـ `main`  
وهي ايضا `public` وايضا هي `static`  

كما قلنا الـ `static` يجعل المتغير او الدالة يتم استدعائها عن طريق `اسم الكلاس` وليس عن طريق `object` من هذا الكلاس   

فمعنى اننا وضعنا للدالة  `static` اننا يمكن استدعائها دون الحاجة لعمل `object` من الكلاس `Main`  

# `مفهوم الـ Static`

ناخد مثال عملي عن كيف تتعامل لغة الـ `Java` مع مفهوم الـ `static`   

<div dir = ltr>

```java
public class Main {
    public String name = "Ahmed";
     
    public static void main(String[] args) {
        System.out.print(name); // Error
    }
}
```
</div>

هنا لدينا متغير يدعى `name` داخل كلاس الـ `Main`  
اذا حاولنا الوصول لهذا المتغير من داخل دالة الـ `main` سيعطينا خطأ   
يقول  

<div dir = ltr>

```
non-static variable name cannot be referenced from a static context
```
</div>

بمعنى ان دالة `main` هي `static` بتالي لا يمكنك ان تستدعي اي متغير `non-static` داخلها بطريقة مباشرة  
والسبب يرجع لان متغير الـ `name` داخل كلاس الـ `Main` فان اردت الوصول له يجب ان تنشيء `object` من هذا الكلاس  

<div dir = ltr>

```java
public class Main {
     public String name = "Ahmed";
    
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.print(obj.name); // Correct, we access name fron object of Main Class
    }
}
```
</div>

هنا لم يحدث اي خطأ لاننا انشأنا `object` من كلاس `Main` واستدعينا المتغير `name` عن طريقه  

الان ماذا سيحدث اذا جعلنا المتغير `name` يكون `static` ؟  
هكذا وعلى حسب مفهوم الـ `static` سيمكننا من استدعاء المتغير دون إنشاء `object` من الكلاس  
وسنستدعيه عن طريق اسم الكلاس فقط  

<div dir = ltr>

```java
public class Main {
     public static String name = "Ahmed";
    
    public static void main(String[] args) {
        System.out.print(Main.name); // Correct, because the "name" variable is a static
    }
}
```
</div>

بهذا الشكل جعنا المتغير `name` يكون `static` ثم استديناه عن طريق كتابة `Main.name`  
استدعيناه عن طريق اسم الكلاس وليس عن طريق `object`  

هنا لدينا شيء جميل بما اننا داخل كلاس الـ `Main` بالفعل فلا حاجة لكتابة اسم الكلاس لاستدعاء الـ `static`  

<div dir = ltr>

```java
public class Main {
     public static String name = "Ahmed";
    
    public static void main(String[] args) {
        System.out.print(name); // Correct, because we are inside the Main Class
    }
}
```
</div>

فطالما نحن داخل الكلاس فلا حاجة لتكرار اسمه  
لكن ان كنا خارج الكلاس فيجب كتابة اسمه ثم المتغير الـ `static`  

# `Singleton Pattern`

احيانًا يوجد بعض الاشياء في مشروعك لا تريد ان يكون لديها اكثر من `object`  

امثلة افتراضية لهذه الحالة  
نريد `object` واحد لقاعدة البيانات `Database`، نحن لدينا قاعدة بيانات واحدة فقط ولا يمكن ان يكون هناك اكثر  
او نريد `object` واحد لكلاس الـ `Manager`، لا يمكن ان يكون لدينا مديران في الشركة  
او نريد `object` واحد لكلاس `Login`, `register`  
اي شيء تفكر فيه تريده ان يكون له `object` وحيد لا غير  

فهذه بحد ذاتها مشكلة تريد حلها، تريد ان تصمم الكلاس خاصتك بحيث يجب ان يكون لديه `object` واحد فقط  

هنا ظهر الحل وهو الـ `Singleton Pattern` ليحل لنا هذه المشكلة  
وهو عبارة عن مجموعة من القواعد التى تتبعها وتضيفها للكلاس خاصتك   
لكي يجعل الكلاس يسمح بإنشاء `object` واحد فقط  

دعونا ننشيء كلاس يدعى `Manager`

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

لدينا كلاس الـ `Manager` بالمتغيرات والدوال التى كانت موضحة في جدول الـ `UML`   

هذا الكلاس كتبناه في ملف خارجي لكنه ضمن الـ `Package`  
في الجافا سنتعامل مع البرنامج او المشروع كمجموعة كلاسات تكون في `Package` موحد يضمها  
كل كلاس نكتبه في ملف منفصل   

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

فكلا الكلاسين الـ `Main` والـ `Manager` متواجدين في نفس الـ `Package`  
فهكذا كلايهما يريان بعضهما البعض  


# `قواعد الـ Singleton`  

الان لدينا كلاس الـ `Manager` ونريد ان نجعله يمتلك `object` واحد فقط  
ولا نريده ان نسمع بإنشاء اكثر من `object` واحد  

لذا سنحاول ان نطبق عليه قواعد الـ `Singleton`

وهي كالأتي  

- إنشاء `object` من نفس نوع الكلاس يكون `private` و`static`
- إنشاء `Constructor` وجعله `private`
- إنشاء دالة تكون `public` تقوم دائما بارجاع الـ `object` الذي انشأناه اول مرة داخل الكلاس 


<div dir = ltr align = "center">

|Singleton|
|:-:|
|- <u> singleton </u>: Singleton|
|- Singleton() <br> + <u> getObject() </u> : Singleton|

</div>

هذا كلاس افتراضي يدعى `Singleton` (`مجرد اسم لا اكثر`) طبقناه فيه قواعد الـ `Singleton Pattern`  


<div dir = ltr>

> \- <u> singleton </u>: Singleton
</div>

هنا انشأنا `object` يدعى `singleton` من نوع الكلاس `Singleton` وجعلناه `static` وهو `private` بسبب اشارة الـ `-`  

<div dir = ltr>

> \- Singleton()
</div>

هنا جعلنا الـ `Constructor` يكون `private` لنمنع انشاء اي `object` من الكلاس بشكل دائم  
وان كان لديك اكثر من `constructor` يجب ان تجعلهم `private`  

<div dir = ltr>

> \+ <u> getObject() </u> : Singleton
</div>

هنا ننشيء الدالة التى سترجع لنا نفس الـ `object` الـ `Singleton` في كل مرة نستدعيها  

دعونا نرى مثال عملي على كلاس الـ `Manager` خاصتنا  


<div dir = ltr align = "center">

|Manager|
|:-:|
|- id : int <br> - name : string <br> - <u> manager </u> : Manager|
|- Manager() <br> + <u> getManager() </u> : Manager <br> + setName(string) <br> + getName() : string|

</div>

لقد اضفنا `object` يدعى `manager` من نفس نوع الكلاس `Manager` وهو `private` و`static`  
ثم جعلنا الـ `constructor` يكون `private` هكذا لا يمكننا انشاء اي object من الـ `Manager`  
ثم اخيرا لدينا دالة هي من سترجع لنا كل مرة `object` الذي انشأه اول مرة وهو الـ `manager`  

دعونا نرى ترجمة كل ما قلناه لكلاس الـ `Manager` في الـ `Java`

<div dir = ltr>

```java
public class Manager{
    // Private Variables
    private int id;
    private String name;

    // The Only one Manager Object
    private static Manager manager = null;
        
    // Private Methods
    // Constructor
    private Manager(){}
        
    // Public Methods
    public static Manager getManager(){
        if(manager == null) // chicking if there is no manager
            manager = new Manager(); // create the manager

        return manager; // return that only Manager Object we have
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

هكذا اصبح كلاس الـ `Manager` يمتلك `object` واحد فقط وهو `manager` الذي جعلناه `private` و`static`  
وجعلنا الـ `constructer` يكون `private` ليمنع انشاء اي `object` اخر من كلاس الـ `Manager`  
ثم لدينا اهم دالة هنا وهي `getManager` وهي `static` لكي يستطيع المستخدم استدعائها دون الحاجة لعمل `object` من الكلاس  
(`وبالمناسبة لن يستطيع عمل object على اي حال`)  

وان حاول فعل هذا

<div dir = ltr>

```java
public class Main {
    
    public static void main(String[] args) {
        Manager obj = new Manager(); // Error, because the constructor is private
    }
}
```
</div>

كيف اذًا نحصل على الـ `object` لنتعامل مع الكلاس خاصتنا والدوال التى به ؟  
هنا يأتي دور الدالة المهمة `getManager`  

دعونا نناقش هذه الدالة قليلا  

<div dir = ltr>

```java
private static Manager manager = null;

public static Manager getManager(){
    if(manager == null) // chicking if there is no manager
        manager = new Manager(); // create the manager

    return manager; // return that only Manager Object we have
}
```
</div>

هي حلقة الوصل بينك وبين الكلاس، هي من تعطيك نفس الـ `object` الوحيد الذي انشأناه  
وهي دالة بسيطة جدا، تقول ان كات الـ `object` الذي انشأناه يساوي `null` معنى هذا انها المرة الاولى التي يتم استدعاء الدالة  
فأنشيء له `object` جديد، ثم ارجع له الـ `object`، ففي كل مرة يستدعي الدالة ستعطيه نفس الـ `object`  


<div dir = ltr>

```java
public class Main {
    
    public static void main(String[] args) {
        Manager obj = Manager.getManager(); // Correct, we use the name of Manager Class to get getManager()
    
        obj.setName("Ahmed");
        System.out.println(obj.getName()); // Output: Ahmed
    }
}
```
</div>

لاحظ اننا استخدمنا اسم الكلاس `Manager` لاستدعاء دالة الـ `getManager` لانها `static`

يمكننا ان نختصر الدالة في سطر واحد هكذا  

<div dir = ltr>

```java
private static final Manager manager = new Manager();

public static Manager getManager(){
    return manager; // return that only Manager Object we have
}
```
</div>

كلمة `final` تعني ان اول قيمة سيتلقاها المتغير او الـ `object` ستكون ثابتة ولن يستطيع ان تغيرها شبيهه بالـ `const`

هنا ينتعي درسنا عن الـ `Singleton`  
الـ `Singleton Pattern` قد يختلف في الشكل والاسلوب عن ما كتبناه لكن تظل قواعده ومفاهيمه ثابتة

</div> 