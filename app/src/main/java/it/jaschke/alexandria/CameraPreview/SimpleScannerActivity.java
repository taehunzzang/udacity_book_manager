package it.jaschke.alexandria.CameraPreview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by taehun on 15. 10. 14..
 */
public class SimpleScannerActivity extends Activity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
        mScannerView.setAutoFocus(true);
        mScannerView.setCameraDistance(100);
    }

    @Override
    public void onResume() {
        super.onResume();

        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Log.v("", "@@@@@@@@@"+rawResult.getText()); // Prints scan results
        Log.v("", "@@@@@@@@@" + rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)
        Intent intent = new Intent();
        intent.putExtra(Intent.EXTRA_TEXT,rawResult.getText());
        setResult(RESULT_OK, intent);
        finish();
    }

}
