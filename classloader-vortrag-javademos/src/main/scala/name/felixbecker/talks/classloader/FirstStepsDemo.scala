package name.felixbecker.talks.classloader

import name.felixbecker.talks.classloader.util.ClassLoaderUtil


object FirstStepsDemo extends App {

  val greeterClass: Class[_] = FirstStepsDemo.getClass
    .getClassLoader.loadClass("name.felixbecker.talks.classloader.GreeterClass")

  // First approach to initialize a class - creating a new instance
  greeterClass.newInstance()

  // Second approach to initialize
  Class.forName("name.felixbecker.talks.classloader.GreeterClass")

  ClassLoaderUtil.printClassLoaderHierachy(FirstStepsDemo.getClass.getClassLoader)


}