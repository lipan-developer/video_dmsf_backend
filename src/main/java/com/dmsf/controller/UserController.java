package com.dmsf.controller;

import com.dmsf.domain.DmsfVideoInfo;
import com.dmsf.domain.UserBasicInfo;
import com.dmsf.exception.ReturnException;
import com.dmsf.resp.Response;
import com.dmsf.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 15:30
 * @Description:
 */

@RestController
@RequestMapping("/dmsf/user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;



    @PostMapping("/getUser")
    public Response<Page<DmsfVideoInfo>> getUser(@RequestParam String nickName, @RequestParam String password){

        try {
            UserBasicInfo user =  userService.getUser(nickName,password);
            return new Response(user);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


    @PostMapping("/editUser")
    public Response<Void> editUser(@RequestBody UserBasicInfo user){

        try {
             userService.editUser(user);
            return new Response(null);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


}
