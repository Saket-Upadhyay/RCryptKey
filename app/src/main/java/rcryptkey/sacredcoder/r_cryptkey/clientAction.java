package rcryptkey.sacredcoder.r_cryptkey;

import android.os.AsyncTask;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.URL;

public class clientAction extends AsyncTask<String , Integer, Long>
{
    private static Socket socket;

    @Override
    protected void onProgressUpdate(Integer... progress)
    {

    }

    @Override
    protected Long doInBackground(String... strings) {




            try {


                socket = new Socket(strings[1], 2408);
                OutputStream os = socket.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                String sendMessage = strings[0];
                bw.write(sendMessage);
                bw.flush();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        return null;
    }

    @Override
    protected void onPostExecute(Long result) {

    }
}
