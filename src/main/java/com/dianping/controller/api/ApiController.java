package com.dianping.controller.api;

/**
 * Created by byebyejude on 2017/9/19.
 */
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dianping.bean.Page;
import com.dianping.bean.SysParam;
import com.dianping.constant.ApiCodeEnum;
import com.dianping.dto.*;
import com.dianping.services.*;
import com.dianping.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AdService adService;

    @Autowired
    private BusinessService businessService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private CommentService commentService;

    @Value("${ad.number}")
    private int adNumber;

    @Value("${businessHome.number}")
    private int businesNumber;


    @Value("${businessSearch.number}")
    private int businessSearchNumber;
    /**
     * 首页 —— 广告（超值特惠）
     */
    @RequestMapping(value = "/homead", method = RequestMethod.GET)
    public List<AdDto> homead()  {
        AdDto adDto = new AdDto();
        adDto.getPage().setNumberInPage(adNumber);
        return adService.searchByPage(adDto);
    }

    /**
     * 首页 —— 推荐列表（猜你喜欢）
     */
    @RequestMapping(value = "/homelist/{city}/{page.currentPage}", method = RequestMethod.GET)
    public BusinessListDto homeList(BusinessDto businessDto) {
        businessDto.getPage().setNumberInPage(businesNumber);
        return  businessService.searchByPageForApi(businessDto);

    }
    /**
     * 分类按钮 - 搜索结果 - 两个参数

     */
    @RequestMapping(value = "/search/{page.currentPage}/{city}/{category}", method = RequestMethod.GET)
    public BusinessListDto homeCategoryButton(BusinessDto businessDto) {
     businessDto.getPage().setNumberInPage(businessSearchNumber);
        return businessService.searchByPageForApi(businessDto);
    }


    /**
     * 搜索栏 - 搜索结果 - 两个参数
     */
    @RequestMapping(value = "/search/{page.currentPage}/{city}/{category}/{keyword}", method = RequestMethod.GET)
    public BusinessListDto search(BusinessDto businessDto){
        businessDto.getPage().setNumberInPage(businessSearchNumber);
        return businessService.searchByPageForApi(businessDto);
    }

    /**
     * 详情页 - 商户信息
     */
    @RequestMapping(value = "/detail/info/{id}", method = RequestMethod.GET)
    public BusinessDto detail(@PathVariable("id") Long id) {
        return businessService.selectById(id);
    }


    /**
     * 根据手机号下发短信验证码
     */
    @RequestMapping(value = "/sms",method = RequestMethod.POST)
    public ApiCodeDto sendSms(@RequestParam("username") Long username) {
          ApiCodeDto apiCodeDto;
          if(memberService.exists(username)){
              String randomCode = String.valueOf(CommonUtil.random(6));
              if(memberService.saveCode(username,randomCode)){
                  if(memberService.sendCode(username,randomCode)){
                      apiCodeDto = new ApiCodeDto(ApiCodeEnum.SUCCESS);
                  }else {
                      apiCodeDto = new ApiCodeDto(ApiCodeEnum.SEND_FAIL);
                  }
              }else {
                  apiCodeDto = new ApiCodeDto(ApiCodeEnum.REPEAT_REQUEST);
              }

          }else {
              apiCodeDto = new ApiCodeDto(ApiCodeEnum.USER_NOT_EXISTS);
          }
          return apiCodeDto;
    }

    /**
     * 会员登录
     */
    @RequestMapping(value = "/login" ,method = RequestMethod.POST)
    public ApiCodeDto login(@RequestParam("username")Long username,@RequestParam("code") String code){
          ApiCodeDto apiCodeDto;

          String saveCode = memberService.getCode(username);
          if (saveCode != null){
              if(saveCode.equals(code)){
                  String token = CommonUtil.getUUID();
                  memberService.saveToken(token,username);

                  apiCodeDto = new ApiCodeDto(ApiCodeEnum.SUCCESS);
                  apiCodeDto.setToken(token);
              }else{
                  apiCodeDto = new ApiCodeDto(ApiCodeEnum.CODE_ERROR);
              }
          }else{
                 apiCodeDto = new ApiCodeDto(ApiCodeEnum.CODE_INVALID);
          }
          return apiCodeDto;
    }

    /**
     * 买单
     */
     @RequestMapping(value = "/order",method = RequestMethod.POST)
     public ApiCodeDto order(OrdersFoyBuyDto ordersFoyBuyDto){
         ApiCodeDto apiCodeDto;
         Long phone = memberService.getPhone(ordersFoyBuyDto.getToken());
         if(phone!= null&&phone.equals(ordersFoyBuyDto.getUsername())){
             Long memberId = memberService.getIdByPhone(phone);
                 OrdersDto ordersDto = new OrdersDto();
                 ordersDto.setNum(ordersFoyBuyDto.getNum());
                 ordersDto.setPrice(ordersFoyBuyDto.getPrice());
                 ordersDto.setBusinessId(ordersFoyBuyDto.getId());
             ordersDto.setMemberId(memberId);
             ordersService.add(ordersDto);
             apiCodeDto = new ApiCodeDto(ApiCodeEnum.SUCCESS);

         }else {
             apiCodeDto = new ApiCodeDto(ApiCodeEnum.NOT_LOGGED);
         }
         return apiCodeDto;
     }



    /**
     * 详情页 - 用户评论
     */
    @RequestMapping(value = "/detail/comment/{currentPage}/{businessId}", method = RequestMethod.GET)
    public CommentListDto commentDetail(@PathVariable("businessId") Long businessId,Page page) {
          return commentService.getListByBusinessId(businessId,page);
    }

    /**
     * 订单列表
     */
    @RequestMapping(value = "/orderlist/{username}", method = RequestMethod.GET)
    public List<OrdersDto> orderlist(@PathVariable("username")  Long username)  {
        Long memberId = memberService.getIdByPhone(username);
        List<OrdersDto> ordersDtoList = ordersService.getListByMemberId(memberId);
        return ordersDtoList;
    }

    /**
     * 提交评论
     */
    @RequestMapping(value = "/submitComment", method = RequestMethod.POST)
    public ApiCodeDto submitComment(CommentForSubmitDto commentForSubmitDto) {
       ApiCodeDto result;
       Long phone = memberService.getPhone(commentForSubmitDto.getToken());

        //校验登录信息：token、手机号
       if(phone != null&&phone.equals(commentForSubmitDto.getUsername())){
           Long memberId = memberService.getIdByPhone(phone);
           OrdersDto ordersDto = ordersService.getById(commentForSubmitDto.getId());

           //根据提交上来的订单ID获取对应的会员ID，校验与当前登录的会员是否一致
           if(ordersDto.getMemberId().equals(memberId)){
               commentService.add(commentForSubmitDto);
               result = new ApiCodeDto(ApiCodeEnum.SUCCESS);
           }else{
               result = new ApiCodeDto(ApiCodeEnum.NO_AUTH);
           }
       }else{
              result = new ApiCodeDto(ApiCodeEnum.NOT_LOGGED);
       }
       return result;
    }
}