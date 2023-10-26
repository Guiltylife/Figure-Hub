package com.example.zsgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
@MapperScan("com.example.zsgc.mapper")
public class ZsgcApplication {
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/FigureHub?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
    static String username = "FigureHub";
    static String password = "123456";

    static Connection conn = null;
    static Statement stmt = null;

    public static void main(String[] args) {
        //创建并初始化数据库
        initDataBase();

        SpringApplication.run(ZsgcApplication.class, args);
    }

    private static void initDataBase() {
        try {
            //注册jdbc驱动
            Class.forName(driver);
            //打开连接
            System.out.println("//开始连接数据库");
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("//数据库连接成功");
            //执行创建表
            System.out.println("//创建并初始化表");
            stmt = conn.createStatement();

            initStyle();

            // 创建数据库表
            createCollection();
            createComment();
            createCommentLike();
            createDealComment();
            createDeal();
            createFigure();
            createFigurization();
            createManufacturer();
            createMerchandise();
            createRole();
            createSale();
            createUser();
            createWork();
            createRoleImg();
            createFigureImg();
            createMerchandiseImg();
            // 创建触发器
            createTrigger();

            stmt.close();
            conn.close();
            System.out.println("//初始化完毕");
        }
        catch (Exception e) {
            System.out.println("//表初始化失败");
            e.printStackTrace();
        }
    }

    static boolean checkNotEmpty(String tableName) throws SQLException {
        stmt.execute("select * from " + tableName);
        return stmt.getResultSet().next();
    }

    static String CreateMerchandiseImg = "CREATE TABLE IF NOT EXISTS `merchandiseimg`  (\n" +
            "  `merchandiseImgId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品图片对应关系id',\n" +
            "  `merchandiseId` int(11) NULL DEFAULT NULL COMMENT '商品id',\n" +
            "  `imgpath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品图片路径',\n" +
            "  PRIMARY KEY (`merchandiseImgId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;\n";

    static String CreateFigureImg = "CREATE TABLE IF NOT EXISTS `figureimg`  (\n" +
            "  `figureImgId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '手办图片对应关系id',\n" +
            "  `figureId` int(11) NULL DEFAULT NULL COMMENT '手办id',\n" +
            "  `imgpath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手办图片路径',\n" +
            "  PRIMARY KEY (`figureImgId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;\n";

    static String CreateRoleImg = "CREATE TABLE IF NOT EXISTS `roleimg`  (\n" +
            "  `roleImgId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色图片对应关系id',\n" +
            "  `roleId` int(11) NULL DEFAULT NULL COMMENT '角色id',\n" +
            "  `imgpath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',\n" +
            "  PRIMARY KEY (`roleImgId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;\n";

    static String CreateWork = "CREATE TABLE IF NOT EXISTS `work`  (\n" +
            "  `workName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作品名称',\n" +
            "  `kind` tinyint(4) NULL DEFAULT NULL COMMENT '作品类别 0:动画 1:漫画 2:游戏 3:小说',\n" +
            "  `intro` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '作品简介',\n" +
            "  PRIMARY KEY (`workName`) USING BTREE\n" +
            ") ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;\n";

    static String CreateSale = "CREATE TABLE IF NOT EXISTS `sale`  (\n" +
            "  `saleId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '销售关系编号',\n" +
            "  `merchandiseId` int(11) NULL DEFAULT NULL COMMENT '商品编号',\n" +
            "  `figureId` int(11) NULL DEFAULT NULL COMMENT '手办编号',\n" +
            "  PRIMARY KEY (`saleId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;\n";

    static String CreateMerchandise = "CREATE TABLE IF NOT EXISTS `merchandise`  (\n" +
            "  `merchandiseId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '商品编号',\n" +
            "  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '售价',\n" +
            "  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',\n" +
            "  `status` tinyint(3) UNSIGNED ZEROFILL NULL DEFAULT NULL COMMENT '商品状态 0:余量充足 1:售罄 2:交易中',\n" +
            "  `type` tinyint(4) NULL DEFAULT NULL COMMENT '商品类型 0:一手 1:二手',\n" +
            "  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',\n" +
            "  PRIMARY KEY (`merchandiseId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品' ROW_FORMAT = Dynamic;\n";

    static String CreateFigurization = "CREATE TABLE IF NOT EXISTS `figurization`  (\n" +
            "  `relaId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '关系编号',\n" +
            "  `figureId` int(11) NULL DEFAULT NULL COMMENT '手办编号',\n" +
            "  `roleId` int(11) NULL DEFAULT NULL COMMENT '角色编号',\n" +
            "  PRIMARY KEY (`relaId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;\n";

    static String CreateDealComment = "CREATE TABLE IF NOT EXISTS `dealcomment`  (\n" +
            "  `dealCommentId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '交易评价编号',\n" +
            "  `buyer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布方',\n" +
            "  `dealId` int(11) NULL DEFAULT NULL COMMENT '交易编号',\n" +
            "  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',\n" +
            "  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',\n" +
            "  PRIMARY KEY (`dealCommentId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;\n";

