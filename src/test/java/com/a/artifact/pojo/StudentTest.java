package com.a.artifact.pojo;


import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-09-15 19:45
 */
class StudentTest {
    public static void main(){

    }
    @Test
    public void test1(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable1 callable1 = new Callable1();
        Future<Integer> result = executorService.submit(callable1);
        executorService.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }



    class Callable1 implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在进行计算");
            Thread.sleep(9000);
           int sum = 0;
            for(int i=0;i<100;i++)
                sum += i;
            return new Integer(sum);
        }
    }

    @Test
    public void test2(){
        //第一种方式
//        ExecutorService executor = Executors.newCachedThreadPool();
//        Task task = new Task();
//        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
//        executor.submit(futureTask);
//        executor.shutdown();

        //第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
        //如果为了可取消性而使用 Future 但又不提供可用的结果，则可以声明 Future<?> 形式类型、并返回 null 作为底层任务的结果。
		Callable1 callableTask = new Callable1();
		FutureTask<Integer> futureTask = new FutureTask<Integer>(callableTask);
		Thread thread = new Thread(futureTask);
		thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+futureTask.get());//
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }

    @Test
    public void testInteger(){
        Integer a = new Integer(3);
        Integer b = 3;  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b); // false 两个引用没有引用同一对象
        System.out.println(a == c); // true a自动拆箱成int类型再和c比较
        System.out.println(b == c); // true
        Integer d=3;
        System.out.println(b == d);

/**
 * 如果整型字面量的值在-128到127之间，那么自动装箱时不会new新的Integer对象，
 * 而是直接引用常量池中的Integer对象，超过范围 a1==b1的结果是false
 */
        Integer a1 = 128;
        Integer b1 = 128;
        System.out.println(a1 == b1); // false

        Integer a2 = 127;
        Integer b2 = 127;
        System.out.println(a2 == b2); // true
    }
}
