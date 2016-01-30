// Removed SecurityManager Stuff
protected Class<?> findClass(final String name) throws ClassNotFoundException {
  String path = name.replace('.', '/').concat(".class");
  Resource res = ucp.getResource(path, false);
  if (res != null) {
    try {
      return defineClass(name, res);
    } catch (IOException e) {
      throw new ClassNotFoundException(name, e);
    }
  } else {
    throw new ClassNotFoundException(name);
  }
}
