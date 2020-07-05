package com.example.algorithm.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * 二十一点
 * 主要是抓取扑克牌数量p+d还是p
 */
public class TwentyOne {
    private static Poker[] cards;
    private int n = 54;

    //生成108张扑克牌,使用现有方法
    //随机生成n张扑克牌
    public static Poker[] generateCards(int n){
        //四种花色
        //String[] suit = {"c","d","h","s"};
        //十三中面值
        String [] ranks = {"2","3","4","5","6","7","8","9","10","11","11","11"};
        Poker[] pokers = new Poker[n];
        for (int i = 0; i < n; i ++){
            //String color = suit[new Random().nextInt(4)];
            String num = ranks[new Random().nextInt(12)];
            pokers[i] = new Poker(num);
            System.out.print("cards["+i+"]:"+pokers[i].getNum()+" ");
            if (i%10==0 && i != 0){
                System.out.println();
            }
        }
        System.out.println();
        return pokers;
    }
    //玩家根据现有轮次抓牌
    //需要注意这个i是剩下的拍数,也就是说剩余拍数是从n开始算起,比如n-6,就代表这一句一共使用了6张牌,
    //按照我们这个庄家配合玩家的思路,第一张牌庄家先拿,那玩家就是n-2,n-4,n-6,海洋保证庄家n-1,n-3,n-5,这样得出玩家(i+3+k),庄家(i+3+p+k)
    public static Poker[] getPlayerCards(Poker[] cards, int i, int p){
        //第一次i=n-4, p=0
        List playArray = new ArrayList();
        Poker[] playerCards;
        //底牌最后拿
        //第一张底牌

        playArray.add(cards[i]);
        //第三张底牌
        playArray.add(cards[i+2]);
        //k代表俺玩家必须选取的数量
        for (int k = 0; k < p; k++){
            playArray.add(cards[i+4+k]);

        }
        playerCards = new Poker[playArray.size()];
        playArray.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (Integer.parseInt(((Poker)o1).getNum()) > Integer.parseInt(((Poker)o2).getNum()))
                        ?1:(((Poker)o1).getNum() == ((Poker)o2).getNum())?0:-1;
            }
        });
        playArray.toArray(playerCards);
        return playerCards;
    }
    //庄家根据现有轮次抓拍
   public static Poker[] getDealerCards(Poker[] cards, int i ,int p, int d){
        List dealerArray = new ArrayList();
        Poker[] dealerCards;
        //底牌最后拿
       dealerArray.add(cards[i+1]);
       dealerArray.add(cards[i+3]);
       //d表示庄家必须拿到的的数量
       for (int k = 0; k < d; k ++){
           dealerArray.add(cards[i+4+k+p]);
       }
       dealerCards = new Poker[dealerArray.size()];
       dealerArray.sort(new Comparator() {
           @Override
           public int compare(Object o1, Object o2) {
               return (Integer.parseInt(((Poker)o1).getNum()) > Integer.parseInt(((Poker)o2).getNum()))
                       ?1:(((Poker)o1).getNum() == ((Poker)o2).getNum())?0:-1;
           }
       });
       dealerArray.toArray(dealerCards);
       return dealerCards;
   }

   //获取每一轮最大积分
    public int blackJack(int i, int[] bjTables){
        //底牌不足四张
        if (n-i<4){
            return 0;
        }
        List<Integer> opArray = new ArrayList();
        Integer options[];
        Poker[] playerCards;

        //玩家尝试抓取各种数量牌
        int player = 0;
        //玩家可以选择出牌数量(4-3=1)
        for (int p = 0; p < n-i-3; p ++){
            //获取玩家出牌
            playerCards = getPlayerCards(cards,i,p);
            player +=Integer.parseInt(playerCards[playerCards.length-1].getNum());
            if (player > 21){
                opArray.add(-1+bjTables[i+4+p]);
                break;
            }
            int dealer = 0;
            Poker[] dealerCards;
            int d = 0;
            //除去四张底牌,现有拍数,去除玩家使用后,剩余拍数
            for (d = 0; d < n-i-p-3; d ++ ){

                dealerCards = getDealerCards(cards,i,p,d);
                dealer+=Integer.parseInt(dealerCards[dealerCards.length-1].getNum());
                if (dealer >= 17){

                    break;
                }
            }
            if (dealer > 21){
                dealer=0;
            }
            //System.out.println((i+4+p+d));
            opArray.add(cmp(player,dealer)+bjTables[i+4+p+d]);

        }
        options = new Integer[opArray.size()];
        opArray.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1>o2)?1:(o1==o2)?0:-1;
            }
        });
        opArray.toArray(options);
        return options[options.length-1];



    }
    //每一步最大的优势
    public int [] iterative(Poker[] cards){
        n = cards.length;
        //System.out.println("n:"+n);
        int [] bjTable = new int[cards.length*2];
        for (int i = n-1; i>=0; i --){
            bjTable[i] = blackJack(i,bjTable);
        }
        for (int i = 0; i < n; i ++){
            System.out.print(i+":"+bjTable[i]+" ");
            if (i%10==0 && i != 0){
                System.out.println();
            }
        }
        return bjTable;
    }

    //如果是用户选择后爆开->一共消耗4+p,此时玩家消耗2+p,
    public static void main(String[] args) {
        TwentyOne to = new TwentyOne();
        cards = generateCards(108);
        to.iterative(cards);
    }
    private int cmp(int player, int dealer){
        if (player > dealer){
            return 1;
        }else if (player ==dealer){
            return 0;
        }else{
            return -1;
        }
    }
}

