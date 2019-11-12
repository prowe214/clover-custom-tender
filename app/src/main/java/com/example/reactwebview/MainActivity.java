//package com.example.reactwebview;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.AsyncTask;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.webkit.JavascriptInterface;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.clover.sdk.util.CloverAccount;
//import com.clover.sdk.v1.Intents;
//import com.clover.sdk.v1.tender.Tender;
//import com.clover.sdk.v1.tender.TenderConnector;
//import com.clover.sdk.v3.payments.ServiceChargeAmount;
//
//import java.util.ArrayList;
//import java.util.Currency;
//
////import android.content.Intent;
//
//
//class WebAppInterface {
//    Context mContext;
//
//    public static final String TAG = "JS";
//    long amount;
//    Currency currency;
//    long taxAmount;
//    ArrayList taxableAmounts;
//    ServiceChargeAmount serviceCharge;
//
//    String orderId;
//    String employeeId;
//    String merchantId;
//
//    Tender tender;
//
//    // Customer Facing specific fields
//    long tipAmount;
//
//    WebAppInterface(Context c) {
//        mContext = c;
//    }
//
//    /**
//     * doSale
//     * <p>
//     * STUB handling submission to Clover SDK.
//     * This will pass a value to Clover upon a successful transaction.
//     */
////    @JavascriptInterface
////    public String doSale(String amount) {
////        Log.w(TAG, "HIT");
////        Intent i = new Intent(Intents.ACTION_SECURE_PAY);
////        i.putExtra(Intents.EXTRA_AMOUNT, Long.valueOf(amount));
////        startActivityForResult(i, WEB_POS_SALE_REQUEST_CODE);
////        return amount;
////    }
//}
//
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Necessary for Customer Facing user experiences
////        setSystemUiVisibility();
//
//        WebView myWebView = findViewById(R.id.webview);
//        myWebView.loadUrl("https://awesome-stonebraker-38b0e2.netlify.com/");
//        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
//        WebSettings webSettings = myWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//    }
//
//    private static void createTenderType(final Context context) {
//        new AsyncTask<Void, Void, Exception>() {
//
//            private TenderConnector tenderConnector;
//
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//                tenderConnector = new TenderConnector(context, CloverAccount.getAccount(context), null);
//                tenderConnector.connect();
//            }
//
//            @Override
//            protected Exception doInBackground(Void... params) {
//                try {
//                    tenderConnector.checkAndCreateTender("CareCreditPayment", context.getPackageName(), true, false); // initialization
//                } catch (Exception exception) {
//                    Log.e("DIED", exception.getMessage(), exception.getCause());
//                    return exception;
//                }
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Exception exception) {
//                tenderConnector.disconnect();
//                tenderConnector = null;
//            }
//        }.execute();
//    }
//
//    public void setSystemUiVisibility() {
//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        | View.SYSTEM_UI_FLAG_LOW_PROFILE
//                        | View.SYSTEM_UI_FLAG_FULLSCREEN
//                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//    }
//
//
//}
//
//
