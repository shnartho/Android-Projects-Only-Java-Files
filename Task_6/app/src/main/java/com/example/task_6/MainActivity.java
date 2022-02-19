package com.example.task_6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;






public class MainActivity extends AppCompatActivity {
    AtomicBoolean currentlyRecording = new AtomicBoolean(false);
    Thread audioReader = null;
    Thread storageWriter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 0);
        }
    }

    public void toggleRecording(View v){
        currentlyRecording.set(!currentlyRecording.get());
        if(!currentlyRecording.get()){
            stopRecording();
        } else {
            startRecording();
        }
    }

    public void stopRecording() {
        ((TextView) findViewById(R.id.currentAction)).setText("Not Recording");
        ((Button) findViewById(R.id.recordButton)).setText("Record");

        try {
            audioReader.join();
            storageWriter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startRecording() {
        ((TextView) findViewById(R.id.currentAction)).setText("Recording");
        ((Button) findViewById(R.id.recordButton)).setText("Stop");

        LinkedBlockingQueue<byte[]> queue = new LinkedBlockingQueue<>();

        audioReader = new Thread(() -> {
            AudioRecord r = new AudioRecord(
                    MediaRecorder.AudioSource.MIC,
                    44100,
                    AudioFormat.CHANNEL_IN_MONO,
                    AudioFormat.ENCODING_PCM_8BIT,
                    16 * 1024
            );
            r.startRecording();

            while (currentlyRecording.get()) {
                byte[] buffer = new byte[16 * 1024];
                int rc = r.read(buffer, 0, buffer.length);
                if (rc < 0) {
                    //error
                } else {

                    try {
                        queue.put(buffer);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
            try {
                queue.put(new byte[0]);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        });

        storageWriter = new Thread(() -> {
            ArrayList<byte[]> content = new ArrayList<>();
            try {
                while (currentlyRecording.get()) {
                    content.add(queue.take());
                }
            } catch(InterruptedException e){
                e.printStackTrace();
            }

            File dir = this.getFilesDir();
            Path p;

            try {
                p = Files.createFile(dir.toPath().resolve("recording.wav"));
                OutputStream os = new FileOutputStream(p.toFile());
                writeHeader(os, content);
                for (byte[] b: content) {
                    os.write(b);
                }
            }catch(IOException e){
                e.printStackTrace();
            }




        });

        audioReader.start();
        storageWriter.start();

    }

    public void writeHeader(OutputStream os, ArrayList<byte[]> content) throws IOException {
        int dataLen = 0;
        for(byte[] b: content) {
            dataLen += b.length;
        }

        int totalLen = dataLen + 36;
        int byteRate = 44100;

        byte[] header = new byte[44];
        header[0] = 'R';
        header[1] = 'I';
        header[2] = 'F';
        header[3] = 'F';
        header[4] = (byte)(totalLen & 0xff);
        header[5] = (byte)((totalLen >> 8) & 0xff);
        header[6] = (byte)((totalLen >> 16) & 0xff);
        header[7] = (byte)((totalLen >> 24) & 0xff);
        header[8] = 'W';
        header[9] = 'A';
        header[10] = 'V';
        header[11] = 'E';
        header[12] = 'f';
        header[13] = 'm';
        header[14] = 't';
        header[15] = ' ';
        header[16] = 16;
        header[17] = 0;
        header[18] = 0;
        header[19] = 0;
        header[20] = 1;
        header[21] = 0;
        header[22] = 1;
        header[23] = 0;
        header[24] = (byte)(44100 & 0xff);
        header[25] = (byte)((44100 >> 8) & 0xff);
        header[26] = (byte)((44100 >> 16) & 0xff);
        header[27] = (byte)((44100 >> 24) & 0xff);
        header[28] = (byte)(byteRate & 0xff);
        header[29] = (byte)((byteRate >> 8) & 0xff);
        header[30] = (byte)((byteRate >> 16) & 0xff);
        header[31] = (byte)((byteRate >> 24) & 0xff);
        header[32] = 1;
        header[33] = 0;
        header[34] = 0;
        header[35] = 0;
        header[36] = 'd';
        header[37] = 'a';
        header[38] = 't';
        header[39] = 'a';
        header[40] = (byte)(dataLen & 0xff);
        header[41] = (byte)((dataLen >> 8) & 0xff);
        header[42] = (byte)((dataLen >> 16) & 0xff);
        header[43] = (byte)((dataLen >> 24) & 0xff);
        os.write(header);
    }
}