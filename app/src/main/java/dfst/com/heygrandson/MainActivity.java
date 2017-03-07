package dfst.com.heygrandson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import dfst.com.heygrandson.ui.BattleField;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private BattleField battleField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        battleField = (BattleField) findViewById(R.id.battle_field);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                battleField.play();
            }
        });
    }
}
