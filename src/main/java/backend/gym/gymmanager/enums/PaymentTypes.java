package backend.gym.gymmanager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum PaymentTypes {

    CASH(0),
    DEBIT(1),
    CREDIT(2),
    OTHER(3);

    private Integer PaymentTypeValue;

    public static PaymentTypes fromValue(Integer value){
        for(PaymentTypes paymentTypes: PaymentTypes.values()){
            if(paymentTypes.PaymentTypeValue.equals(value)){
                return paymentTypes;
            }
        }
        return null;
    }
}
