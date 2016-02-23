/**
 * Created by bpant on 23/12/15.
 */
public class test {
    public static void main(String[] args) {
        System.out.println(incrementString("aaa".toCharArray())); // Prints aab

        System.out.println(next("abcdzz")); // Prints abceaa

        System.out.println(next("zzz")); // Prints aaaa
    }

    public static String next(String s) {
        int length = s.length();
        char c = s.charAt(length - 1);

        if(c == 'z')
            return length > 1 ? next(s.substring(0, length - 1)) + 'a' : "aa";

        return s.substring(0, length - 1) + ++c;
    }

    public static char[]  incrementString(char[] str)
    {
        for(int pos = str.length - 1; pos >= 0; pos--)
        {
            if(Character.toUpperCase(str[pos]) != 'Z')
            {
                str[pos]++;
                break;
            }
            else
                str[pos] = 'a';
        }
        return str;
    }

}