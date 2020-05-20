package org.fenixsoft.jvm.chapter2;

import java.util.HashSet;
import java.util.Set;

/**
 * 2.4.3 方法区和运行时常量池溢出
 *
 * VM Args：-XX:PermSize=6M -XX:MaxPermSize=6M
 *
 * @author zzm
 */
public class RuntimeConstantPoolOOM_1 {

    public static void main(String[] args) {
        // 使用 Set 保持着常量池引用，避免 Full GC 回收常量池行为
        Set<String> set = new HashSet<String>();
        // 在 short 范围内足以让 6MB 的 PermSize 产生 OOM
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }
}
