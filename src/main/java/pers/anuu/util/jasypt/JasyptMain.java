package pers.anuu.util.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author pangxiong
 * @title: JasyptMain
 * @projectName c_channel
 * @description: TODO
 * @date 2023/1/1217:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptMain {

    @Autowired
    private StringEncryptor codeSheepEncryptorBean;

    @Test
    public void test() {
        String mysqlOriginUrl="jdbc:mysql://";
        String mysqlOriginUsername="";
        String mysqlOriginPswd="";

        // 加密
        String mysqlEncryptedUrl=encrypt( mysqlOriginUrl );
        String mysqlEncryptedUsername = encrypt( mysqlOriginUsername );
        String mysqlEncryptedPswd = encrypt( mysqlOriginPswd );

        // 打印加密前后的结果对比
        System.out.println( "MySQL原始明文url为：" + mysqlOriginUrl );
        System.out.println( "MySQL原始明文用户名为：" + mysqlOriginUsername );
        System.out.println( "MySQL原始明文密码为：" + mysqlOriginPswd );
        System.out.println( "====================================" );
        System.out.println( "MySQL原始明文url加密后的结果为：" + mysqlEncryptedUrl );
        System.out.println( "MySQL原始明文用户名加密后的结果为：" + mysqlEncryptedUsername );
        System.out.println( "MySQL原始明文密码加密后的结果为：" + mysqlEncryptedPswd );
    }

    private String encrypt( String originPassord ) {
        String encryptStr = codeSheepEncryptorBean.encrypt( originPassord );
        return encryptStr;
    }

    private String decrypt( String encryptedPassword ) {
        String decryptStr = codeSheepEncryptorBean.decrypt( encryptedPassword );
        return decryptStr;
    }
}
