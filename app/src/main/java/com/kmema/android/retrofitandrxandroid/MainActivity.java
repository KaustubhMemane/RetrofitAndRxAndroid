package com.kmema.android.retrofitandrxandroid;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static final  String TAG = "MainActivity_TAG:";
   /* Observable<ResumeDataType> mobservable;
    Observer<ResumeDataType> mObserver;
   */ TextView mTextView;
    Subscription subscription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tvHello);
        mTextView = (TextView) findViewById(R.id.tvHello);

         Observable.defer(new Callable<ObservableSource<ResumeDataType>>() {
                    @Override
                    public ObservableSource<ResumeDataType> call() throws Exception {

                        ResumeDataType resumeDataType=getDataFromJson();

                        return (Observable.just(resumeDataType));
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<ResumeDataType>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResumeDataType resumeDataType) {
                        Toast.makeText(MainActivity.this, resumeDataType.className+"Hope", Toast.LENGTH_SHORT).show();
                        mTextView.setText(resumeDataType.overview);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG,e.getMessage());
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(MainActivity.this, "Hope", Toast.LENGTH_SHORT).show();
                    }
                });
        Toast.makeText(this, "exit", Toast.LENGTH_SHORT).show();
    }


    private ResumeDataType getDataFromJson() throws IOException {
        ResumeDataType resumeData = new ResumeDataType();
        final OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://kaustubhmemane.com/my_resume_overview")
                .build();
        Response response = client.newCall(request).execute();
        
        Gson gson = new Gson();
        ResumeDataType r = gson.fromJson(response.body().string(),ResumeDataType.class);
        return r;
    }

    public Observable<ResumeDataType> resumeDataTypeObservable()
    {
        return null;
    }
}
