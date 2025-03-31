package com.demo.example.student_library_management_system.converters;

import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.requestdto.CardRequestDto;

public class CardConverter {

    public static Card convertCardRequestDtoIntoCard(CardRequestDto cardRequestDto){
        Card card = new Card();

        card.setCardStatus(cardRequestDto.getCardStatus());
        card.setBloodGroup(cardRequestDto.getBloodGroup());

        // foreign keys present in request dto are not used in converters.
        // they are directly used in service class while writing business logics

        return card;

    }
}
