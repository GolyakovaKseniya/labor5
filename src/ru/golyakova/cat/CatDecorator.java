package ru.golyakova.cat;

public class CatDecorator implements Meowable {
    private final Cat cat;
    private int count;

    public int getCount() {
        return count;
    }

    public Cat getCat() {
        return cat;
    }

    public CatDecorator(Cat cat){
        this.cat = cat;
        this.count = 0;
    }

    @Override
    public void meow() {
        cat.meow();
        count++;
    }
}
