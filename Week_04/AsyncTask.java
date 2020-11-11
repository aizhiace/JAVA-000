package com.czh.geek.homework.multiThread;

/**
 * 思考有多少种方式，在 main 函数启动一个新线程，运行一个方法，拿到这个方法的返回值后，退出主线程？
 *
 * @author Caizh
 * @date 2020/11/11
 */
public class AsyncTask {

    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        // 方法一
//        new Thread(() -> System.out.println(getThreadName())).start();
//        Thread.sleep(1000);

        // 方法二
//        ExecutorService ex = Executors.newSingleThreadExecutor();
//        ex.execute(new Thread(() -> System.out.println(getThreadName())));
//        ex.shutdown();
//        try {
//            // 设置等待时间等待子线程运行完毕
//            if (!ex.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
//                // 等待时间内子线程并未全部运行完毕就直接关闭
//                ex.shutdownNow();
//            }
//        } catch (InterruptedException e) {
//            ex.shutdownNow();
//        }

        // 方法三
//        Thread thread = new Thread(() -> System.out.println(getThreadName()));
//        thread.start();
//        thread.join();

        // 方法四
        new Thread(() -> System.out.println(getThreadName())).start();
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName());
    }

    public static String getThreadName() {
        return Thread.currentThread().getName();
    }

}
