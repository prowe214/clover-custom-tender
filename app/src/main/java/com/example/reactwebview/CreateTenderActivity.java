package com.example.reactwebview;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.clover.sdk.util.CloverAccount;
import com.clover.sdk.util.CloverAuth;
import com.clover.sdk.v1.Intents;
import com.clover.sdk.v1.tender.TenderConnector;

public class CreateTenderActivity extends AppCompatActivity {
    private static final String TAG = "CareCreditCustomTender";
//
//    private static final int REQUEST_ACCOUNT = 1;
//
//    private TenderConnector tenderConnector;
//    private Account account;
//
//    private TextView resultText;
//    WebView myWebView;
private static void createTenderType(final Context context) {
    new AsyncTask<Void, Void, Exception>() {

        private TenderConnector tenderConnector;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tenderConnector = new TenderConnector(context, CloverAccount.getAccount(context), null);
            tenderConnector.connect();
        }

        @Override
        protected Exception doInBackground(Void... params) {
            try {
                tenderConnector.checkAndCreateTender("Care Credit Custom Tender", context.getPackageName(), true, false); // initialization
            } catch (Exception exception) {
                Log.e(TAG, exception.getMessage(), exception.getCause());
                return exception;
            }
            return null;
        }

        @Override
        protected void onPostExecute(Exception exception) {
            tenderConnector.disconnect();
            tenderConnector = null;
        }
    }.execute();
}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializes and registers with clover's register app (hopefully)
        createTenderType(this);

        Long amount = getIntent().getLongExtra(Intents.EXTRA_AMOUNT, 0);
        TextView amountTextView = findViewById(R.id.amount_text_view);

        amountTextView.setText(amount.toString());

        Button approveButton = findViewById(R.id.approve_btn);
        approveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo - figure out how to interface with clover register app
                Intent data = new Intent();
//                data.putExtra(Intents.EXTRA_AMOUNT, amount);
//                data.putExtra(Intents.EXTRA_CLIENT_ID, Utils.nextRandomId());
//                data.putExtra(Intents.EXTRA_NOTE, "Transaction Id: " + Utils.nextRandomId());
//
//                setResult(RESULT_OK, data);
                finish();
            }
        });

//        resultText = (TextView) findViewById(R.id.result);
//        myWebView = findViewById(R.id.webview);
//        myWebView.loadUrl("https://awesome-stonebraker-38b0e2.netlify.com/");
//        myWebView.addJavascriptInterface(new WebAppInterface(this), "Android");
//        WebSettings webSettings = myWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);

    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_ACCOUNT && resultCode == RESULT_OK) {
//            String name = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
//            String type = data.getStringExtra(AccountManager.KEY_ACCOUNT_TYPE);
//
//            account = new Account(name, type);
//        }
//    }

//    private void startAccountChooser() {
//        Intent intent = AccountManager.newChooseAccountIntent(null, null, new String[]{CloverAccount.CLOVER_ACCOUNT_TYPE}, false, null, null, null, null);
//        startActivityForResult(intent, REQUEST_ACCOUNT);
//    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//    }


//    @Override
//    protected void onPause() {
//        disconnect();
//        super.onPause();
//    }

//    private void connect() {
//        disconnect();
//        if (account != null) {
//            tenderConnector = new TenderConnector(this, account, null);
//            tenderConnector.connect();
//        }
//    }
//
//    private void disconnect() {
//        if (tenderConnector != null) {
//            tenderConnector.disconnect();
//            tenderConnector = null;
//        }
//    }
//
//    private void getTenders() {
//        tenderConnector.getTenders(new TenderConnector.TenderCallback<List<Tender>>() {
//            @Override
//            public void onServiceSuccess(List<Tender> result, ResultStatus status) {
//                super.onServiceSuccess(result, status);
//                String text = "Tenders:\n";
//                for (Tender t : result) {
//                    text += "  " + t.getId() + " , " + t.getLabel() + " , " + t.getLabelKey() + " , " + t.getEnabled() + " , " + t.getOpensCashDrawer() + "\n";
//                }
//                resultText.setText(text);
//            }
//
//            @Override
//            public void onServiceFailure(ResultStatus status) {
//                super.onServiceFailure(status);
//                resultText.setText(status.getStatusMessage());
//            }
//
//            @Override
//            public void onServiceConnectionFailure() {
//                super.onServiceConnectionFailure();
//                resultText.setText("Service Connection Failure");
//            }
//        });
//    }
//
//    private void createTender() {
//        final String tenderName = "Clover Example Tender";
//        final String packageName = getPackageName();
//
//        tenderConnector.checkAndCreateTender(tenderName, packageName, true, false, new TenderConnector.TenderCallback<Tender>() {
//            @Override
//            public void onServiceSuccess(Tender result, ResultStatus status) {
//                super.onServiceSuccess(result, status);
//                String text = "Custom Tender:\n";
//                text += "  " + result.getId() + " , " + result.getLabel() + " , " + result.getLabelKey() + " , " + result.getEnabled() + " , " + result.getOpensCashDrawer() + "\n";
//                resultText.setText(text);
//            }
//
//            @Override
//            public void onServiceFailure(ResultStatus status) {
//                super.onServiceFailure(status);
//                resultText.setText(status.getStatusMessage());
//            }
//
//            @Override
//            public void onServiceConnectionFailure() {
//                super.onServiceConnectionFailure();
//                resultText.setText("Service Connection Failure");
//            }
//        });
//    }

}
