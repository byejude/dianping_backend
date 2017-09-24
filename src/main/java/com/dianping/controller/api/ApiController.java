package com.dianping.controller.api;

/**
 * Created by byebyejude on 2017/9/19.
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dianping.dto.AdDto;
import com.dianping.dto.BusinessDto;
import com.dianping.dto.BusinessListDto;
import com.dianping.dto.CommentListDto;
import com.dianping.dto.OrdersDto;
import com.dianping.services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AdService adService;

    @Value("${ad.number}")
    private int adNumber;

    /**
     * 首页 —— 广告（超值特惠）
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/homead", method = RequestMethod.GET)
    public List<AdDto> homead()  {
        AdDto adDto = new AdDto();
        adDto.getPage().setNumberInPage(adNumber);
        return adService.searchByPage(adDto);
    }

    /**
     * 首页 —— 推荐列表（猜你喜欢）
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/homelist/{city}/{page.currentPage}", method = RequestMethod.GET)
    public BusinessListDto homelist(BusinessDto businessDto) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = "{\"hasMore\":true,\"data\":[{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201638030-473660627.png\",\"title\":\"汉堡大\",\"subTitle\":\"叫我汉堡大，还你多彩口味\",\"price\":\"28\",\"distance\":\"120m\",\"mumber\":\"389\",\"id\":\"6261170837131391\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201645858-1342445625.png\",\"title\":\"北京开源饭店\",\"subTitle\":\"[望京]自助晚餐\",\"price\":\"98\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"6426906644915766\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201652952-1050532278.png\",\"title\":\"服装定制\",\"subTitle\":\"原价xx元，现价xx元，可修改一次\",\"price\":\"1980\",\"distance\":\"160\",\"mumber\":\"106\",\"id\":\"5749145392303552\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201700186-1351787273.png\",\"title\":\"婚纱摄影\",\"subTitle\":\"免费试穿，拍照留念\",\"price\":\"2899\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"3838329886957028\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201708124-1116595594.png\",\"title\":\"麻辣串串烧\",\"subTitle\":\"双人免费套餐等你抢购\",\"price\":\"0\",\"distance\":\"160\",\"mumber\":\"1426\",\"id\":\"9499467197483056\"}]}";
        return mapper.readValue(s,new TypeReference<BusinessListDto>() {});
    }

    /**
     * 搜索结果页 - 搜索结果 - 三个参数
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/search/{page.currentPage}/{city}/{category}/{keyword}", method = RequestMethod.GET)
    public BusinessListDto searchByKeyword(BusinessDto businessDto) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = "{\"hasMore\":true,\"data\":[{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145742279-606202974.jpg\",\"title\":\"河束人家\",\"subTitle\":\"南锣鼓巷店\",\"price\":\"150\",\"distance\":\"120m\",\"mumber\":\"389\",\"id\":\"16414190508477233\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145750123-1745839503.jpg\",\"title\":\"漫漫火锅\",\"subTitle\":\"[王府井]自助火锅\",\"price\":\"113\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"10379361046633062\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145755545-1770557408.jpg\",\"title\":\"北方涮肉\",\"subTitle\":\"什刹海店\",\"price\":\"92\",\"distance\":\"160\",\"mumber\":\"106\",\"id\":\"2684953608146943\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145800732-576947550.jpg\",\"title\":\"姓高火锅\",\"subTitle\":\"知春里店\",\"price\":\"90\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"4327667029608906\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145806201-1193851669.jpg\",\"title\":\"八重牛府\",\"subTitle\":\"最好吃的牛丸\",\"price\":\"85\",\"distance\":\"160\",\"mumber\":\"1426\",\"id\":\"05417345080828273\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022150855185-1659375763.jpg\",\"title\":\"蜀乡涮锅\",\"subTitle\":\"[王府井]自助火锅\",\"price\":\"113\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"4165909692594816\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145800732-576947550.jpg\",\"title\":\"满楼福火锅\",\"subTitle\":\"知春路店\",\"price\":\"90\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"17548314689876077\"}]}";
        return mapper.readValue(s,new TypeReference<BusinessListDto>() {});
    }

    /**
     * 搜索结果页 - 搜索结果 - 两个参数
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/search/{page.currentPage}/{city}/{category}", method = RequestMethod.GET)
    public BusinessListDto search(BusinessDto businessDto) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = "{\"hasMore\":true,\"data\":[{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145742279-606202974.jpg\",\"title\":\"河束人家\",\"subTitle\":\"南锣鼓巷店\",\"price\":\"150\",\"distance\":\"120m\",\"mumber\":\"389\",\"id\":\"16414190508477233\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145750123-1745839503.jpg\",\"title\":\"漫漫火锅\",\"subTitle\":\"[王府井]自助火锅\",\"price\":\"113\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"10379361046633062\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145755545-1770557408.jpg\",\"title\":\"北方涮肉\",\"subTitle\":\"什刹海店\",\"price\":\"92\",\"distance\":\"160\",\"mumber\":\"106\",\"id\":\"2684953608146943\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145800732-576947550.jpg\",\"title\":\"姓高火锅\",\"subTitle\":\"知春里店\",\"price\":\"90\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"4327667029608906\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145806201-1193851669.jpg\",\"title\":\"八重牛府\",\"subTitle\":\"最好吃的牛丸\",\"price\":\"85\",\"distance\":\"160\",\"mumber\":\"1426\",\"id\":\"05417345080828273\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022150855185-1659375763.jpg\",\"title\":\"蜀乡涮锅\",\"subTitle\":\"[王府井]自助火锅\",\"price\":\"113\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"4165909692594816\"},{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161022145800732-576947550.jpg\",\"title\":\"满楼福火锅\",\"subTitle\":\"知春路店\",\"price\":\"90\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"17548314689876077\"}]}";
        return mapper.readValue(s,new TypeReference<BusinessListDto>() {});
    }

    /**
     * 详情页 - 商户信息
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/detail/info/{id}", method = RequestMethod.GET)
    public BusinessDto detail(@PathVariable("id") Long id) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String s = "{\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201645858-1342445625.png\",\"title\":\"天下第一锅\",\"star\":4,\"price\":\"88\",\"subTitle\":\"重庆 & 四川 麻辣火锅\",\"desc\":\"营业时间 11:00 - 21:00 <br> 电话订购 11:00 - 19:00 <br> 网络订购 11:00 - 19:00\"}";
        return mapper.readValue(s,new TypeReference<BusinessDto>() {});
    }

    /**
     * 详情页 - 用户评论
     */
    @RequestMapping(value = "/detail/comment/{page}/{id}", method = RequestMethod.GET)
    public CommentListDto detail() throws JsonParseException, JsonMappingException, IOException {
        String s = "{\"hasMore\":true,\"data\":[{\"username\":\"133****3355\",\"comment\":\"非常好吃，棒棒的，下次再来\",\"star\":5},{\"username\":\"135****3452\",\"comment\":\"羊肉够分量，不错\",\"star\":4},{\"username\":\"137****1242\",\"comment\":\"有自助的水果，非常喜欢\",\"star\":4},{\"username\":\"131****3980\",\"comment\":\"桌子环境有点糟糕，不喜欢\",\"star\":2},{\"username\":\"135****3565\",\"comment\":\"基本还可以，中规中矩吧，虽然没有啥惊喜\",\"star\":3},{\"username\":\"130****9879\",\"comment\":\"感觉很棒，服务员态度非常好\",\"star\":5},{\"username\":\"186****7570\",\"comment\":\"要是能多给开点发票就好了，哈哈啊\",\"star\":4}]}";
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(s, new TypeReference<CommentListDto>() {});
    }

    /**
     * 订单列表
     */
    @RequestMapping(value = "/orderlist/{username}", method = RequestMethod.GET)
    public List<OrdersDto> orderlist() throws JsonParseException, JsonMappingException, IOException {
        String s = "[{\"id\":1494060890936,\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201638030-473660627.png\",\"title\":\"汉堡大王\",\"count\":3,\"price\":\"167\",\"commentState\":0},{\"id\":1494060890936,\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201708124-1116595594.png\",\"title\":\"麻辣香锅\",\"count\":1,\"price\":\"188\",\"commentState\":0},{\"id\":1494060890936,\"img\":\"http://images2015.cnblogs.com/blog/138012/201610/138012-20161016201645858-1342445625.png\",\"title\":\"好吃自出餐\",\"count\":2,\"price\":\"110\",\"commentState\":2}]";
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(s, new TypeReference<List<OrdersDto>>() {});
    }

    /**
     * 提交评论
     */
    @RequestMapping(value = "/submitComment", method = RequestMethod.POST)
    public Map<String, Object> submitComment() {
        Map<String, Object> result = new HashMap<>();
        result.put("errno", 0);
        result.put("msg", "ok");
        return result;
    }
}