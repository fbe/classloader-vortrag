package name.felixbecker.talks.classloader.synthetic;


public class SyntheticLoaderDemo {

    public static void main(String[] args) throws Exception {
        SyntheticClassLoader cl = new SyntheticClassLoader();
        cl.createSyntheticGreeterClass().newInstance();
    }
}
