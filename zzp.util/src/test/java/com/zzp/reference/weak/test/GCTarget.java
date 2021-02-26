package com.zzp.reference.weak.test;

/**
 * @Description GCTarget
 * @Author karyzeng
 * @since 2021.02.25
 **/
public class GCTarget {

    private String id;

    public GCTarget() {}

    public GCTarget(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("GC回收GCTarget对象，id为：" + this.id);
    }
}
