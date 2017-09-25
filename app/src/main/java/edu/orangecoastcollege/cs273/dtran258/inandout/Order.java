package edu.orangecoastcollege.cs273.dtran258.inandout;

/**
 * Represents an order at In And Out Burger. Contains information about the amount of each item
 * ordered and the price of each item.
 *
 * @author Derek Tran
 * @version 1.0
 * @since September 24, 2017
 */

public class Order
{

    private static final double PRICE_DOUBLE_DOUBLE = 3.60;
    private static final double PRICE_CHEESEBURGER = 2.15;
    private static final double PRICE_FRENCH_FRIES = 1.65;
    private static final double PRICE_SHAKE = 2.20;
    private static final double PRICE_SMALL_DRINK = 1.45;
    private static final double PRICE_MEDIUM_DRINK = 1.55;
    private static final double PRICE_LARGE_DRINK = 1.75;
    private static final double TAX_RATE = 0.08;

    private int mDoubleDoubles;
    private int mCheeseburgers;
    private int mFrenchFries;
    private int mShakes;
    private int mSmallDrinks;
    private int mMediumDrinks;
    private int mLargeDrinks;

    /**
     * Gets the amount of Double Doubles ordered.
     * @return The amount of Double Doubles ordered.
     */
    public int getDoubleDoubles()
    {
        return mDoubleDoubles;
    }

    /**
     * Sets the amount of Double Doubles ordered.
     * @param doubleDoubles The amount of Double Doubles ordered.
     */
    public void setDoubleDoubles(int doubleDoubles)
    {
        mDoubleDoubles = doubleDoubles;
    }

    /**
     * Gets the amount of cheeseburgers ordered.
     * @return The amount of cheeseburgers orderd.
     */
    public int getCheeseburgers()
    {
        return mCheeseburgers;
    }

    /**
     * Sets the amount of cheeseburgers ordered.
     * @param cheeseburgers The number of cheeseburgers ordered.
     */
    public void setCheeseburgers(int cheeseburgers)
    {
        mCheeseburgers = cheeseburgers;
    }

    /**
     * Gets the amount of french fries ordered.
     * @return The amount of french fries ordered.
     */
    public int getFrenchFries()
    {
        return mFrenchFries;
    }

    /**
     * Sets the amount of french fries ordered.
     * @param frenchFries The amount of french fries ordered.
     */
    public void setFrenchFries(int frenchFries)
    {
        mFrenchFries = frenchFries;
    }

    /**
     * Gets the amount of shakes ordered.
     * @return The amount of shakes ordered.
     */
    public int getShakes()
    {
        return mShakes;
    }

    /**
     * Sets the amount of shakes ordered.
     * @param shakes The amount of shakes ordered.
     */
    public void setShakes(int shakes)
    {
        mShakes = shakes;
    }

    /**
     * Gets the amount of small drinks ordered.
     * @return The amount of small drinks ordered.
     */
    public int getSmallDrinks()
    {
        return mSmallDrinks;
    }

    /**
     * Sets the amount of small drinks ordered.
     * @param smallDrinks The amount of small drinks ordered.
     */
    public void setSmallDrinks(int smallDrinks)
    {
        mSmallDrinks = smallDrinks;
    }

    /**
     * Gets the amount of medium drinks ordered.
     * @return The amount of medium drinks ordered.
     */
    public int getMediumDrinks()
    {
        return mMediumDrinks;
    }

    /**
     * Sets the amount of medium drinks ordered.
     * @param mediumDrinks The amount of medium drinks ordered.
     */
    public void setMediumDrinks(int mediumDrinks)
    {
        mMediumDrinks = mediumDrinks;
    }

    /**
     * Gets the amount of large drinks ordered.
     * @return The amount of large drinks ordered.
     */
    public int getLargeDrinks()
    {
        return mLargeDrinks;
    }

    /**
     * Sets the amount of large drinks ordered.
     * @param largeDrinks The amount of large drinks ordered.
     */
    public void setLargeDrinks(int largeDrinks)
    {
        mLargeDrinks = largeDrinks;
    }

    /**
     * Gets the number of items ordered from the menu.
     * @return The number of items ordered from the menu.
     */
    public int getNumberItemsOrdered()
    {
        return mDoubleDoubles + mCheeseburgers + mFrenchFries + mShakes + mSmallDrinks
                + mMediumDrinks + mLargeDrinks;
    }

    /**
     * Calculates the base cost of all the items ordered.
     * @return The base cost of all the items ordered.
     */
    public double calculateSubtotal()
    {
        return mDoubleDoubles * PRICE_DOUBLE_DOUBLE + mCheeseburgers * PRICE_CHEESEBURGER
                + mFrenchFries * PRICE_FRENCH_FRIES + mShakes * PRICE_SHAKE
                + mSmallDrinks * PRICE_SMALL_DRINK + mMediumDrinks * PRICE_MEDIUM_DRINK
                + mLargeDrinks * PRICE_LARGE_DRINK;
    }

    /**
     * Calculates the tax added to the base cost of all items ordered.
     * @return The tax added to the base cost of all items ordered.
     */
    public double calculateTax()
    {
        return calculateSubtotal() * TAX_RATE;
    }

    /**
     * Calculates the total cost of all the items ordered, with tax.
     * @return The total cost of all the items ordered, with tax.
     */
    public double calculateTotal()
    {
        return calculateSubtotal() + calculateTax();
    }
}
