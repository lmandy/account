package com.lmandy.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by 94993 on 2017/3/1.
 */
public class EntityMysqlUtil {

    private String packageOutPath = "com.lmandy.bean";//生成实体路径
    private String tableName;
    private String authorName = System.getProperties().getProperty("user.name");
    private String[] colNames;
    private String[] colTypes;

    public EntityMysqlUtil(String tableName){
        this.tableName = tableName;
        createBean();
    }

    public void createBean(){

        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("jdbc.driver");
        String url = bundle.getString("jdbc.url");
        String userName = bundle.getString("jdbc.username");
        String password = bundle.getString("jdbc.password");

        Connection conn = null;
        PreparedStatement statement = null;
        //生成实体sql
        String sql = "select * from "+ tableName;

        try {
            Class clazz = Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, password);
            statement = conn.prepareStatement(sql);
            ResultSetMetaData metaData = statement.getMetaData();



            colNames = new String[metaData.getColumnCount()];
            colTypes = new String[metaData.getColumnCount()];

            for (int i = 0; i < metaData.getColumnCount(); i++) {
                colNames[i] = metaData.getColumnName(i+1);
                colTypes[i] = metaData.getColumnTypeName(i+1);
                System.out.println(colNames[i]+":"+colTypes[i]);
            }
            String str = parse();
            File file = new File("");
            String path = file.getAbsolutePath()+"/src/main/java/";

            FileWriter fw = new FileWriter(path + packageOutPath.replace(".","\\")+"/"+initCap(tableName)+".java");
            PrintWriter pw = new PrintWriter(fw);
            pw.print(str);
            pw.flush();
            pw.close();
            System.out.println("创建成功！");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String parse(){
        StringBuffer sb = new StringBuffer();
        sb.append("package " + packageOutPath+";\r\n");
        sb.append("\r\n");
        sb.append("/**\r\n");
        sb.append(" * Created by " + authorName + " on " + DateUtil.dateToString(new Date(),"yyyy/MM/dd")+"\r\n");
        sb.append(" */\r\n");
        sb.append("public class " + initCap(tableName) + " {\r\n");
        //生成属性
        createAttribute(sb);
        //生成方法
        createMethod(sb);

        sb.append("}");

        return sb.toString();
    }

    /**
     * 生成属性
     * @param sb
     */
    public void createAttribute(StringBuffer sb){

        sb.append("\r\n");
        for (int i = 0; i < colNames.length; i++) {
            sb.append("\t" + "private " + sqlType2JavaType(colTypes[i]) + " " + colNames[i]+";");
            sb.append("\r\n");
        }
    }
    /**
     * 生成方法
     */
    public void createMethod(StringBuffer sb){
        sb.append("\r\n");
        for (int i = 0; i < colNames.length; i++) {
            //get方法
            sb.append("\t" + "public " + sqlType2JavaType(colTypes[i]) + " " + "get"+initCap(colNames[i])+"() {\r\n");
            sb.append("\t\t" + "return " + colNames[i] +";\r\n");
            sb.append("\t}\r\n");
            //set方法
            sb.append("\t" + "public void set" + initCap(colNames[i])+"(" + sqlType2JavaType(colTypes[i]) + " " + colNames[i] +") {\r\n");
            sb.append("\t\t" + "this." + colNames[i] + " = " + colNames[i] + ";\r\n");
            sb.append("\t}");

            sb.append("\r\n");
        }
    }

    /**
     * 获取列字段数据类型
     */
    public String sqlType2JavaType(String type){
        String resultType = null;
        switch (type){
            case "INT":     resultType = "Integer";     break;
            case "TINYINT ":resultType = "Integer";     break;
            case "BIGINT ": resultType = "BigeInteger"; break;
            case "BIT":     resultType = "Boolean";     break;
            case "VARCHAR": resultType = "String";      break;
            case "TEXT":    resultType = "String";      break;
            case "FLOAT":   resultType = "Float";       break;
            case "DOUBLE":  resultType = "Double";      break;
            case "DECIMAL": resultType = "BigDecimal";  break;
            case "BOOLEAN": resultType = "Integer";     break;
            case "BLOB":    resultType = "byte[]";      break;
            default:        resultType = "String";      break;
        }
        return resultType;
    }

    /**
     * 将输入字符串的首字母改成大写
     * @return
     */
    public String initCap(String str){
        StringBuffer sb = new StringBuffer();
        String[] sp = str.split("_");
        for (String s : sp) {
            sb.append(new StringBuffer(s).replace(0,1,String.valueOf(s.toCharArray()[0]).toUpperCase()).toString());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        //表名称
        new EntityMysqlUtil("account_system_user_role");
    }
}
