//package com.example.class_loader_learn.classpath;
//
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//public class ClassPath {
//    // 启动类路径
//    private Entry bootstrapClassPath;
//    // 扩展类路径
//    private Entry extensionClassPath;
//    // 用户类路径
//    private Entry userClassPath;
//
//    public ClassPath(String jreOption, String cpOption) {
//        bootstrapAndExtensionClassPath(jreOption);
//        parseUserClassPath(cpOption);
//    }
//
//    private void bootstrapAndExtensionClassPath(String jreOption) {
//        String jreDir = getJreDir(jreOption);
//
//        String jreLibPath = P
//    }
//
//    private static String getJreDir(String jreOption) {
//        if (jreOption != null && Files.exists(Paths.get(jreOption))) {
//            return jreOption;
//        }
//        if (Files.exists(Paths.get("./jre"))) {
//            return "./jre";
//        }
//
//        String jh = System.getenv("JAVA_HOME");
//        if (jh != null) {
//            return Paths.get(jh, "jre").toString();
//        }
//
//        throw new RuntimeException("Can not find JRE folder!");
//
//    }
//
//    private void parseUserClassPath(String cpOption) {
//        if (cpOption == null) {
//            cpOption = ".";
//        }
//        userClassPath = Entry.create(cpOption);
//    }
//
//    public byte[] readClass(String className) throws Exception {
//        className = className + ".class";
//        try {
//            return bootstrapClassPath.readClass(className);
//        } catch (Exception ignored) {
//
//        }
//        try {
//            return extensionClassPath.readClass(className);
//        } catch (Exception ignored) {
//
//        }
//
//        return userClassPath.readClass(className);
//    }
//
//
//}
