package com.deba.forkjoin.recurstivetask;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransactionGenerator {

    String[] categories = new String[]{"FOOD", "ELECTRONICS", "GROCERY", "FASHION"};

    public List<Transaction> generate(long num) {
        List<Transaction> transactions = new ArrayList<>();
        Random random = new Random();

        for(long i = 1; i <= num; i++) {
            String userId = "U100" + i;

            //Amount shld be bwteen 10 and 2000(including)
            double amount = random.nextDouble(10, 2001);;

            int categoryNum = random.nextInt(0, categories.length);
            String category = categories[categoryNum];

            transactions.add(new Transaction(i, userId, amount, category));
        }

        return transactions;
    }
}
