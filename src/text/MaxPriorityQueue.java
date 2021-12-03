package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-12-03 17:09
 **/
public class MaxPriorityQueue {
    /**
     * 建立一个优先队列，来实现有优先级，（其实就是输入无序，输出有序（从小到大就是最小堆，从大到小就是最大堆））
     * 使用堆的思想，但是实际数据结构使用数组来进行
     * 插入时需要调整顺序，弹出时也需要调整顺序
     */
    //队列最大数
    private Integer queueCount = 0;
    private Integer queueSize = 10;

    private Integer[] queues = new Integer[queueSize];

    public Boolean insert(Integer num) {
        if (queueCount.equals(queueSize)) {
            System.out.println("队列已满，无法存入");
            return false;
        }
        //将新加入的数据存放在数组末端，然后在进行调整
        queues[queueCount] = num;
        swim(queueCount);
        queueCount++;
        return true;
    }

    //上浮，把当前插入的数放在合适的位置上
    private void swim(Integer index) {
        while (index > 0) {
            if (queues[index] > queues[index / 2]) {
                exchange(index, index / 2);
                index = index / 2;
            } else {
                break;
            }
        }
    }

    public Integer pop() {
        if (queueCount.equals(0)) {
            System.out.println("没有数据了！");
            return null;
        }
        Integer result = queues[0];
        queues[0] = queues[--queueCount];
        queues[queueCount] = null;
        sink();
        return result;
    }

    //下沉，将根节点的数据下沉到合适的位置上
    private void sink() {
        Integer index = 0;
        while ((index * 2 + 1) < queueCount) {
            if (queues[index] < queues[index * 2]) {
                exchange(index, index * 2);
                index = index * 2;
            } else if (queues[index] < queues[index * 2 + 1]) {
                exchange(index, index * 2 + 1);
                index = index * 2 + 1;
            } else {
                break;
            }
        }
    }

    private void exchange(Integer index1, Integer index2) {
        queues[index1] += queues[index2];
        queues[index2] = queues[index1] - queues[index2];
        queues[index1] -= queues[index2];
    }

    public void showResult() {
        for (int i = 0; i < queues.length; i++) {
            System.out.print("queues[" + i + "] = " + queues[i] + '\t');

        }
        System.out.println();
    }

    public void popResult() {
        System.out.println("popResult begin");
        for (int i = 0; queueCount > 0; i++) {
            System.out.print("queues[" + i + "] = " + pop() + '\t');
            showResult();
        }
        System.out.println("\npopResult end");

    }

    public void test() {
        insert(1);
        insert(2);
        insert(5);
        insert(8);
        insert(4);
        insert(3);
        insert(1);
        insert(9);
        showResult();
        popResult();
    }

}
