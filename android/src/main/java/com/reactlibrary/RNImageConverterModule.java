package com.reactlibrary;

import java.io.File;
import java.io.ByteArrayOutputStream;
import android.util.Base64;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNImageConverterModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNImageConverterModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNImageConverter";
  }

  @ReactMethod
  public void getPNG(String original, Promise promise) {
    Bitmap bm = BitmapFactory.decodeFile(original);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
    byte[] byteArrayImage = baos.toByteArray();
    String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);

    promise.resolve(encodedImage);
  }

  @ReactMethod
  public void getJPEG(String original, Promise promise) {
    Bitmap bm = BitmapFactory.decodeFile(original);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);
    byte[] byteArrayImage = baos.toByteArray();
    String encodedImage = Base64.encodeToString(byteArrayImage, Base64.DEFAULT);

    promise.resolve(encodedImage);
  }
}
