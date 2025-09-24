package com.example.payfinancesapi.util;

import com.example.payfinancesapi.model.ValidationTransactionStatus;

import java.util.Random;

public class RandomStatus {

    private static final Random RANDOM = new Random();

    public static ValidationTransactionStatus getRandomStatus() {
        return RANDOM.nextBoolean() ? ValidationTransactionStatus.APROBADO : ValidationTransactionStatus.NO_APROBADO;
    }
}
