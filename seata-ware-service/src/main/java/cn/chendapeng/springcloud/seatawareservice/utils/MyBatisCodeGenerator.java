package cn.chendapeng.springcloud.seatawareservice.utils;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * 博客：https://chendapeng.cn - 行百里者半九十，凡事善始善终，吾将上下而求索！
 * 公众号：行百里er
 *
 * @author 行百里者
 * @date 2022-09-01 16:30
 */
public class MyBatisCodeGenerator {
    /**
     * 数据库连接配置
     */
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://192.168.242.112:3306/seata-ware?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private static final String JDBC_USER_NAME = "zhangsan";
    private static final String JDBC_PASSOWRD = "Fawai@kuangtu6";

    /**
     * 包名和模块名
     */
    private static final String PACKAGE_NAME = "cn.chendapeng.springcloud.seatawareservice";
    private static final String MODULE_NAME = "ware";

    /**
     * 表名，多个表使用英文逗号分割
     */
    private static final String TBL_NAMES = "t_ware";

    /**
     * 表名的前缀，根据表生成代码时会去掉前缀
     */
    private static final String TABLE_PREFIX = "t_";

    /**
     * 全局配置
     * @return GlobalConfig
     */
    private static GlobalConfig getGlobalConfig() {
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir") + "/seata-ware-service";

        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("行百里er");
        gc.setOpen(false);
        // 自定义生成的ServiceName，去掉默认的ServiceName前面的I
        gc.setServiceName("%s" + ConstVal.SERVICE);
        gc.setDateType(DateType.ONLY_DATE);
        return gc;
    }

    /**
     * 数据源配置
     * @return DataSourceConfig
     */
    private static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDriverName(JDBC_DRIVER);
        dsc.setUrl(JDBC_URL);
        dsc.setUsername(JDBC_USER_NAME);
        dsc.setPassword(JDBC_PASSOWRD);
        return dsc;
    }

    /**
     * 包配置
     * @return PackageConfig
     */
    private static PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setParent(PACKAGE_NAME);
        pc.setMapper("dao");
        return pc;
    }

    /**
     * 自定义配置
     * @return InjectionConfig
     */
    private static InjectionConfig getInjectionConfig() {

        // 这里模板引擎使用的是freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        String projectPath = System.getProperty("user.dir") + "/seata-ware-service";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper"
                        + StringPool.DOT_XML;
            }
        });

        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    /**
     * 模板配置
     * @return TemplateConfig
     */
    private static TemplateConfig getTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        return templateConfig;
    }

    /**
     * 策略配置
     * @return StrategyConfig
     */
    private static StrategyConfig getStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        // 下划线转驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(TBL_NAMES.split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix(TABLE_PREFIX);
        return strategy;
    }

    public static void main(String[] args) {
        // 0.代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 1.全局配置
        GlobalConfig gc = getGlobalConfig();
        mpg.setGlobalConfig(gc);

        // 2.数据源配置
        DataSourceConfig dsc = getDataSourceConfig();
        mpg.setDataSource(dsc);

        // 3.包配置
        PackageConfig pc = getPackageConfig();
        mpg.setPackageInfo(pc);

        // 4.自定义配置
        InjectionConfig cfg = getInjectionConfig();
        mpg.setCfg(cfg);

        // 5.模板配置
        TemplateConfig templateConfig = getTemplateConfig();
        mpg.setTemplate(templateConfig);
        // 使用Freemarker模板引擎
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 6.策略配置
        StrategyConfig strategy = getStrategyConfig();
        mpg.setStrategy(strategy);

        // 7.开始生成代码
        mpg.execute();
    }
}
