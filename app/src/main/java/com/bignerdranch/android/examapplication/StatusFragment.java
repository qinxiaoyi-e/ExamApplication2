package com.bignerdranch.android.examapplication;


import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatusFragment extends Fragment {
    private MediaPlayer mMediaPlayer;

    private WebView webview;
    private ProgressDialog dialog;

    public StatusFragment() {
        // Required empty public constructor
    }
    /*private void init() {
        webview=(WebView)findViewById(R.id.webview);
        webview.loadUrl("http://2014.qq.com");//加载网页
        //webview.loadUrl("file:///android_asset/fadeIn.html");//加载本地html页面

		*//*覆盖WebView默认通过第三方或者是系统浏览器打开网页的行为，使得网页可以在WebView中打开，WebViewClint帮助WebView去处理一些页面控制和请求*//*
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;    //返回值是true的时候控制网页在WebView中去打开，如果为false调用下同浏览器或第三方浏览器去打开
            }
        });
		*//*启用支持javascript*//*
        WebSettings settings=webview.getSettings();
        settings.setJavaScriptEnabled(true);
		*//*WebView加载页面优先使用缓存加载*//*
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);

		*//*设置进度条对话框*//*
        webview.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if(newProgress==100){      //newprogress是一到一百中的整数，反正加载进度
					*//*网页加载完毕，关闭ProgressDialog*//*
                    closeDialog(newProgress);
                }else{
					*//*网页正在加载，打开ProgressDialog*//*
                    openDialog(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

            private void openDialog(int newProgress) {
                if(dialog==null){           //如果dialog为空，代表没有被创建过，需要创建
                    dialog=new ProgressDialog(getActivity());   //参数为上下文环境
                    dialog.setTitle("正在加载...");
                    dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);   //横向进度条
                    dialog.setProgress(newProgress);     //设置进度并显示
                    dialog.show();          //显示进度条
                }else{          //若dialog不为空，代表进度条已经被创建
                    dialog.setProgress(newProgress);    //刷新进度
                }
            }

            private void closeDialog(int newProgress) {
                if(dialog!=null&&dialog.isShowing()){    //如果dialog不为空并且正在显示
                    dialog.dismiss();            //关闭dialog
                    dialog=null;
                }
            }
        });
    }
*/
/*					*//*改写物理按键--返回的逻辑*//*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK){      //点击返回按钮
            if(webview.canGoBack()){             //判断能不能返回上一界面，就是该页面前边是否还有页面
                webview.goBack();                //返回上一界面
                return true;
            }else{                               //如果该页面是第一个页面
                System.exit(0);          //退出程序
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_list,menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.music_start:
                Toast.makeText(getActivity(),
                        "click music_start",
                        Toast.LENGTH_SHORT).show();
                mMediaPlayer= MediaPlayer.create(getActivity(),R.raw.smallbox);
                mMediaPlayer.start();
                break;
            case R.id.music_stop:
                Toast.makeText(getActivity(),
                        "click music_stop",
                        Toast.LENGTH_SHORT).show();
                mMediaPlayer.stop();
                break;
            case R.id.web_view:
                Toast.makeText(getActivity(),
                        "click web_view",
                        Toast.LENGTH_SHORT).show();
                
                startActivity(new Intent(getActivity(),BrowerIntentWebActivity.class));
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_status, container, false);

        return view;
    }
}
