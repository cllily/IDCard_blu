package com.IDCard.Identify;

/**
 * create by zhouchengchao on 2018/5/18
 */
public class Test {
    public static void main(String[] args) {
        FaceTool ft = new FaceTool();
        IDCard idCard = new IDCard();

        idCard.setCard_path("C:\\Users\\dev2\\Desktop\\Img\\1.jpg");

        ft.Identify(idCard,null);
        System.out.println("idCard:" + idCard.toString());


    }
}
