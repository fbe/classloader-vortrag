package name.felixbecker.talks.classloader

import com.google.common.io.ByteStreams


class B()

class A {
  var b: B = new B
}

// Run with.. -XX:+PrintJVMWarnings

object ResolveClassDemo extends App {

  val classLoader = new ClassLoader() {

    override def loadClass(name: String, resolve: Boolean): Class[_] = {
      println(s"Loading class $name")

      if(name.startsWith("name.felixbecker")){

        val resourceName = name.replace(".", "/") + ".class"
        println(s"Loading class $name as resource $resourceName")
        val classBytes = ByteStreams.toByteArray(getParent.getResourceAsStream(resourceName))
        val loadedClass = defineClass(name, classBytes, 0, classBytes.length)
        resolveClass(loadedClass)
        loadedClass
      } else {
        getParent.loadClass(name)
      }
    }
  }

  val aClass = classLoader.loadClass("name.felixbecker.talks.classloader.A")
  //aClass.newInstance()

}
