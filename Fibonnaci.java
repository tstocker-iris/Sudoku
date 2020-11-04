package com.company;

import javax.security.auth.callback.Callback;

public class Fibonnaci {

    public static void main(String[] args) {
        int factorielArg = Integer.parseInt(args[0]);
        fibonacci(factorielArg);
    }

    public static int fibonacci(int n) {
        // U0 = U1 = 1

        // Un = Un-1 + Un-2 pour n > 1
        if (n <= 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
