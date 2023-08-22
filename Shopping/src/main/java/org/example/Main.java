package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //要件1 String型のListかMapを作成して、その内容をコンソール画面に表示してみよう。
        //要件2 Listに入れる内容は何でもOKだが、複数入れること。
        ArrayList<String> shoppingBasket = new ArrayList<>();
        shoppingBasket.add("電子レンジ");
        shoppingBasket.add("冷蔵庫");
        shoppingBasket.add("洗濯機");

        //shoppingBasketの要素を順に取り出す　拡張for文
        System.out.println("商品一覧");
        for (String s : shoppingBasket) {
            System.out.println("商品名：" + s);
        }
        System.out.println();

        //shoppingBasketの要素を順に取り出す　イテレータ
        System.out.println("商品一覧");
        Iterator<String> iterator = shoppingBasket.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println("商品名：" + s);
        }
        System.out.println();


        //要件3 任意のプログラムで例外を起こしてみる。
        shoppingBasket.clear();
        try {
            if (shoppingBasket.isEmpty()) {
                throw new BasketNotFoundException("カゴに商品が入っていません。");
            }
        } catch (BasketNotFoundException e) {
            e.printStackTrace();
        }


        //自己学習　LinkedHashMapの使用
        Map<Integer, Product> foods = new LinkedHashMap<>();
        foods.put(1, new Product("焼き魚", 400));
        foods.put(2, new Product("からあげ", 350));
        printFoodsInfo(foods, "食品商品一覧");

        //自己学習　ArrayListの使用
        List<Product> clothes = new ArrayList<>();

        //要素の追加
        clothes.add(new Product("Tシャツ", 2500));
        clothes.add(new Product("パーカー", 6000));
        printClothesInfo(clothes, "初期商品一覧");

        //リストの1番目に要素を挿入する
        clothes.add(1, new Product("ジーンズ", 4000));
        printClothesInfo(clothes, "1番目にジーンズを追加後の商品一覧");

        //リストの2番目の要素を上書きする
        clothes.set(2, new Product("スカート", 4500));
        printClothesInfo(clothes, "2番目の商品をスカートに上書き後の商品一覧");

        //リストの2番目の要素を一部変更する
        clothes.get(2).setPrice(15000);
        printClothesInfo(clothes, "2番目の商品の価格を変更後の商品一覧");

    }

    public static void printClothesInfo(List<Product> products, String header) {
        System.out.println(header);

        for (Product product : products) {
            System.out.println("商品名：" + product.getName() + "、価格：" + String.format("%,d", product.getPrice()) + "円");
        }
        System.out.println();//空行を入れて見やすくする
    }

    public static void printFoodsInfo(Map<Integer, Product> products, String header) {
        System.out.println(header);

        for (Integer key : products.keySet()) {
            Product product = products.get(key);
            System.out.println("ID：" + key + "、商品名：" + product.getName() + "、価格：" + String.format("%,d", product.getPrice()) + "円");
        }
        System.out.println();//空行を入れて見やすくする
    }
}

