package com.dmsf.controller;

import com.dmsf.domain.Video;
import com.dmsf.exception.ReturnException;
import com.dmsf.resp.Response;
import com.dmsf.service.IHomeService;
import com.dmsf.service.IMovieService;
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
@RequestMapping("/movie")
@CrossOrigin
public class MovieController {

    @Autowired
    private IMovieService movieService;



    @PostMapping("/listPage")
    public Response<List<Video>> listPage(){

        try {
            List<Video> videos =  movieService.listPage();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }




    @PostMapping("/newMovie")
    public Response<List<Video>> getNewMovie(){

        try {
            List<Video> videos =  movieService.getNewMovie();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }



    @PostMapping("/hotMovie")
    public Response<List<Video>> getHotMovie(){

        try {
            List<Video> videos =  movieService.getHotMovie();
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


}
