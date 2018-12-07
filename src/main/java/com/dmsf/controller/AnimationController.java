package com.dmsf.controller;

import com.dmsf.domain.Video;
import com.dmsf.exception.ReturnException;
import com.dmsf.resp.Response;
import com.dmsf.service.IAnimationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Response<List<Video>> listPage(){

        try {
            List<Video> videos =  animationService.listPage();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }




}
