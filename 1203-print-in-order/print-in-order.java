class Foo {

    private boolean firstPrinted = false;
    private boolean secondPrinted = false;
    private boolean thirdPrinted = false;

    public Foo() {
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstPrinted = true;
        notifyAll();
    }

    public synchronized void second(Runnable printSecond) throws InterruptedException {

        while (!firstPrinted) {
            this.wait();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondPrinted = true;
        notifyAll();
    }

    public synchronized void third(Runnable printThird) throws InterruptedException {

        while (!secondPrinted) {
            this.wait();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        thirdPrinted = true;
        notifyAll();
    }
}