package anhhy.day02_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class InputActivity extends AppCompatActivity {

    private EditText edtUsername, edtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        edtAge = findViewById(R.id.edtAge);
        edtUsername = findViewById(R.id.edtUsername);
    }

    public void clickToDone(View view) {
        String username = edtUsername.getText().toString();
        int age = Integer.parseInt(edtAge.getText().toString());

//        Intent intent = new Intent(this, MainActivity.class);
        Intent intent = this.getIntent();
        intent.putExtra("username", username);
        intent.putExtra("age", age);
//        startActivity(intent);
        this.setResult(RESULT_OK, intent);
        finish();
    }
}
