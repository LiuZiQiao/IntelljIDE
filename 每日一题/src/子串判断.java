import java.util.*;

public class 子串判断 {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] result = new boolean[p.length];
        for (int i=0;i<p.length;i++){
            if (s.contains(p[i])){
                result[i] = true;
            }else {
                result[i] = false;
            }
        }
        return result;
    }
}

class 成绩排序{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        System.out.println(num);
        String[] str = new String[num];
        Map<String,Integer> map = new TreeMap<>();
        for (int i=0;i<num;i++){
            str[i] = sc.nextLine();
            String[] s = str[i].split(" ");
            map.put(s[0],Integer.valueOf(s[1]));
        }
        System.out.println(map);
    }

}

class person{
    private String name;
    private int gread;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGread() {
        return gread;
    }

    public void setGread(int gread) {
        this.gread = gread;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", gread=" + gread +
                '}';
    }
}
