package pers.anuu.util.mybatisGenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码自动生成
 *
 * @author apache.jing
 * @date 2019/5/23 23:33
 */
@Data
public class MysqlGenerator {

    private String projectPath;
    private String packageName;
    private String moduleName;
    private String tableName;
    private String author;
    private String dbUrl;
    private String dbUser;
    private String dbPwd;

    private AutoGenerator mpg;

    public MysqlGenerator(String projectPath, String packageName, String moduleName, String tableName, String author, String dbUrl, String dbUser, String dbPwd) {
        this.setProjectPath(projectPath);
        this.setPackageName(packageName);
        this.setModuleName(moduleName);
        this.setTableName(tableName);
        this.setAuthor(author);
        this.setDbUrl(dbUrl);
        this.setDbUser(dbUser);
        this.setDbPwd(dbPwd);
    }

    //执行生产
    public void execute() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        this.setMpg(mpg);
        // 全局配置
        mpg.setGlobalConfig(getGlobalConfig());
        // 数据源配置
        mpg.setDataSource(getDataSourceConfig());
        // 包配置
        mpg.setPackageInfo(getPackageConfig());
        // 自定义配置
        mpg.setCfg(getInjectionConfig());
        // 模板配置
        mpg.setTemplate(getTemplateConfig());
        // 策略配置
        mpg.setStrategy(getStrategyConfig());

        // 选择 freemarker 引擎需要指定如下加，注意 pom 依赖必须有！
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

    // 全局配置
    public GlobalConfig getGlobalConfig() {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(getProjectPath() + "/src/main/java");
        gc.setAuthor(getAuthor());
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        gc.setEnableCache(false);
        gc.setDateType(DateType.ONLY_DATE);//时间类型
        gc.setControllerName(null);
        return gc;
    }

    // 数据源配置
    public DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl(getDbUrl());
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(getDbUser());
        dsc.setPassword(getDbPwd());
        return dsc;
    }

    // 包配置
    public PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setParent(getPackageName());
        pc.setModuleName(getModuleName());
        pc.setEntity("model");
        pc.setMapper("mapper");
        return pc;
    }

    // 自定义配置
    public InjectionConfig getInjectionConfig() {
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                String outPath = getProjectPath() + "/src/main/resources/" + getMpg().getPackageInfo().getParent().replaceAll("\\.", "/") + "/" + getMpg().getPackageInfo().getMapper() + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                return outPath;
            }
        });
        cfg.setFileOutConfigList(focList);
        return cfg;
    }

    // 模板配置
    public TemplateConfig getTemplateConfig() {
        TemplateConfig tc = new TemplateConfig();
        tc.setController(null);//不生成controller
        tc.setXml(null);//不生成默认的mapper.xml
        return tc;
    }

    // 策略配置
    public StrategyConfig getStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setSuperEntityClass("com.pgy.BaseEntity");
        strategy.setEntityLombokModel(true);
//        strategy.setSuperControllerClass("com.pgy.BaseController");
        strategy.setRestControllerStyle(false);
        strategy.setInclude(getTableName());//表名
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setEntityColumnConstant(true);//字段常量
        strategy.setEntityTableFieldAnnotationEnable(true);//会在字段属性上加上@TableField
//        strategy.setTablePrefix(pc.getModuleName() + "_");//会在类上加上@TableName
        return strategy;
    }


}
