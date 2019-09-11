package com.example.dowtintuc;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DowTinTucTask extends AsyncTask<Void, Integer, String> {
    Activity context;
    TextView txtTrangthai;
    ProgressBar progressBar;

    public DowTinTucTask(Activity context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        txtTrangthai = context.findViewById(R.id.txtTrangthai);
        progressBar = context.findViewById(R.id.proBar);
        if (txtTrangthai!=null && progressBar!=null) {
            txtTrangthai.setText("Bắt đầu tải");
            progressBar.setProgress(0);
        }
    }

    @Override
    protected String doInBackground(Void... voids) {
        for (int i=0; i<=100; i++) {
            try {
                Thread.sleep(10);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Đã tải song";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        txtTrangthai.setText(s);
    }
}
