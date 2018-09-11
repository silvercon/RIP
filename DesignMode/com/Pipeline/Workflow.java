package com.Pipeline;

import java.util.HashMap;
import java.util.Map;

/**
 * 稳定性方案工作流
 * @author: silver 
 * @since: 2018年9月6日 下午12:30:58 
 * @history:
 */
public enum Workflow {

    Draft("0", "起草方案"), Approve1("1", "审核方案"), Approve2("2", "审批方案"), Done("4",
            "方案通过");

    String code;

    String status;

    public static Map<String, Workflow> getWorkflowMap() {
        Map<String, Workflow> map = new HashMap<String, Workflow>();
        for (Workflow workflow : Workflow.values()) {
            map.put(workflow.getCode(), workflow);
        }
        return map;
    }

    public static Workflow geWorkfolwtStatus(String code) {
        Map<String, Workflow> map = getWorkflowMap();
        Workflow workflow = map.get(code);
        return workflow;
    }

    private Workflow(String code, String status) {
        this.code = code;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

}
