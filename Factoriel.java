package com.company;

public class Factoriel {

    public static void main(String[] args) {
        int factorielArg = 5;
        //int factorielArg = Integer.parseInt(args[0]);

        System.out.println(factorielRecursif(factorielArg));
        System.out.println(factorielInteratif(factorielArg));
    }

    public static int factorielRecursif(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorielRecursif(n - 1);
        }
    }

    public static int factorielInteratif(int n) {
        int factoriel = 1;

        for (int i = 1 ; i <= n; i++) {
            factoriel = factoriel * i;
        }

        return factoriel;
    }
}
