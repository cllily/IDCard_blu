package com.IDCard.Identify;

import com.IDCard.http.CardOperate;
import com.IDCard.http.Response;


import java.util.HashMap;

/**
 * create by zhouchengchao on 2018/5/18
 */
public class FaceTool {
    private  String Api_Key;
    private  String Api_Secret;
    private static CardOperate co;
    private static Response rs;
    private String cards;
    private String returnContents;
    private HashMap<String,String> ReturnMap;
    private HashMap<String,String> CardsMap;


    Img img;

    public String getApi_Key() {
        return Api_Key;
    }

    public void setApi_Key(String api_Key) {
        Api_Key = api_Key;
    }

    public String getApi_Secret() {
        return Api_Secret;
    }

    public void setApi_Secret(String api_Secret) {
        Api_Secret = api_Secret;
    }
    public FaceTool(){
        this.Api_Key="F70Yb4KkHP6Nqh4JpKYMjjTO64SBIorr";
        this.Api_Secret="rBSfmCXpdECEDD4bucBsH44h7V2k0Mkw";
        co=new CardOperate(this.Api_Key,this.Api_Secret);
        ReturnMap=new HashMap<String, String>();
        CardsMap=new HashMap<String, String>();

    }
    public FaceTool(String Api_Key, String Api_Sercret){
        this.Api_Key=Api_Key;
        this.Api_Secret=Api_Sercret;
        co=new CardOperate(Api_Key,Api_Secret);
    }

    public   HashMap<String ,String>  Contet_get(String contents){  // get the key and value from string
        HashMap<String,String> map =new HashMap<String, String>() ;
        // contents.contains("")
        //StringBuffer sb=new StringBuffer(contents);
        int start=2;
        int end;
        String key="";
        String value;


        int temp;
        for(int i=0;i<contents.length()-1;i++){
            // temp=0;
            // key=null;

            char c=contents.charAt(i);

            if(key.equals("cards")){     //put cards!!!!!!!!
                temp=contents.indexOf("cards");
                while(contents.charAt(temp) !='{'){
                    temp++;
                    i++;

                    // System.out.println(contents.charAt(temp));
                }
                start=temp;

                while(contents.charAt(temp)!='}'){
                    temp++;
                    i++;
                }

                System.out.println(start+"-"+temp);
                value =contents.substring(start,temp+1);
                map.put(key,AsciiToUTF(value));
                key="";
                start=temp+5;  //
                i=start;


            }


            if( c==',' ) {      //value end,key start
                temp = i - 1;
                if( contents.charAt(temp) == '"') temp--;  //skip "

                value = contents.substring(start, temp+1);

                map.put(key,AsciiToUTF(value));

                temp = ++i;
                if (contents.charAt(temp) == ' ' ) {  //skip  space
                    temp++;
                    i++;
                }
                if( contents.charAt(temp) == '"') {   //skip "
                    temp++;
                    i++;
                }

                start=temp;
            }



            if(c==':'){   //key end ,value start
                temp=i-1;

                if( contents.charAt(temp) == '"') temp--;  //skip "
                key=contents.substring(start,temp+1);


                temp=++i;
                if(contents.charAt(temp) == ' ' ) {  //skip  space
                    temp++;
                    i++;
                }
                if( contents.charAt(temp) == '"') {   //skip "
                    temp++;
                    i++;
                }
                start=temp;


            }



        }
        //the last one
        if(contents.charAt(contents.length()-2)=='"')     value=contents.substring(start,contents.length()-2);
        else     value=contents.substring(start,contents.length()-1);

        map.put(key,AsciiToUTF(value));
        return map;

    }
    public  String AsciiToUTF(String asicii){
        String[] sp=asicii.split("\\\\u");
        String result=sp[0];
        for (int i=1;i<sp.length;i++){
            String s1=sp[i];
            result+=(char)Integer.parseInt(s1.substring(0,4),16);
            if(s1.length()>4){
                result+=s1.substring(4,s1.length());
            }
        }
        return result;

    }
    public  void Identify(IDCard idCard, Img img) {
        if (idCard.getCard_path() == null ){
            System.out.println("by img");
            if(img==null) return ;
        } else {                         //
          //  System.out.println(idCard.toString());
            System.out.println("by path");
            img = new Img(idCard.getCard_path());
           // img.setImage_base64();
            img.base64StringtoImage(img.getImage_base64());
            //img.setImage_base64(img.getImage_base64());
        }
        try {
            rs=co.ocrIDcard(null,null, img.getImage_base64(), 0);
            System.out.println(rs.getContent());
            returnContents=new String(rs.getContent());
            System.out.println(returnContents);
            ReturnMap = this.Contet_get(returnContents);
            cards=ReturnMap.get("cards");
            System.out.println(cards);
            CardsMap=this.Contet_get(cards);
            idCard.setAdress(CardsMap.get("address"));
            idCard.setBirthday(CardsMap.get("birthday"));
            idCard.setGender(CardsMap.get("gender"));
            idCard.setRace(CardsMap.get("race"));
            idCard.setId_card_number(CardsMap.get("id_card_number"));
            idCard.setName(CardsMap.get("name"));
            idCard.setSide(CardsMap.get("side"));
            idCard.setIssued_by(CardsMap.get("issued_by"));
            idCard.setValid_day(CardsMap.get("valid_date"));
            idCard.setType(Integer.parseInt(CardsMap.get("type")));
            System.out.println(idCard.toString());



        }catch ( Exception e){
            e.printStackTrace();
        }
    }


}
