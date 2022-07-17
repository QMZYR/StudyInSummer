

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<LostProperty> lostArray=new ArrayList<>();
    //失物
    static LostProperty l1 = new LostProperty("202104051621","蓝色水杯");
    static LostProperty l11 = new LostProperty("202104051621","白色耳机");
    static LostProperty l2 = new LostProperty("202004051621","手机");
    static LostProperty l3 = new LostProperty("201004051621","钥匙");
    static LostProperty l4 = new LostProperty("202304051621","笔");
    static LostProperty l5 = new LostProperty("202107051621","工具");
    static LostProperty l6 = new LostProperty("202107051622","鼠标");
    static LostProperty l7 = new LostProperty("202104051621","电脑");
    static LostProperty l8 = new LostProperty("202112061521","手表");
    static LostProperty l9 = new LostProperty("202104061621","书包");
    static  LostProperty l10 = new LostProperty("202103051621","耳机");
    static LostBook book1 = new LostBook("202103051621","书","高等数学");
    static LostCard card1 =new LostCard("202103051621","卡","小明",2021215973);


    public static void main(String[] args) {

        lostArray.add(l1);
        lostArray.add(l11);
        lostArray.add(l2);
        lostArray.add(l3);
        lostArray.add(l4);
        lostArray.add(l5);
        lostArray.add(l6);
        lostArray.add(l7);
        lostArray.add(l8);
        lostArray.add(l9);
        lostArray.add(l10);
        lostArray.add(book1);
        lostArray.add(card1);
        sort(lostArray);
        showArray(lostArray);
//searchByName(lostArray);

keywordsSearch(lostArray);

    }
    public static void sortLost(){


        //比大小
//00冒泡排序

    }

    /**
     * 全名搜索
     * @param list 在此数组中查找
     */
    public static void searchByName(ArrayList<LostProperty> list){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n =0;
        boolean flag = list.get(n).getPropertyName().equals(input);
        while(list.get(n).getPropertyName().equals(input) ==false)
        {
            n++;
            }

        if (list.get(n).getPropertyName().equals(input)){
            System.out.println(list.get(n).toString());
        }
        scanner.close();

    }


    /**
     * 关键词比对搜索
     * @param list 用于搜索的集合
     */
    public static void keywordsSearch(ArrayList<LostProperty> list){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n =0,size=input.length();
        boolean flag = list.get(n).getPropertyName().equals(input);
        while(n<lostArray.size())
        {
            if (keywordsMatch(input,list.get(n).getPropertyName()) ==true){
            System.out.println(list.get(n).toString());
        }
            n++;
        }


        scanner.close();



    }







    /**
     * 比较两个丢失时间先后
     * @param lp1 第一个失物
     * @param lp2 第二个失物
     * @return   后者大于前者 是真，反之为否
      */
    public static boolean compare(LostProperty lp1, LostProperty lp2){
        boolean flag = true;
          int compare=lp1.getLostTime().compareTo(lp2.getLostTime());
        if (compare<0){
            flag=true;
        }else{
            flag=false;
        }
        return flag;
    }


    /**
     * 把相关的失物根据遗失物品的时间从大到小排序
     * @param list 输入的失物的集合，进行排序
     */
    public static void sort(ArrayList<LostProperty> list){
        for(int m=list.size()-1; m >= 0; m--)//7次大排序
        {
            for(int n=m-1; n>=0; n--)//每次单独的小排序
            {
                if (compare(list.get(n),list.get(m)))//前后比较
                {LostProperty temp=list.get(m);
                    list.set(m,list.get(n));
                    list.set(n,temp);//交换
                }
            }
        }

    }

    /**
     * 遍历失物集合，检验顺序
     * @param list 用于遍历的 集合
     */
    private static void showArray(ArrayList<LostProperty> list) {
        for(int n=0;n<list.size();n++){
            System.out.println("   "+list.get(n).getLostTime());
        }
        System.out.println();
    }


    /**
     *关键字比较
     * @param s1 关键字
     * @param s2 比较的字符串
     * @return  是否匹配的
     */
    public static boolean keywordsMatch(String s1,String s2){
        boolean flag= false;
        int s1Len= s1.length();
        for (int n=0;n<s2.length()-s1Len+1;n++){
                 int endIndex = 3*(n+s1Len);
            if(s1.equals(subStrUtf8(s2,n,endIndex))){
                flag=true;
            }
        }
        return flag;
    }


    /**
     * 用于截取含中文的字符串
     * @param str 输入的字符串
     * @param beginIndex 开始的索引值
     * @param endIndex  结束的索引值
     * @return 截取的后的字符串
     */
    public static String subStrUtf8(String str, int beginIndex, int endIndex) {
        String subStr = "";
        try {
            int byteEndIndex = Math.min(str.length(), endIndex);
            int byteLen = 0;
            do {
                // 1.将要截取的子串长度减1
                subStr = str.substring(beginIndex, byteEndIndex--);

                // 2.更新subStr转为UTF-8的byte[]的长度
                byteLen = subStr.getBytes("UTF-8").length;

                // 3.只要byteLen大于最初想要截取的子串的值，则继续循环
            } while (byteLen > endIndex - beginIndex);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return subStr;
    }
}

