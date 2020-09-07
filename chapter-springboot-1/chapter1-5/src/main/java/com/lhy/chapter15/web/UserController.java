package com.lhy.chapter15.web;

import com.lhy.chapter15.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "用户列表信息获取", notes = "")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUsers(){
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @ApiOperation(value = "创建用户信息", notes = "")
    @ApiImplicitParam(name = "user",value = "用户信息实体",required = true,dataType = "User")
    @RequestMapping(value = "/", method=RequestMethod.POST)
    public String postUser(@RequestBody User user){
        users.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "获取用户信息", notes = "")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, paramType = "path" , dataType = "Long")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return users.get(id);
    }

    @ApiOperation(value = "修改用户信息",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "用户id", required = true, paramType = "path", dataType = "Long"),
            @ApiImplicitParam(name = "user",value = "用户信息实体",required = true,dataType = "User")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id,@RequestBody User user){
        User u = users.get(id);
        u.setId(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id,u);
        return "success";
    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }
}
