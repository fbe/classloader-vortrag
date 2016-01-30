package name.felixbecker.talks.classloader;

public class Main {

    public static void main(String[] args) throws Exception {
        SyntheticClassLoader cl = new SyntheticClassLoader();

        // class definition geht nur 1x, sonst error (LinkageError)
        final Class<?> syntheticGreeterClass = cl.createSyntheticGreeterClass();
        syntheticGreeterClass.newInstance();

        // Define class true
        /*Class<?> greeterClass = cl.loadClass("name.felixbecker.talks.classloader.GreeterClass");
        Object i1 = greeterClass.newInstance();
        Object i2 = greeterClass.newInstance();
        */


        //Main.class.getClassLoader().getResourceAsStream("")




    }
}
