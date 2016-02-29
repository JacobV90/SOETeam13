import java.util.ArrayList;

/**
 * Created by sujvdo on 12/12/15.
 */
public class Decryp {

    static long  gcd(long n, long e)
    {
        long lastx = 1;
        long lasty = 0;
        long x = 0;
        long y = 1;
        long temp;

        while (e != 0) {

            long q = n/e;
            long r = n %e;

            n = e;
            e = r;

            temp = x;
            x = lastx - (q * x);
            lastx = temp;

            temp = y;
            y = lasty - (q* y);
            lasty = temp;

        }
        System.out.printf("s = "+lastx +"\nd = "+lasty +"\n");
        return lasty;
    }

    private long numDigits;
    private long e;

    public Decryp(long n, long e){
        this.numDigits = n;
        this.e = e;

    }

    public void setNumDigits(long numDigits) {
        this.numDigits = numDigits;
    }

    public long decrypMessage(long message){

        System.out.printf("C^d mod n = " +modularExp(message, gcd(numDigits,e) ) +"\n");

        return  1;//this.modularExp(message,inverseMult)  % this.numDigits;
    }


    private long modularExp(long message, long d){

        long p = 1;
        long s = message;
        long r = d;

        while(r > 0){

            if(r %2 == 1){
                p = (p*s) % 3053 ;
            }
            s = (s*s) % 3053;
            r = Math.floorDiv(r,2);
        }
        return p;
    }

    public static void main(String[] args) {

        /*int e = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);*/

        long e = 19;
        long n =2940;
        long message = 309;

        //JFrame window = new JFrame();


        Decryp decryp = new Decryp(n,e);
        decryp.decrypMessage(message);
        gcd(n,e);

       // System.out.printf("Message: %d\n", decryp.decrypMessage(message));

    }
}
