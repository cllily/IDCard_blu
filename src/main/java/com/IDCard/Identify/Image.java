package com.IDCard.Identify;//package Identify;
//
///**
// * create by zhouchengchao on 2018/5/17
// */
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Random;
//import javax.net.ssl.SSLException;
//import javax.swing.text.html.parser.Entity;
//
//public class Image {
//
//    public static byte[] getBytesFromFile(File f) {
//        try {
//            FileInputStream fileInputStream = new FileInputStream(f);
//            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1000);
//            byte[] b = new byte[1000];
//            int n;
//            while ((n = fileInputStream.read(b)) != -1) {
//                byteArrayOutputStream.write(b, 0, n);
//                fileInputStream.close();
//                byteArrayOutputStream.close();
//                return byteArrayOutputStream.toByteArray();
//            }
//        } catch (FileNotFoundException e) {
//            return null;
//        } catch (IOException e) {
//            return null;
//        }
//        return null;
//
//    }
//
//
//    public static void main(String[] args) throws Exception {
//        String api_url = "https://api-cn.faceplusplus.com/cardpp/v1/ocridcard";
//
//        File file = new File("C:\\Users\\dev2\\Desktop\\Img\\3.jpg");
//        byte[] buff = getBytesFromFile(file);
//        // String url = "https://api-cn.faceplusplus.com/facepp/v3/detect";
//        //url=api_url;
//        HashMap<String, String> map = new HashMap<String, String>();
//        HashMap<String, byte[]> byteMap = new HashMap<String, byte[]>();
//        map.put("api_key", "F70Yb4KkHP6Nqh4JpKYMjjTO64SBIorr");       //key
//        map.put("api_secret", "rBSfmCXpdECEDD4bucBsH44h7V2k0Mkw");    //secret
//        map.put("image_file", new String(buff));                      // img
//        HttpURLConnection conn;
//        URL url;
//        try {
//            StringBuilder sb = new StringBuilder();
//            sb.append("?");
//            Map.Entry<String, String> en;
//            for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
//                en = it.next();
//                sb.append(en.getKey() + "=" + URLEncoder.encode(en.getValue(), "utf-8") + (it.hasNext() ? "&" : ""));
//            }
//            url = new URL(api_url + sb);
//            conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setConnectTimeout(5000);
//            conn.setReadTimeout(5000);
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(conn.getInputStream());
//            Reader reader = new InputStreamReader(bufferedInputStream, "GBK");
//            char[] buffer = new char[1000];
//            int len;
//            CharArrayWriter charArrayWriter = new CharArrayWriter();
//            while ((len = reader.read(buffer)) > -1) {
//                charArrayWriter.write(buffer, 0, len);
//            }
//
//            reader.close();
//            bufferedInputStream.close();
//            conn.disconnect();
//            System.out.println(charArrayWriter.toString());
//
//
//        } catch (Exception e) {
//
//        }
//
//    }
//}
