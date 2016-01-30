public URL getResource(String name) {

  URL url;

  if (parent != null) {
    url = parent.getResource(name);
  } else {
    url = getBootstrapResource(name);
  }

  if (url == null) {
    url = findResource(name);
  }

  return url;
}
