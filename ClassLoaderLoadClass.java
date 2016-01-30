protected Class<?> loadClass(String name, boolean resolve) 
  throws ClassNotFoundException {

  synchronized (getClassLoadingLock(name)) {

    Class<?> c = findLoadedClass(name);
  
    if (c == null) {
      try {
        if (parent != null){
          c = parent.loadClass(name, false);
        } else {
          c = findBootstrapClassOrNull(name);
        }
      } catch (ClassNotFoundException e) {}
  
      if (c == null){  c = findClass(name); }
    }
  
    if (resolve){ resolveClass(c); }
  
    return c;
  }
}
