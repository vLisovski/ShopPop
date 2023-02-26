package org.homework.servlets.model;

public class Card {

  private String title;
  private String text;
  private String imgUrl;

    public Card(String title, String cardText, String cardImgUrl){
        this.title = title;
        this.text = cardText;
        this.imgUrl = cardImgUrl;
    }

}