    static String CreateDeal = "CREATE TABLE IF NOT EXISTS `deal`  (\n" +
            "  `dealId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '交易编号',\n" +
            "  `status` tinyint(255) NULL DEFAULT NULL COMMENT '交易状态 0:待付款 1:待评价 2:已完成',\n" +
            "  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '交易发起时间',\n" +
            "  `buyer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家',\n" +
            "  `seller` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卖家',\n" +
            "  `merchandiseId` int(11) NULL DEFAULT NULL COMMENT '商品编号',\n" +
            "  PRIMARY KEY (`dealId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '交易' ROW_FORMAT = Dynamic;\n";

    static String CreateCommentLike = "CREATE TABLE IF NOT EXISTS `commentlike`  (\n" +
            "  `likeId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '点赞ID',\n" +
            "  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',\n" +
            "  `commentId` int(11) NULL DEFAULT NULL COMMENT '评论编号',\n" +
            "  PRIMARY KEY (`likeId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '点赞' ROW_FORMAT = Dynamic;\n";

    static String CreateComment = "CREATE TABLE IF NOT EXISTS `comment`  (\n" +
            "  `commentId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论编号',\n" +
            "  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名称',\n" +
            "  `figureId` int(10) NULL DEFAULT NULL COMMENT '手办编号',\n" +
            "  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评论内容',\n" +
            "  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '发表时间',\n" +
            "  PRIMARY KEY (`commentId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;\n";

    static String CreateCollection = "CREATE TABLE IF NOT EXISTS `collection`  (\n" +
            "  `coID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '收藏编号',\n" +
            "  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',\n" +
            "  `merchandiseId` int(11) NULL DEFAULT NULL COMMENT '商品编号',\n" +
            "  PRIMARY KEY (`coID`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收藏' ROW_FORMAT = Dynamic;\n";

    static String CreateUser = "CREATE TABLE IF NOT EXISTS `user`  (\n" +
            "  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',\n" +
            "  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',\n" +
            "  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',\n" +
            "  `type` tinyint(2) NOT NULL COMMENT '用户类型(0:管理员;1:普通用户;2:厂商用户)',\n" +
            "  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户当前的token',\n" +
            "  `imgpath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户头像',\n" +
            "  PRIMARY KEY (`username`) USING BTREE\n" +
            ") ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = DYNAMIC;\n";

    static String CreateFigure = "CREATE TABLE IF NOT EXISTS `figure`  (\n" +
            "  `figureId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '手办编号',\n" +
            "  `figureName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手办名称',\n" +
            "  `figureType` tinyint(1) NULL DEFAULT NULL COMMENT '手办类型\\r\\n0-未知\\r\\n1-GK手办\\r\\n2-PVC手办\\r\\n3-可动手办\\r\\n4-景品手办\\r\\n5-粘土人',\n" +
            "  `price` decimal(10, 0) NULL DEFAULT NULL COMMENT '售价',\n" +
            "  `prop` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '比例',\n" +
            "  `manuName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手办厂商名字',\n" +
            "  PRIMARY KEY (`figureId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '手办' ROW_FORMAT = DYNAMIC;\n";

    static String CreateRole = "CREATE TABLE IF NOT EXISTS `role`  (\n" +
            "  `roleId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '角色编号',\n" +
            "  `roleName` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',\n" +
            "  `gender` tinyint(1) NULL DEFAULT NULL COMMENT '性别 0-未知 1-男 2-女',\n" +
            "  `intro` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',\n" +
            "  `workName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出自作品名称',\n" +
            "  PRIMARY KEY (`roleId`) USING BTREE\n" +
            ") ENGINE = MyISAM AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色' ROW_FORMAT = DYNAMIC;\n";

    static String CreateManufacturer = "CREATE TABLE IF NOT EXISTS `manufacturer`  (\n" +
            "  `manuName` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '厂商名称',\n" +
            "  `manuLink` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '官网链接',\n" +
            "  PRIMARY KEY (`manuName`) USING BTREE\n" +
            ") ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '手办厂商' ROW_FORMAT = DYNAMIC;\n";

    static String CreateFigureTriggerOnFigurization =
            "CREATE TRIGGER triggerDeleteFigureOnFigurization BEFORE DELETE \n" +
            "ON figure FOR EACH ROW \n" +
            "BEGIN \n" +
            "DELETE FROM figurization WHERE figureId = old.figureId; \n" +
            "END;";

    static String CreateRoleTriggerOnFigurization =
            "CREATE TRIGGER triggerDeleteRoleOnFigurization BEFORE DELETE \n" +
            "ON role FOR EACH ROW \n" +
            "BEGIN \n" +
            "DELETE FROM figurization WHERE roleId = old.roleId; \n" +
            "END;";

