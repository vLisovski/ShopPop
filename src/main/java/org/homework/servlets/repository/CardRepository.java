package org.homework.servlets.repository;

import org.homework.servlets.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CardRepository {

    private List<Card> cardList;

    private CardRepository(){
        cardList = new ArrayList<>();
    }

    private static CardRepository instance = null;

    public static CardRepository getInstance(){
        if(instance==null){
            instance=new CardRepository();

            Collections.addAll(instance.cardList,
                    new Card("Торшер","Замечательный торшер для вашего интерьера."
                            ,"https://great-light.ru/wa-data/public/shop/products/53/25/2553/images/16986/16986.970.jpg"),
                    new Card("Стул","Замечательный стул для вашего интерьера."
                            ,"https://annihaus.ru/upload/iblock/561/56166c4717cd3ab25b0d15e598f82fb7.jpg"),
                    new Card("Светильник","Замечательный светильник для вашего интерьера."
                            ,"https://romatti.ru/upload/iblock/346/34663c1a38444961d4dd02ca4aec8c5a.png"),
                    new Card("Стол","Замечательный стол для вашего интерьера."
                            ,"https://www.parra.ru/wa-data/public/shop/products/30/13/1330/images/2957/2957.970.png"),
                    new Card("Ваза","Замечательная ваза для вашего интерьера"
                            , "https://dom-a-dom.ru/images/images/88258_original.jpg?1599561176"),
                    new Card("Ковёр","Замечательный ковёр для вашего интерьера"
                            , "https://www.kuchenland.ru/upload/iblock/863/6klp26ojx4f278scwbvmgn7ob02888ab/5355e820_f6ed_11e9_9ecb_98f2b3f54c76_e97ec9df_a212_11eb_a036_9cdc71c2cdfd.jpeg")
            );

        }
        return instance;
    }

    public List<Card> getAllCards(){
        return cardList;
    }

}
