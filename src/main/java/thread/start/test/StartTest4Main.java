package thread.start.test;

import static thread.util.MyLogger.log;

public class StartTest4Main {

    public static void main(String[] args) {
        Runnable runnable1 = new PrintWords("A", 1000);
        Runnable runnable2 = new PrintWords("B", 500);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }

    static class PrintWords implements Runnable {
        String word;
        int sleepTime;

        public PrintWords(String word, int sleepTime) {
            this.word = word;
            this.sleepTime = sleepTime;
        }

        @Override
        public void run() {
            while (true) {
                log(word);
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}



