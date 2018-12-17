package com.dmsf.controller;

import com.dmsf.domain.DmsfVideoInfo;
import com.dmsf.exception.ReturnException;
import com.dmsf.resp.Response;
import com.dmsf.service.IAnimationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 15:30
 * @Description:
 */

@RestController
@RequestMapping("/animation")
@CrossOrigin
public class AnimationController {

    @Autowired
    private IAnimationService animationService;



    @PostMapping("/listPage")
    public Response<Page<DmsfVideoInfo>> listPage(@RequestParam Integer page, @RequestParam Integer size){

        try {
            Page<DmsfVideoInfo> videos =  animationService.listPage( page,size);
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


    @PostMapping("/newAnimation")
    public Response<List<DmsfVideoInfo>> getNewAnimation(){

        try {
            List<DmsfVideoInfo> videos =  animationService.getNewAnimation();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


    @PostMapping("/hotAnimation")
    public Response<List<DmsfVideoInfo>> getHotAnimation(){

        try {
            List<DmsfVideoInfo> videos =  animationService.getHotAnimation();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


}
