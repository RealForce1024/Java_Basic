package com.fqc.io.decorator_io;

import org.junit.Test;

public class MemberTest {

    @Test
    public void testSave() throws Exception {
        Member[] members = new Member[]{
                new Member("001","fqc",26),
                new Member("002","fqc02",26),
                new Member("003","fqc03",26),
        };
        for (Member member : members) {
            member.save();
        }
    }

    @Test
    public void testReload() throws Exception {
        String account_no = "001";
        Member member = Member.reload(account_no);
        System.out.println(member);
    }
}