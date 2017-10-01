package com.fqc.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class test06 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ArrayList<Integer> list = Arrays.stream(arr).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        Set<Integer> set = list.stream().collect(Collectors.toSet());
        System.out.println(set.contains(33));

        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User("name:" + i));
        }
        Map<String, User> map = users.stream().collect(Collectors.toMap(u -> u.username, u -> u));
        map.forEach((s, user) -> System.out.println(user.username));
    }
}


class User {
    String username;

    public User(String username) {
        this.username = username;
    }
}
