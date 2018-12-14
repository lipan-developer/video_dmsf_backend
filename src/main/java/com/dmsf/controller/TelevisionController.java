package com.dmsf.controller;

import com.dmsf.domain.Video;
import com.dmsf.exception.ReturnException;
import com.dmsf.resp.Response;
import com.dmsf.service.IHomeService;
import com.dmsf.service.ITelevisionService;
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
@RequestMapping("/television")
@CrossOrigin
public class TelevisionController {

    @Autowired
    private ITelevisionService televisionService;



    @PostMapping("/listPage")
    public Response<Page<Video>> listPage(@RequestParam Integer page, @RequestParam Integer size){

        try {
            Page<Video> videos =  televisionService.listPage(page,size);
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }

    @PostMapping("/newTelevision")
    public Response<List<Video>> getNewTelvision(){

        try {
            List<Video> videos =  televisionService.getNewTelvision();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }

    @PostMapping("/hotTelevision")
    public Response<List<Video>> getHotTelvision(){

        try {
            List<Video> videos =  televisionService.getHotTelvision();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


}
