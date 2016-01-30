package name.felixbecker.talks.classloader.duplicatedloading;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DuplicateLoadingDemo {

    private static final SimpleDefiningClassLoader cl1 = new SimpleDefiningClassLoader();
    private static final SimpleDefiningClassLoader cl2 = new SimpleDefiningClassLoader();

    public static void main(String... args) throws Exception {

        Path path = Paths.get("/home/becker/git/classloader-vortrag/classloader-vortrag-javademos/simple-app-manually-compiled/name/felixbecker/SimpleApp.class");

        byte[] data = Files.readAllBytes(path);

        Class<?> cl1Clazz = cl1.defineManually(data);
        Class<?> cl2Clazz = cl2.defineManually(data);

        Object cl1Instance = cl1Clazz.newInstance();
        Thread.sleep(1000);
        Object cl2Instance = cl2Clazz.newInstance();

        Method cl1Method = cl1Clazz.getDeclaredMethod("greet", String.class);
        Method cl2Method = cl2Clazz.getDeclaredMethod("greet", String.class);

        cl1Method.invoke(cl1Instance, "felix");
        cl2Method.invoke(cl2Instance, "felix");

        System.out.println(cl1Clazz.getCanonicalName() + " " + cl1Clazz);
        System.out.println(cl2Clazz.getCanonicalName() + " " + cl2Clazz);


    }




}
