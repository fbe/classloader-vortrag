package name.felixbecker.talks.classloader.util

import scala.annotation.tailrec

object ClassLoaderUtil {

  @tailrec
  def printClassLoaderHierachy(loader: ClassLoader): Unit ={
    println(s"ClassLoader: ${loader.getClass.getCanonicalName}")
    val parent = loader.getParent
    if(parent != null) printClassLoaderHierachy(parent)
  }

}
