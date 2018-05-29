package com.IDCard.Identify;

/**
 * create by zhouchengchao on 2018/5/18
 */
public class IDCard {

        private String card_path; // card path ,as the indentify ID
        private String name;      //name
        private String gender;    // sex
        private String adress;    //adress
        private String side ;     //front or back
        private String id_card_number;  //id number
        private String race;        //race
        private int type;           //1--ID-card
        private String birthday;    //birthdat
        private String issued_by;   // made by
        private String valid_day;   // 1995.11.28-2015.11.28

    public String getCard_path() {
        return card_path;
    }

    public void setCard_path(String card_path) {
        this.card_path = card_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getId_card_number() {
        return id_card_number;
    }

    public void setId_card_number(String id_card_number) {
        this.id_card_number = id_card_number;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIssued_by() {
        return issued_by;
    }

    public void setIssued_by(String issued_by) {
        this.issued_by = issued_by;
    }

    public String getValid_day() {
        return valid_day;
    }

    public void setValid_day(String valid_day) {
        this.valid_day = valid_day;
    }

    @Override
    public String toString() {
        return "IDCard{" +
                "card_path='" + card_path + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", adress='" + adress + '\'' +
                ", side='" + side + '\'' +
                ", id_card_number='" + id_card_number + '\'' +
                ", race='" + race + '\'' +
                ", type=" + type +
                ", birthday='" + birthday + '\'' +
                ", issued_by='" + issued_by + '\'' +
                ", valid_day='" + valid_day + '\'' +
                '}';
    }

    public String toJSonString() {
        return "[" +
                "'card_path':'" +card_path + "',\n" +
                "'name':'" +name + "',\n" +
                "'gender':'" +gender + "',\n" +
                "'adress':'" +adress + "',\n" +
                "'side':'" +side + "',\n" +
                "'id_card_number':'" +id_card_number + "',\n" +
                "'race':'" +race + "',\n" +
                "'type':'" +type + "',\n" +
                "'birthday':'" +birthday + "',\n" +
                "'issued_by':'" +issued_by + "',\n" +
                "'valid_day':'" +valid_day + "',\n" +
                ']';
    }

}
