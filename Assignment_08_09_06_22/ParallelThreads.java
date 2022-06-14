package Assignment_08_09_06_22;

import java.io.*;
import java.util.*;

class T1 implements Runnable {
    String RED = "\033[91m";
    String GREEN = "\033[92m";
    String BLUE = "\033[94m";
    String BLACKBACK = "\u001B[40m";
    @Override
    public void run() {
        for(int i=1;i<=3;i++) System.out.println(RED+BLACKBACK+"Thread_1 : "+i);
    }
}
class T2 extends T1 {
    @Override
    public void run() {
        for(int i=1;i<=3;i++) System.out.println(GREEN+BLACKBACK+"Thread_2 : "+i);
    }
}
class T3 extends T2 {
    @Override
    public void run() {
        for(int i=1;i<=3;i++) System.out.println(BLUE+BLACKBACK+"Thread_2 : "+i);
    }
}
public class ParallelThreads {

    public static void main(String[] args) {
        Thread t1 = new Thread(new T1());
        Thread t2 = new Thread(new T2());
        Thread t3 = new Thread(new T3());
        t1.start();
        t2.start();
        t3.start();
        }
    }

