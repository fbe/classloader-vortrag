package name.felixbecker.talks.classloader.duplicatedloading;

public class SimpleDefiningClassLoader extends ClassLoader {

    Class<?> defineManually(byte[] bytes){
        return defineClass(null, bytes, 0, bytes.length);
    }

}
