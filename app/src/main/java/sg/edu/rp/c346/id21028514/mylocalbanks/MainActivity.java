package sg.edu.rp.c346.id21028514.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView DBS;
    ImageView OCBC;
    ImageView UOB;
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String wordClicked = "";
    boolean status1 = false;
    boolean status2 = false;
    boolean status3 = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBS = findViewById(R.id.DBS);
        OCBC = findViewById(R.id.OCBC);
        UOB = findViewById(R.id.UOB);
        tvDBS = findViewById(R.id.textDBS);
        tvOCBC = findViewById(R.id.textOCBC);
        tvUOB = findViewById(R.id.textUOB);
        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == DBS) {
            wordClicked = "DBS";
        } else if (v == OCBC) {
            wordClicked = "OCBC";
        } else if (v == UOB) {
            wordClicked = "UOB";
        }

        menu.add(0, 0, 0, "Visit Website");
        menu.add(0, 1, 1, "Call Hotline");
        menu.add(0, 2, 2, "Toggle Favourite");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            Toast.makeText(MainActivity.this, "English is chosen", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            Toast.makeText(MainActivity.this, "Chinese is chosen", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intentCall);
            } else if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com"));
                startActivity(intent);
            }
            if (item.getItemId() == 2) {
                if (status1 == false) {
                    tvDBS.setTextColor(Color.parseColor("#FF0000"));
                    status1 = true;
                } else if (true) {
                    tvDBS.setTextColor(Color.parseColor("#3A3B3C"));
                    status1 = false;
                }

            }


        }

        if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intentCall);
            } else if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            }
            if (item.getItemId() == 2) {
                if (status2 == false) {
                    tvOCBC.setTextColor(Color.parseColor("#FF0000"));
                    status2 = true;
                } else if (true) {
                    tvOCBC.setTextColor(Color.parseColor("#3A3B3C"));
                    status2 = false;
                }

            }


        }
        if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(intentCall);
            } else if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            }
            if (item.getItemId() == 2) {
                if (status3 == false) {
                    tvUOB.setTextColor(Color.parseColor("#FF0000"));
                    status3 = true;
                } else if (true) {
                    tvUOB.setTextColor(Color.parseColor("#3A3B3C"));
                    status3 = false;
                }

            }


        }
        return super.onOptionsItemSelected(item);
    }
}