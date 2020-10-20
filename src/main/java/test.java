public class test {

    //计算硬币总重量
    int sum_coin(int coin[], int m, int n) {
        int result = 0;
        if (m > n)
            return 0;
        for (int i = m; i <= n; i++) {
            result += coin[i];
        }

        return result;
    }

    ;


    //找出假币   m , n 数组下标,coin 硬币数组，relCoin 真币数组长度
    int check_coin(int coin[], int m, int n, int relCoin,int count) {
        count++;
        int vary = n - m + 1;

        int restCoin = vary % 3;
        int vary2 = vary - restCoin;

        if (vary == 1) {
            System.out.println("count="+count);
            return m;
        }

        if (vary == 2) {
            if (sum_coin(coin, m, m) == sum_coin(coin, relCoin, relCoin)) {
                System.out.println("count="+count);
                return n;
            }
            else {
                System.out.println("count="+count);
                return m;
            }

        }


        if (sum_coin(coin, m, m + vary2 / 3 - 1) == sum_coin(coin, m + vary2 / 3, m + (vary2 / 3) * 2 - 1))//第一堆 == 第二堆
        {
            if ((sum_coin(coin, m, m + vary2 / 3 - 1) == sum_coin(coin, m + (vary2 / 3) * 2, m + vary2 - 1)))//第一堆 == 第三堆
                relCoin = check_coin(coin, n - restCoin + 1, n, relCoin,count);
            else//第一堆 ！= 第三堆
                relCoin = check_coin(coin, m + (vary2 / 3) * 2, m + vary2 - 1, relCoin,count);
        } else//第一堆 ！= 第二堆
        {
            if (sum_coin(coin, m, m + vary2 / 3 - 1) == sum_coin(coin, m + (vary2 / 3) * 2, m + vary2 - 1))//第一堆 == 第三堆
                relCoin = check_coin(coin, m + vary2 / 3, m + (vary2 / 3) * 2 - 1, relCoin,count);
            else//第一堆 ！= 第三堆
                relCoin = check_coin(coin, m, m + vary2 / 3 - 1, relCoin,count);
        }
        return relCoin;
    }


    //返回真币数组下标
    int getRelCoin(int coin[], int m, int n) {
        if (n - m + 1 <= 2) {
            System.out.println("硬币数小于3枚！！！无解");
            return -1;
        } else {
            if (coin[0] == coin[1]) {
                return 0;
            } else {
                if (coin[0] == coin[2])
                    return 2;
                else {
                    return 1;
                }
            }
        }

    }

    int[] produceCoins( int n)//n 是硬币个数
    {
        int[] coins=new int[n];
        int i;


        int a = (int)(Math.random() * 10 + 1);//在1~11之间随机产生真币的重量

        //先把所有硬币的重量都赋值为真币的质量
        for(i = 0; i < n; i++)
        {
            coins[i] = a;
        }

        int b;//假币的重量
        do
        {
            b = (int)(Math.random() * 20 + 1);//在1~21之间随机产生假币的重量
        } while(b == a);//假币的重量不能和真币的重量相同
        System.out.println(b);

        int c = (int)(Math.random() * n);//随机产生假币的坐标
        System.out.println("假币的索引："+c);
        coins[c] = b;//把假币添加进去
        return coins;
    }

    public static void main(String[] args) {
        test my=new test();
        int[] coins=my.produceCoins(70);
        for (int i=0;i<coins.length;i++){
            System.out.print(coins[i]+"  ");
        }
        System.out.println();
        int index=my.check_coin(coins,0,coins.length-1,0,0);
        System.out.println(index);
        for (int i=0;i<coins.length;i++){
            System.out.print(coins[i]+"  ");
        }
        System.out.println();
    }

}
