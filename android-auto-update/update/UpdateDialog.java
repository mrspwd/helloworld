package org.cocos2dx.lua.update;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.app.ProgressDialog;

class UpdateDialog {

    static ProgressDialog mProgressDialog;
    // 可选更新
    static void show(final Context context, String content, final String downloadUrl) {
        
        if (isContextValid(context)) {
            // mProgressDialog = creProgressDialog(context);

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            // builder.setTitle(R.string.android_auto_update_dialog_title);
            builder.setTitle("发现新版本");
            builder.setMessage(Html.fromHtml(content))
                    // .setPositiveButton(R.string.android_auto_update_dialog_btn_download, new DialogInterface.OnClickListener() {
                    .setPositiveButton("立即下载", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            goToDownload(context, downloadUrl);
                        }
                    })
                    // .setNegativeButton(R.string.android_auto_update_dialog_btn_cancel, new DialogInterface.OnClickListener() {
                    .setNegativeButton("以后再说", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // mProgressDialog.dismiss();
                            // mProgressDialog = null;
                        }
                    });

            AlertDialog dialog = builder.create();
            //点击对话框外面,对话框不消失
            dialog.setCanceledOnTouchOutside(false);
            //点击返回键不消失
            // dialog.setCancelable(false);  
            dialog.show();
        }
    }

    // 强制更新
    static void maskshow(final Context context, String content, final String downloadUrl) {

        if (isContextValid(context)) {
            mProgressDialog = creProgressDialog(context);

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            // builder.setTitle(R.string.android_auto_update_dialog_title);
            builder.setTitle("发现新版本");
            builder.setMessage(Html.fromHtml(content))
                    // .setPositiveButton(R.string.android_auto_update_dialog_btn_download, new DialogInterface.OnClickListener() {
                    .setPositiveButton("立即下载", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            goToDownload(context, downloadUrl);
                        }
                    });

            AlertDialog dialog = builder.create();
            //点击对话框外面,对话框不消失
            dialog.setCanceledOnTouchOutside(false);
            //点击返回键不消失
            dialog.setCancelable(false);  
            dialog.show();
        }
    }

    static ProgressDialog creProgressDialog( final Context context ){
        final ProgressDialog dialog = new ProgressDialog(context);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);// 设置水平进度条
        dialog.setCancelable(false);// 设置是否可以通过点击Back键取消
        dialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
        // dialog.setIcon(R.drawable.ic_launcher);// 设置提示的title的图标，默认是没有的
        dialog.setTitle("提示");
        dialog.setMax(100);
        // dialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定",
        //         new DialogInterface.OnClickListener() {

        //             @Override
        //             public void onClick(DialogInterface dialog, int which) {
        //                 // TODO Auto-generated method stub

        //             }
        //         });
        // dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "取消",
        //         new DialogInterface.OnClickListener() {

        //             @Override
        //             public void onClick(DialogInterface dialog, int which) {
        //                 // TODO Auto-generated method stub

        //             }
        //         });
        // dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "中立",
        //         new DialogInterface.OnClickListener() {

        //             @Override
        //             public void onClick(DialogInterface dialog, int which) {
        //                 // TODO Auto-generated method stub

        //             }
        //         });
        dialog.setMessage("下载apk进度");
        dialog.show();
        // new Thread(new Runnable() {

        //     @Override
        //     public void run() {
        //         // TODO Auto-generated method stub
        //         int i = 0;
        //         while (true) {
        //             try {
        //                 Thread.sleep(500);
        //                 // 更新进度条的进度,可以在子线程中更新进度条进度
        //                 dialog.incrementProgressBy(DownloadService.mProgress);
        //                 // dialog.incrementSecondaryProgressBy(10)//二级进度条更新方式
        //                 i++;

        //             } catch (Exception e) {
        //                 // TODO: handle exception
        //             }
        //         }
        //         // 在进度条走完时删除Dialog
        //         // dialog.dismiss();
        //     }
        // }).start();
        return dialog;
    }

    private static boolean isContextValid(Context context) {
        return context instanceof Activity && !((Activity) context).isFinishing();
    }


    private static void goToDownload(Context context, String downloadUrl) {
        Intent intent = new Intent(context.getApplicationContext(), DownloadService.class);
        intent.putExtra(Constants.APK_DOWNLOAD_URL, downloadUrl);
        context.startService(intent);
    }
}
