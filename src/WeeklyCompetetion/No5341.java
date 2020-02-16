package WeeklyCompetetion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No5341 {
    public static void main(String[] args) {


    }
}


class ProductOfNumbers {


    private List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1);
    }

    public void add(int num) {
        if(num == 0){       //如果增加了一个0，则在计算乘积时前面的数都没用了，所以直接新建一个ArrayList
            products = new ArrayList<>();
            products.add(1);
        } else {
            products.add(products.get(products.size() - 1) * num);  //增加数字时直接相乘，第k位上的数字代表下标从1到k共k个数字的乘积
        }
    }

    public int getProduct(int k) {
        if(products.size() <= k ){  //说明第k个数到siez-1有0，所以直接返回0
            return 0;
        }
        return products.get(products.size() - 1) / products.get(products.size() - 1- k);    //k到size-1的所有数的乘积
    }
}
