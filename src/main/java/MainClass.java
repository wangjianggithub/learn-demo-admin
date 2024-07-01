public class MainClass {
    private Object lock1 = new Object();

    private Object lock2 = new Object();

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        mainClass.demo();
    }

    private void demo() {
        Thread ta = new Thread(new DeadA());
        Thread tb = new Thread(new DeadB());
        ta.start();
        tb.start();
    }

    private class DeadA implements Runnable {
        private String id = "A";

        @Override
        public void run() {
            System.out.println(id + " 申请锁1...");
            synchronized (lock1) {
                System.out.println(id + " 获得锁1");

                System.out.println(id + " 申请锁2...");
                synchronized (lock2) {
                    //A得不到锁2，死锁
                    System.out.println(id + "获得锁2");
                }
            }

            System.out.println(id + " 运行结束");
        }
    }

    private class DeadB implements Runnable {
        private String id = "B";

        @Override
        public void run() {
            System.out.println(id + " 申请锁2...");
            synchronized (lock2) {
                System.out.println(id + " 获得锁2");

                System.out.println(id + " 申请锁1...");
                synchronized (lock1) {
                    //B得不到锁1，死锁
                    System.out.println(id + " 获得锁1");
                }
            }

            System.out.println(id + " 运行结束");
        }
    }
}
