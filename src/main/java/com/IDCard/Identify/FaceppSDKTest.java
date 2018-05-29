package com.IDCard.Identify;//package Identify;
//
//import com.fasterxml.jackson.databind.util.JSONPObject;
//import http.CardOperate;
//import http.ImageOperate;
//import http.Response;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//import javax.imageio.ImageIO;
//import javax.net.ssl.SSLException;
//import javax.xml.stream.events.EndDocument;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Random;
//
///**
// * create by zhouchengchao on 2018/5/17
// */
//public class FaceppSDKTest {
//   public static BASE64Encoder encoder=new BASE64Encoder();
//   public static   BASE64Decoder decoder=new BASE64Decoder();
//
//    public static byte[] getBytesFromFile(File f){
//        try{
//            FileInputStream fileInputStream=new FileInputStream(f);
//            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(1000);
//            byte[] b=new byte[1000];
//            int n;
//            while ((n=fileInputStream.read(b))!=-1){
//                byteArrayOutputStream.write(b,0,n);
//                fileInputStream.close();
//                byteArrayOutputStream.close();
//                return byteArrayOutputStream.toByteArray();
//            }
//        }catch (FileNotFoundException e){
//            return null;
//        }catch (IOException e){
//            return null;
//        }
//        return null;
//
//    }
//
//    public  static  String getImageBinary(String path){
//        File f=new File(path);
//        try{
//            BufferedImage bi=ImageIO.read(f);
//            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//            ImageIO.write(bi,"jpg",byteArrayOutputStream);
//            byte[] bytes=byteArrayOutputStream.toByteArray();
//            return encoder.encodeBuffer(bytes).trim();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    public static void base64StringtoImage( String base64String){
//        try {
//            byte[] bytes=decoder.decodeBuffer(base64String);
//            ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
//            BufferedImage bufferedImage=ImageIO.read(byteArrayInputStream);
//            File f1=new File("d://out.jpg");
//            ImageIO.write(bufferedImage,"jpg",f1);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//    }
//    public static String decodeUnicode(final String dataStr) {
//        int start = 0;
//        int end = 0;
//        final StringBuffer buffer = new StringBuffer();
//        while (start > -1) {
//            end = dataStr.indexOf("\\u", start + 2);
//            String charStr = "";
//            if (end == -1) {
//                charStr = dataStr.substring(start + 2, dataStr.length());
//            } else {
//                charStr = dataStr.substring(start + 2, end);
//            }
//            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
//            buffer.append(new Character(letter).toString());
//            start = end;
//        }
//        return buffer.toString();
//    }
//
//
////
//public static  HashMap<String ,String>  Contet_get(String contents){  // get the key and value from string
//    HashMap<String,String> map =new HashMap<String, String>() ;
//    // contents.contains("")
//    //StringBuffer sb=new StringBuffer(contents);
//    int start=2;
//    int end;
//    String key="";
//    String value;
//
//
//    int temp;
//    for(int i=0;i<contents.length()-1;i++){
//        // temp=0;
//        // key=null;
//
//        char c=contents.charAt(i);
//
//        if(key.equals("cards")){     //put cards!!!!!!!!
//            temp=contents.indexOf("cards");
//            while(contents.charAt(temp) !='{'){
//                temp++;
//                i++;
//
//                // System.out.println(contents.charAt(temp));
//            }
//            start=temp;
//
//            while(contents.charAt(temp)!='}'){
//                temp++;
//                i++;
//            }
//
//            System.out.println(start+"-"+temp);
//            value =contents.substring(start,temp+1);
//            map.put(key,value);
//            key="";
//            start=temp+5;  //
//            i=start;
//
//
//        }
//
//
//        if( c==',' ) {      //value end,key start
//            temp = i - 1;
//            if( contents.charAt(temp) == '"') temp--;  //skip "
//
//            value = contents.substring(start, temp+1);
//            map.put(key, value);   //value end
//
//            temp = ++i;
//            if (contents.charAt(temp) == ' ' ) {  //skip  space
//                temp++;
//                i++;
//            }
//            if( contents.charAt(temp) == '"') {   //skip "
//                temp++;
//                i++;
//            }
//
//            start=temp;
//        }
//
//
//
//        if(c==':'){   //key end ,value start
//            temp=i-1;
//
//            if( contents.charAt(temp) == '"') temp--;  //skip "
//            key=contents.substring(start,temp+1);
//
//
//            temp=++i;
//            if(contents.charAt(temp) == ' ' ) {  //skip  space
//                temp++;
//                i++;
//            }
//            if( contents.charAt(temp) == '"') {   //skip "
//                temp++;
//                i++;
//            }
//            start=temp;
//
//
//        }
//
//
//
//    }
//    //the last one
//    if(contents.charAt(contents.length()-2)=='"')     value=contents.substring(start,contents.length()-2);
//    else     value=contents.substring(start,contents.length()-1);
//
//    map.put(key,value);
//    return map;
//
//}
//    public static void main(String[] args) {
//        String Api_url="https://api-cn.faceplusplus.com/cardpp/v1/ocridcard";
//        String Api_key="F70Yb4KkHP6Nqh4JpKYMjjTO64SBIorr";
//        String Api_Secret="rBSfmCXpdECEDD4bucBsH44h7V2k0Mkw";
//        String path="C:\\Users\\dev2\\Desktop\\Img\\2.jpg";
//        String image_url="http://img1.imgtn.bdimg.com/it/u=680756696,610110959&fm=27&gp=0.jpg";
//
//       // base64StringtoImage(getImageBinary(path));
//
//        String Image_string=getImageBinary(path);
//        try {
//            byte[] Image_byte=decoder.decodeBuffer(Image_string);
//            System.out.println(Image_string);
//            CardOperate co=new CardOperate(Api_key,Api_Secret);
//            ImageOperate io=new ImageOperate(Api_key,Api_Secret);
//            Response rs;
//            rs=co.ocrIDcard(null,Image_byte,Image_string,0);
//            System.out.println(rs.getStatus()+"    "+new String(rs.getContent()));
//            String cos=new String(rs.getContent(),"GBK");
//
//            HashMap<String,String> map=Contet_get(cos);
//            Map.Entry<String ,String> en;
//            for(Iterator<Map.Entry<String,String>> it=map.entrySet().iterator();it.hasNext();){
//                en=it.next();
//                System.out.println(en.getKey()+"-----"+en.getValue());
//            }
//            System.out.println("------------------------------------------------------------------------------------");
//            String cards=map.get("cards");
//            System.out.println(cards);
//            HashMap<String,String> cards_map=Contet_get(cards);
//
//            for(Iterator<Map.Entry<String,String>> it=cards_map.entrySet().iterator();it.hasNext();){
//                en=it.next();
//                System.out.println(en.getKey()+"-----"+en.getValue());
//            }
//
//
//           // System.out.println(map.toString());
//
//            rs.getContent();
//            // byte[] b1=new byte[100];
//            // Map<String ,String> map=b1.
//          //  JSONObject j1=new JSONPObject(new String("sss"));
//            rs=io.textRecognition(null,Image_byte,Image_string);
//          //  System.out.println(rs.getStatus()+"    "+new String(rs.getContent()));
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//     }
//
//}
