package com.thin.utils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author: hi@hackfree.cn
 * @Date: 2020/10/4 23:19
 */
public class PackageUtils {

    public static ClassLoader CLASS_LOADER = Thread.currentThread().getContextClassLoader();

    public static List<Class> getClassList(String packageName, Predicate<Class> filter) {
        List<Class> classList = new ArrayList();
        List<String> classNameList = getClassNameList(packageName);
        if (CollectionUtils.isNotEmpty(classNameList)) {
            classNameList.forEach(className -> {
                try {
                    Class<?> clazz = Class.forName(className);
                    if (filter.test(clazz)) {
                        classList.add(clazz);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        }
        return classList;
    }

    public static List<String> getClassNameList(String packageName) {
        List<String> classNameList = new ArrayList<>();
        String targetPath = packageName.replaceAll("\\.", "/");
        URL url = CLASS_LOADER.getResource(targetPath);
        File dir = new File(url.getFile());
        for (File file : dir.listFiles()) {
            String path = packageName + "." + file.getName();
            if (file.isDirectory()) {
                classNameList.addAll(getClassNameList(path));
            } else {
                if (file.getName().endsWith(".class")) {
                    // 包名为空时前面多出一个点要去掉
                    path = path.replaceAll("^\\.", "");
                    classNameList.add(path.replace(".class", ""));
                }
            }
        }
        return classNameList;
    }
}
