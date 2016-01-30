package name.felixbecker.talks.classloader.urlclassloading;

import java.net.URL;
import java.net.URLClassLoader;

public class URLClassLoaderDemo {

    public static void main(String... args) throws Exception {

        /* Dir when ending with /, otherwise jar! */
        final URL simpleAppURL = new URL(
            "file:///home/becker/git/classloader-vortrag/classloader-vortrag-javademos/simple-app-manually-compiled/");

        final ClassLoader ownURLClassLoader = new URLClassLoader(new URL[]{simpleAppURL});

        System.out.println(ownURLClassLoader.getParent());

        Class<?> simpleAppClass = ownURLClassLoader.loadClass("name.felixbecker.SimpleApp");
        final Object simpleAppInstance = simpleAppClass.newInstance();
        simpleAppClass.getDeclaredMethod("greet", String.class).invoke(simpleAppInstance, "Felix");
    }

}
