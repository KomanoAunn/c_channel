package pers.anuu;

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
public class JasyptGenerator {

    @Autowired
    private StringEncryptor codeSheepEncryptorBean;

    @Test
    public void test() {
        String mysqlOriginUrl = "jdbc:mysql://?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
        String mysqlOriginUsername = "";
        String mysqlOriginPswd = "";
        // 加密
        String mysqlEncryptedUrl = encrypt(mysqlOriginUrl);
        String mysqlEncryptedUsername = encrypt(mysqlOriginUsername);
        String mysqlEncryptedPswd = encrypt(mysqlOriginPswd);

        // 打印加密前后的结果对比
        System.out.println("MySQL原始明文url为：" + mysqlOriginUrl);
        System.out.println("MySQL原始明文用户名为：" + mysqlOriginUsername);
        System.out.println("MySQL原始明文密码为：" + mysqlOriginPswd);
        System.out.println("====================================");
        System.out.println("MySQL原始明文url加密后的结果为：" + mysqlEncryptedUrl);
        System.out.println("MySQL原始明文用户名加密后的结果为：" + mysqlEncryptedUsername);
        System.out.println("MySQL原始明文密码加密后的结果为：" + mysqlEncryptedPswd);
    }

    @Test
    public void test2() {


        String mysqlEncryptedUrl = "D4Bpa47bDpHBHo1Cke6SNyFs2tD6vSJvls8ltCJ13LFjliDekm7wEnd0qvgVN0IZrihlrMYrYPk+FTkTmTAcBKh61B32imoJDSYSSt8AYC0HYz8WAY05oiQjjr4+sI1CneWNQG/9yeLCcQ/RuEQ7ebvQXkEZbNdIh5r1tQmpfCbwRwAz8aRaGX+LpEAX4eZM";
        String mysqlOriginUrl = decrypt(mysqlEncryptedUrl);
        System.out.println("MySQL密文密码解密后的结果为：" + mysqlOriginUrl);
    }

    private String encrypt(String originPassord) {
        String encryptStr = codeSheepEncryptorBean.encrypt(originPassord);
        return encryptStr;
    }

    private String decrypt(String encryptedPassword) {
        String decryptStr = codeSheepEncryptorBean.decrypt(encryptedPassword);
        return decryptStr;
    }
}
