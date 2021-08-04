package niuke;

import java.util.*;

/**
 * @ProjectName:
 * @ClassName: HJ1
 * @Author: czf
 * @Description: 字符串最后一个单词的长度
 * @Date: 2021/7/6 20:53
 * @Version: 1.0
 **/

public class HJ1 {

    public static void main(String[] args) {

        t3();
    }

    public void t0(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int i = s[s.length - 1].length();
        System.out.println(i);
    }



    public  static void t1(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String tStr= scanner.nextLine();

        char tChar =tStr.length()==0?' ' :tStr.charAt(0);
        int count = 0;
        char[] chars =  str.toCharArray();
        for(int i = 0;i<chars.length;i++){
            if(Character.toUpperCase(chars[i])==Character.toUpperCase(tChar)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void t2(){
        Scanner scanner = new Scanner(System.in);
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        scanner.nextInt();
        while (scanner.hasNext()){
            treeSet.add(scanner.nextInt());
        }
        for(Integer i : treeSet){
            System.out.println(i);
        }
    }

    public static void t3(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        List<String> strs = Arrays.asList(str.split(" ")) ;
        Collections.reverse(strs);
        for(String s :strs){
            System.out.print(s+" ");
        }

    }
}
