package basic.Chapter9;

public class MyStringBuffer implements IStringbuffer {
    int capacity = 19;
    int length = 0;
    char[] value;
    public MyStringBuffer() {
        value = new char[capacity];
    }

    public MyStringBuffer(String str) {
        this();
        if (str == null) return;

//            value = str.toCharArray();
//            length = value.length;


            if (capacity < str.length()) {
                capacity = value.length * 2;
                value = new char[capacity];

            }


            System.arraycopy(str.toCharArray(), 0, value, 0, str.length());
            length = str.length();

//        value = new char[capacity];
    }

    @Override
    public void insert(int pos, char c) {
        String input = String.valueOf(c);
        insert(pos, input);

    }

    @Override
    public void insert(int pos, String b) {
        // justify the bounds
        if (pos < 0) return;
        if (pos > length) return;
        if (b == null) return;

        // expand
        while (length + b.length() > capacity) {
            capacity = (int) ((length + b.length()) * 1.5);
            char[] newValue = new char[capacity];
            System.arraycopy(value, 0, newValue, 0, length);
            value = newValue;
        }


        char[] cs = b.toCharArray();

        System.arraycopy(value, pos, value, pos+b.length(), length-pos);
        System.arraycopy(cs, 0, value, pos, cs.length);
        length += cs.length;
//        while(length+b.length()>capacity){
//            capacity = (int) ((length+b.length())*1.5f);
//            char[] newValue = new char[capacity];
//            System.arraycopy(value, 0, newValue, 0, length);
//            value = newValue;
//        }
//
//        char[] cs = b.toCharArray();
//
//        //先把已经存在的数据往后移
//
//        System.arraycopy(value, pos, value,pos+ cs.length, length-pos);
//        //把要插入的数据插入到指定位置
//        System.arraycopy(cs, 0, value, pos, cs.length);
//
//        length = length+cs.length;


    }

    @Override
    public void delete(int start) {
        delete(start, length);

    }

    @Override
    public void delete(int start, int end) {
        if (start < 0 || end < 0) return;
        if (start >= length  || end <= start) return;
        if (end > length) return;

//        char[] newValue = new char[length - (start - end + 1)];
//        System.arraycopy(value, 0, newValue, 0, start +1 );
//        if (end < length) {
//            System.arraycopy(value, end, newValue, start+1, length-end);
//        }
        System.arraycopy(value, end, value, start, length - end);
        length -= end - start;

    }

    @Override
    public void reverse() {
        for (int i = 0; i < length / 2; i++) {
            char tmp = value[i];
            value[i] = value[length-1-i];
            value[length-i-1] = tmp;
        }
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public void append(char c) {
        insert(length, c);

    }

    @Override
    public void append(String str) {
        insert(length, str);
    }


    public String toString() {
        char[] realValue = new char[length];
        System.arraycopy(value, 0, realValue, 0, length);
        return new String(realValue);
    }

    public static void main(String[] args) {
        MyStringBuffer sb = new MyStringBuffer("there light");
        System.out.println(sb);
        sb.insert(0, "let ");
        System.out.println(sb);
        sb.insert(10, "be ");
        sb.insert(0, "God Say:");
        System.out.println(sb);
        sb.append("!");
        System.out.println(sb);
        sb.append('?');
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        sb.delete(0, 4);
        System.out.println(sb);
        sb.delete(4);
        System.out.println(sb);
    }
}
