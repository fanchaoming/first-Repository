package com.example.washroom.conroller;

import com.example.washroom.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

//name：api文档显示接口名  description：接口功能描述
@Tag(name = "添加用户", description = "用户的增删改查操作接口")//将helloController类在api文档里显示为"添加用户"
@RestController//这就意味着这个类已经变成控制器了，可以接受前端的请求了
public class helloController {
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    //@Operation作用：在api调用文档里解释说明的，summary是该接口简要标题，description是该接口详细描述
    @Operation(summary="上传信息",description = "将姓名电话传过来")
    public String hello(@RequestParam(value="nickname",required = false) String name, String tel){
        System.out.println("姓名:"+name+",电话:"+tel);
        return "可以即时更新吗?"+name;
    }

    @RequestMapping(value = "/postTest1",method = RequestMethod.POST)
    public String Test1(String name,String tel,String address){
        System.out.println(name);
        System.out.println(tel);
        System.out.println(address);
        return name;
    }
    @RequestMapping(value = "/postTest2",method = RequestMethod.POST)
    public User Test2(User user){
        System.out.println(user.getName());
        System.out.println(user.getGender());
        System.out.println(user.getTel());
        System.out.println(user.getAddress());
        System.out.println(user);
        return user;
    }
}
