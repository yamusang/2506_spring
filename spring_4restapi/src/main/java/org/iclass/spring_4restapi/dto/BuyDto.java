package org.iclass.spring_4restapi.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BuyDto {

    private final int buy_seq;
    private final String customer_id;
    private final String pcode;
    private final int quantity;
    private final Date buydate;

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
