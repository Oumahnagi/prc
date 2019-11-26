package com.company;
import java.io.*;
import parcs.*;
import parcs.AM;
import parcs.AMInfo;
import parcs.channel;
import parcs.point;
import parcs.task;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class RhoPollardP implements AM {

    public static void main(String[] args) {
        task curtask = new task();
        curtask.addJarFile("RhoPollardP.jar");
        (new RhoPollardP()).run(new AMInfo(curtask, (channel)null));
        curtask.end();
    }

    public void run(AMInfo info) {
        BigInteger n;
        System.out.print("Enter n: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextBigInteger();

        point p1 = info.createPoint();
        channel c1 = p1.createChannel();
        p1.execute("RhoPollard");
        c1.write(n.toString());

        System.out.println("Waiting for result...");
        ArrayList<BigInteger> r = ArrayList<BigInteger>(c1.readLong());
        System.out.println("Result found.");

        System.out.println(Arrays.toString(r));
    }
}
