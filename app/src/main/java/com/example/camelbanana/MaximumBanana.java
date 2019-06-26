package com.example.camelbanana;



public class MaximumBanana {
    private float numberOfBanana,distanceToMarket,numberOfBananaPerKm,carriedBanana, numberOfBananaConsumed,remainingDistance;
    private int numberOfStoppagePoint,numberOfTime,numberOfCamel;


    public  float getRemainingDistance() {
        return remainingDistance;
    }

    public void setRemainingDistance(float distanceToMarket,float r ,float numberOfTimes,float numberOfCamel,float numberOfBananaPerKm) {
        this.remainingDistance = distanceToMarket - (r/(numberOfTimes*numberOfBananaPerKm*numberOfCamel));
    }

    public float getCarriedBanana() {
        return carriedBanana;
    }

    public void setCarriedBanana(float numberOfStoppagePoints) {
        this.carriedBanana = (numberOfBanana/numberOfStoppagePoints);
    }

    public int  getNumberOfTime() {
        return numberOfTime;
    }

    public void setNumberOfTime(int  numberOfStoppagePoints ) {
        this.numberOfTime = (2*numberOfStoppagePoints)- getNumberOfCamel();
    }

    public float getNumberOfBananaConsumed() {
        return numberOfBananaConsumed;
    }

    public void setR(float numberOfBanana,float carriedBanana,float numberOfStoppagePoints) {
        this.numberOfBananaConsumed = numberOfBanana+carriedBanana - (carriedBanana*numberOfStoppagePoints);
    }

    public int  getNumberOfStoppagePoint() {
        return numberOfStoppagePoint;
    }

    public void setNumberOfStoppagePoint(int numberOfBanana ) {
        if (numberOfBanana% 1000 > 0) {
            this.numberOfStoppagePoint = (numberOfBanana/1000)+1;
        }
        else {
            this.numberOfStoppagePoint = (numberOfBanana/1000);
        }
    }

    public MaximumBanana(int numberOfBanana, int distanceToMarket, int numberOfCamel, int numberOfBananaPerKm) {
        this.numberOfBanana = numberOfBanana;
        this.distanceToMarket = distanceToMarket;
        this.numberOfCamel = numberOfCamel;
        this.numberOfBananaPerKm = numberOfBananaPerKm;
    }

    public float getNumberOfBanana() {
        return numberOfBanana;
    }

    public void setNumberOfBanana(float  numberOfBanana) {
        this.numberOfBanana = numberOfBanana;
    }

    public float getDistanceToMarket() {
        return distanceToMarket;
    }

    public void setDistanceToMarket(float  distanceToMarket) {
        this.distanceToMarket = distanceToMarket;
    }

    public int  getNumberOfCamel() {
        return numberOfCamel;
    }

    public void setNumberOfCamel(int numberOfCamel) {
        this.numberOfCamel = numberOfCamel;
    }

    public float getNumberOfBananaPerKm() {
        return numberOfBananaPerKm;
    }

    public void setNumberOfBananaPerKm(int numberOfBananaPerKm) {
        this.numberOfBananaPerKm = numberOfBananaPerKm;
    }

    public int   maximumBanana() {
        int   maximumBanana ;
        setNumberOfStoppagePoint((int)getNumberOfBanana());
        setCarriedBanana(getNumberOfStoppagePoint());
        setR(getNumberOfBanana(), getCarriedBanana(), getNumberOfStoppagePoint());
        setNumberOfTime(getNumberOfStoppagePoint());
        if (getNumberOfBanana() <= getDistanceToMarket()) {
            maximumBanana = 0;
        }
        else if (getNumberOfBanana() > getDistanceToMarket() && getDistanceToMarket()==0) {
            maximumBanana = (int) getNumberOfBanana();
        }
        else if ((getNumberOfTime() * getNumberOfCamel()*getCarriedBanana())/getNumberOfCamel() <= getNumberOfBananaConsumed()) {
            maximumBanana = (int) (getNumberOfBanana() - (getDistanceToMarket()*getNumberOfStoppagePoint()*getNumberOfCamel()*getNumberOfBananaPerKm()));
        }
        else {
            setRemainingDistance(getDistanceToMarket(), getNumberOfBananaConsumed(), getNumberOfTime(),getNumberOfCamel(), getNumberOfBananaPerKm());
            setNumberOfStoppagePoint((int) (getNumberOfBanana()- getNumberOfBananaConsumed()));
            setNumberOfBanana(getNumberOfBanana()- getNumberOfBananaConsumed());
            setDistanceToMarket(getRemainingDistance());
            setNumberOfTime(getNumberOfStoppagePoint());
            maximumBanana =  maximumBanana();
        }

        return maximumBanana;
    }


}


