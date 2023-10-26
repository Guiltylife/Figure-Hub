package com.example.zsgc.mapper;

import com.example.zsgc.entity.Comment;
import com.example.zsgc.entity.Deal;
import com.example.zsgc.entity.DealFront;
import com.example.zsgc.entity.Figure;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DealMapper {
    @Select("select distinct deal.dealId,deal.status,deal.createTime,deal.buyer,deal.seller,deal.merchandiseId,figure.figureName" +
            " from deal,sale,figure" +
            " where deal.merchandiseId=sale.merchandiseId" +
            " and sale.figureId=figure.figureId")
    public List<DealFront> selectAll();

    //@Select("select * from deal where buyer like concat('%', #{buyer}, '%')")
    @Select("select distinct deal.dealId,deal.status,deal.createTime,deal.buyer,deal.seller,deal.merchandiseId,figure.figureName" +
            " from deal,sale,figure" +
            " where deal.merchandiseId=sale.merchandiseId" +
            " and sale.figureId=figure.figureId" +
            " and deal.buyer like concat('%', #{buyer}, '%')")
    public List<DealFront> selectByBuyer(String buyer);

    //@Select("select * from deal where seller like concat('%', #{seller}, '%')")
    @Select("select distinct deal.dealId,deal.status,deal.createTime,deal.buyer,deal.seller,deal.merchandiseId,figure.figureName" +
            " from deal,sale,figure" +
            " where deal.merchandiseId=sale.merchandiseId" +
            " and sale.figureId=figure.figureId" +
            " and deal.seller like concat('%', #{seller}, '%')")
    public List<DealFront> selectBySeller(String seller);

    //@Select("select * from deal where merchandiseId=#{merchandiseId}")
    @Select("select distinct deal.dealId,deal.status,deal.createTime,deal.buyer,deal.seller,deal.merchandiseId,figure.figureName" +
            " from deal,sale,figure" +
            " where deal.merchandiseId=sale.merchandiseId" +
            " and sale.figureId=figure.figureId" +
            " and deal.merchandiseId=#{merchandiseId}")
    public List<DealFront> selectByMerchandiseId(int merchandiseId);

    @Insert("insert into deal(status, createTime, buyer, seller, merchandiseId) values (#{status},#{createTime},#{buyer},#{seller},#{merchandiseId})")
    public void insertDeal(Deal deal);

    @Update("update deal set status=#{status},createTime=#{createTime},buyer=#{buyer},seller=#{seller},merchandiseId=#{merchandiseId} where dealId=#{dealId}")
    public void updateDeal(Deal deal);

    @Delete("delete from deal where dealId=#{dealId}")
    public void deleteDeal(int dealId);
}
