package com.dmsf.controller;

import com.dmsf.domain.Video;
import com.dmsf.exception.ReturnException;
import com.dmsf.model.resp.NavDataResp;
import com.dmsf.resp.Response;
import com.dmsf.service.ICommonService;
import com.dmsf.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 15:30
 * @Description:
 */

@RestController
@RequestMapping("/dmsf/common")
@CrossOrigin
public class CommonController {

    @Autowired
    private ICommonService commonService;



    @PostMapping("/getSeachResult")
    public Response<List<Video>> listPage(@RequestParam String searchValue,@RequestParam String type){

        try {
            List<Video> videos =  commonService.getSeachResult(searchValue,type);
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }




}
