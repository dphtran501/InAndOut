package edu.orangecoastcollege.cs273.dtran258.inandout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This activity allows the user to input the number of each In And Out Burger item they want to
 * order. The user can then click a button to launch <code>SummaryActivity</code>, which will
 * display the cost of their order.
 *
 * @author Derek Tran
 * @version 1.0
 * @since September 26, 2017
 */
public class OrderActivity extends AppCompatActivity
{

    // Currency formatter
    private static NumberFormat currency = NumberFormat.getCurrencyInstance();

    // VIEW
    private TextView mDoubleDoublePriceTextView;
    private EditText mDoubleDoubleEditText;
    private TextView mCheeseburgerPriceTextView;
    private EditText mCheeseburgerEditText;
    private TextView mFrenchFriesPriceTextView;
    private EditText mFrenchFriesEditText;
    private TextView mShakesPriceTextView;
    private EditText mShakesEditText;
    private TextView mSmallDrinkPriceTextView;
    private EditText mSmallDrinkEditText;
    private TextView mMediumDrinkPriceTextView;
    private EditText mMediumDrinkEditText;
    private TextView mLargeDrinkPriceTextView;
    private EditText mLargeDrinkEditText;

    // MODEL
    Order mOrder = new Order();

    /**
     * Initializes <code>OrderActivity</code> by inflating its UI.
     *
     * @param savedInstanceState Bundle containing the data it recently supplied in
     *                           onSaveInstanceState(Bundle) if activity was reinitialized after
     *                           being previously shut down. Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        initialize();
    }

    /**
     * Retrieves data on the base cost, tax amount, and total cost of the order specified in this
     * actiivity, as well as the number of items ordered, and sends that data to
     * <code>SummaryActivity</code>. <code>SummaryActivity</code> is then launched.
     *
     * @param v The view that called this method.
     */
    protected void placeOrder(View v)
    {
        setOrder();

        Intent summaryIntent = new Intent(this, SummaryActivity.class);
        summaryIntent.putExtra("order total", mOrder.calculateTotal());
        summaryIntent.putExtra("items ordered", mOrder.getNumberItemsOrdered());
        summaryIntent.putExtra("subtotal", mOrder.calculateSubtotal());
        summaryIntent.putExtra("tax", mOrder.calculateTax());
        startActivity(summaryIntent);
    }

    private void initialize()
    {
        mDoubleDoublePriceTextView = (TextView) findViewById(R.id.double_double_price_text_view);
        mDoubleDoublePriceTextView.setText(currency.format(Order.PRICE_DOUBLE_DOUBLE));
        mDoubleDoubleEditText = (EditText) findViewById(R.id.double_double_edit_text);
        mCheeseburgerPriceTextView = (TextView) findViewById(R.id.cheeseburger_price_text_view);
        mCheeseburgerPriceTextView.setText(currency.format(Order.PRICE_CHEESEBURGER));
        mCheeseburgerEditText = (EditText) findViewById(R.id.cheeseburger_edit_text);
        mFrenchFriesPriceTextView = (TextView) findViewById(R.id.fries_price_text_view);
        mFrenchFriesPriceTextView.setText(currency.format(Order.PRICE_FRENCH_FRIES));
        mFrenchFriesEditText = (EditText) findViewById(R.id.fries_edit_text);
        mShakesPriceTextView = (TextView) findViewById(R.id.shakes_price_text_view);
        mShakesPriceTextView.setText(currency.format(Order.PRICE_SHAKE));
        mShakesEditText = (EditText) findViewById(R.id.shakes_edit_text);
        mSmallDrinkPriceTextView = (TextView) findViewById(R.id.small_price_text_view);
        mSmallDrinkPriceTextView.setText(currency.format(Order.PRICE_SMALL_DRINK));
        mSmallDrinkEditText = (EditText) findViewById(R.id.small_edit_text);
        mMediumDrinkPriceTextView = (TextView) findViewById(R.id.medium_price_text_view);
        mMediumDrinkPriceTextView.setText(currency.format(Order.PRICE_MEDIUM_DRINK));
        mMediumDrinkEditText = (EditText) findViewById(R.id.medium_edit_text);
        mLargeDrinkPriceTextView = (TextView) findViewById(R.id.large_price_text_view);
        mLargeDrinkPriceTextView.setText(currency.format(Order.PRICE_LARGE_DRINK));
        mLargeDrinkEditText = (EditText) findViewById(R.id.large_edit_text);
    }

    private void setOrder()
    {
        mOrder.setDoubleDoubles(Integer.parseInt(mDoubleDoubleEditText.getText().toString()));
        mOrder.setCheeseburgers(Integer.parseInt(mCheeseburgerEditText.getText().toString()));
        mOrder.setFrenchFries(Integer.parseInt(mFrenchFriesEditText.getText().toString()));
        mOrder.setShakes(Integer.parseInt(mShakesEditText.getText().toString()));
        mOrder.setSmallDrinks(Integer.parseInt(mSmallDrinkEditText.getText().toString()));
        mOrder.setMediumDrinks(Integer.parseInt(mMediumDrinkEditText.getText().toString()));
        mOrder.setLargeDrinks(Integer.parseInt(mLargeDrinkEditText.getText().toString()));
    }

}
