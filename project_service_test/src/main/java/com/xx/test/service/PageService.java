package com.xx.test.service;

import com.xx.test.dao.PageMapper;
import com.xx.test.pojo.Page;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class PageService {

    @Autowired
    private PageMapper pageMapper;

    /**
     * 全部数据
     * @return
     */
    public List<Page> findAll(){
        return pageMapper.selectAll();
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    public Page findById(String pageId){
        return  pageMapper.selectByPrimaryKey(id);
    }

    /**
     * 增加
     * @param page
     */
    public void add(Page page){
        pageMapper.insert(page);
    }

    /**
     * 修改
     * @param page
     */
    public void update(Page page){
        pageMapper.updateByPrimaryKey(page);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(String pageId){
        pageMapper.deleteByPrimaryKey(id);
    }


    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    public Page<Page> findPage( int page, int size){
        PageHelper.startPage(page,size);
        return (Page<Page>)pageMapper.selectAll();
    }

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    public List<Page> findList(Map<String,Object> searchMap){
        Example example = createExample(searchMap);
        return pageMapper.selectByExample(example);
    }

    /**
     * 构建查询对象
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String,Object> searchMap){
        Example example=new Example(Page.class);
        Example.Criteria criteria = example.createCriteria();
        if(searchMap!=null){
            // pageId
            if(searchMap.get("pageId")!=null && !"".equals(searchMap.get("pageId"))){
                criteria.andLike("pageId","%"+searchMap.get("pageId")+"%");
           	}
            // bookname
            if(searchMap.get("bookname")!=null && !"".equals(searchMap.get("bookname"))){
                criteria.andLike("bookname","%"+searchMap.get("bookname")+"%");
           	}
            // bookbuyer
            if(searchMap.get("bookbuyer")!=null && !"".equals(searchMap.get("bookbuyer"))){
                criteria.andLike("bookbuyer","%"+searchMap.get("bookbuyer")+"%");
           	}
            // bookborrower
            if(searchMap.get("bookborrower")!=null && !"".equals(searchMap.get("bookborrower"))){
                criteria.andLike("bookborrower","%"+searchMap.get("bookborrower")+"%");
           	}
            // bookStatus
            if(searchMap.get("bookStatus")!=null && !"".equals(searchMap.get("bookStatus"))){
                criteria.andLike("bookStatus","%"+searchMap.get("bookStatus")+"%");
           	}
            // locationType
            if(searchMap.get("locationType")!=null && !"".equals(searchMap.get("locationType"))){
                criteria.andLike("locationType","%"+searchMap.get("locationType")+"%");
           	}
            // selectValue
            if(searchMap.get("selectValue")!=null && !"".equals(searchMap.get("selectValue"))){
                criteria.andLike("selectValue","%"+searchMap.get("selectValue")+"%");
           	}
            // cmspageId
            if(searchMap.get("cmspageId")!=null && !"".equals(searchMap.get("cmspageId"))){
                criteria.andLike("cmspageId","%"+searchMap.get("cmspageId")+"%");
           	}

            // bookvolume
            if(searchMap.get("bookvolume")!=null ){
                criteria.andEqualTo("bookvolume",searchMap.get("bookvolume"));
            }

        }
        return example;
    }

    /**
     * 条件+分页查询
     * @param searchMap 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    public Page<Page> findPage(Map<String,Object> searchMap, int page, int size){
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        return (Page<Page>)pageMapper.selectByExample(example);
    }

}
