package com.dmsf.controller;

import com.dmsf.domain.DmsfVideoInfo;
import com.dmsf.domain.VideoSalveInfo;
import com.dmsf.exception.ReturnException;
import com.dmsf.model.req.ManagePageReq;
import com.dmsf.resp.Response;
import com.dmsf.service.IManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Auther: LiPan
 * @Date: 2018.12.3 15:30
 * @Description:
 */

@RestController
@RequestMapping("/dmsf/manage")
@CrossOrigin
public class ManageController {

    @Autowired
    private IManageService manageService;



    @PostMapping("/listPage")
    public Response<Page<DmsfVideoInfo>> listPage(@RequestBody ManagePageReq req){

        try {
            Page<DmsfVideoInfo> videos =  manageService.listPage(req);
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }





    @PostMapping("/editData")
    public Response<Boolean> editData(@RequestBody DmsfVideoInfo video){

        try {
            Boolean data =  manageService.editData(video);
            return new Response(data);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }



    @PostMapping("/deleteData")
    public Response<Boolean> deleteData(@RequestParam String tableKey){

        try {
            Boolean data =  manageService.deleteData(tableKey);
            return new Response(data);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


    @PostMapping("/manageDetails/query")
    public Response<Page<VideoSalveInfo>> queryManageDetails(@RequestBody Map req){

        try {
            Page<VideoSalveInfo> data =  manageService.queryManageDetails(req);
            return new Response(data);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }

    @PostMapping("/manageDetails/add")
    public Response<Boolean> addManageDetails(@RequestBody Map<String,String> req){

        try {
            Boolean data =  manageService.addManageDetails(req);
            return new Response(data);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }


    @PostMapping("/manageDetails/delete")
    public Response<Boolean> deleteManageDetails(@RequestParam String tableKey){

        try {
            Boolean data =  manageService.deleteManageDetails(tableKey);
            return new Response(data);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }
}
