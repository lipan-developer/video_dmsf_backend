package com.dmsf.controller;

import com.dmsf.domain.Video;
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
    public Response<Page<Video>> listPage(@RequestParam Integer page, @RequestParam Integer size){

        try {
            Page<Video> videos =  animationService.listPage( page,size);
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


    @PostMapping("/newAnimation")
    public Response<List<Video>> getNewAnimation(){

        try {
            List<Video> videos =  animationService.getNewAnimation();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


    @PostMapping("/hotAnimation")
    public Response<List<Video>> getHotAnimation(){

        try {
            List<Video> videos =  animationService.getHotAnimation();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


}
