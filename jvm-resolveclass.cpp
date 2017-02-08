// http://hg.openjdk.java.net/jdk8/jdk8/hotspot/file/tip/src/share/vm/prims/jvm.cpp

// 732 - 735
JVM_ENTRY(void, JVM_ResolveClass(JNIEnv* env, jclass cls))
  JVMWrapper("JVM_ResolveClass");
  if (PrintJVMWarnings) warning("JVM_ResolveClass not implemented");
JVM_END
