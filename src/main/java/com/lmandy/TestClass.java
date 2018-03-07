package com.lmandy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.lmandy.bean.AccountUser;
import com.sun.media.sound.SoftTuning;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liming<liming@1rock.net> on 2017/6/19.
 */
public class TestClass{

    public static void main(String[] args) {

//        Map map = new HashMap();
//        map.put("name","张三");
//        List list = new ArrayList();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//
//        AccountUser user = new AccountUser();
//        user.setUserName("李四");
//        user.setPassWord("123456");
//
//        AccountUser user2 = new AccountUser();
//        user2.setUserName("王五");
//        user2.setPassWord("123456");
//
//        List list2 = new ArrayList();
//        list2.add(user);
//        list2.add(user2);
//
//        AccountUser user3 = new AccountUser();
//        user3.setUserName("赵六");
//        user3.setPassWord("123456");
//
//        map.put("list",list);
//        map.put("list2",list2);
//        map.put("user3",user3);
//
//        JSONObject o = (JSONObject) JSON.toJSON(user3);
//
//        System.out.println(o.get("userName"));

        TestClass t = new TestClass(new A() {
            @Override
            public void f() {
                System.out.println("Class对象是:" + this.getClass());
            }
        });
    }

    public TestClass(A a){
        System.out.println("构造函数");
        a.f();
    }
}

interface A {
    void f();
}

