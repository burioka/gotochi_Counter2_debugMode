
package jag.kumamoto.gotochi.counter;

import jag.kumamoto.apps.gotochi.PrefecturesActivityBase;


import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;

public class SecondActivity extends PrefecturesActivityBase {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        // アラートダイアログのタイトルを設定します
        alertDialogBuilder.setTitle("熊本ご当地アプリのダウンロード");
        // アラートダイアログのメッセージを設定します
        alertDialogBuilder.setMessage("熊本ご当地アプリをダウンロードしますか？");
        // アラートダイアログの肯定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
        alertDialogBuilder.setPositiveButton("ＯＫ",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    	startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com")));  
                    }
                });

        // アラートダイアログの否定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
        alertDialogBuilder.setNegativeButton("キャンセル",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    	startActivity(new Intent(SecondActivity.this,CounterActivity.class));
                    }
                });
        // アラートダイアログのキャンセルが可能かどうかを設定します
        alertDialogBuilder.setCancelable(true);
        AlertDialog alertDialog = alertDialogBuilder.create();
        // アラートダイアログを表示します
        alertDialog.show();
    }
     
}
