package com.nowcoder.community;


import com.nowcoder.community.util.MailClient;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class MailTest {
    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;
    // 直接发送文字信息
    @Test
    public void testTextMail() {
        mailClient.sendMail("2868786774@qq.com", "TEST", "Welcome！");
    }

    // 发送动态网页
    @Test
    public void testHtmlMail() {
        Context context = new Context();
        context.setVariable("username", "廖佳婷");

        String content = templateEngine.process("/mail/demo", context);
        System.out.println(context);

        mailClient.sendMail("2518671184@qq.com", "HTML", content);
    }

    @Test
    public void listToArray(){
        List<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(123);

        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
    }


}
