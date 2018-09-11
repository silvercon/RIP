package com.Pipeline;

/**
 * 稳定性样品
 * @author: silver 
 * @since: 2018年9月6日 下午12:32:38 
 * @history:
 */
public class Stab {

    String status;

    public Stab() {
        super();
        this.status = Workflow.Draft.getStatus();
    }

    public String getStatus() {
        return this.status;
    }
}
