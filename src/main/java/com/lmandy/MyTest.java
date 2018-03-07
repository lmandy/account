package com.lmandy;


/**
 * Created by liming<liming@1rock.net> on 2017/8/14.
 */
public class MyTest {
    /**
     * 阶乘
     * @param n
     * @return
     */
    public static int f(int n) {

        if (1 == n)
            return 1;
        else
            return n*(n-1);
    }

    /**
     * 判读质数
     * @param num
     */
    public static void prime(int num){
        if(num<2){
            System.out.println("不是质数");
        }else {
            for (int i=2;i<=Math.sqrt(num);i++){
                System.out.println(Math.sqrt(num));
                if(num%i==0){
                    System.out.println("不是质数");
                }else {
                    System.out.println("这是一个质数");
                }
            }
        }
    }

    public static void main(String[] args) {
        prime(5);
    }
}
