package com.thin.core;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 工作流顶层接口
 * @author: hi@hackfree.cn
 * @Date: 2020/10/4 9:58
 */
@Data
public class Workflow {

    private List<Step> stepList = new ArrayList<Step>();

}
