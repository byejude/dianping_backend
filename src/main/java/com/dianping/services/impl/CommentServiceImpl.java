package com.dianping.services.impl;

import com.dianping.bean.Business;
import com.dianping.bean.Comment;
import com.dianping.bean.Orders;
import com.dianping.bean.Page;
import com.dianping.constant.CommentStateConst;
import com.dianping.dao.CommentDao;
import com.dianping.dao.OrdersDao;
import com.dianping.dto.CommentDto;
import com.dianping.dto.CommentForSubmitDto;
import com.dianping.dto.CommentListDto;
import com.dianping.services.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by byebyejude on 2017/10/8.
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public boolean add(CommentForSubmitDto commentForSubmitDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentForSubmitDto ,comment);
        System.out.println("@@@@@@@@@@@@@@commentForSubmitDto.getId()"+commentForSubmitDto.getId());
        //将评论的ID设为null使其不与订单有任何关系
        comment.setId(null);
        comment.setOrdersId(commentForSubmitDto.getId());
        comment.setCreateTime(new Date());
        //提交评论
        commentDao.insert(comment);
        Orders orders = new Orders();
        orders.setId(commentForSubmitDto.getId());
        orders.setcommentState(CommentStateConst.HAS_COMMENT);
        //更新订单评论状态
        ordersDao.update(orders);
        return false;
    }

    @Override
    public CommentListDto getListByBusinessId(Long businessId, Page page) {
         CommentListDto result = new CommentListDto();

          Comment comment = new Comment();
          Orders orders = new Orders();
          Business business = new Business();

          comment.setOrders(orders);
          orders.setBusiness(business);
          business.setId(businessId);

          page.setCurrentPage(page.getCurrentPage()+1);
          comment.setPage(page);
          List<Comment> commentList = commentDao.selectByPage(comment);

         List<CommentDto> data = new ArrayList<>();
         for (Comment commentTemp:commentList ) {
              CommentDto commentDto = new CommentDto();
              BeanUtils.copyProperties(commentTemp,commentDto);
              StringBuffer phoneBuffer = new StringBuffer(String.valueOf(commentTemp.getOrders().getMember().getPhone()));
              commentDto.setUsername(phoneBuffer.replace(3,7,"****").toString());
              data.add(commentDto);
        }
         result.setData(data);
         result.setHasMore(page.getCurrentPage()<page.getTotalPage());
        return result;
    }

    @Override
    public List<CommentDto> selectByPage(CommentDto commentDto) {
        List<CommentDto> result = new ArrayList<>();

        Comment comment = new Comment();
        Orders orders = new Orders();
        Business business = new Business();
        comment.setOrders(orders);
        orders.setBusiness(business);

        comment.setPage(new Page());
        List<Comment> commentList = commentDao.selectByPage(comment);
        for (Comment commentTemp:commentList ) {
            CommentDto commentDtoTemp = new CommentDto();
            commentDtoTemp.setUsername(commentTemp.getOrders().getMember().getPhone().toString());
            commentDtoTemp.setStar(commentTemp.getStar());
            commentDtoTemp.setId(commentDtoTemp.getOrdersId());
            result.add(commentDtoTemp);
        }
        return result;

    }
}
