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
        if(num == 0){       //���������һ��0�����ڼ���˻�ʱǰ�������û���ˣ�����ֱ���½�һ��ArrayList
            products = new ArrayList<>();
            products.add(1);
        } else {
            products.add(products.get(products.size() - 1) * num);  //��������ʱֱ����ˣ���kλ�ϵ����ִ����±��1��k��k�����ֵĳ˻�
        }
    }

    public int getProduct(int k) {
        if(products.size() <= k ){  //˵����k������siez-1��0������ֱ�ӷ���0
            return 0;
        }
        return products.get(products.size() - 1) / products.get(products.size() - 1- k);    //k��size-1���������ĳ˻�
    }
}
