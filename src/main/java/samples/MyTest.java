package samples;

/**
 * @author fqc
 */
public class MyTest {
    public static int num;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new MyThread(), "thread-" + i).start();
        }
    }
}

class MyThread extends Thread {
    private MyTest obj = new MyTest();

    @Override
    public void run() {
        System.out.println(currentThread().getName() + ":" + (++MyTest.num));

    }
}
/*
* thread-0:1
thread-1:1
thread-2:2
thread-3:3
thread-4:4
thread-5:5
thread-6:6
thread-7:7
thread-8:8
thread-9:9
thread-10:10
thread-11:11
thread-12:12
thread-13:13
thread-14:14
thread-15:15
thread-16:16
thread-17:17
thread-18:18
thread-19:19
thread-20:20
thread-21:21
thread-22:22
thread-23:23
thread-24:24
thread-25:25
thread-26:26
thread-27:27
thread-28:28
thread-29:29
thread-30:30
thread-31:31
thread-32:32
thread-33:33
thread-34:34
thread-35:35
thread-36:36
thread-37:37
thread-38:38
thread-39:39
thread-40:40
thread-41:41
thread-42:42
thread-43:43
thread-44:44
thread-45:45
thread-46:46
thread-47:47
thread-48:48
thread-49:49
thread-50:50
thread-51:51
thread-52:52
thread-53:53
thread-54:54
thread-55:55
thread-56:56
thread-57:57
thread-58:58
thread-59:59
thread-60:60
thread-61:61
thread-62:62
thread-63:63
thread-64:64
thread-65:65
thread-66:66
thread-67:67
thread-68:68
thread-69:69
thread-70:70
thread-71:71
thread-72:72
thread-73:73
thread-74:74
thread-75:75
thread-76:76
thread-77:77
thread-78:78
thread-79:79
thread-80:80
thread-81:81
thread-82:82
thread-83:83
thread-84:84
thread-85:85
thread-86:86
thread-87:87
thread-88:88
thread-89:89
thread-90:90
thread-91:91
thread-92:92
thread-93:93
thread-94:94
thread-95:95
thread-96:96
thread-97:97
thread-98:98
thread-99:99
* */





