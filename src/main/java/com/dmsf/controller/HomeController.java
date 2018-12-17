package com.dmsf.controller;

import com.dmsf.domain.DmsfVideoInfo;
import com.dmsf.exception.ReturnException;
import com.dmsf.resp.Response;
import com.dmsf.service.IHomeService;
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
@RequestMapping("/home")
@CrossOrigin
public class HomeController {

    @Autowired
    private IHomeService homeService;



    @PostMapping("/listPage")
    public Response<Page<DmsfVideoInfo>> listPage(@RequestParam Integer page, @RequestParam Integer size){

        try {
            Page<DmsfVideoInfo> videos =  homeService.listPage(page,size);
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


    @PostMapping("/hotMovie")
    public Response<List<DmsfVideoInfo>> hotMovie(){

        try {
            List<DmsfVideoInfo> videos =  homeService.hotMovie();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }

    @PostMapping("/hotTelevision")
    public Response<List<DmsfVideoInfo>> hotTelevision(){

        try {
            List<DmsfVideoInfo> videos =  homeService.hotTelevision();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


    @PostMapping("/hotAnimation")
    public Response<List<DmsfVideoInfo>> hotAnimation(){

        try {
            List<DmsfVideoInfo> videos =  homeService.hotAnimation();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }



    @PostMapping("/hot3ForAll")
    public Response<List<DmsfVideoInfo>> hot3ForAll(){

        try {
            List<DmsfVideoInfo> videos =  homeService.hot3ForAll();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }

}
