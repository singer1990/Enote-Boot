package com.grand.enoteboot.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.grand.enoteboot.dto.ResponseData;
import com.grand.enoteboot.dto.ResponseVO;
import com.grand.enoteboot.entity.Article;
import com.grand.enoteboot.service.ArticleService;
import com.grand.enoteboot.util.StringTool;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author GrandX
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/init",method = RequestMethod.GET)
    public ModelAndView init(){
        return new ModelAndView("/article/init");
    }
    /**
     * 查找所有文章
     * @return
     */
    @ApiOperation(value = "获取文章列表",notes = "查找所有文章")
    @RequestMapping(value = "/articleList",method = RequestMethod.GET)
    @ResponseBody
    public ResponseData articleList(String search, String sort, String order, Integer offset, Integer limit){
        //Map<String,Object> result = new HashMap<>(2);
        Page page = PageHelper.offsetPage(offset,limit,true);
        if(sort != null){
            String orderBy = StringTool.camelhumpToUnderline(sort)+" "+order;
            page.setOrderBy(orderBy);
        }
        List<Article> articleList = articleService.findAll();
        //List<ArticleVO> articleVOList = new ArrayList<>();
        //for (Article article : articleList) {
        //    ArticleVO articleVO = new ArticleVO();
        //    BeanUtils.copyProperties(article,articleVO);
        //    articleVO.setRecommendStr(RecommendEnum.getDescByCode(articleVO.getRecommendFlag()));
        //    articleVO.setStatusStr(StatusEnum.getDescByCode(articleVO.getStatus()));
        //    articleVOList.add(articleVO);
        //}
        //result.put("rows",articleList);
        //result.put("total",page.getTotal());
        //return result;
        return ResponseData.ok(articleList,page.getTotal());
    }
    @RequestMapping(value = "/addPage",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView addPage(){
        return new ModelAndView("/article/add");
    }

    /**
     * 查询文章列表
     * @param article 文章实体
     * @return
     */
    @ApiOperation(value = "添加文章",notes = "添加文章")
    @ApiImplicitParam(name = "Article", value = "文章实体Article", required = true, dataType = "Article")
    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO addArticle(@RequestBody Article article){
        articleService.addArticle(article);
        return ResponseVO.ok();
    }

    @RequestMapping(value = "/editPage",method = RequestMethod.GET)
    public ModelAndView editPage(Long id){
        ModelAndView mv = new ModelAndView("/article/editPage");
        Article article = articleService.findById(id);
        mv.addObject("article",article);
        return mv;
    }

    @ApiOperation(value = "修改文章",notes = "修改文章")
    @ApiImplicitParam(name = "Article", value = "文章实体Article", required = true, dataType = "Article")
    @RequestMapping(value = "/editArticle",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseVO editArticle(@RequestBody Article article){
        articleService.update(article);
        return  ResponseVO.ok();
    }

    @RequestMapping(value = "/deleteArticle/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public ResponseVO deleteArticle(@PathVariable String id){
        articleService.delete(Long.valueOf(id));
        return ResponseVO.ok();
    }
}
