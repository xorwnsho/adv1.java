package thread.start.test;

import static thread.util.MyLogger.log;

public class StartTest4Main {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new PrintWords("A", 1000), "Thread-A");
        Thread thread2 = new Thread(new PrintWords("B", 500), "Thread-B");

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



