package name.felixbecker.talks.classloader;

public class ClassLoadingUtil {

    public static void printClassLoaderHierachy(ClassLoader firstClassLoader){

        ClassLoader cl = firstClassLoader;

        do {
            System.out.println("ClassLoader: " + cl.getClass().getCanonicalName());
            cl = cl.getParent();
        } while(cl != null);

    }
}
