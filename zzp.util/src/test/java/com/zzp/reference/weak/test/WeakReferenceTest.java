package com.zzp.reference.weak.test;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description WeakReferenceTest
 * @Author karyzeng
 * @since 2021.02.25
 **/
public class WeakReferenceTest {

    private static ReferenceQueue<GCTarget> referenceQueue = new ReferenceQueue<GCTarget>();

    public static void main(String[] args) {
        List<GCTargetWeakReference> gcTargetWeakReferences = new ArrayList<GCTargetWeakReference>();

        GCTarget noGcTarget = null;

        for (int i= 0; i < 5; i++) {
            GCTarget gcTarget = new GCTarget(String.valueOf(i));
            GCTargetWeakReference gcTargetWeakReference = new GCTargetWeakReference(gcTarget, referenceQueue);
            gcTargetWeakReferences.add(gcTargetWeakReference);
            System.out.println("创建GCTargetWeakReference对象，id为：" + i);
            if (i == 3) {
                noGcTarget = gcTargetWeakReference.get();
            }
        }

        System.gc();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 检查关联的引用队列是否为空
        Reference<? extends GCTarget> reference;
        while((reference = referenceQueue.poll()) != null) {
            if(reference instanceof GCTargetWeakReference) {
                System.out.println("In queue, id is: " +
                        ((GCTargetWeakReference) (reference)).getId());
            }
        }

    }

}
