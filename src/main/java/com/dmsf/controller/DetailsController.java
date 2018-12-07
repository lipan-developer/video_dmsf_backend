package com.dmsf.controller;

import com.dmsf.domain.Video;
import com.dmsf.exception.ReturnException;
import com.dmsf.resp.Response;
import com.dmsf.service.IAnimationService;
import com.dmsf.service.IDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 15:30
 * @Description:
 */

@RestController
@RequestMapping("/dmsf")
@CrossOrigin
public class DetailsController {

    @Autowired
    private IDetailsService detailsService;



    @PostMapping("/details")
    public Response<Video> listPage(@RequestParam(required = true) String tableKey){

        try {
            Video video =  detailsService.getVideoDetail(tableKey);
            return new Response(video);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }




}
