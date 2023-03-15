import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //test 1
        int[] nums = {1, 1, 2, 3, 4, 4, 12, 2, 3 };
        int single = singleNumber(nums);
        System.out.println(single);

        //test 2
        System.out.println(minSplit(9));

        //test 3
        System.out.println(notContains(nums));

        //test 4
        String sum = add("1010", "1011");
        System.out.println(sum);

        //test 5
        System.out.println(countVariants(5));

        //test 6
        MyDataStructure<Integer> myDataStructure = new MyDataStructure<>();
        myDataStructure.add(2);
        myDataStructure.add(3);
        myDataStructure.add(4);
        myDataStructure.add(5);
        myDataStructure.add(6);
        myDataStructure.add(7);
        //System.out.println(myDataStructure.size());
        MyDataStructure.Element tuple = myDataStructure.headElement;
        for (int i = 0; i < myDataStructure.size() - 1; i++) {
            tuple = tuple.next;
            System.out.println(tuple.getObj());
        }
        myDataStructure.deleteLast();
        MyDataStructure.Element tuple1 = myDataStructure.headElement;
        for (int i = 0; i < myDataStructure.size() - 1; i++) {
            tuple1 = tuple1.next;
            System.out.println(tuple1.getObj());
        }

        myDataStructure.deleteLast();
        MyDataStructure.Element tuple2 = myDataStructure.headElement;
        for (int i = 0; i < myDataStructure.size() - 1; i++) {
            tuple2 = tuple2.next;
            System.out.println(tuple2.getObj());
        }

    }
    // 1
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    // 2
    public static int minSplit(int amount) {
        int[] monets = new int[]{1, 5, 10, 20, 50};
        int res = 0;

        for (int i = 4; i >= 0; i--) {
            if (amount >= monets[i]) {
                res += amount / monets[i];
                amount %= monets[i];
            }
        }
        return res;
    }

    // 3
    public static int notContains(int[] array) {
        Arrays.sort(array);
        int min = 1;

        for (int j : array) {
            if (j == min)
                min++;
        }
        return min;
    }

    // 4
    public static String add(String a, String b) {
        int n1 = Integer.parseInt(a, 2);
        int n2 = Integer.parseInt(b, 2);
        int sum = n1 + n2;
        return Integer.toBinaryString(sum);
    }

    // 5
    public static int countVariants(int stearsCount) {
        if(stearsCount == 1) return 1;
        int[] d = new int[stearsCount + 1];
        d[1] = 1;
        d[2] = 2;

        for (int k = 3; k <= stearsCount; k++)
            d[k] = d[k - 1] + d[k - 2];

        return d[stearsCount];
    }
}
