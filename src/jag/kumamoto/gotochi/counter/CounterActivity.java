
package jag.kumamoto.gotochi.counter;

import jag.kumamoto.apps.gotochi.PrefecturesActivityBase;

import java.util.Date;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.content.Context;
import android.content.Intent;
import android.graphics.*;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;

import android.graphics.drawable.BitmapDrawable; 

public class CounterActivity extends PrefecturesActivityBase {
    /** Called when the activity is first created. */
    /** 画面描画用 View */
	static final  int DIALOG_PAUSED_ID = 1;
    android.os.Handler handler = new android.os.Handler();
    Integer WindowHeight = 0;
    Integer WindowWidth = 0;
	Integer ScleWidth = 0;
	Integer ScleHeight = 0;
	ImageView BackGroundImg;
	MyTrainView train ;
	Integer x1=0;
	Integer y1=0;
	FrameLayout FR;
	Float rate;
	BitmapDrawable bitmapDrawable; 

	LoopCounter loopcounter = new LoopCounter();
	Long lngXday = new Date("2011/3/12").getTime();
	Long TempD = 0L;
	Long[] TimeLeft = new Long[4];
	MyveilView veil;
	MyTextView DownloadTxt;
	Long TestCount = new Date("2011/3/11").getTime() ; 
	MyCeremonyBallView ball;
	MyCountView myimg;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitParam();
        Display display = getDisplay();
        WindowHeight = display.getHeight();
        WindowWidth = display.getWidth();
        
        FR = new FrameLayout(getApplication());        

