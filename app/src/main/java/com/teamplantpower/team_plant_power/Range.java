package com.teamplantpower.team_plant_power;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Samantha on 2017-07-04.
 */

public class Range implements Serializable {
    private String type;
    private double minRange, maxRange;

    /**
     * Default constructor
     */
    public Range() {
        this.type = "";
        this.minRange = Double.NaN;
        this.maxRange = Double.NaN;
    }

    /**
     * A constructor which just accepts the ranges, mainly for testing.
     * @param minRange The min range
     * @param maxRange The max range
     */

    public Range(double minRange, double maxRange) {
        this.type = "";
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    /**
     * Constructor that sets type and range
     * @param type The key and identifier. Light, Humidity, or Temperature
     * @param minRange The min range
     * @param maxRange The max range
     */
    public Range(String type, double minRange, double maxRange) {
        this.type = type;
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    //Getters******************************************************************
    /**
     * Get the range type
     * @return A string. Should be Light, Humidity, or Temperature
     */
    public String getType() {
        return type;
    }

    /**
     * Get the min range
     * @return The min value
     */
    public double getMinRange() {
        return minRange;
    }

    /**
     * Get the max range
     * @return The max value
     */
    public double getMaxRange() {
        return maxRange;
    }


    //Setters******************************************************************
    /**
     * Set the type
     * @param type The key and identifier. Light, Humidity, or Temperature
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Set the min range
     * @param minRange The min value of the range
     */
    public void setMinRange(double minRange) {
        this.minRange = minRange;
    }

    /**
     * Set the max range
     * @param maxRange The max value of the range
     */
    public void setMaxRange(double maxRange) {
        this.maxRange = maxRange;
    }

    /**
     * Resets the range. Sets min and max to NULL.
     */
    @Exclude
    public void resetRange() {
        minRange = Double.NaN;
        maxRange = Double.NaN;
    }

    //Validation******************************************************************

    /**
     * Validate that the ranges are between 0 and 100 (for light and humidity) and do not overlap
     * @return A boolean, true if valid, false otherwise
     */
    @Exclude
    public boolean validateRange(){
        boolean inRange = true;
        //for light and humidity
        if(!type.equals("Temperature")){
            if(minRange < 0 || minRange > 100 || maxRange < 0 || maxRange > 100)
                inRange = false;

        }
        if (minRange > maxRange){
            inRange = false;
        }
        return inRange;

    }

    /**
     * Checks whether range is set.
     * @return True if range is set, false otherwise
     */
    @Exclude
    public boolean isRangeSet() {
        return !Double.isNaN(minRange) && !Double.isNaN(maxRange);
    }


    /**
     * Check whether value is in range
     * @param value The value to check
     * @return A boolean. True if in range, false otherwise.
     */
    @Exclude
    public boolean isInRange(double value){
        if(value >= minRange && value<= maxRange)
            return true;
        else
            return false;
    }

    /**
     * Convert object to hashmap
     * @return A hashmap
     */
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("type", type);
        result.put("minRange", minRange);
        result.put("maxRange", maxRange);

        return result;
    }





}
