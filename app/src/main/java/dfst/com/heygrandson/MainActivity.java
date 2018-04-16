package dfst.com.heygrandson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import dfst.com.heygrandson.ui.BattleField;

public class MainActivity extends AppCompatActivity {

    private Button startBtn, scopeBtn;
    private BattleField battleField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.startBtn);
        scopeBtn = (Button) findViewById(R.id.scopeBtn);
        battleField = (BattleField) findViewById(R.id.battle_field);

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                battleField.play();
                startBtn.setEnabled(false);
            }
        });
        scopeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (battleField.scopeVisiable()) {
                    battleField.scope(false);
                } else  {
                    battleField.scope(true);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        battleField.release();
    }
}
