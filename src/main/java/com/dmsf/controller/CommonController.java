package com.dmsf.controller;

import com.dmsf.domain.DmsfVideoInfo;
import com.dmsf.exception.ReturnException;
import com.dmsf.resp.Response;
import com.dmsf.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    public Response<Page<DmsfVideoInfo>> listPage(@RequestParam String searchValue, @RequestParam String type, @RequestParam Integer page, @RequestParam Integer size){

        try {
            Page<DmsfVideoInfo> videos =  commonService.getSeachResult(searchValue,type,page,size);
            return new Response(videos);
        }catch (ReturnException e){
            return new Response("00001",e.getMessage(),null);
        }catch (Exception e){
            return new Response("00001",e.getMessage(),null);
        }

    }




}
