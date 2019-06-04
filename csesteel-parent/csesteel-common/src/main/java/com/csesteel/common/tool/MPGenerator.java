package com.csesteel.common.tool;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MPGenerator {	
public static void main(String[] args) {
	 AutoGenerator mpg = new AutoGenerator();
	 
     //MyBatis-Plus 全局策略配置
     GlobalConfig gc = new GlobalConfig();
     //生成文件的输出目录【默认 D 盘根目录】
     gc.setOutputDir("D://Cache//MPGenerator");
     //是否覆盖已有文件
     gc.setFileOverride(true);
     //开启 ActiveRecord 模式
     gc.setActiveRecord(true);
     //是否在xml中添加二级缓存配置
     gc.setEnableCache(false);
     //开启 BaseResultMap
     gc.setBaseResultMap(true);
     //开启 baseColumnList
     gc.setBaseColumnList(true);
     // 开发人员
     gc.setAuthor("wangtao");

     // 自定义文件命名，注意 %s 会自动填充表实体属性！
     gc.setMapperName("%sMapper");
     gc.setXmlName("%sMapper");
     gc.setServiceName("%sService");
     gc.setServiceImplName("%sService");//%sServiceImpl
     gc.setControllerName("%sController");
     mpg.setGlobalConfig(gc);

     // 数据源配置
     DataSourceConfig dsc = new DataSourceConfig();
     dsc.setDbType(DbType.ORACLE);
     dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
     dsc.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
     dsc.setUsername("c##scott");
     dsc.setPassword("accp");
     mpg.setDataSource(dsc);

     // 策略配置
     StrategyConfig strategy = new StrategyConfig();
  
     strategy.setTablePrefix(new String[] { "t_m_", "t_p_", "t_s_", "t_r_", "t_c_"});// 此处可以修改为您的表前缀
     strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
     strategy.setInclude(new String[] {"DEPT"}); // 需要生成的表
     // strategy.setExclude(new String[]{"test"}); // 排除生成的表
     mpg.setStrategy(strategy);

     // 包配置
     PackageConfig pc = new PackageConfig();
     pc.setParent("src");
//     pc.setModuleName("member");
     mpg.setPackageInfo(pc);

     // 执行生成
     mpg.execute();
     
}
}
