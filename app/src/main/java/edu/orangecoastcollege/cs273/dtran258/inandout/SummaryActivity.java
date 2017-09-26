package edu.orangecoastcollege.cs273.dtran258.inandout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This activity retrieves data sent from <code>OrderActivity</code> to display information about
 * the cost of the user's order at In And Out Burger.
 *
 * @author Derek Tran
 * @version 1.0
 * @since September 26, 2017
 */
public class SummaryActivity extends AppCompatActivity
{
    // Formatters
    private static NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static NumberFormat percent = NumberFormat.getPercentInstance();

    // VIEWS
    private TextView mTotalTextView;
    private TextView mItemsTextView;
    private TextView mSubtotalTextView;
    private TextView mTaxTextView;

    /**
     * Initializes <code>SummaryActivity</code> by inflating its UI and retrieving data from
     * <code>OrderActivity</code>.
     *
     * @param savedInstanceState Bundle containing the data it recently supplied in
     *                           onSaveInstanceState(Bundle) if activity was reinitialized after
     *                           being previously shut down. Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Intent intentFromOrder = getIntent();
        String total = currency.format(intentFromOrder.getDoubleExtra("order total", 0.0));
        int numOfItems = intentFromOrder.getIntExtra("items ordered", 0);
        String subtotal = currency.format(intentFromOrder.getDoubleExtra("subtotal", 0.0));
        String tax = currency.format(intentFromOrder.getDoubleExtra("tax", 0.0));

        initialize();

        mTotalTextView.setText(getString(R.string.order_total_text_view, total));
        mItemsTextView.setText(getString(R.string.items_text_view, numOfItems));
        mSubtotalTextView.setText(getString(R.string.subtotal_text_view, subtotal));
        mTaxTextView.setText(getString(R.string.tax_text_view, percent.format(Order.TAX_RATE), tax));
    }

    /**
     * Terminates this activity and returns to <code>OrderActivity</code>.
     *
     * @param v The view that called this method.
     */
    protected void startNewOrder(View v)
    {
        finish();
    }

    private void initialize()
    {
        mTotalTextView = (TextView) findViewById(R.id.order_total_text_view);
        mItemsTextView = (TextView) findViewById(R.id.items_ordered_text_view);
        mSubtotalTextView = (TextView) findViewById(R.id.subtotal_text_view);
        mTaxTextView = (TextView) findViewById(R.id.tax_text_view);
    }
}
