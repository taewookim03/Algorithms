package leetcode;

/**
 * Created by Taewoo Kim on 4/13/2017.
 */
public class complex_number_multiplication {
    public class Solution {
        class Complex{
            int re, im;
            Complex(int re, int im){
                this.re = re;
                this.im = im;
            }
            Complex(String s){
                String[] ss = s.split("\\+");
                this.re = Integer.parseInt(ss[0]);
                this.im = Integer.parseInt(ss[1].substring(0, ss[1].length()-1));
            }
            Complex multiply(Complex other){
                int prod_re = this.re * other.re - this.im * other.im;
                int prod_im = this.re * other.im + this.im * other.re;
                return new Complex(prod_re, prod_im);
            }
            @Override
            public String toString(){
                return this.re + "+" + this.im + "i";
            }
        }
        public String complexNumberMultiply(String a, String b) {
            Complex ca = new Complex(a);
            Complex cb = new Complex(b);
            return ca.multiply(cb).toString();
        }
    }
}
