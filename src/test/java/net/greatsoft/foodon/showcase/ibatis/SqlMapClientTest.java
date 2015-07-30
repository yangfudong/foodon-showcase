package net.greatsoft.foodon.showcase.ibatis;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

/**
 * Created by foodon on 2014/9/11.
 */
public class SqlMapClientTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static SqlMapClient sqlMapClient;

    @BeforeClass
    public static void beforeClass() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("ibatis/ibatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
    }

    @Test
    public void testQueryForObject() {
        Object c = null;
        try {
            c = sqlMapClient.queryForObject("countUser");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.debug(c.toString());
    }

    @Test
    public void testQueryForMap() {

    }

    @Test
    public void testQueryForList() {

    }
}
