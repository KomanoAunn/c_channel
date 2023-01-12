package pers.anuu.util.mybatisGenerator;

/**
 * MyBatisPlus代码生成器
 *
 * @author apache.jing
 * @date 2022/03/21 14:43
 */
public class MybatisGenerator {

    public static void tableGenerator(String[] tables, String moduleName) {
        //数据库配置
        String dbUrl = "jdbc:mysql://";
        String dbUser = "";
        String dbPwd = "";
        //项目配置
        String author = "anuu";
        String projectPath = "D:\\workspace10\\c_channel";
        String packageName = "pers.anuu";

        for (String tableName : tables) {
            MysqlGenerator mg = new MysqlGenerator(projectPath, packageName, moduleName, tableName, author, dbUrl, dbUser, dbPwd);
            mg.execute();
        }
    }

    private static void doris() {
        String[] tables = new String[]{
                "a_user",
                "b_not_book_tag",
                "b_note_book"
        };
        tableGenerator(tables, "base");
    }

    public static void main(String[] args) {
        doris();
    }
}
