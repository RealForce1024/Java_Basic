package com.fqc.io.decorator_io;

import java.io.*;

/**
 * com.fqc.io.decorator_io
 *
 * @author fqc
 * @date 16/1/2
 */
public class Member implements Serializable{
    private String account_no;
    private String username;
    private int age;

    public Member() {

    }

    public Member(String account_no, String username, int age) {
        this.account_no = account_no;
        this.username = username;
        this.age = age;
    }

    public String getAccount_no() {
        return account_no;
    }

    //region getter setter
    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //endregion

    @Override
    public String toString() {
        return String.format("%s,%s,%d",this.getAccount_no(),this.getUsername(),this.getAge());
    }

    public void save() throws IOException{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(this.account_no))){
            oos.writeObject(this);
        }
    }

    public static Member reload(String number) throws IOException, ClassNotFoundException{
        Member member;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(number))) {
            member = (Member)ois.readObject();
        }
        return member;
    }
}
