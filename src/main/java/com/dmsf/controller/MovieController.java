package com.dmsf.controller;

import com.dmsf.domain.DmsfVideoInfo;
import com.dmsf.exception.ReturnException;
import com.dmsf.resp.Response;
import com.dmsf.service.IMovieService;
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
@RequestMapping("/movie")
@CrossOrigin
public class MovieController {

    @Autowired
    private IMovieService movieService;



    @PostMapping("/listPage")
    public Response<Page<DmsfVideoInfo>> listPage(@RequestParam Integer page, @RequestParam Integer size){

        try {
            Page<DmsfVideoInfo> videos =  movieService.listPage(page,size);
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }




    @PostMapping("/newMovie")
    public Response<List<DmsfVideoInfo>> getNewMovie(){

        try {
            List<DmsfVideoInfo> videos =  movieService.getNewMovie();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }



    @PostMapping("/hotMovie")
    public Response<List<DmsfVideoInfo>> getHotMovie(){

        try {
            List<DmsfVideoInfo> videos =  movieService.getHotMovie();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


}
