package net.greatsoft.foodon.showcase.ibatis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by foodon on 2014/10/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/springroot-prop.xml",
        "classpath:spring/springroot-jdbc.xml",
        "classpath:spring/springroot-ibatis.xml"})
public class SqlMapClientTemplateTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private SqlMapClientTemplate sqlMapClientTemplate;

    @Test
    public void testInitTemplate() {
        Assert.assertNotNull(sqlMapClientTemplate);
    }

    @Test
    public void testQueryForObject() {
        Object count = sqlMapClientTemplate.queryForObject("countUser");
        logger.debug(count.toString());
    }

    @Transactional
    public void testDelete() {
        sqlMapClientTemplate.delete("deleteFromUserWhereUserIdIs0");
    }
}
