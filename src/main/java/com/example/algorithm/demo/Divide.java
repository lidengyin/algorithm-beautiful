package com.example.algorithm.demo;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 分治算法求最小点距离
 */
public class Divide {

    private static Point[] result;


    private static ArrayList curMinArray = new ArrayList();
    private static List<Points> curMinPoint = new ArrayList<>();
    public static void main(String[] args) {

        //测试用例
        Point[] points  = {new Point(2,3), new Point(10, 1), new Point(3, 25),
                new Point(23,15),new Point(18,3), new Point(8,9),
                new Point(12,30),new Point(25,30),new Point(9,2),
                new Point(13,10), new Point(3,4), new Point(5,6),
                new Point(22,32), new Point(5,32), new Point(23,9),
                new Point(19,25),new Point(14,1), new Point(11,25),
                new Point(26,26),new Point (12,9),new Point(18,9),
                new Point(27,13),new Point(32,13)};
        //预处理排序.按照X轴坐标排序
        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                //大于返回1等于返回0小于返回-1
                return (o1.x>o2.x)?1:(o1.x==o2.x)?0:-1;
            }
        });
        //得到两最近距离的最小值
        System.out.println(divide(0,points.length-1,points));

    }

    /**
     * 求二维空间相同块距离最近两个点
     * @param left
     * @param rigth
     * @param points
     * @return
     */
    public static double divide(int left, int rigth, Point[] points){

        //当前最小距离初始为无穷大
        double curMinDis = 1e20;
        //只有一个点,最小距离无穷大
        if (left == rigth){
            return curMinDis;
        }
        //判断是否只有这两个点.,如果是可以直接求解
        if (left+1==rigth){

            return distance(points[left],points[rigth]);
        }

        //分治法:第一步分区,并取得左右分区最小的两点距离
        //通过右移运算除2,对区域进行合理的划分,使得左右分区最小两点的距离大致保持相同的个数
        int middle = (left+rigth)>>1;
        int middleX = (points[left].x+points[rigth].x)/2;
        double leftMinDis = divide(left,middle,points);
        double rightMinDis = divide(middle,rigth,points);
        curMinDis = (leftMinDis<= rightMinDis)?leftMinDis:rightMinDis;

        //以中线为界,将所有点分成两组放在两个表中
        ArrayList leftArray = new ArrayList();
        ArrayList rightArray = new ArrayList();
        //中线
        //int middleX = (points[0].getX()+points[points.length-1].getX())/2;
        for (int i = 0; i < points.length; i++){
            if (points[i].x<=middleX){
                leftArray.add(points[i]);
            }
            if (points[i].x>middleX){
                rightArray.add(points[i]);
            }
        }
        //将两张表转换为数组类型,并且按照X坐标升绪
        Point[] leftPoint = new Point[leftArray.size()];
        Point[] rightPoint = new Point[rightArray.size()];
        leftArray.toArray(leftPoint);
        rightArray.toArray(rightPoint);
        //在s1,s2中收集距离小于s1的点,分别存放在两个表中

        ArrayList minLeftArray = new ArrayList();
        ArrayList minRightArray = new ArrayList();
        for (int i = 0; i < leftPoint.length; i ++){
            if (middleX-leftPoint[i].getX() < curMinDis){
                minLeftArray.add(leftPoint[i]);
            }

        }
        for (int i = 0; i < rightPoint.length; i ++){
            if (rightPoint[i].getX()-middleX < curMinDis){
               // System.out.println("y:"+rightPoint[i].getY());
                minRightArray.add(rightPoint[i]);
            }
        }
        //将两张表转换为数组类型,并且按照Y坐标升绪
        Point[] minLeftPoint = new Point[minLeftArray.size()];
        Point[] minRightPoint = new Point[minRightArray.size()];
        minLeftArray.toArray(minLeftPoint);
        minRightArray.toArray(minRightPoint);
        System.out.println(curMinDis);
        double tempD = curMinDis;
        for (int i = 0; i < minLeftPoint.length; i ++){
            for (int j = 0; j < minRightPoint.length; j ++){

                if (Math.abs(minLeftPoint[i].getY()-minRightPoint[j].getY()) < curMinDis){
                    double temp = distance(minLeftPoint[i], minRightPoint[j]);
                    if (temp<tempD){
                        tempD= temp;
                        Point[]pp = new Point[2];
                        pp[0] = minLeftPoint[i];
                        pp[1] = minRightPoint[j];
                        result =pp;
                    }
                }
            }
        }

        return (curMinDis>=tempD)?tempD:curMinDis;
    }

    /**
     * 计算两个点之间的距离
     * @param p1
     * @param p2
     * @return
     */
    public static double distance(Point p1, Point p2){
        return Math.sqrt(Math.pow(Math.abs(p2.y-p1.y),2)+Math.pow(Math.abs(p2.x-p1.x),2));
    }
    public static void showPoint(List<Points> pointsList){
        for (Points points :pointsList){
            System.out.println("("+points.getX().getX()+","+points.getX().getY()+")("+points.getY().getX()+","+points.getY().getY()+")");
        }
    }

}
class Points{
    private Point x;
    private Point y;

    public Points(Point x, Point y) {
        this.x = x;
        this.y = y;
    }

    public Point getX() {
        return x;
    }

    public void setX(Point x) {
        this.x = x;
    }

    public Point getY() {
        return y;
    }

    public void setY(Point y) {        
        this.y = y;
    }

    
}
//二维点对象
class Point{
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}