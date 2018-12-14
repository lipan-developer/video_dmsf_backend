package com.dmsf.controller;

import com.dmsf.domain.Video;
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
    public Response<Page<Video>> listPage(@RequestParam Integer page,@RequestParam Integer size){

        try {
            Page<Video> videos =  homeService.listPage(page,size);
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


    @PostMapping("/hotMovie")
    public Response<List<Video>> hotMovie(){

        try {
            List<Video> videos =  homeService.hotMovie();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }

    @PostMapping("/hotTelevision")
    public Response<List<Video>> hotTelevision(){

        try {
            List<Video> videos =  homeService.hotTelevision();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


    @PostMapping("/hotAnimation")
    public Response<List<Video>> hotAnimation(){

        try {
            List<Video> videos =  homeService.hotAnimation();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }



    @PostMapping("/hot3ForAll")
    public Response<List<Video>> hot3ForAll(){

        try {
            List<Video> videos =  homeService.hot3ForAll();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }

}
