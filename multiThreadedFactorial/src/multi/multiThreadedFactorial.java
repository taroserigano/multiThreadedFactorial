package multi;

import java.math.BigInteger;
import java.util.Scanner;

public class multiThreadedFactorial {

    public static void main(String args[]) {
        Scanner vinnu = new Scanner(System.in);
        int a;
        Thread t;
        System.out.print("Enter the number  : ");
        long startTime = System.nanoTime();

        a = vinnu.nextInt();
        FirstThread firstThread = new FirstThread(a);               //Creating the first thread 
        SecondThread secondThread = new SecondThread(a);            //Creating the Second thread
        firstThread.start();                                        //Starting the first thread   
        secondThread.start();                                       //Starting the second thread 
        try {
            firstThread.join();
        } catch (InterruptedException ex) {
        }

        try {
            secondThread.join();
        } catch (InterruptedException ex) {
        }

        

        
        long endTime = System.nanoTime();
        System.out.println("Took "+(endTime - startTime) + " ns"); 
        factorial(a);



    }

    static void factorial(int a) {
        int i, j, k;
        k = a;
        j = 1;
        while (a > 0) {
            j = j * a;
            a--;
        }
         
        System.out.println("THREAD MAIN : Factorial of " + k + " = " + j);

    }
}

class FirstThread extends Thread {

    private int a;

    public FirstThread(int a) {
        this.a = a;
    }

    public void run() {
        int i, j, y, x, k;
        k = a;
        y = 0;
        i = 0;
        while (a > 0) {
            i = a % 10;       
            y = (y * 10) + i;    
            a = a / 10;         
        }

       
    }
}

class SecondThread extends Thread {

    int a;

    public SecondThread(int a) {
        this.a = a;
    }

    @Override
    public void run() {
        int i, j, n;
        point:
        for (i = 2; i < a; i++) {
            for (j = 2; j < i; j++) {
                n = i % j;
                if (n == 0) {
                    continue point;
                }

            }
 
        }
    }
}