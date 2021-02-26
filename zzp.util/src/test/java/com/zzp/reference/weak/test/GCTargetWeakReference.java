package com.zzp.reference.weak.test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Description GCTargetWeakReference
 * @Author karyzeng
 * @since 2021.02.25
 **/
public class GCTargetWeakReference extends WeakReference<GCTarget> {

    private String id;

    public GCTargetWeakReference(GCTarget referent, ReferenceQueue<? super GCTarget> q) {
        super(referent, q);
        this.id = referent.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("GC回收GCTargetWeakReference对象，id为：" + this.id);
    }
}
