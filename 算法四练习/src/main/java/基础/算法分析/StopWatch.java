package 基础.算法分析;

/**
 * 一种表示计数器的抽象数据类型
 */
public class StopWatch {
    private final long start;
    public StopWatch(){
        start = System.currentTimeMillis();
    }
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now -start)/1000.0;
    }
}
