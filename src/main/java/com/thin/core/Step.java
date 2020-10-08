package com.thin.core;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author: hi@hackfree.cn
 * @Date: 2020/10/4 23:20
 */
@Data
public class Step {

    private List<BaseCommand> commandList = new ArrayList<BaseCommand>();

}
