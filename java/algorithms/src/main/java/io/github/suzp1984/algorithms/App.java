package io.github.suzp1984.algorithms;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Queue<String> queueS = new LinkedBlockingQueue<>();
        queueS.poll();
    }
}
