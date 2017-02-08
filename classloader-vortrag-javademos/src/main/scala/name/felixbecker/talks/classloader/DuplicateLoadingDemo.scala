package name.felixbecker.talks.classloader

import java.nio.file.{Files, Paths}

class SimpleDefiningClassLoader extends ClassLoader {
  def defineManually(bytes: Array[Byte]): Class[_] = defineClass(null, bytes, 0, bytes.length)
}

object DuplicateLoadingDemo extends App {

  val cl1 = new SimpleDefiningClassLoader
  val cl2 = new SimpleDefiningClassLoader

  val path = Paths.get("/home/becker/kaufhof/git/classloader-vortrag/classloader-vortrag-javademos/simple-app-manually-compiled/name/felixbecker/SimpleApp.class")
  val data = Files.readAllBytes(path)

  val cl1Clazz = cl1.defineManually(data)
  val cl2Clazz = cl2.defineManually(data)

  val cl1Instance = cl1Clazz.newInstance
  Thread.sleep(1000)
  val cl2Instance = cl2Clazz.newInstance

  val cl1Method = cl1Clazz.getDeclaredMethod("greet", classOf[String])
  val cl2Method = cl2Clazz.getDeclaredMethod("greet", classOf[String])

  cl1Method.invoke(cl1Instance, "felix")
  cl2Method.invoke(cl2Instance, "felix")

  println(cl1Clazz.getCanonicalName + " " + cl1Clazz)
  println(cl2Clazz.getCanonicalName + " " + cl2Clazz)

  println("Class 1 is assignable from class 1: " + cl1Clazz.isAssignableFrom(cl1Clazz))
  println("Class 1 is assignable from class 2: " + cl1Clazz.isAssignableFrom(cl2Clazz))
}
