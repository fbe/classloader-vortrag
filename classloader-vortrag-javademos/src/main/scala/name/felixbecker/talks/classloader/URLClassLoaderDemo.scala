package name.felixbecker.talks.classloader

import java.net.{URL, URLClassLoader}

object URLClassLoaderDemo extends App {
  /* Dir when ending with /, otherwise jar! */

  val simpleAppURL = new URL("file:///home/becker/kaufhof/git/classloader-vortrag/classloader-vortrag-javademos/simple-app-manually-compiled/")
  val ownURLClassLoader = new URLClassLoader(Array[URL](simpleAppURL))

  println(ownURLClassLoader.getParent)

  val simpleAppClass = ownURLClassLoader.loadClass("name.felixbecker.SimpleApp")
  val simpleAppInstance = simpleAppClass.newInstance

  simpleAppClass.getDeclaredMethod("greet", classOf[String]).invoke(simpleAppInstance, "Felix")
}
