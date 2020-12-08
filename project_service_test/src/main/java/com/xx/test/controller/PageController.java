package com.xx.test.controller;

import com.xx.test.pojo.Page;
import com.xx.test.service.PageService;
import com.github.pagehelper.Page;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/page")
@CrossOrigin
public class PageController {


    @Autowired
    private PageService pageService;

    @GetMapping
    public Result findAll(){
        List<Page> pageList = pageService.findAll();
        return new Result(true, StatusCode.OK,"查询成功",pageList) ;
    }

    @GetMapping("/{pageId}")
    public Result findById(@PathVariable String pageId){
        Page page = pageService.findById(pageId);
        return new Result(true,StatusCode.OK,"查询成功",page);
    }

    @PostMapping
    public Result add(@RequestBody Page page){
        pageService.add(page);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    @PutMapping(value="/{pageId}")
    public Result update(@RequestBody Page page,@PathVariable String pageId){
        page.setId(pageId);
        pageService.update(page);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    @DeleteMapping(value = "/{pageId}" )
    public Result delete(@PathVariable String pageId){
        pageService.delete(pageId);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@PathVariable  int page, @PathVariable  int size){
        Page<Page> pageList = pageService.findPage(page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

    @PostMapping(value = "/search" )
    public Result findList(@RequestBody Map searchMap){
        List<Page> list = pageService.findList(searchMap);
        return new Result(true,StatusCode.OK,"查询成功",list);
    }

    @PostMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody Map searchMap, @PathVariable  int page, @PathVariable  int size){
        Page<Page> pageList = pageService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return new Result(true,StatusCode.OK,"查询成功",pageResult);
    }

}