        setContentView(FR);
        BackGroundImg = new ImageView(getApplication());
        BackGroundImg.setImageResource(R.drawable.counter_bg);
    	BackGroundImg.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FR.addView(BackGroundImg);
        

    }
    @Override
	public void onWindowFocusChanged(boolean hasFocus){
		super.onWindowFocusChanged(hasFocus);
		ScleWidth = BackGroundImg.getWidth();
		ScleHeight = BackGroundImg.getHeight();
		scontinue();
	}
    private void scontinue() {
    	ScleWidth = BackGroundImg.getMeasuredWidth();
	    ScleHeight = BackGroundImg.getMeasuredHeight();
	    Myrectangle mypoint1 = new Myrectangle(getApplication());
	    x1 = WindowWidth/2-(480*ScleHeight/800)/2;
	    y1 = 0;
	    mypoint1.setxy(x1, y1);
	    rate =  ScleHeight/800f;
	    myimg = new MyCountView(getApplication(),x1,y1,rate);
	    train = new MyTrainView(getApplication(),x1,y1,rate);
	    ball= new MyCeremonyBallView(getApplication(),x1,y1,rate);
	    veil = new MyveilView(getApplication(),x1,y1,WindowWidth,WindowHeight,rate);
	    /*
	     * TODO:ソース後片付け
	     */
	    //mypoint2.setxy(200*rate+x1, 250*rate+y1);
        //
	    //if(TimeLeft[3] == 1L){
	    //	Log.v("test",Long.toString(TimeLeft[3]));
	    //	//Resources res = getResources();
	    //	//DownloadTxt = new MyTextView(getApplication(),x1,y1,rate,"hua");
	    //	ball.setOnClickListener(new View.OnClickListener(){
		//		@Override
		//		public void onClick(View v) {
		//		//クリックされたら、ダイアログ表示用のアクティビティへ移動
		//			startActivity(new Intent(CounterActivity.this,SecondActivity.class));
		//		}
	    //});
	    //	
	    //}
	    Log.v("test",Long.toString(TimeLeft[3]));
	    FR.addView(myimg);
	    FR.addView(train);
	    FR.addView(ball);
	    FR.addView(veil);
	    /*
	     * TODO:後で主巣栄
	     */
	   if(DownloadTxt==null){
	    }else{
	    	FR.addView(DownloadTxt);
	   }

	    //スレッドスタート
	    loopcounter.start();
    }
    private Display getDisplay(){
    	WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
    	Display display = wm.getDefaultDisplay();
    	return display;
    }

    class Myrectangle extends View {
    	float cx = 0;
    	float cy = 0;
    	public Myrectangle(Context context ){
    		super(context);
    		setFocusable(true);

    	}
    	public void setxy(float x ,float y){
    		cx = x;
    		cy = y;
    	}
    	protected void onDraw(Canvas canvas) {
    	super.onDraw(canvas);
    	Paint paint = new Paint();
        // 円を適当な位置に描画する
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        paint.setStrokeWidth(6);

        canvas.drawPoint(cx, cy,  paint);
    	}
    }
       class MyCountView extends View {
    	   float BaseX;
    	   float BaseY;
    	   float BaseRate;
    	   BitmapDrawable tempbitmap;
    	   BitmapDrawable bitmapN0;
    	   BitmapDrawable bitmapN1;
    	   BitmapDrawable bitmapN2;
    	   BitmapDrawable bitmapN3;
    	   BitmapDrawable bitmapN4;
    	   BitmapDrawable bitmapN5;
    	   BitmapDrawable bitmapN6;
    	   BitmapDrawable bitmapN7;
    	   BitmapDrawable bitmapN8;
    	   BitmapDrawable bitmapN9;
	    public MyCountView(Context context,float x1,float y1,float rate) {  
	      super(context); 
	      BaseX = x1;
	      BaseY = y1;
	      BaseRate = rate;
	      
	      // BitmapDrawable を作成  
	      bitmapN0 = (BitmapDrawable) context.getResources().getDrawable(R.drawable.number0);
	      bitmapN1 = (BitmapDrawable) context.getResources().getDrawable(R.drawable.number1);
	      bitmapN2 = (BitmapDrawable) context.getResources().getDrawable(R.drawable.number2);
	      bitmapN3 = (BitmapDrawable) context.getResources().getDrawable(R.drawable.number3);
	      bitmapN4 = (BitmapDrawable) context.getResources().getDrawable(R.drawable.number4);
	      bitmapN5 = (BitmapDrawable) context.getResources().getDrawable(R.drawable.number5);
	      bitmapN6 = (BitmapDrawable) context.getResources().getDrawable(R.drawable.number6);
	      bitmapN7 = (BitmapDrawable) context.getResources().getDrawable(R.drawable.number7);
	      bitmapN8 = (BitmapDrawable) context.getResources().getDrawable(R.drawable.number8);
	      bitmapN9 = (BitmapDrawable) context.getResources().getDrawable(R.drawable.number9);
	    }  
	    @Override  
	    public void onDraw(Canvas canvas) {
	      Float[][] PointXY = MakeList();
	      Long[] buff = new Long[6];
	      for (int i=0;i<3;i++){
	    	  if (TimeLeft[i] < 10L){  
	    		  buff[2*i] = 0L;
	    		  buff[2*i+1]  =  TimeLeft[i];
	    	  } else{
	    		  buff[2*i] =  TimeLeft[i] / 10;
	    		  buff[2*i+1]  =  TimeLeft[i] - buff[2*i]*10;
	    	  }
	      }
	      for(int i=0;i<6;i++){
	      }
	      for(int i=0;i< PointXY[0].length;i++){
	    	  
	    	  switch(Longtoint(buff[i])){
	    	
				case 0:
					bitmapN0.setBounds(Math.round(PointXY[0][i]*BaseRate+x1), Math.round(PointXY[1][i]*BaseRate+y1),
						Math.round((PointXY[0][i]+ PointXY[2][i])*BaseRate+x1), Math.round((PointXY[1][i]+PointXY[3][i])*BaseRate+y1));
					bitmapN0.draw(canvas);
					break;
	    	  	case 1:
	    	  		bitmapN1.setBounds(Math.round(PointXY[0][i]*BaseRate+x1), Math.round(PointXY[1][i]*BaseRate+y1),
							Math.round((PointXY[0][i]+ PointXY[2][i])*BaseRate+x1), Math.round((PointXY[1][i]+PointXY[3][i])*BaseRate+y1));
					bitmapN1.draw(canvas);
					break;
	    	  	case 2:
	    	  		bitmapN2.setBounds(Math.round(PointXY[0][i]*BaseRate+x1), Math.round(PointXY[1][i]*BaseRate+y1),
							Math.round((PointXY[0][i]+ PointXY[2][i])*BaseRate+x1), Math.round((PointXY[1][i]+PointXY[3][i])*BaseRate+y1));
					bitmapN2.draw(canvas);
					break;
	    	  	case 3:
	    	  		bitmapN3.setBounds(Math.round(PointXY[0][i]*BaseRate+x1), Math.round(PointXY[1][i]*BaseRate+y1),
							Math.round((PointXY[0][i]+ PointXY[2][i])*BaseRate+x1), Math.round((PointXY[1][i]+PointXY[3][i])*BaseRate+y1));
					bitmapN3.draw(canvas);
					break;
	    	  	case 4:
	    	  		bitmapN4.setBounds(Math.round(PointXY[0][i]*BaseRate+x1), Math.round(PointXY[1][i]*BaseRate+y1),
							Math.round((PointXY[0][i]+ PointXY[2][i])*BaseRate+x1), Math.round((PointXY[1][i]+PointXY[3][i])*BaseRate+y1));
					bitmapN4.draw(canvas);
					break;
	    	  	case 5:
	    	  		bitmapN5.setBounds(Math.round(PointXY[0][i]*BaseRate+x1), Math.round(PointXY[1][i]*BaseRate+y1),
							Math.round((PointXY[0][i]+ PointXY[2][i])*BaseRate+x1), Math.round((PointXY[1][i]+PointXY[3][i])*BaseRate+y1));
					bitmapN5.draw(canvas);
					break;
	    	  	case 6:
	    	  		bitmapN6.setBounds(Math.round(PointXY[0][i]*BaseRate+x1), Math.round(PointXY[1][i]*BaseRate+y1),
							Math.round((PointXY[0][i]+ PointXY[2][i])*BaseRate+x1), Math.round((PointXY[1][i]+PointXY[3][i])*BaseRate+y1));
					bitmapN6.draw(canvas);
					break;
	    	  	case 7:
	    	  		bitmapN7.setBounds(Math.round(PointXY[0][i]*BaseRate+x1), Math.round(PointXY[1][i]*BaseRate+y1),
							Math.round((PointXY[0][i]+ PointXY[2][i])*BaseRate+x1), Math.round((PointXY[1][i]+PointXY[3][i])*BaseRate+y1));
					bitmapN7.draw(canvas);
					break;
	    	  	case 8:
	    	  		bitmapN8.setBounds(Math.round(PointXY[0][i]*BaseRate+x1), Math.round(PointXY[1][i]*BaseRate+y1),
							Math.round((PointXY[0][i]+ PointXY[2][i])*BaseRate+x1), Math.round((PointXY[1][i]+PointXY[3][i])*BaseRate+y1));
					bitmapN8.draw(canvas);

					break;
	    	  	default:
	    	  		bitmapN9.setBounds(Math.round(PointXY[0][i]*BaseRate+x1), Math.round(PointXY[1][i]*BaseRate+y1),
							Math.round((PointXY[0][i]+ PointXY[2][i])*BaseRate+x1), Math.round((PointXY[1][i]+PointXY[3][i])*BaseRate+y1));
					bitmapN9.draw(canvas);
					break;
				
	    	  		
	    	  }
	      }
	    }
	    private Float[][] MakeList(){
	    	Float[][] XY = new Float[4][6];
	    	XY[0][0] = 212F;XY[1][0] = 235F;XY[2][0] = 46F;XY[3][0] = 79F;
	    	XY[0][1] = 265F;XY[1][1] = 235F;XY[2][1] = 46F;XY[3][1] = 79F;
	    	XY[0][2] = 103F;XY[1][2] = 324F;XY[2][2] = 38F;XY[3][2] = 70F;
	    	XY[0][3] = 146F;XY[1][3] = 324F;XY[2][3] = 38F;XY[3][3] = 70F;
	    	XY[0][4] = 248F;XY[1][4] = 323F;XY[2][4] = 38F;XY[3][4] = 70F;
	    	XY[0][5] = 291F;XY[1][5] = 323F;XY[2][5] = 38F;XY[3][5] = 70F;
	    	return XY;
	    }
	    
  }  
       class MyTrainView extends View {
    	   float BaseX;
    	   float BaseY;
    	   float BaseRate;
    	   BitmapDrawable bitmapDrawable2; 
	    public MyTrainView(Context context,float x1,float y1,float rate) {  
	      super(context); 
	      BaseX = x1;
	      BaseY = y1;
	      BaseRate = rate;
	      
	      // BitmapDrawable を作成  
	      bitmapDrawable2 = (BitmapDrawable) context.getResources().getDrawable(R.drawable.counter_n700);
	      
	    }  
	    @Override  
	    public void onDraw(Canvas canvas) {
	    	Float[][] PointXY = MakeList();

	    	int i = 0;
	    	if(TimeLeft[3] == 1L){
	    		i=0;	
	    	}else if (TimeLeft[0] <= 3L){
	    		i=1;
	    	}else {
	    		i= 2;
	    	}

			bitmapDrawable2.setBounds(Math.round(PointXY[0][i]*BaseRate+x1), Math.round(PointXY[1][i]*BaseRate+y1),
			    		  		Math.round((PointXY[0][i]+ PointXY[2][i])*BaseRate+x1), Math.round((PointXY[1][i]+PointXY[3][i])*BaseRate+y1));  
	    	// BitmapDrawable の描画  
	    	bitmapDrawable2.draw(canvas);
	    	
	    }
	    /*
	     * TODO:値の微調整と1banすける
	     */
	    private Float[][] MakeList(){
	    	Float[][] XY = new Float[4][3];
	    	XY[0][0] = 129F;XY[1][0] = 652F;XY[2][0] = 435F;XY[3][0] = 153F;
	    	XY[0][1] = 276F;XY[1][1] = 648F;XY[2][1] = 395F;XY[3][1] = 130F;
	    	XY[0][2] = 423F;XY[1][2] = 650F;XY[2][2] = 288F;XY[3][2] = 95F;	    	
	    	return XY;
	    }
	    
  }  
   class MyCeremonyBallView extends View {
	   float BaseX;
	   float BaseY;
	   float BaseRate;
	   BitmapDrawable bitmapDrawable;
	   Context context; 
	   Float PointXY[][];
	   public MyCeremonyBallView(Context context,float x1,float y1,float rate) {  
		      super(context); 
		      BaseX = x1;
		      BaseY = y1;
		      BaseRate = rate;
		      this.context = context;

	    }  
	    @Override  
	    public void onDraw(Canvas canvas) {
	    	PointXY = MakeList();
	    	//開通後クス玉が開いた状態になる
	    	if (TimeLeft[3].equals(1L)){
			      // BitmapDrawable を作成  
			      bitmapDrawable = (BitmapDrawable) context.getResources().getDrawable(R.drawable.counter_kusudama_2);
			      bitmapDrawable.setBounds(Math.round(PointXY[0][0]*BaseRate+x1), Math.round(PointXY[1][0]*BaseRate+y1),
		    		  		Math.round((PointXY[0][0]+ PointXY[2][0])*BaseRate+x1), Math.round((PointXY[1][0]+PointXY[3][0])*BaseRate+y1));
	    	}else{
			      bitmapDrawable = (BitmapDrawable) context.getResources().getDrawable(R.drawable.counter_kusudama_1);
			      bitmapDrawable.setBounds(Math.round(PointXY[0][1]*BaseRate+x1), Math.round(PointXY[1][1]*BaseRate+y1),
		    		  		Math.round((PointXY[0][1]+ PointXY[2][1])*BaseRate+x1), Math.round((PointXY[1][1]+PointXY[3][1])*BaseRate+y1));
	    	}
	    	
    		  //BitmapDrawable の描画  
	    	bitmapDrawable.draw(canvas);
		    
	    	
	    	
        }  
	    private Float[][] MakeList(){
	    	Float[][] XY = new Float[4][2];
	    	//開いてるときの座標幅高さ
	    	XY[0][0] = 240F;XY[1][0] = 430F;XY[2][0] = 214F;XY[3][0] = 232F;
	    	//閉じてるときの座標幅高さ
	    	XY[0][1] = 292F;XY[1][1] = 440F;XY[2][1] = 113F;XY[3][1] = 112F;
	    	return XY;
	    }
   }
   public class MyveilView extends View{
	   float BaseX ;
	   float BaseY;
	   float winwidth;
	   float winheight;
	   float thisrate;
	   public MyveilView(Context context,float x1,float y1,float ww,float wh,float rate) {
		super(context);
		BaseX = x1;
		BaseY = y1;
		winwidth = ww;
		winheight = wh;
		thisrate = rate;
	   }

	protected void  onDraw(Canvas canvas){
		   super.onDraw(canvas);
		
		   Paint mPaint = new Paint();
		   mPaint.setStyle(Paint.Style.FILL);
		   mPaint.setARGB(255, 0, 0, 0);
			
			canvas.drawRect(x1+(480*thisrate), 0,winwidth , winheight, mPaint);
			canvas.drawRect(0, 0,x1 , winheight, mPaint);
	   }
	
   }
   public class MyTextView extends View{
	   float BaseX ;
	   float BaseY;
	   float thisrate;
	   String thisText;
	   public MyTextView(Context context,float x1,float y1,float rate,String text) {
		super(context);
		BaseX = x1;
		BaseY = y1;
		thisText = text;
		thisrate = rate;
	   }

	protected void  onDraw(Canvas canvas){
		   super.onDraw(canvas);
		   
		   Paint mPaint = new Paint();
		   //mPaint.setARGB(255, 255, 255, 255);
		   mPaint.setStyle(Paint.Style.FILL);
		   mPaint.setTextSize(8);
		   canvas.drawText(thisText,Math.round(189*thisrate+x1), Math.round(436*thisrate+y1), mPaint);
	   }
	
   }    
   	private void OpeningAfter() {
   		myimg.invalidate();
   		ball.setOnClickListener(new View.OnClickListener(){
   					@Override
   					public void onClick(View v) {
   					//クリックされたら、ダイアログ表示用のアクティビティへ移動
   						startActivity(new Intent(CounterActivity.this,SecondActivity.class));
   					}
   		    });
   		ball.invalidate();
	}
    class LoopCounter extends Handler {
    	
	    private boolean isUpdate;
	    public void start(){
            this.isUpdate = true;
            handleMessage(new Message());
	    }
	    public void stop(){
            this.isUpdate = false;
	    }
	    @Override
	    public void handleMessage(Message msg) {
            this.removeMessages(0);//既存のメッセージは削除
            if(this.isUpdate){
            	TimeLeft = CalTimeLeft();
            	//TODO:拡張可能に書き換える
            	if (TimeLeft[3] == 2L ){
            		myimg.invalidate();
	            	if (TimeLeft[0] <= 10L){
	                	 if (TempD.equals(TimeLeft[0])){
	                	 }else{
	                		 TempD = TimeLeft[0];
	                		 train.invalidate();
	                	 }
	                }else{
	                }
            	}else{
            		OpeningAfter();
            		this.stop();
            	}
            	 sendMessageDelayed(obtainMessage(0), 60000);//60000ミリ秒後にメッセージを出力
            }
	    }
        private Long[] CalTimeLeft(){
	    	/*
	    	 * 日：RtnTLefts[0]　時：RtnTLefts[1] 分：RtnTLefts[2]
	    	 *  秒（未使用）：RtnTLefts[3]
	    	 * をそれぞれ管理する
	    	 */
	    	Long[] RtnTLefts = new Long[4];
	    	/*
	    	 * TODO:後で削除
	    	 */
	    	/*
	    	 * TODO:ここから
	    	 */
	    	final Integer ONEDAY  = 1000 * 60 * 60 * 24;
	    	final Integer ONEHOUR  = 1000 * 60 * 60;
	    	final Integer ONEMIN  = 1000 * 60;

	    	TestCount =  TestCount + 3*ONEHOUR + 3*ONEMIN;
	    	Long lngNow = TestCount;
	    	/*
	    	 * TODO:ここまで
	    	 */
	    	/*
	    	 * TODO:テストが終わったら復帰
	    	Long lngNow = new Date().getTime();
	    	//TODO 型の違いを学習
	    	final Integer ONEDAY  = 1000 * 60 * 60 * 24;
	    	final Integer ONEHOUR  = 1000 * 60 * 60;
	    	final Integer ONEMIN  = 1000 * 60;
	    	//未使用
	    	final Integer ONESEC  = 1000;

	    	for(int i = 0; i<=3;i++){
	    		RtnTLefts[i] = 0L;
	    	}
	    	*/
	    	
	    	//残り時間をミリ秒で算出
	    	if(lngXday - lngNow > 0L){
	    		Long diffday = (lngXday - lngNow);
	    		RtnTLefts[0] = diffday / ONEDAY;
	        	RtnTLefts[1] = (diffday - RtnTLefts[0]*ONEDAY )/ ONEHOUR;
	        	RtnTLefts[2] = (diffday - RtnTLefts[0]*ONEDAY - RtnTLefts[1]*ONEHOUR) / ONEMIN ;
	        	//超過フラグ　1:超過 2:未到達
	        	RtnTLefts[3] = 2L;
	    	}else{
	    		RtnTLefts[3] = 1L;
	    		RtnTLefts[0] = 0L;
	        	RtnTLefts[1] = 0L;
	        	RtnTLefts[2] = 0L ;

	    	}
	    	return RtnTLefts;
	    }
    }
    private void InitParam() {
    	TimeLeft[0] = 0L;
    	TimeLeft[1] = 0L;
    	TimeLeft[2] = 0L;
    	TimeLeft[3] = 0L;
    }
    private int Longtoint(Long Lv){
    	int rtnint = 0;
    	if (Lv == 0L){
    		rtnint  = 0;
    	}
    	if (Lv == 1L){
    		rtnint  = 1;
    	}
    	if (Lv == 2L){
    		rtnint  = 2;
    	}
    	if (Lv == 3L){
    		rtnint  = 3;
    	}
    	if (Lv == 4L){
    		rtnint  = 4;
    	}
    	if (Lv == 5L){
    		rtnint  = 5;
    	}
    	if (Lv == 6L){
    		rtnint  = 6;
    	}
    	if (Lv == 7L){
    		rtnint  = 7;
    	}
    	if (Lv == 8L){
    		rtnint  = 8;
    	}
    	if (Lv == 9L){
    		rtnint  = 9;
    	}

    	return rtnint;
    }
     
}
