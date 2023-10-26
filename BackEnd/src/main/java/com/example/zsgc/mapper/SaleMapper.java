package com.example.zsgc.mapper;

import com.example.zsgc.entity.Figurization;
import com.example.zsgc.entity.Sale;
import com.example.zsgc.entity.SaleInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SaleMapper {
//    @Select("select * from sale")
//    public List<Sale> selectAll();

    @Select("select distinct sale.saleId, sale.merchandiseId, user.username, user.nickname, figure.figureName, merchandise.price, user.imgpath, sale.figureId from sale, merchandise, user, figure where sale.figureId=figure.figureId and sale.merchandiseId=merchandise.merchandiseId and merchandise.username=user.username")
    public List<SaleInfo> selectAll();

    @Select("select distinct " +
            "sale.saleId, sale.merchandiseId, user.username, user.nickname, " +
            "figure.figureName, merchandise.price, user.imgpath, sale.figureId " +
            "from sale, merchandise, user, figure " +
            "where sale.figureId=figure.figureId " +
            "and sale.merchandiseId=merchandise.merchandiseId " +
            "and merchandise.username=user.username " +
            "and figure.figureName like concat('%', #{figureName}, '%')")
    public List<SaleInfo> selectByFigureName(String figureName);

    @Select("select * from sale where figureId=#{figureId}")
    public List<Sale> selectByFigureId(int figureId);

    @Select("select * from sale where merchandiseId=#{merchandiseId}")
    public List<Sale> selectByMerchandiseId(int merchandiseId);

    @Insert("insert into sale(figureId, merchandiseId) " +
            "values (#{figureId},#{merchandiseId})")
    public void insertSale(Sale sale);

    @Update("update sale set " +
            "figureId=#{figureId},merchandiseId=#{merchandiseId} " +
            "where saleId=#{saleId}")
    public void updateSale(Sale sale);

    @Delete("delete from sale where saleId=#{saleId}")
    public void deleteSale(int saleId);
}
