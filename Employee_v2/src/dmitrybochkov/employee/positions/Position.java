package dmitrybochkov.employee.positions;

import dmitrybochkov.employee.Month;
import dmitrybochkov.employee.SalaryStrategy.Strategy;

public class Position {
    private final String name;
    private final TypeOfPosition type;
    private final LevelOfPosition level;
    private Strategy premiumStrategy;

    public static class Builder{
        //Обязательные поля
        private final String name;
        private final TypeOfPosition type;
        private final LevelOfPosition level;


        public Builder(String name, TypeOfPosition type, LevelOfPosition level){
            this.name = name;
            this.type = type;
            this.level = level;
        }

    }

    private Position(Builder builder){
        this.name = builder.name;
        this.type = builder.type;
        this.level = builder.level;
    }


    //Getters:

    public TypeOfPosition getType(){
        return type;
    }

    public LevelOfPosition getLevel(){
        return level;
    }

}
