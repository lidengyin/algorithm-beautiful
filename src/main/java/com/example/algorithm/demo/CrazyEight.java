package com.example.algorithm.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class CrazyEight {

    //判断两张扑克是否匹配
    public static boolean isTrick(Poker c1, Poker c2){
        //花色匹配
        if (c1.getColor().equals(c2.getColor())){
            return true;
            //数目匹配
        }else if(c1.getNum().equals(c2.getNum())){
            return true;
            //疯狂的八
        }else if(c1.getNum().equals("8") || c2.getNum().equals("8")){
            return true;
        }else{
            //不匹配
            return false;
        }
    }
    //随机生成n张扑克牌
    public static Poker[] generateCards(int n){
        //四种花色
        String[] suit = {"c","d","h","s"};
        //十三中面值
        String [] ranks = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
        Poker[] pokers = new Poker[n];
        for (int i = 0; i < n; i ++){
            String color = suit[new Random().nextInt(4)];
            String num = ranks[new Random().nextInt(13)];
            pokers[i] = new Poker(color,num);
        }
        return pokers;
    }
    //自底向上求解疯狂的8
    //定义子问题,求解最长匹配子序列
    //猜部分解
    //建立递归关系
    //自底向上实现递归

    public static void crazyEight(Poker[] cards){
        //最长匹配子序列
        int [] trick = new int[10];;
        //最长匹配子序列具体有那几张扑克
        int []parent = new int[10];
        //边界条件
        trick[0] = 1;
        parent[0] = -1;
        for (int i = 0; i < cards.length; i ++){
            //暂时存储连长
            List<Integer> tmpTrick = new ArrayList<>();
            //炼厂转换数组
            Integer[] tmp_trick;
            //最大炼厂对应扑克牌索引
            int indexMax = 0;
            int tmp = 0;
            //从第二章扑克牌记起,因为我们需要第一张扑克牌作为出口也就是临街条件
            if (i > 0){
                //检查两张扑克牌是否匹配
                for (int j = 0; j < i; j ++){
                    if (isTrick(cards[i],cards[j])){
                        tmpTrick.add(trick[j]);
                        if (trick[j] > tmp){
                            tmp = trick[j];
                            //最长链接的索引
                            indexMax=j;
                        }
                        //tmp_trick[j] = trick[j];
                    }else{
                        tmpTrick.add(0);
                        //tmp_trick[j] = 0;
                    }
                }
                //组建长链
                if (isTrick(cards[i],cards[indexMax])){
                    parent[i] = indexMax;
                }else{
                    parent[i] = -1;
                }

                //排序从小到大
                tmpTrick.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if (o1.intValue() > o2.intValue()){
                            return 1;
                        }else if (o1.intValue() == o2.intValue()){
                            return 0;
                        }else {
                            return -1;
                        }
                    }
                });
                //System.out.println("tmpTrick.size()"+tmpTrick.size());
                tmp_trick = new Integer[tmpTrick.size()];
                tmpTrick.toArray(tmp_trick);
                //System.out.println("tmp_trick.length()"+tmp_trick.length);
                //获取最长匹配子序列

                int maxTrick = 0;
                for (int k = 0; k < tmp_trick.length; k ++){
                    if (maxTrick<tmp_trick[k]){
                        maxTrick = tmp_trick[k];
                        System.out.println("maxTrick:"+maxTrick);
                    }
                }
                //获取当前最长连
                trick[i] = 1+maxTrick;
            }

        }
        getLongestSubsequence(cards,trick,parent);


    }
//    private int maxTrick(int [] tricks){
//        for (int i = 0; i < tricks.length; i ++){
//            for (int )
//        }
//    }
    public static void getLongestSubsequence(Poker[] cards, int[] trick, int[] parent){
        System.out.println("随机生成的十张扑克牌");
        for (int i = 0; i < cards.length; i ++){
            System.out.print(cards[i].getNum()+cards[i].getColor()+" ");
        }
        System.out.println("\n随机队列长度");
        for (int i= 0; i< trick.length; i++){
            System.out.print(i+":"+trick[i]+" ");
        }
        Poker[] pokers;
        List<Poker> subsequence = new ArrayList<>();
        int maxTrick = 0;
        int indexMax = -1;
        for (int i = 0; i < trick.length; i++){
            if (trick[i] > maxTrick){
                maxTrick = trick[i];
                indexMax = i;
            }
        }
        while (indexMax != -1){
            System.out.println("\nindexMax:"+indexMax+"card[index]:"+cards[indexMax].getNum()+cards[indexMax].getColor());
          subsequence.add(cards[indexMax]);
          indexMax = parent[indexMax];
        }
        pokers = new Poker[subsequence.size()];
        subsequence.toArray(pokers);
        System.out.println("sizew:"+subsequence.size());
        System.out.println("length:"+pokers.length);
        for (Poker poker : pokers) {
            System.out.print(poker.getColor() + poker.getNum()+" ");
        }
    }

    public static void main(String[] args) {
       crazyEight(generateCards(10));
    }
}
//面向对象,单张扑克牌
class Poker{
    private String color;
    private String num;

    public Poker(String color, String num) {
        this.color = color;
        this.num = num;
    }

    public Poker(String num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
//面向对象,封装返回结果