    static String CreateFigureTriggerOnSale = "CREATE TRIGGER triggerDeleteFigureOnSale BEFORE DELETE \n" +
            "ON figure FOR EACH ROW \n" +
            "BEGIN \n" +
            "DELETE FROM sale WHERE figureId = old.figureId; \n" +
            "END;";

    static String CreateMerchandiseTriggerOnSale = "CREATE TRIGGER triggerDeleteMerchandiseOnSale BEFORE DELETE \n" +
            "ON merchandise FOR EACH ROW \n" +
            "BEGIN \n" +
            "DELETE FROM sale WHERE merchandiseId = old.merchandiseId; \n" +
            "END;";

    static String CreateMerchandiseTriggerOnImg = "CREATE TRIGGER triggerDeleteMerchandiseOnImg BEFORE DELETE \n" +
            "ON merchandise FOR EACH ROW \n" +
            "BEGIN \n" +
            "DELETE FROM merchandiseimg WHERE merchandiseId = old.merchandiseId; \n" +
            "END;";

    static String CreateRoleTriggerOnImg = "CREATE TRIGGER triggerDeleteRoleOnImg BEFORE DELETE \n" +
            "ON role FOR EACH ROW \n" +
            "BEGIN \n" +
            "DELETE FROM roleimg WHERE roleId = old.roleId; \n" +
            "END;";

    static String CreateFigureTriggerOnImg = "CREATE TRIGGER triggerDeleteFigureOnImg BEFORE DELETE \n" +
            "ON figure FOR EACH ROW \n" +
            "BEGIN \n" +
            "DELETE FROM figureimg WHERE figureId = old.figureId; \n" +
            "END;";

    private static void createTrigger() throws SQLException {
        stmt.execute("DROP TRIGGER IF EXISTS triggerDeleteFigureOnFigurization");
        String CreateFigureTriggerOnFigurization =
                "CREATE TRIGGER triggerDeleteFigureOnFigurization BEFORE DELETE \n" +
                        "ON figure FOR EACH ROW \n" +
                        "BEGIN \n" +
                        "DELETE FROM figurization WHERE figureId = old.figureId; \n" +
                        "END;";
        stmt.execute(CreateFigureTriggerOnFigurization);
        stmt.execute("DROP TRIGGER IF EXISTS triggerDeleteRoleOnFigurization");
        stmt.execute(CreateRoleTriggerOnFigurization);
        stmt.execute("DROP TRIGGER IF EXISTS triggerDeleteFigureOnSale");
        stmt.execute(CreateFigureTriggerOnSale);
        stmt.execute("DROP TRIGGER IF EXISTS triggerDeleteMerchandiseOnSale");
        stmt.execute(CreateMerchandiseTriggerOnSale);
        stmt.execute("DROP TRIGGER IF EXISTS triggerDeleteMerchandiseOnImg");
        stmt.execute(CreateMerchandiseTriggerOnImg);
        stmt.execute("DROP TRIGGER IF EXISTS triggerDeleteRoleOnImg");
        stmt.execute(CreateRoleTriggerOnImg);
        stmt.execute("DROP TRIGGER IF EXISTS triggerDeleteFigureOnImg");
        stmt.execute(CreateFigureTriggerOnImg);
    }

    private static void createRoleImg() throws SQLException {
        stmt.execute(CreateRoleImg);
    }

    private static void createFigureImg() throws SQLException {
        stmt.execute(CreateFigureImg);
    }

    private static void createMerchandiseImg() throws SQLException {
        stmt.execute(CreateMerchandiseImg);
    }

    private static void createCollection() throws SQLException {
        stmt.execute(CreateCollection);
    }

    private static void createComment() throws SQLException {
        stmt.execute(CreateComment);
    }

    private static void createCommentLike() throws SQLException {
        stmt.execute(CreateCommentLike);
    }

    private static void createDealComment() throws SQLException {
        stmt.execute(CreateDealComment);
    }

    private static void createDeal() throws SQLException {
        stmt.execute(CreateDeal);
    }

    private static void createFigurization() throws SQLException {
        stmt.execute(CreateFigurization);
    }

    private static void createMerchandise() throws SQLException {
        stmt.execute(CreateMerchandise);
    }

    private static void createSale() throws SQLException {
        stmt.execute(CreateSale);
    }

    private static void createWork() throws SQLException {
        stmt.execute(CreateWork);
    }

    private static void createUser() throws SQLException {
        stmt.execute(CreateUser);
    }

    private static void createManufacturer() throws SQLException {
        stmt.execute(CreateManufacturer);
    }

    private static void createRole() throws SQLException {
        stmt.execute(CreateRole);
    }

    private static void createFigure() throws SQLException {
        stmt.execute(CreateFigure);
    }

    private static void initStyle() throws SQLException {
        stmt.execute("SET NAMES utf8mb4");
        stmt.execute("SET FOREIGN_KEY_CHECKS = 0");
    }

}
