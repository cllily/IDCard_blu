package com.IDCard.Identify;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * create by zhouchengchao on 2018/5/18
 */
public class Img {

    private String imageUrl;   //loacation
    private byte[] fileByte;           //filebyte
    private  String image_base64;      //filestring
    public static BASE64Encoder encoder=new BASE64Encoder();
    public static BASE64Decoder decoder=new BASE64Decoder();

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public byte[] getFileByte() {
        return fileByte;
    }

    public void setFileByte(byte[] fileByte) {
        this.fileByte = fileByte;
    }

    public String getImage_base64() {
        return image_base64;
    }

    public void setImage_base64(String image_base64) {
        this.image_base64 = image_base64;
    }


    public    String getImageBinary(String path){

        File f=new File(path);
        try{
            BufferedImage bi=ImageIO.read(f);

            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            ImageIO.write(bi,"jpg",byteArrayOutputStream);
            byte[] bytes=byteArrayOutputStream.toByteArray();
            return encoder.encodeBuffer(bytes).trim();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static void base64StringtoImage( String base64String){
        try {
            byte[] bytes=decoder.decodeBuffer(base64String);
            ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
            BufferedImage bufferedImage=ImageIO.read(byteArrayInputStream);
          //  File f1=new File("e://out.jpg");
          //  ImageIO.write(bufferedImage,"jpg",f1);
            System.out.println("out.jpg");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public  Img(String url){
        this.imageUrl=url;
        this.image_base64= this.getImageBinary(url);
        try {
            this.fileByte=decoder.decodeBuffer(url);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
   public Img(byte[] fileByte){
        this.fileByte=fileByte;


    }

}
