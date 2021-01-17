package algorithm;

public class PrimeNumber {

    public static void main (String args[]){
        int p = 12;
        boolean isPrime = true;
        for(int i = 2 ; i < p ; i++ ){
            if(p%i==0)
                isPrime = false;
        }

        System.out.println(isPrime);
    }
}
