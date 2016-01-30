package name.felixbecker.talks.classloader;

public class FirstSteps {

    public static void main(String... args) throws Exception {

        Class<?> greeterClass = FirstSteps.class.getClassLoader().loadClass("name.felixbecker.talks.classloader.GreeterClass");
        greeterClass.newInstance();

        // Oder

        Class.forName("name.felixbecker.talks.classloader.GreeterClass");

        // Spaß mit Classloader hierachien

        ClassLoadingUtil.printClassLoaderHierachy(FirstSteps.class.getClassLoader());

    }

}
