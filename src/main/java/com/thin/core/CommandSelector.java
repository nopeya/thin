package com.thin.core;

/**
 * 命令选择器，顶层接口
 * 所有命令选择器需要继承或实现这个接口
 * @author: hi@hackfree.cn
 * @Date: 2020/10/4 9:57
 */
public interface CommandSelector {

    /**
     * 命令查询方法
     * 本接口方法定义如何获取一个命令
     * @author: hi@hackfree.cn
     * @Date: 2020/10/4 10:08
     */
    BaseCommand find(String command);

}
