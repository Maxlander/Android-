package com.wuw.myplane;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

import com.wandoujia.ads.sdk.Ads;
import com.wuw.constant.ConstantUtil;
import com.wuw.sounds.GameSoundPool;
import com.wuw.view.EndView;
import com.wuw.view.MainView;
import com.wuw.view.ReadyView;

public class MainActivity extends Activity {
	private EndView endView;
	private MainView mainView;
	private ReadyView readyView;
	private GameSoundPool sounds;
	
	private static final String APP_ID = "100037136";
	  private static final String SECRET_KEY = "521843a3d78c40650285accf6157846f";
	  private static final String BANNER = "55b46f86626bc6fde0e12455909bc937";
	  private static final String APP_WALL = "69e68b742b590546da1bdc21a18a878c";
	
	@SuppressLint("HandlerLeak")
	private Handler handler = new Handler(){ 
		@Override
        public void handleMessage(Message msg){
            if(msg.what == ConstantUtil.TO_MAIN_VIEW){
            	toMainView();
            }
            else  if(msg.what == ConstantUtil.TO_END_VIEW){
            	toEndView(msg.arg1);
            }
            else  if(msg.what == ConstantUtil.END_GAME){
            	endGame();
            }
        }
    };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		sounds = new GameSoundPool(this);
		sounds.initGameSound();
		readyView = new ReadyView(this,sounds);
		setContentView(readyView);
		initwandoujia();
	
	}
	//显示游戏的主界面
	public void toMainView(){
		if(mainView == null){
			mainView = new MainView(this,sounds);
		}
		setContentView(mainView);
		readyView = null;
		endView = null;
	}
	//显示游戏结束的界面
	public void toEndView(int score){
		if(endView == null){
			endView = new EndView(this,sounds);
			endView.setScore(score);
		}
		setContentView(endView);
		mainView = null;
	}
	//结束游戏
	public void endGame(){
		if(readyView != null){
			readyView.setThreadFlag(false);
		}
		else if(mainView != null){
			mainView.setThreadFlag(false);
		}
		else if(endView != null){
			endView.setThreadFlag(false);
		}
		this.finish();
	}
	//getter和setter方法
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
	
public void initwandoujia(){
		
		new AsyncTask<Void, Void, Boolean>() {
		      @Override
		      protected Boolean doInBackground(Void... params) {
		        try {
		          Ads.init(MainActivity.this, APP_ID, SECRET_KEY);
		          return true;
		        } catch (Exception e) {
		          Log.e("ads-sample", "error", e);
		          return false;
		        }
		      }

		      @Override
		      protected void onPostExecute(Boolean success) {
		    	  FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT,
		  				FrameLayout.LayoutParams.WRAP_CONTENT);
		    	  FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT,
		    			  FrameLayout.LayoutParams.WRAP_CONTENT);
		  		// 设置广告条的悬浮位置
		  		layoutParams.gravity = Gravity.BOTTOM | Gravity.RIGHT; // 这里示例为右下角
		  		layoutParams2.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL; // 这里示例为右下角

		        if (success) {
		          /**
		           * pre load
		           */
		          Ads.preLoad(BANNER, Ads.AdFormat.banner);
		          Ads.preLoad(APP_WALL, Ads.AdFormat.appwall);

		          /**
		           * add ad views
		           */
		          View bannerView = Ads.createBannerView(MainActivity.this, BANNER);
		          MainActivity.this.addContentView(bannerView, layoutParams);
		          

		          Button btW = new Button(MainActivity.this);
		          btW.setText("点击发现更多精彩");
		          btW.setBackgroundResource(R.drawable.back);
		          btW.setOnClickListener(new View.OnClickListener() {
		            @Override
		            public void onClick(View v) {
		              Ads.showAppWall(MainActivity.this, APP_WALL);
		            }
		          });
		          MainActivity.this.addContentView(btW, layoutParams2);
		        }  
		      }
		    }.execute();
	}
	
}
