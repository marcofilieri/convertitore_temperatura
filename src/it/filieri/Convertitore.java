package it.filieri;

public class Convertitore {
    public static double k_to_f(double k){
        return (k - 273.15) * 9/5 + 32;
    }

    public static double k_to_c(double k){
        return (k - 273.15);
    }

    public static double f_to_k(double f){
        return (f - 32) * 5/9 + 273.15;
    }

    public static double f_to_c(double f){
        return (f - 32) * 5/9;
    }

    public static double c_to_f(double c){
        return (c * 9/5) + 32;
    }

    public static double c_to_k(double c){
        return (c + 273.15);
    }
}
