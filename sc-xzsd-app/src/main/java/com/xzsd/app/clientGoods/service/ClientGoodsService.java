package com.xzsd.app.clientGoods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzsd.app.clientGoods.dao.ClientGoodsDao;
import com.xzsd.app.clientGoods.entity.AppGoodsInfo;
import com.xzsd.app.clientGoods.entity.GoodsEvaluateInfo;
import com.xzsd.app.clientGoods.entity.OneClassifyInfo;
import com.xzsd.app.clientGoods.entity.TwoClassifyInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author cairuifeng
 * @date 2020-04-23
 */
@Service
public class ClientGoodsService {

    @Resource
    private ClientGoodsDao clientGoodsDao;

    /**
     * clientGoods 查询商品详情
     * @param goodsCode
     * @return
     * @Author cairuifeng
     * @Date 2020-04-23
     */
    public AppResponse getGoods(String goodsCode) {
        AppGoodsInfo appGoodsInfo = clientGoodsDao.getGoods(goodsCode);
        clientGoodsDao.updateSeeSum(goodsCode);
        return AppResponse.success("查询成功！",appGoodsInfo);
    }

    /**
     * clientGoods 查询商品评价列表（分页）
     * @param goodsEvaluateInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-24
     */
    public AppResponse listGoodsEvaluates(GoodsEvaluateInfo goodsEvaluateInfo) {
        PageHelper.startPage(goodsEvaluateInfo.getPageNum(), goodsEvaluateInfo.getPageSize());
        List<GoodsEvaluateInfo> goodsEvaluateInfoList = clientGoodsDao.listGoodsEvaluatesByPage(goodsEvaluateInfo);
        // 包装Page对象
        PageInfo<GoodsEvaluateInfo> pageData = new PageInfo<GoodsEvaluateInfo>(goodsEvaluateInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * clientGoods 查询一级分类列表
     * @param oneClassifyInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-24
     */
    public AppResponse listOneGoodsClassify(OneClassifyInfo oneClassifyInfo) {
        List<OneClassifyInfo> oneClassifyInfoList = clientGoodsDao.listOneGoodsClassify(oneClassifyInfo);
        return AppResponse.success("查询成功！",oneClassifyInfoList);
    }

    /**
     * 查询一级分类下二级分类及商品列表
     * @param twoClassifyInfo
     * @return
     * @Author cairuifeng
     * @Date 2020-04-14
     */
    public AppResponse listGetClassGoods(TwoClassifyInfo twoClassifyInfo) {
        List<TwoClassifyInfo>  twoClassifyInfoList = clientGoodsDao.listGetClassGoods(twoClassifyInfo);
        return AppResponse.success("查询成功！",twoClassifyInfoList);
    }
}
