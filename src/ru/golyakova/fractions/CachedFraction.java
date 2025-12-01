package ru.golyakova.fractions;

import java.util.HashMap;
import java.util.Map;

public class CachedFraction extends Fraction {
    private static final Map<String, Double> cachedValue = new HashMap<>();

    public CachedFraction(int numerator, int denominator){
        super(numerator, denominator);
    }

    @Override
    public double getValue() {
        String key = getNumerator() + "/" + getDenominator();
        return cachedValue.computeIfAbsent(key, k-> super.getValue());
    }

    @Override
    public void setFraction(int numerator, int denominator) {
        String oldKey = getNumerator() + "/" + getDenominator();
        if(cachedValue.containsKey(oldKey)){
            cachedValue.remove(oldKey);
            System.out.println("[КЭШ] Удалено старое значение: " + oldKey);
        }
        super.setFraction(numerator, denominator);
    }
    public static void printCache() {
        System.out.println("Кэш содержит " + cachedValue.size() + " значений: " + cachedValue);
    }

}
